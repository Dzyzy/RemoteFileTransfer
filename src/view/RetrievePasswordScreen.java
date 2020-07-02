package view;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;

public class RetrievePasswordScreen extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent retrievePasswordScreen = FXMLLoader.load(getClass().getResource("fxml/RetrievePasswordScreen.fxml"));
        primaryStage.setTitle("找回密码");
        primaryStage.setScene(new Scene(retrievePasswordScreen, 450, 411));
        primaryStage.show();

    }
}
