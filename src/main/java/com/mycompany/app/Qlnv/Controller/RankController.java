package com.mycompany.app.Qlnv.Controller;
import java.awt.FlowLayout;
import java.awt.GridLayout;
 
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.WindowConstants;

import com.mycompany.app.Qlnv.Data.FileUtil;
import com.mycompany.app.Qlnv.Mycompany.*;
import com.mycompany.app.Qlnv.View.Staffview;
import com.mycompany.app.Qlnv.View.RankView;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.*;

public class RankController extends JFrame implements ActionListener {
    RankView rankview;
    Rank rank;
    RankXML rankXML;
    FileUtil file;

    public RankController(RankXML rankXML_){
        this.rankXML = rankXML_;
        rankXML.clear_rank();
        file = new FileUtil();
        file.File_Rank_Read(rankXML);
        rankview = new RankView(rankXML);
        rankview.changeButton_setActionListener(new changeButton_setActionListener());
        rankview.deleteButton_setActionListener(new deleteButton_setActionListener());
        rankview.RankField_setEnable(false);
        rankview.salaryField_setEnable(false);
        rankview.rankbox_setEnable(false);
    }
    public void rankview_setVisible(boolean bol){

        rankview.setVisible(bol);
    }

    public class changeButton_setActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            if((rankview.rankField_isEnabled() == false)&&(rankview.salaryField_isEnabled() == false)){
                rankview.RankField_setEnable(true);
                rankview.salaryField_setEnable(true);
                rankview.deleteButton_setEnable(false);
                rankview.rankbox_setEnable(false);
                if(rankview.rankTalbe_getSelectedRow() != -1){
                rank = rankXML.get_Rank(rankview.rankTalbe_getSelectedRow());
                rankview.rankField_setText(rank.get_rank());
                rankview.salaryField_setText(String.valueOf(rank.get_salary()));
                rankview.table_setEnable(false);
                }
            }
            else{
                if(rankview.rankField_getText().equals("") == true){
                rankview.RankField_setEnable(false);
                rankview.salaryField_setEnable(false);
                rankview.deleteButton_setEnable(true);
                }
                else{
                boolean bol = false;
                for(int i = 0 ; i < rankXML.get_size() ; i ++){
                    rank = rankXML.get_Rank(i);
                       if(rankview.rankField_getText().equals(rank.get_rank())){
                        bol = true;
                        rank = new Rank();
                        rank.set_rank(rankview.rankField_getText());
                        rank.set_salary(Double.parseDouble(rankview.salaryField_getText()));
                        rankXML.set_rank(rank, i);
                        if(rankview.rankTalbe_getSelectedRow() == -1){
                        rankview.rankBox_add(rank);
                        }
                        break;
                       } 
                }
                if(bol==false){
                        rank = new Rank();
                        rank.set_rank(rankview.rankField_getText());
                        rank.set_salary(Double.parseDouble(rankview.salaryField_getText()));
                        rankXML.set_rankxml(rank);
                        rankview.rankBox_add(rank);
                }
                rankview.show_rank(rankXML);
                
                file.File_Rank_Write(rankXML);
                rankview.rankBox_setInformation(rankview.rankField_getText());
                rankview.clear_Text();
                rankview.RankField_setEnable(false);
                rankview.salaryField_setEnable(false);
                rankview.deleteButton_setEnable(true);
                rankview.rankbox_setEnable(false);
                rankview.table_setEnable(true);
            }
          }
        }
    }

    public class deleteButton_setActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            if(rankview.changeButton_isEnabled()){
                rankview.changeButton_setEnable(false);
                rankview.rankbox_setEnable(true);
            }
            else{
                for(int i = 0 ; i < rankXML.get_size();i++){
                    rank = rankXML.get_Rank(i);
                    if(rank.get_rank().equals(rankview.rankBox_getText())){
                        rankXML.delete_rank(i);
                        rankview.rankBox_remove(rank);
                        break;
                    }
                }
                rankview.changeButton_setEnable(true);
                file.File_Rank_Write(rankXML);
                rankview.show_rank(rankXML);
                rankview.rankbox_setEnable(false);
            }
        }
    }




@Override
  public void actionPerformed(ActionEvent e){

    }
}