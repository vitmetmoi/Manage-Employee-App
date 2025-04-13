package com.mycompany.app.Qlnv.Controller;
import com.mycompany.app.Qlnv.Mycompany.*;
import com.mycompany.app.Qlnv.View.*;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.util.*;


public class Logincontroller extends JFrame implements ActionListener {

    private User user;
    private UserXML userXML;
    private LoginView loginview;
    private StaffXML staffXML;
    private RankXML rankXML;
    private Registercontroller registercontroller;
    private Staffcontroller staffcontroller;

    public Logincontroller(UserXML userXML_,StaffXML staffXML,RankXML rankXML){
        this.userXML = userXML_; this.staffXML = staffXML; this.rankXML = rankXML;
        user = new User();
        registercontroller = new Registercontroller(userXML);
        loginview = new LoginView();
        loginview.addActionListener_(new LoginListener());
        loginview.addActionListener_register(new RegisterListener());
    }

    public void show_login_view(){
        loginview.setEnable(true);
    }
    public void off_login_view(){
        loginview.setEnable(false);
    }



        class LoginListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            boolean bol = false;
            for(int i = 0 ; i<userXML.get_size();i++){
            user = userXML.get_user(i);
            if(loginview.get_text_username().equals(user.get_username()) && (user.get_password().equals(loginview.get_text_password()))){
               bol = true;
               user.set_username(loginview.get_text_username());
               user.set_password(loginview.get_text_password());
               break;
                /*
                 * Student View entable : true ?? Place code here (Deadline 00:00 Sunday) :) 
                 */
            }
            else{
                bol = false;
            }
        }
        if(bol == true){
            staffcontroller = new Staffcontroller(staffXML, rankXML, user);
            loginview.setEnable(false);
            staffcontroller.showStaffView();

             
        }
        if(bol == false){
            loginview.showMessage("Tài khoản hoặc mật khẩu không đúng!");
        }
        }
        public String get_username(){
            return "";
        }
    
        }


        class RegisterListener implements ActionListener{
            public void actionPerformed(ActionEvent e){
                loginview.setVisible(false);
                registercontroller.show_registerView();
            }
        }


    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }


}
