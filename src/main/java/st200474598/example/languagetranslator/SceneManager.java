package st200474598.example.languagetranslator;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneManager
{
    private static SceneManager m_instance = null;
    private SceneManager() {}
    public static SceneManager Instance()
    {
        if(m_instance == null)
        {
            m_instance = new SceneManager();
        }
        return m_instance;
    }

    public void changeScene(ActionEvent event, String FXMLFileName) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(LanguageTranslatorApplication.class.getResource(FXMLFileName));
        Scene scene = new Scene(fxmlLoader.load());

        // derive the stage (window) from the action event (button press)
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
