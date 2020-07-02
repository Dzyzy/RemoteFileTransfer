package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pojo.User;
import sun.misc.Cleaner;
import utils.Client;
import utils.ServiceFactory;
import view.MainScreen;
import view.UploadFileScreen;
import view.RegistrationScreen;
import view.RetrievePasswordScreen;

import java.io.IOException;


/**
 * 登录界面相关操作
 */

public class LoginScreenController {

    @FXML
    private TextField account;

    @FXML
    private Button login;

    @FXML
    private PasswordField password;

    public static Client client;
    public static User user = null;


    //判断是否登录成功
    @FXML
    private void LoginSuccess() {
        String userId = account.getText();
        String userPassword = password.getText();

        if (userId.equals("") || userPassword.equals("")) {
            String msg = "用户名或者密码为空白!\n        请输入完整!";
            PromptWindowsController.showPromptWindows(msg);
        } else {
            boolean flag = ServiceFactory.getUserServiceInstance().findUserPasswordById(userId, userPassword);
            if(flag) {
                user = new User();
                user.setUserId(userId);
                user.setUserPassword(userPassword);
                //关闭当前窗口,打开主界面
                connectServer(userId);
                try {
                    new MainScreen().start(new Stage());
                    Stage stage = (Stage) login.getScene().getWindow();
                    stage.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                String msg = "用户名或者密码错误!\n       请重新输入!";
                PromptWindowsController.showPromptWindows(msg);
            }
        }
    }

    //用户连接服务器
    public static void connectServer(String userId) {
        client = new Client();
        client.send(userId);
    }

    //打开注册界面
    @FXML
    private void RegistrationScreen() {
        try {
            new RegistrationScreen().start(new Stage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //打开找回密码界面
    @FXML
    private void RetrievePasswordScreen() {
        try {
            new RetrievePasswordScreen().start(new Stage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
