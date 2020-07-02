package view;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;

public class ChangePasswordScreen extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent changePasswordScreen = FXMLLoader.load(getClass().getResource("fxml/ChangePasswordScreen.fxml"));
        primaryStage.setTitle("更改密码");
        primaryStage.setScene(new Scene(changePasswordScreen, 450, 250));
        primaryStage.show();

    }
}
