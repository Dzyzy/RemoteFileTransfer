package view;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;

public class RegistrationScreen extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent registrationScreen = FXMLLoader.load(getClass().getResource("fxml/RegistrationScreen.fxml"));
        primaryStage.setTitle("注册");
        primaryStage.setScene(new Scene(registrationScreen, 450, 645));
        primaryStage.show();

    }
}
