package pojo;

import java.sql.Date;

public class User {
    private String userId;
    private String userPassword;
    private String userName;
    private String userSex;
    private Date userBirthday;
    private String userPhone;
    private String userEmail;

    public User() {
    }

    public User(String userId, String userPassword, String userName, String userSex, Date userBirthday, String userPhone, String userEmail) {
        this.userId = userId;
        this.userPassword = userPassword;
        this.userName = userName;
        this.userSex = userSex;
        this.userBirthday = userBirthday;
        this.userPhone = userPhone;
        this.userEmail = userEmail;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public Date getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(Date userBirthday) {
        this.userBirthday = userBirthday;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userPassword='" + userPassword + '\'' +
                ", userName='" + userName + '\'' +
                ", userSex='" + userSex + '\'' +
                ", userBirthday=" + userBirthday +
                ", userPhone='" + userPhone + '\'' +
                ", userEmail='" + userEmail + '\'' +
                '}';
    }
}
