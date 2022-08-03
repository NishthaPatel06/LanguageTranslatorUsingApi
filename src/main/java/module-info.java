module ca.georgiancollege.languagetranslator {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    requires java.net.http;
    requires org.apache.httpcomponents.httpcore;
    requires org.apache.httpcomponents.httpclient;
    requires org.json;
    requires java.desktop;

    opens st200474598.example.languagetranslator to javafx.fxml, com.google.gson;
    exports st200474598.example.languagetranslator;
    exports st200474598.example.languagetranslator.Models;
    opens st200474598.example.languagetranslator.Models to com.google.gson, javafx.fxml;
}