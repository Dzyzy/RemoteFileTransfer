package view;

import controller.LoginScreenController;
import controller.MainScreenController;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class MainScreen extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        //导入登录界面FXML的路径
        Parent loginScreen = FXMLLoader.load(getClass().getResource("fxml/MainScreen.fxml"));
        //左上角的名字
        primaryStage.setTitle("主界面");
        primaryStage.setScene(new Scene(loginScreen, 1021, 798));
        primaryStage.show();

        //监听端口是否关闭
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                LoginScreenController.client.close(LoginScreenController.user.getUserId());
                System.exit(0);
            }
        });
    }
}
