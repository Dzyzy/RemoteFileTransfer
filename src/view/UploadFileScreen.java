package view;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class UploadFileScreen extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        //导入登录界面FXML的路径
        Parent loginScreen = FXMLLoader.load(getClass().getResource("fxml/UploadFileScreen.fxml"));
        //左上角的名字
        primaryStage.setTitle("上传文件");
        primaryStage.setScene(new Scene(loginScreen, 1013, 834));
        primaryStage.show();

    }
}
