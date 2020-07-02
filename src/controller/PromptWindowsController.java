package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import view.PromptWindows;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * 点击确定关闭提示界面
 */

public class PromptWindowsController implements Initializable {

    @FXML
    private Button datermine;

    @FXML
    private Label label;

    private static String strOutput;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        label.setText(strOutput);
    }

    public void ReceiveOutputInformation(String str) {
        strOutput = str;
    }

    //关闭当前窗口
    @FXML
    public void WindowClose() {
        try {
            Stage stage = (Stage) datermine.getScene().getWindow();
            stage.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //其他界面通过调用这个方法来打开提示界面
    public static void showPromptWindows(String msg) {
        try {
            new PromptWindowsController().ReceiveOutputInformation(msg);
            new PromptWindows().start(new Stage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
