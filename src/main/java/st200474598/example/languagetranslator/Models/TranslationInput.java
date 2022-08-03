package st200474598.example.languagetranslator.Models;

import com.google.gson.annotations.SerializedName;

/**
 * Model class for translation input that would contain the current language code, input text and target language code
 */
public class TranslationInput {

    /**
     * Variable to store the current language code
     */
    @SerializedName("LanguageCode")
    private String languageCode;

    /**
     * Variable to store the input text
     */
    @SerializedName("LanguageText")
    private String languageText;

    /**
     * Variable to store the target language code
     */
    @SerializedName("TargetLanguageCode")
    private String targetLanguageCode;

    // Getters and Setters

    /**
     * Getter for language code
     * @return
     */
    public String getLanguageCode() {
        return languageCode;
    }

    /**
     * Setter for language code
     * @param languageCode
     */
    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    /**
     * Getter for input language text
     * @return
     */
    public String getLanguageText() {
        return languageText;
    }

    /**
     * Setter for input language text
     * @param languageText
     */
    public void setLanguageText(String languageText) {
        this.languageText = languageText;
    }

    /**
     * Getter for target language code
     * @return
     */
    public String getTargetLanguageCode() {
        return targetLanguageCode;
    }

    /**
     * Setter for target language code
     * @param targetLanguageCode
     */
    public void setTargetLanguageCode(String targetLanguageCode) {
        this.targetLanguageCode = targetLanguageCode;
    }

    /**
     * Default constructor to initialize blank value to all the variables
     */
    public TranslationInput() {
        this.languageCode = "";
        this.languageText = "";
        this.targetLanguageCode = "";
    }

    /**
     * Parameterized constructor to initialize given values to respective variables
     */
    public TranslationInput(String languageCode, String languageText, String targetLanguageCode) {
        this.languageCode = languageCode;
        this.languageText = languageText;
        this.targetLanguageCode = targetLanguageCode;
    }

    // Overridden Methods

    /**
     * Method to print all the values of a translation input object
     * @return
     */
    @Override
    public String toString()
    {
        return String.format("Language Code: %s, Language Text: %s, Target Language Code: %s",
                getLanguageCode(), getLanguageText(), getTargetLanguageCode());
    }
}
