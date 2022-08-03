package st200474598.example.languagetranslator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class LanguageTranslatorApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LanguageTranslatorApplication.class.getResource("language-translator-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        // Applying the custom css sheet to scene
        scene.getStylesheets().add(LanguageTranslatorApplication.class.getResource("app.css").toExternalForm());
        stage.setTitle("Translator!");
        Image icon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("icon.jpg")));
        stage.getIcons().add(icon);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
