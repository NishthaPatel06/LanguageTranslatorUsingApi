package st200474598.example.languagetranslator;

import st200474598.example.languagetranslator.Models.LanguagesModel;
import st200474598.example.languagetranslator.Models.TranslationInput;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class LanguageTranslatorController implements Initializable {

    @FXML
    private TextArea inputText;

    @FXML
    private ComboBox languageSelector;
    @FXML
    private TextArea translatedText;

    /**
     * This method is called by the FXMLLoader when initialization is complete
     * @param fxmlFileLocation
     * @param resources
     */
    @Override
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {

        List<String> languagesOption = new ArrayList<>();

        // Preparing the list of languages available for translation
        for (Map.Entry<String, String> entry : LanguagesModel.Languages.entrySet()) {
            String key = entry.getKey();
            languagesOption.add(key);
        }

        // Sorting the list of languages
        Collections.sort(languagesOption);

        // Setting the languages list to the combobox
        languageSelector.getItems().setAll(languagesOption);

        // listen for changes to the language combo box selection
        languageSelector.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override public void changed(ObservableValue<? extends String> selected, String oldFruit, String newFruit) {
                System.out.println(LanguagesModel.Languages.get(languageSelector.getSelectionModel().getSelectedItem().toString()));
            }
        });
    }

    /**
     * On Click Function for the translate button
     * @throws IOException
     */
    @FXML
    protected void onTranslateButtonClick() throws IOException {

        // Checking if text is entered in the input box or not
        if(inputText.getText().isEmpty())
        {
            // Displaying error for input text not present
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Translator - Error");
            errorAlert.setHeaderText("Required Data Not Available");
            errorAlert.setContentText("Kindly enter a text that you want to translate!");
            errorAlert.showAndWait();
        }

        // Checking if a language option is selected or not in the combobox
        else if(languageSelector.getSelectionModel().getSelectedIndex() == -1)
        {
            // Displaying error for output language not selected
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Translator - Error");
            errorAlert.setHeaderText("Required Data Not Available");
            errorAlert.setContentText("Kindly select output language for translation");
            errorAlert.showAndWait();
        }

        // Once necessary information is available, proceeding with the translation using google api
        else {

            TranslationInput input = new TranslationInput(LanguagesModel.English,
                    inputText.getText().toString(),
                    LanguagesModel.Languages.get(languageSelector.getSelectionModel().getSelectedItem().toString()));

            var translationResult = APIHandler.Instance().getTranslation(input);

            // Setting the resulting translated text
            translatedText.setText(translationResult.getLanguageText());
        }
    }
}
