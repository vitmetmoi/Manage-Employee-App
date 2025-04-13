package com.mycompany.app.Qlnv.Controller;
import com.mycompany.app.Qlnv.Data.FileUtil;
import com.mycompany.app.Qlnv.Mycompany.*;
import com.mycompany.app.Qlnv.View.*;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import java.util.*;


public class Registercontroller implements ActionListener {
    RegisterView register;
    UserXML userXML;
    User user;
    FileUtil file ;
    StaffXML staffXML;
    RankXML rankXML;
    Logincontroller logincontroller;

    public Registercontroller (UserXML userxml_){
        this.userXML = userxml_;
        register = new RegisterView();
        user = new User();
        file = new FileUtil();
        register.setAction_registerButton(new registerButton_());
        register.setAction_cancelButton(new cancelButton_());
       
    }

    public void show_registerView(){
        register.setVisible(true);
    }

    public void off_registerView(){
        register.setVisible(false);
    }
    

        class registerButton_ implements ActionListener {
            public void actionPerformed(ActionEvent e){


                boolean BOL = true;
                if(register.getText_password().equals(register.getText_repassword()) == false){
                    register.showMessage("Nhập lại mật khẩu không trùng nhau!");
                    register.clear_pass();
                    BOL = false;
                }
                if(register.getText_register().equals("")){
                    register.showMessage("Vui lòng nhập tài khoản hoặc mật khẩu!");
                    BOL = false;
                }
                if(BOL == true){

                boolean bol = true;
                for(int i = 0 ; i < userXML.get_size();i++){
                    user = userXML.get_user(i);
                    if(user.get_username().equals(register.getText_register()) || user.get_password().equals(register.getText_password())){
                        bol = false;
                        break;
                    }
                        }
                        if(bol == true){
                        register.showMessage("Đăng ký thành công!");
                        user = new User();
                        user.set_username(register.getText_register());
                        user.set_password(register.getText_password());
                        userXML.set_user(user);
                        file.File_User_Write(userXML);
                       
                        }
                        else{
                            register.showMessage("Tên đăng nhập hoặc mật khẩu đã tồn tại !");
                            register.clear_text();
                        }
                }
            }
            }

        class cancelButton_ implements ActionListener {
            public void actionPerformed(ActionEvent e){
                register.setVisible(false);
                logincontroller.show_login_view();
                
            }
        }

    @Override 

    public void actionPerformed(ActionEvent e){
        //Baoduy
    }
}


