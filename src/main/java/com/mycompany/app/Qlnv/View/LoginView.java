package com.mycompany.app.Qlnv.View;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class LoginView extends JFrame {

    private JLabel passwordLabel;
    private JLabel usernameLabel;
    private JPasswordField passwordTextField;
    private JTextField usernameTextField; 
    private JButton loginButton;
    private JButton registerButton;

    private JPanel panel;
    Graphics g;

    private ImageIcon LoginIcon;
    private JLabel Loginiconlabel;
    private Image loginImage,iconimage;

    public LoginView (){
        Run();
    }

    public void setEnable(boolean bol){
        setVisible(bol);
    }

        public void Run(){

            
            setLocationRelativeTo(null);
            usernameLabel = new JLabel("Username");
            passwordLabel = new JLabel("Password");
            passwordTextField = new JPasswordField(18);
            usernameTextField = new JTextField(18);
            loginButton = new JButton("Login"); loginButton.setBackground(new Color(0, 255, 255));loginButton.setForeground(new Color(38, 38, 38));
            registerButton = new JButton("Register");registerButton.setBackground(new Color(0, 255, 255));registerButton.setForeground(new Color(38, 38, 38));
            panel = new JPanel(){
                    @Override
                    public void paintComponent(Graphics g){
                    super.paintComponents(g);
                    Graphics2D g2d = (Graphics2D) g;
                    Rectangle rec = new Rectangle(0,0,370,250);
                    g2d.setColor(Color.WHITE);
                    g2d.fill(rec);
                    
                    Toolkit t=Toolkit.getDefaultToolkit();  
                    loginImage = t.getImage("meteor-rain.gif");  
                    g2d.drawImage(loginImage,230,0,45,45,this);
                    g2d.drawImage(loginImage,220,150,50,50,this);
                    g2d.drawImage(loginImage,20,10,40,40,this);
                    g2d.drawImage(loginImage,20,125,50,50,this);
                    g2d.drawImage(loginImage,280,50,60,60,this);
                    loginImage = t.getImage("login-.gif");
                    g2d.drawImage(loginImage,135,5,80,80,this);
            }};

            LoginIcon = new ImageIcon("Login.png");

            iconimage = LoginIcon.getImage();
            Image newing = iconimage.getScaledInstance(65, 65, java.awt.Image.SCALE_SMOOTH);
            LoginIcon = new ImageIcon(newing);
            Loginiconlabel = new JLabel(LoginIcon);
            loginImage = Toolkit.getDefaultToolkit().createImage("Stafflogin.png");
           

                SpringLayout layout = new SpringLayout();
                panel.setLayout(layout);
                panel.add(usernameLabel);
                panel.add(passwordLabel);
                panel.add(passwordTextField);
                panel.add(usernameTextField);
                panel.add(loginButton);
                panel.add(registerButton);
                

        layout.putConstraint(SpringLayout.WEST, usernameLabel, 20, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, usernameLabel, 80, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, passwordLabel, 20, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, passwordLabel, 108, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, usernameTextField, 80, SpringLayout.WEST, usernameLabel);
        layout.putConstraint(SpringLayout.NORTH, usernameTextField, 80, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, passwordTextField, 80, SpringLayout.WEST, passwordLabel);
        layout.putConstraint(SpringLayout.NORTH, passwordTextField, 105, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, loginButton, 80, SpringLayout.WEST, passwordLabel);
        layout.putConstraint(SpringLayout.NORTH, loginButton, 130, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, registerButton, 80, SpringLayout.WEST, loginButton);
        layout.putConstraint(SpringLayout.NORTH, registerButton, 130, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.NORTH, Loginiconlabel, 4 , SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, Loginiconlabel, 140 , SpringLayout.WEST, panel);

        add(panel);
        setIconImage(loginImage);
        setTitle("Login Terminal");
        setSize(370,250);
        setResizable(false);
        setLocationRelativeTo(null);    


    

        }

    public String get_text_username(){
        return usernameTextField.getText();
    }

    public String get_text_password(){
        return String.copyValueOf(passwordTextField.getPassword());
    }

    public void addActionListener_(ActionListener e){
        loginButton.addActionListener(e);
    }
    public void addActionListener_register(ActionListener e){
        registerButton.addActionListener(e);
    }
    
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    
}
