package com.example.classproject;
public class ListData {

    private String userImage;
    private String UserName;

    public String getUserImage() {
        return userImage;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public ListData(String userImage, String userName)
    {
        this.userImage= userImage;
        this.UserName= userName;
    }

}