package view;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;

public class PromptWindows extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent promptWindows = FXMLLoader.load(getClass().getResource("fxml/PromptWindows.fxml"));
        primaryStage.setTitle("提示");
        primaryStage.setScene(new Scene(promptWindows, 330, 182));
        primaryStage.show();

    }
}
