package com.mycompany.app.Qlnv.View;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.io.*;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class RegisterView extends JFrame implements ActionListener {
    private JButton registerButton;
    private JButton cancelButton;
    private JPasswordField passwordField;
    private JPasswordField repasswordField;
    private JLabel usernameLabel;
    private JTextField usernameField;
    private JLabel passwordLabel;
    private JLabel repasswordLabel;

    private JPanel panel;

    public RegisterView (){
        run();
    }

    public void set_Enabled(boolean bol){
        this.setVisible(bol);
    }

    public void run(){
        

        registerButton = new JButton("Đăng ký"); registerButton.setBackground(new Color(0, 255, 255)); registerButton.setForeground(Color.BLACK);
        cancelButton = new JButton("Cancel"); cancelButton.setBackground(new Color(0, 255, 255)); cancelButton.setForeground(Color.BLACK);
        passwordField = new JPasswordField(18);
        repasswordField = new JPasswordField(18);
        usernameLabel = new JLabel("Tên đăng nhập");
        passwordLabel = new JLabel("Mật khẩu");
        repasswordLabel = new JLabel("Nhập lại");
        usernameField = new JTextField(18);
        panel = new JPanel(){
            @Override 
            public void paintComponent(Graphics g){
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                Rectangle rec = new Rectangle(0,0,350,280);
                g2d.setColor(Color.WHITE);
                g2d.fill(rec);

                  Toolkit t=Toolkit.getDefaultToolkit();  
                  Image  loginImage = t.getImage("meteor-rain.gif");  
                    g2d.drawImage(loginImage,150,0,50,50,this);
                    g2d.drawImage(loginImage,240,150,50,50,this);
                    g2d.drawImage(loginImage,10,10,35,35,this);
                    g2d.drawImage(loginImage,20,125,50,50,this);
                    g2d.drawImage(loginImage,280,50,60,60,this);
                    g2d.drawImage(loginImage,150,100,50,50,this);


            }
        };

       /*  panel.add(registerButton);
        panel.add(cancelButton);
        panel.add(passwordField);
        panel.add(registerField);
        
        */

        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(repasswordLabel);
        panel.add(repasswordField);
        panel.add(registerButton);
        panel.add(cancelButton);


        SpringLayout layout = new SpringLayout();
        panel.setLayout(layout);

        layout.putConstraint(SpringLayout.WEST, usernameLabel, 5 , SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, usernameLabel , 40, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, usernameField, 95 ,SpringLayout.WEST, usernameLabel);
        layout.putConstraint(SpringLayout.NORTH, usernameField, 40 , SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST,passwordLabel,0,SpringLayout.WEST,usernameLabel);
        layout.putConstraint(SpringLayout.NORTH, passwordLabel, 40 , SpringLayout.NORTH, usernameLabel);
        layout.putConstraint(SpringLayout.WEST,passwordField, 95,SpringLayout.WEST,passwordLabel);
        layout.putConstraint(SpringLayout.NORTH,passwordField, 40,SpringLayout.NORTH,usernameLabel);
        layout.putConstraint(SpringLayout.WEST, repasswordLabel, 0,SpringLayout.WEST,passwordLabel);
        layout.putConstraint(SpringLayout.NORTH, repasswordLabel, 40,SpringLayout.NORTH,passwordLabel);
        layout.putConstraint(SpringLayout.WEST,repasswordField, 95,SpringLayout.WEST,repasswordLabel);
        layout.putConstraint(SpringLayout.NORTH,repasswordField, 0,SpringLayout.NORTH,repasswordLabel);
        layout.putConstraint(SpringLayout.WEST,registerButton, 0,SpringLayout.WEST,repasswordField);
        layout.putConstraint(SpringLayout.NORTH,registerButton, 50,SpringLayout.NORTH,repasswordLabel);
        layout.putConstraint(SpringLayout.WEST, cancelButton, 88,SpringLayout.WEST,registerButton);
        layout.putConstraint(SpringLayout.NORTH, cancelButton,0,SpringLayout.NORTH,registerButton);

        


        this.add(panel);
            this.pack();

            this.setTitle("Đăng ký tài khoản");
            this.setSize(350,280);
            this.setResizable(false);
            setLocationRelativeTo(null);
    }

    public void setAction_registerButton(ActionListener e){
        registerButton.addActionListener(e);
    }
    public void setAction_cancelButton(ActionListener e){
        cancelButton.addActionListener(e);
    }
    public void showMessage(String message){
        JOptionPane.showMessageDialog(this,message,"Thông báo!",JOptionPane.INFORMATION_MESSAGE);
    }

    public String getText_register (){
        return usernameField.getText();
    }

    public String getText_password(){
        return String.copyValueOf(passwordField.getPassword());
    }

    public String getText_repassword(){
        return String.copyValueOf(repasswordField.getPassword());
    }

    public void clear_text(){
        usernameField.setText("");
        passwordField.setText("");
        repasswordField.setText("");
    }

    public void clear_pass(){
        passwordField.setText("");
        repasswordField.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e){

    }
    
}
