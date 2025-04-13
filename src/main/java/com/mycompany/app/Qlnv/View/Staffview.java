package com.mycompany.app.Qlnv.View;

import com.mycompany.app.Qlnv.Mycompany.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Image;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

import javax.imageio.ImageIO;

import java.util.*;

public class Staffview extends JFrame implements ActionListener {

    private StaffXML staffXML;
    private RankXML rankXML;
    private Staff staff;
    private Rank rank;

    private JLabel nameLabel;
    private JLabel rankLabel;
    private JLabel adressLabel;
    private JLabel idLabel;

    private JTextField nameField;
    private JComboBox rankField;
    private JTextArea adressField;
    private JTextField idField;
    private JLabel idsortLabel;private JTextField idsortField;private JButton idsortButton;
    private JLabel ranksortLabel; private JComboBox ranksortField;private JButton ranksortButton;

 /*    private JLabel addrankLabel;
    private JTextField addrankField;
    private JLabel addsalaryLabel;
    private JTextField addsalaryField; */

    private JScrollPane staffScrollPane;
    private JTable staffTable;

   private JButton addButton;
    private JButton deleteButton;
    private JButton changeButton;
    private JButton addrankButton;
    private JButton rankmenubButton;

    private ImageIcon icon;
    private JLabel commentLabel;
    private Image image;

    private JPanel panel;

    private String[] columnnames = new String[]{
        "STT","ID","Tên","Địa chỉ","Chức vụ","Hệ số lương"
    };

    private Object data = new Object [][]{};


        public Staffview (StaffXML staffXML,RankXML rankXML){
            this.staffXML = staffXML;
            this.rankXML = rankXML;
            showStaffView();

        }

        public void showStaffView(){
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            DefaultComboBoxModel data_rank = new DefaultComboBoxModel();
            nameLabel = new JLabel("Tên "); nameField = new JTextField(27);
            rankLabel = new JLabel("Chức vụ"); 
            adressLabel = new JLabel("Địa chỉ");   adressField = new JTextArea(5,27);
            idLabel = new JLabel("ID"); idField = new JTextField(27);

            addButton = new JButton("Thêm nhân sự"); changeButton = new JButton("Sửa thông tin");
            deleteButton = new JButton("Xóa nhân sự"); rankmenubButton = new JButton("Chức vụ"); 
            idsortLabel = new JLabel("Hệ số lương");idsortField = new JTextField(15); idsortButton = new JButton("Lọc hệ số lương");
            ranksortLabel = new JLabel("Chức vụ");ranksortField = new JComboBox(data_rank); ranksortButton = new JButton("Lọc chức vụ"); 
            addButton.setBackground(new Color(0, 255, 255)); addButton.setForeground(new Color(38, 38, 38));
            deleteButton.setBackground(new Color(	0, 255, 255)); deleteButton.setForeground(new Color(38, 38, 38));
            changeButton.setBackground(new Color(	0, 255, 255)); changeButton.setForeground(new Color(38, 38, 38));
            idsortButton.setBackground(new Color(	0, 255, 255)); idsortButton.setForeground(new Color(38, 38, 38));
            ranksortButton.setBackground(new Color(	0, 255, 255)); ranksortButton.setForeground(new Color(38, 38, 38));
            rankmenubButton.setBackground(new Color(	0, 255, 255)); rankmenubButton.setForeground(new Color(38, 38, 38));
            ranksortButton.setPreferredSize(new Dimension(128, 25)); 
            rankmenubButton.setPreferredSize(new Dimension(128,25));
            

            panel = new JPanel(){
                @Override
                public void paintComponent(Graphics g){
                    super.paintComponent(g);
                    Graphics2D g2d = (Graphics2D) g;

                    Rectangle rec = new Rectangle(0,0,1000,600);
                    g2d.setColor(Color.WHITE); g2d.fill(rec);
                    rec = new Rectangle(100,250,300,300);
                    Toolkit t=Toolkit.getDefaultToolkit(); 
                    Image image = t.getImage("id.gif");
                    g2d.drawImage(image,65,0,38,38, this);
                    image = t .getImage("profile.gif");
                    g2d.drawImage(image,65,62,38,38, this);
                    image = t .getImage("military-medal.gif");
                    g2d.drawImage(image,65+70,(62*2)+8,38,38, this);
                    image = t .getImage("military-medal.gif");
                    g2d.drawImage(image,65+118+70,((62*2)+8),38,38, this);
                    image = t .getImage("earth.gif");
                    g2d.drawImage(image,65,200,38,38, this);
                    image = t .getImage("human-resources.gif");
                    g2d.drawImage(image,750,510-90-5-5,38,38, this);
                    image = t .getImage("human-resources.gif");
                    g2d.drawImage(image,750,460,38,38, this);
                    image = t .getImage("human-resources.gif");
                    g2d.drawImage(image,750,508,38,38, this);
                    image = t .getImage("model.gif");
                    g2d.drawImage(image,455,483,80,70, this);
                    image = t .getImage("social-care.gif");
                    g2d.drawImage(image,80,370,200,200, this);


                   /*  Image loginImage = t.getImage("meteor-rain.gif");  
                    g2d.drawImage(loginImage,85,380,70,70,this);
                    g2d.drawImage(loginImage,210,470,80,80,this);
                    g2d.drawImage(loginImage,250,400,45,45,this);
                    g2d.drawImage(loginImage,50,500,45,45,this);
                    g2d.drawImage(loginImage,140,480,25,25,this);*/

                }
            };

            staffTable = new JTable();
            staffScrollPane = new JScrollPane();
            
            staffTable.setModel(new DefaultTableModel((Object[][]) data, columnnames));
            staffScrollPane.setViewportView(staffTable);
            staffScrollPane.setPreferredSize(new Dimension(600,400));
            staffScrollPane.setBackground(Color.WHITE);
            nameLabel.setFont(new Font(nameLabel.getFont().getName(), nameLabel.getFont().getStyle(), 12));
            adressLabel.setFont(new Font(adressLabel.getFont().getName(), adressLabel.getFont().getStyle(), 12));
            rankLabel.setFont(new Font(rankLabel.getFont().getName(), rankLabel.getFont().getStyle(), 12));
            adressField.setBackground(new Color(242, 242, 242));

            

            data_rank = getrank(data_rank);
            rankField = new JComboBox(data_rank);
            rankField.setBackground(Color.WHITE);
            ranksortField.setBackground(Color.WHITE);


            icon = new ImageIcon("meteor-rain.png");
            image = icon.getImage();
            Image imagenew = image.getScaledInstance(175, 175,java.awt.Image.SCALE_SMOOTH);
            icon = new ImageIcon(imagenew);
            commentLabel = new JLabel(icon);
            
            icon = new ImageIcon("Stafflogin.png");
            image = icon.getImage();
            
            SpringLayout layout = new SpringLayout();

            panel.setLayout(layout); 
            panel.add(nameLabel);
            panel.add(rankLabel);panel.add(adressLabel);panel.add(nameField);
            panel.add(rankField);panel.add(adressField);panel.add(addButton);
            panel.add(changeButton);panel.add(deleteButton);
            panel.add(idLabel);panel.add(idField);
            panel.add(staffScrollPane);
            panel.add(idsortLabel);panel.add(idsortButton);panel.add(idsortField);
            panel.add(ranksortButton);panel.add(ranksortLabel);panel.add(ranksortField);
            panel.add(rankmenubButton);panel.add(commentLabel);

            layout.putConstraint(SpringLayout.NORTH, idLabel, 5, SpringLayout.NORTH, panel);
            layout.putConstraint(SpringLayout.WEST, idLabel, 5, SpringLayout.WEST, panel);
            layout.putConstraint(SpringLayout.NORTH, idField, 0, SpringLayout.NORTH, idLabel);
            layout.putConstraint(SpringLayout.WEST, idField, 100, SpringLayout.WEST, idLabel);
            layout.putConstraint(SpringLayout.WEST, nameLabel, 5 , SpringLayout.WEST, panel);
            layout.putConstraint(SpringLayout.NORTH, nameLabel, 65 , SpringLayout.NORTH, panel);
            layout.putConstraint(SpringLayout.WEST, rankLabel, 5 , SpringLayout.WEST, panel);
            layout.putConstraint(SpringLayout.NORTH, rankLabel, 70 , SpringLayout.NORTH, nameLabel);
            layout.putConstraint(SpringLayout.WEST, adressLabel, 5, SpringLayout.WEST, panel);
            layout.putConstraint(SpringLayout.NORTH, adressLabel, 70, SpringLayout.NORTH, rankLabel);
            layout.putConstraint(SpringLayout.NORTH, nameField, 0 , SpringLayout.NORTH,nameLabel);
            layout.putConstraint(SpringLayout.WEST, nameField, 100 , SpringLayout.WEST,nameLabel);
            layout.putConstraint(SpringLayout.WEST, rankField , 70 , SpringLayout.WEST, nameField );
            layout.putConstraint(SpringLayout.NORTH, rankField , 70 , SpringLayout.NORTH, nameField );
            layout.putConstraint(SpringLayout.WEST, adressField , 0-70 , SpringLayout.WEST, rankField );
            layout.putConstraint(SpringLayout.NORTH, adressField , 70 , SpringLayout.NORTH, rankField );

            layout.putConstraint(SpringLayout.NORTH,addButton , 190 ,SpringLayout.NORTH, rankField);
            layout.putConstraint(SpringLayout.WEST,addButton , 0 ,SpringLayout.WEST, adressLabel);
            layout.putConstraint(SpringLayout.NORTH,changeButton , 0 ,SpringLayout.NORTH, addButton);
            layout.putConstraint(SpringLayout.WEST,changeButton , 125 ,SpringLayout.WEST, addButton);
            layout.putConstraint(SpringLayout.NORTH,deleteButton , 0 ,SpringLayout.NORTH, changeButton);
            layout.putConstraint(SpringLayout.WEST,deleteButton , 120 ,SpringLayout.WEST, changeButton);

            layout.putConstraint(SpringLayout.WEST, staffScrollPane , 270,SpringLayout.WEST, nameField);
            layout.putConstraint(SpringLayout.NORTH, staffScrollPane , 0,SpringLayout.NORTH, idLabel);
            layout.putConstraint(SpringLayout.NORTH, idsortLabel, 420,SpringLayout.NORTH, staffScrollPane);
            layout.putConstraint(SpringLayout.WEST, idsortLabel, 0,SpringLayout.WEST, staffScrollPane);
            layout.putConstraint(SpringLayout.NORTH, idsortField, 0,SpringLayout.NORTH, idsortLabel);
            layout.putConstraint(SpringLayout.WEST, idsortField, 90,SpringLayout.WEST, idsortLabel);
            layout.putConstraint(SpringLayout.NORTH, idsortButton, -7,SpringLayout.NORTH, idsortField);
            layout.putConstraint(SpringLayout.WEST, idsortButton, 150,SpringLayout.WEST, idsortField);

            layout.putConstraint(SpringLayout.NORTH, ranksortLabel, 40,SpringLayout.NORTH, idsortLabel);
            layout.putConstraint(SpringLayout.WEST, ranksortLabel, 0,SpringLayout.WEST, idsortLabel);
            layout.putConstraint(SpringLayout.NORTH, ranksortField, 0,SpringLayout.NORTH, ranksortLabel);
            layout.putConstraint(SpringLayout.WEST, ranksortField, 90,SpringLayout.WEST, ranksortLabel);
            layout.putConstraint(SpringLayout.NORTH, ranksortButton, 0,SpringLayout.NORTH, ranksortField);
            layout.putConstraint(SpringLayout.WEST, ranksortButton, 150,SpringLayout.WEST, ranksortField);

            layout.putConstraint(SpringLayout.NORTH, rankmenubButton, 50, SpringLayout.NORTH, ranksortLabel);
            layout.putConstraint(SpringLayout.WEST, rankmenubButton, 0, SpringLayout.WEST, ranksortButton);
            
            layout.putConstraint(SpringLayout.NORTH, commentLabel , 45, SpringLayout.NORTH, addButton);
            layout.putConstraint(SpringLayout.WEST, commentLabel, 70, SpringLayout.WEST, addButton);

            
            idField.setEnabled(false);
            nameField.setEnabled(false);
            adressField.setEnabled(false);
            rankField.setEnabled(false);
            staffTable.setEnabled(true);
            

            showStaff(staffXML);
            
            this.add(panel);
            this.pack();
            this.setTitle("Quản lý nhân sự");
            this.setSize(1000,600);
            this.setResizable(false);
            this.setLocationRelativeTo(null);
            this.setIconImage(image);
            
        }

        public void showStaff(StaffXML stffxml){
            Object[][] data = new Object[staffXML.get_size()][6];
            

            for(int i = 0 ; i<stffxml.get_size() ; i++){
                staff = stffxml.get_staffxml(i);
                data[i][0] = i+1;
                data[i][1] = staff.get_id();
                data[i][2] = staff.get_name();
                data[i][3] = staff.get_adress();
                data[i][4] = staff.get_rank();
                data[i][5] = staff.get_salary();
            }
            staffTable.setModel(new DefaultTableModel(data,columnnames));
        }

        public DefaultComboBoxModel getrank(DefaultComboBoxModel data_rank){
            for(int i = 0 ; i < rankXML.get_size() ; i++){
                rank = rankXML.get_Rank(i);
            data_rank.addElement(rank.get_rank());
            }
            return data_rank;
        }

        public void sortbySalary(double number){
            StaffXML sort = new StaffXML();
            for(int i = 0 ; i<staffXML.get_size() ; i++){
                staff = staffXML.get_staffxml(i);
                if(number < staff.get_salary()){
                    sort.set_staffxml(staff);
                }
            }
            showStaff(sort);

        }

        public void sortbyRank(String str){
            StaffXML sort = new StaffXML();
            for(int i = 0 ; i<staffXML.get_size() ; i++){
                staff = staffXML.get_staffxml(i);
                if(str.equals(staff.get_rank())){
                    sort.set_staffxml(staff);
                }
            }
            showStaff(sort);

        }

      /*  public void addStaff(){
        if(nameField.isEnabled() == false){

        
            adressField.setEnabled(true);
            nameField.setEnabled(true);
            idField.setEnabled(false);
            rankField.setEnabled(true);
            changeButton.setEnabled(false);
            deleteButton.setEnabled(false);
        }
        else{
            staff = new Staff(getName(), WIDTH, getName(), ABORT);
                staff.set_name(nameField.getText());
                staff.set_adress(adressField.getText());
                staff.set_rank(rankField.getText());
            showStaff(staffXML);
        }
        }
        */

        public void nameField_setEnabled(boolean bol){
            nameField.setEnabled(bol);
        }
        public boolean nameField_isEnabled(){
            return nameField_isEnabled();
        }
        public void idField_setEnabled(boolean bol){
            idField.setEnabled(bol);
        }
        public boolean idField_isEnabled(){
            return idField_isEnabled();
        }
        public void rankfield_setEnabled(boolean bol){
            rankField.setEnabled(bol);
        }
        public boolean rankField_isEnabled(){
            return rankField_isEnabled();
        }
        public void adressField_setEndable(boolean bol){
            adressField.setEnabled(bol);
        }
        public boolean adressField_isEnabled(){
            return adressField_isEnabled();
        }

        public void changeButton_setEnabled(boolean bol){
            changeButton.setEnabled(bol);
        }

        public boolean changeButton_isEnabled(){
            return changeButton.isEnabled();
        }

        public void deleteButton_setEnabled(boolean bol){
            deleteButton.setEnabled(bol);
        }

        public boolean deleteButton_isEnabled(){
            return deleteButton.isEnabled();
        }

        public void addButton_setEndabled(boolean bol){
            addButton.setEnabled(bol);
        }

        public boolean addButton_isEnabled(){
            return addButton.isEnabled();
        }

        public void viewDisable(){
            idField.setEnabled(false);
            nameField.setEnabled(false);
            adressField.setEnabled(false);
            rankField.setEnabled(false);
        }

        public void viewEnable(){
            idField.setEnabled(true);
            nameField.setEnabled(true);
            adressField.setEnabled(true);
            rankField.setEnabled(true);
        }

        public String nameField_getText(){
            return nameField.getText();
        }
        public String idField_getText(){
            return idField.getText();
        }
        public String adressField_getText(){
            return adressField.getText();
        }
        public String rankField_getText(){
            String str = "";
            str = str + rankField.getItemAt(rankField.getSelectedIndex());
            return str;
        }


        public String ranksortField_getText(){
            String str = "";
            str = str + ranksortField.getItemAt(ranksortField.getSelectedIndex());
            return str;
        }

        public void ranksortField_setVisible(boolean bol){
            ranksortField.setEnabled(bol);
        }

        public boolean ranksortField_isEnable(){
            return ranksortField.isEnabled();
        }

        public String salarysortField_getText(){
            return idsortField.getText();
        }

        public boolean nameField_isvalid(){
            boolean bol = nameField.isValid();
            return bol;
        }

        public boolean adressField_isvalid(){
            boolean bol = adressField.isValid();
            return bol;
        }

        public boolean idsortField_isvalid(){
            boolean bol = idsortField.isValid();
            return bol;
        }

        public boolean idsortField_idEntable(){
            boolean bol = idsortField.isEnabled();
            return bol;
        }

        public void idsortField_setVisible(boolean bol){
            idsortField.setEnabled(bol);
        }

        public void idsortField_clear(){
            idsortField.setText("");
        }

        public double idsortField_getText(){
            double number = Double.parseDouble(idsortField.getText());
            return number;
        }

       public void rankBox_reset(RankXML rankXML_){
        
     /*    for(int i = 0 ; i<rankField.getItemCount(); i++){
   
            boolean bol = false;
            for(int j = 0 ; j < rankXML_.get_size() ; j ++){
                rank = rankXML_.get_Rank(j);
            if(rankField.getItemAt(i).equals(rank.get_rank())){
                bol = true;
            }
            }
            if(bol == false){
                rankField.removeItemAt(i);
            }
        }*/

        rankField.removeAllItems();

        for(int i = 0 ; i < rankXML_.get_size() ; i++){
            rank = rankXML_.get_Rank(i);
            rankField.addItem(rank.get_rank());
        }

       }

        

        public boolean addbutton_viewEnable_check(){
            boolean bol = false;
            if((idField.isEnabled() == false) && (nameField.isEnabled() == true) &&(rankField.isEnabled() == true) && (adressField.isEnabled() == true)){
                bol = true;
            }
            return bol;
        }

        public boolean changbutton_viewEndable_check(){
            boolean bol = false;
            if((idField.isEnabled() == true) && (nameField.isEnabled() == true) &&(rankField.isEnabled() == true) && (adressField.isEnabled() == true)){
                bol = true;
            }
            return bol;
        }

        public boolean deletebutton_viewEndable_check(){
            boolean bol = false;
            if((idField.isEnabled() == true) && (nameField.isEnabled() == false) &&(rankField.isEnabled() == false) && (adressField.isEnabled() == false)){
                bol = true;
            }
            return bol;
        }

        public void clearText(){
            nameField.setText("");
            idField.setText("");
            adressField.setText("");
        }



        public void changeStaff(){
            if(idField.isEnabled() == false){
                idField.setEnabled(true);     
                adressField.setEnabled(true);
                nameField.setEnabled(true);
                rankField.setEnabled(false);
                deleteButton.setEnabled(false);
                addButton.setEnabled(false);
            }
            else{
                /////
            }

        }

        public void idField_setText(String str){
            idField.setText(str);
        }
        public void nameField_setText(String str){
            nameField.setText(str);
        }
        public void adressField_setText(String str){
            adressField.setText(str);
        }
        public void rankField_setText(String str){
            rankField.setSelectedItem(str);
        }

        public void deleteStaff(){
            if((idField.isEnabled() == true) && (nameField.isEnabled() == true) ){
                nameField.setEnabled(false);
                adressField.setEnabled(false);
                rankField.setEnabled(false);

            }
            else{
                idField.setEnabled(true);
            }
        }

        public int staffTable_getSelectedRow(){
            return staffTable.getSelectedRow();
        }

        public void addButtonSetaction(ActionListener e){
            addButton.addActionListener(e);
        }

        public void showMessage(String str){
            JOptionPane.showMessageDialog(this,str);
        }

        public void changeButtonSetaction(ActionListener e){
            changeButton.addActionListener(e);
        }

        public void deleteButtonSetaction(ActionListener e){
            deleteButton.addActionListener(e);
        }

        public void ranksortButtonSetaction(ActionListener e){
            ranksortButton.addActionListener(e);
        }

        public void idsortButtonButtonSetaction(ActionListener e){
            idsortButton.addActionListener(e);
        }

        public void rankmenubButtonSetaction(ActionListener e){
            rankmenubButton.addActionListener(e);
        }

    

        


    @Override
    public void actionPerformed(ActionEvent e){

    }
    
}
