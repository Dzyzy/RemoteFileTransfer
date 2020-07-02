package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import utils.ServiceFactory;


/**
 * 更改密码
 */

public class ChangePasswordScreenController {

    @FXML
    private PasswordField password;

    @FXML
    private PasswordField confirmPassword;

    @FXML
    private Button datermine;

    //修改密码
    @FXML
    void confirmInformation() {
        String userPassword = password.getText();
        String userConfirmPassword = confirmPassword.getText();
        String msg = "";

        if (userPassword.equals("") || userConfirmPassword.equals("")) {
            msg = "你输入的密码为空\n     请输入密码！";
        } else if(userPassword.equals(userConfirmPassword)) {
            //更改数据库里的密码
            boolean result = ServiceFactory.getUserServiceInstance().updateUserPassword(RetrievePasswordScreenController.user.getUserId(), userPassword);
            //关闭当前窗口
            Stage stage = (Stage) datermine.getScene().getWindow();
            stage.close();
            if(result) {
                msg = "恭喜你，修改密码成功！";
            } else {
                msg = "修改密码失败！";
            }
        } else {
            msg = "你两次输入的密码不一致\n         请重新输入！";
        }

        PromptWindowsController.showPromptWindows(msg);
    }
}

