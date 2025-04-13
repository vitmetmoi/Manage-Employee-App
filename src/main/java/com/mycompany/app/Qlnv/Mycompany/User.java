package com.mycompany.app.Qlnv.Mycompany;


public class User {
    private String username = "Admin";
    private String password = "123456";

    public String get_username(){
        return username;
    }

    public String get_password(){
        return password;
    }

    public void set_username(String username){
        this.username = username;
    }

    public void set_password(String password){
        this.password = password;
    }
}
