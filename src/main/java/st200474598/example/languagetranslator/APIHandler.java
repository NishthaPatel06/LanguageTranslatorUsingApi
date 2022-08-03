package st200474598.example.languagetranslator;

import st200474598.example.languagetranslator.Models.LanguagesModel;
import st200474598.example.languagetranslator.Models.TranslationInput;
import st200474598.example.languagetranslator.Models.TranslationResult;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

/**
 * API Handler call for performing api operations for translating the entered text
 */
public class APIHandler {

    private static APIHandler api_instance = null;

    /**
     * API Key for using the Google Translate api and making required api calls
     */
    public static final String KEY = "0619ca6033mshd2a5bb724fd2e75p104e4cjsn801c2e9f6b98";

    /**
     * API server url
     */
    public static final String BASE_URL = "https://google-translate1.p.rapidapi.com/language/translate/v2";

    private APIHandler() {}

    /**
     * Method for initializing api handler instance
     * @return
     */
    public static APIHandler Instance()
    {
        if(api_instance == null)
        {
            api_instance = new APIHandler();
        }
        return api_instance;
    }

    /**
     * Method for making the HttpRequest and processing the http response in json format and extracting the required result
     * @param input
     * @return
     */
    public String translateToJSON(TranslationInput input) {

        String textToTranslate = input.getLanguageText().replace(" ", "%20");

        // Preparing the http request with the url and required inputs
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL))
                .header("content-type", "application/x-www-form-urlencoded")
                .header("Accept-Encoding", "application/gzip")
                .header("X-RapidAPI-Key", KEY)
                .header("X-RapidAPI-Host", "google-translate1.p.rapidapi.com")
                .method("POST",
                        HttpRequest.BodyPublishers.ofString(
                                "q=" + textToTranslate +
                                        "&target=" + input.getTargetLanguageCode() +
                                        "&source=" + input.getLanguageCode()))
                .build();

        try
        {
            //  Sending the http request and retrieving in the response variable
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

            // Converting the response body into JSON object and extracting the required data
            JSONObject data = new JSONObject(response.body());
            JSONObject translation = data.getJSONObject("data");
            JSONArray translations = translation.getJSONArray("translations");

            // returning the translated text
            return translations.getJSONObject(0).getString("translatedText");
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }

        return null;

    }

    /**
     * Function which invokes and gets the http request function and response and prepare the output to be returned to UI element
     * @param input
     * @return
     * @throws IOException
     */
    public TranslationResult getTranslation(TranslationInput input) throws IOException {

        TranslationResult result = null;

        // Invoking the translateToJson function which makes the http calls
        String resultantText = translateToJSON(input);

        result = new TranslationResult();
        result.setLanguageCode(input.getTargetLanguageCode());
        for(Map.Entry<String, String> entry: LanguagesModel.Languages.entrySet()) {
            if(entry.getValue() == input.getTargetLanguageCode()) {
                result.setLanguage(entry.getKey());
                break;
            }
        }
        result.setLanguageText(resultantText);

        return result;
    }

}
