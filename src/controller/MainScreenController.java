package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import pojo.FileInformation;
import view.UploadFileScreen;

import java.io.File;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class MainScreenController implements Initializable {

    @FXML
    private TableView<FileInformation> tableView;

    @FXML
    private TableColumn fileNameColumn;

    @FXML
    private TableColumn fileTimeColumn;

    @FXML
    private TableColumn fileSizeColumn;


    private ObservableList<FileInformation> observableList = FXCollections.observableArrayList();
    public static String path = null;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        fileNameColumn.setCellValueFactory(new PropertyValueFactory("fileNameString"));
        fileTimeColumn.setCellValueFactory(new PropertyValueFactory("fileTimeString"));
        fileSizeColumn.setCellValueFactory(new PropertyValueFactory("fileSizeString"));
        LoginScreenController.client.send("getPath|" + LoginScreenController.user.getUserId());
        while(path == null) {
        }
        File[] files = new File(path).listFiles();
        for(File file : files) {
            String fileName = file.getName();
            long lastModified = file.lastModified();
            Date date = new Date(lastModified);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String fileTime = sdf.format(date);
            if(file.isDirectory()) {
                observableList.add(new FileInformation(fileName, fileTime, null));
            } else {
                String fileSize = file.length() + "";
                observableList.add(new FileInformation(fileName, fileTime, fileSize));
            }
        }
        tableView.setItems(observableList);
    }

    @FXML
    void download() {

    }

    @FXML
    void upload() {
        //打开上传文件窗口
        try {
            new UploadFileScreen().start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
