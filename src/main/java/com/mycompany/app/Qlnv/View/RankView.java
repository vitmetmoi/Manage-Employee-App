package com.mycompany.app.Qlnv.View;

import com.mycompany.app.Qlnv.Mycompany.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

import javax.imageio.ImageIO;


import java.util.*;


public class RankView extends JFrame implements ActionListener {

    private JButton addButton, deleteButton,changeButton;
    private JLabel addLabel, deleteLabel,changeLabel,rankLabel,salaryLabel;

    private JScrollPane textPane; private JTable table;
    private JTextField changeField,addField;

    private JTextField rankField,salaryField;
    private JComboBox rankBox;

    private RankXML rankXML; private JPanel panel;
    

    Rank rank;

    private String[] columnnames = new String[]{
        "Chức vụ","Hệ số lương"
    };

    private Object data = new Object [][]{};
    
        public RankView (RankXML rankXML_){
            this.rankXML = rankXML_;
            show_rank_view();
        }
        public void set_Visible(boolean bol){
            this.setVisible(bol);
        }
        public boolean is_Visible(){
            return this.isVisible();
        }

            public void show_rank_view(){
                DefaultComboBoxModel data_rank = new DefaultComboBoxModel();
                addButton = new JButton("Thêm chức vụ"); changeButton = new JButton("Chỉnh sửa chức vụ"); deleteButton = new JButton("Xóa chức vụ");
                rankLabel = new JLabel("Chức vụ"); salaryLabel = new JLabel("Hệ số lương"); panel = new JPanel(){
                    @Override
                    public void paintComponent(Graphics g){
                        super.paintComponent(g);
                        Graphics2D g2d = (Graphics2D) g;
                        Rectangle rec = new Rectangle(0,0,500,400);
                        g2d.setColor(Color.WHITE);
                        g2d.fill(rec);
                    }
                };
                rankField = new JTextField(15); salaryField = new JTextField(15);
                table = new JTable();
                textPane = new JScrollPane();
                
                changeButton.setFont(new Font(changeButton.getFont().getName(), changeButton.getFont().getStyle(), 9));
                deleteButton.setFont(new Font(deleteButton.getFont().getName(), deleteButton.getFont().getStyle(), 9)); 
                deleteButton.setPreferredSize(new Dimension(123,21));
                changeButton.setBackground(new Color(0, 255, 255));
                deleteButton.setBackground(new Color(0, 255, 255));
                changeButton.setForeground(Color.BLACK);
                deleteButton.setForeground(Color.BLACK);
                data_rank = get_rank(data_rank);
                rankBox = new JComboBox(data_rank);
                rankBox.setBackground(Color.white);

                               
                table.setModel(new DefaultTableModel((Object[][]) data, columnnames));
                textPane.setViewportView(table);
                textPane.setPreferredSize(new Dimension(480,200));  
                table.setEnabled(true);
                SpringLayout layout = new SpringLayout();
                panel.setLayout(layout);

                panel.add(textPane);
                panel.add(rankField);
                panel.add(salaryField);
                panel.add(rankBox);
                panel.add(rankLabel);
                
                panel.add(salaryLabel);
                panel.add(changeButton);
                panel.add(deleteButton);

                layout.putConstraint(SpringLayout.NORTH,textPane, 2,SpringLayout.NORTH, panel);
                layout.putConstraint(SpringLayout.WEST, textPane, 4, SpringLayout.WEST, panel);
                layout.putConstraint(SpringLayout.NORTH,rankField, 220,SpringLayout.NORTH, textPane);
                layout.putConstraint(SpringLayout.WEST, rankField, 85, SpringLayout.WEST, textPane);
                layout.putConstraint(SpringLayout.NORTH,rankLabel, 0,SpringLayout.NORTH, rankField);
                layout.putConstraint(SpringLayout.WEST, rankLabel, -80, SpringLayout.WEST, rankField);
                layout.putConstraint(SpringLayout.NORTH,salaryField, 40,SpringLayout.NORTH, rankField);
                layout.putConstraint(SpringLayout.WEST, salaryField, 0, SpringLayout.WEST, rankField);
                layout.putConstraint(SpringLayout.NORTH,salaryLabel, 0,SpringLayout.NORTH, salaryField);
                layout.putConstraint(SpringLayout.WEST, salaryLabel, -80, SpringLayout.WEST, salaryField);
                layout.putConstraint(SpringLayout.NORTH,rankBox, 40,SpringLayout.NORTH, salaryField);
                layout.putConstraint(SpringLayout.WEST, rankBox, 163, SpringLayout.WEST, salaryField);
                
                layout.putConstraint(SpringLayout.NORTH,changeButton, 0,SpringLayout.NORTH, rankField);
                layout.putConstraint(SpringLayout.WEST, changeButton, 160, SpringLayout.WEST, rankField);
                layout.putConstraint(SpringLayout.NORTH,deleteButton, 0,SpringLayout.NORTH, salaryField);
                layout.putConstraint(SpringLayout.WEST, deleteButton, 160, SpringLayout.WEST, salaryField);
                

                show_rank(rankXML);
                rankField.setEnabled(false);
                salaryField.setEnabled(false);
                this.add(panel);
                this.pack();
                this.setTitle("Quản lý chức vụ");
                this.setSize(500,400);
                this.setResizable(false);
                this.setLocationRelativeTo(null);


            }
            public DefaultComboBoxModel get_rank(DefaultComboBoxModel data_rank){
                String[] str ;
                for(int i = 0 ;i<rankXML.get_size()  ; i++ ){
                    rank = rankXML.get_Rank(i);
                    data_rank.addElement(rank.get_rank());
                }

                return data_rank;
            }

            public void show_rank(RankXML rankxml){
                Object[][] data = new Object[rankxml.get_size()][2];
                for(int i = 0 ; i< rankxml.get_size(); i++){
                    rank = rankxml.get_Rank(i);
                    
                    data[i][0] ="                           " +rank.get_rank();
                    data[i][1] ="                              " + rank.get_salary();

                }

                table.setModel(new DefaultTableModel(data,columnnames));
            }

            public void rankBox_remove(Rank Rank_){
                rankBox.removeItem(Rank_.get_rank());
            }

            public void rankBox_add(Rank rank_){
                rankBox.addItem(rank_.get_rank());
            }

            public void rankBox_create(DefaultComboBoxModel data_rank){
                this.rankBox = new JComboBox(data_rank);
            }

            public void rankBox_setInformation(String str){
                rankBox.setSelectedItem(str);
            }

            public String rankField_getText(){
                return rankField.getText();
            }
            public String salaryField_getText(){
                return salaryField.getText();
            }
            public void changeButton_setActionListener(ActionListener e){
                changeButton.addActionListener(e);
            }
            public void deleteButton_setActionListener(ActionListener e){
                deleteButton.addActionListener(e);
            }
            public void RankField_setEnable(boolean bol){
                rankField.setEnabled(bol);
            }
            public void salaryField_setEnable(boolean bol){
                salaryField.setEnabled(bol);
            }
            public void changeButton_setEnable(boolean bol){
                changeButton.setEnabled(bol);
            }
            public void rankbox_setEnable(boolean bol){
                rankBox.setEnabled(bol);
            }
            public boolean rankField_isEnabled(){
                return rankField.isEnabled();
            }
            public boolean salaryField_isEnabled(){
                return salaryField.isEnabled();
            }
            public boolean changeButton_isEnabled(){
                return changeButton.isEnabled();
            }
            public boolean deleteButton_isEnabled(){
                return deleteButton.isEnabled();
            }
            
            public void deleteButton_setEnable(boolean bol){
                deleteButton.setEnabled(bol);
            }
            public void clear_Text(){
                rankField.setText("");
                salaryField.setText("");
            }
            public String rankBox_getText(){
                String str = "" + rankBox.getSelectedItem();
                return str;
            }

            public int rankTalbe_getSelectedRow(){
                return table.getSelectedRow();
            }

            public void rankField_setText(String str){
                rankField.setText(str);
            }
            public void salaryField_setText(String str){
                salaryField.setText(str);
            }

            public void table_setEnable(boolean bol){
                table.setEnabled(bol);
            }


@Override
public void actionPerformed(ActionEvent e){

}
}
