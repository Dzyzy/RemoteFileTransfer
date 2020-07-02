package pojo;


import javafx.beans.property.SimpleStringProperty;

public class FileInformation {
    private String fileName;
    private String fileTime;
    private String fileSize;
    private SimpleStringProperty fileNameString;
    private SimpleStringProperty fileTimeString;
    private SimpleStringProperty fileSizeString;

    public FileInformation() {
    }

    public FileInformation(String fileName, String fileTime, String fileSize) {
        this.fileName = fileName;
        this.fileTime = fileTime;
        this.fileSize = fileSize;
        this.fileNameString = new SimpleStringProperty(fileName);
        this.fileTimeString = new SimpleStringProperty(fileTime);
        this.fileSizeString = new SimpleStringProperty(fileSize);
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
        this.fileNameString = new SimpleStringProperty(fileName);
    }

    public String getFileTime() {
        return fileTime;
    }

    public void setFileTime(String fileTime) {
        this.fileTime = fileTime;
        this.fileTimeString = new SimpleStringProperty(fileTime);
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
        this.fileSizeString = new SimpleStringProperty(fileSize);
    }

    public SimpleStringProperty fileNameStringProperty() {
        return fileNameString;
    }

    public SimpleStringProperty fileTimeStringProperty() {
        return fileTimeString;
    }

    public SimpleStringProperty fileSizeStringProperty() {
        return fileSizeString;
    }
}
