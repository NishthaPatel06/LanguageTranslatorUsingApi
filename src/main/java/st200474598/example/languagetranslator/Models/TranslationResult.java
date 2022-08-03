package st200474598.example.languagetranslator.Models;

import com.google.gson.annotations.SerializedName;

/**
 * Model class for translation output that would contain the output language, output language code, output text
 */
public class TranslationResult {

    /**
     * Variable to store the language name
     */
    @SerializedName("Language")
    private String language;

    /**
     * Variable to store the language code
     */
    @SerializedName("LanguageCode")
    private String language_code;

    /**
     * Variable to store the language text
     */
    @SerializedName("LanguageText")
    private String language_text;

    // Getters and Setters (Mutators and Accessors)

    /**
     * Getter for language
     * @return
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Setter for language
     * @param language
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * Getter for language code
     * @return
     */
    public String getLanguageCode() {
        return language_code;
    }

    /**
     * Setter for language code
     * @param language_code
     */
    public void setLanguageCode(String language_code) {
        this.language_code = language_code;
    }

    /**
     * Getter for language text
     * @return
     */
    public String getLanguageText() {
        return language_text;
    }

    /**
     * Setter for language text
     * @param language_text
     */
    public void setLanguageText(String language_text) {
        this.language_text = language_text;
    }

    /**
     * Default constructor to initialize blank value to all the variables
     */
    public TranslationResult() {
        this.language = "";
        this.language_code = "";
        this.language_text = "";
    }

    /**
     * Parameterized constructor to initialize given values to respective variables
     */
    public TranslationResult(String language, String language_code, String language_text) {
        this.language = language;
        this.language_code = language_code;
        this.language_text = language_text;
    }

    /**
     * Method to print all the values of a translation output object
     * @return
     */
    // Overridden Methods
    @Override
    public String toString()
    {
        return String.format("Language: %s, Language Code: %s, Language Text: %s",
                getLanguage(), getLanguageCode(), getLanguageText());
    }
}
