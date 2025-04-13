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

public class Staffcontroller extends JFrame implements ActionListener {
    StaffXML staffXML;
    RankXML rankXML;
    Staff staff;
    Rank rank;
    Staffview staffview;
    FileUtil file;
    User user;
    RankView rankview;
    RankController rankController;

    public Staffcontroller(StaffXML staffXML , RankXML rankXML , User user){
        this.staffXML = staffXML ; this.rankXML = rankXML; this.user = user;
        file = new FileUtil();
        staffview = new Staffview(staffXML,rankXML);
        rankview = new RankView(rankXML);
        rankController = new RankController(rankXML);
        staffview.addButtonSetaction(new addButtonSetaction());
        staffview.changeButtonSetaction(new changeButtonSetaction());
        staffview.deleteButtonSetaction(new deleteButtonSetaction());
        staffview.idsortButtonButtonSetaction(new idsortsetActon());
        staffview.ranksortButtonSetaction(new ranksortAction());
        staffview.rankmenubButtonSetaction(new changeRankAction());

        file.File_Staff_Read(staffXML, user);
        staffview.showStaff(staffXML);
    }

    public void showStaffView(){
        staffview.setVisible(true);
    }

    public class addButtonSetaction implements ActionListener {
        public void actionPerformed(ActionEvent e){
                
            
        double randomdouble = Math.random();
            if(staffview.addbutton_viewEnable_check() == false){
                rankXML.clear_rank();
                file.File_Rank_Read(rankXML);
                staffview.rankBox_reset(rankXML);
                staffview.adressField_setEndable(true);
                staffview.nameField_setEnabled(true);
                staffview.idField_setEnabled(false);
                staffview.rankfield_setEnabled(true);
                staffview.changeButton_setEnabled(false);
                staffview.deleteButton_setEnabled(false);
            }
            else{
                if(staffview.nameField_getText().equals("")){
                    rankXML.clear_rank();
                    file.File_Rank_Read(rankXML);
                    staffview.viewDisable();
                    staffview.clearText();
                    staffview.addButton_setEndabled(true);
                    staffview.changeButton_setEnabled(true);
                    staffview.deleteButton_setEnabled(true);
                    
                    }
                    else{
                
                      staff = new Staff(null, 0, null, 0,null);
                        staff.set_name(staffview.nameField_getText());
                        staff.set_adress(staffview.adressField_getText());
                        staff.set_rank(staffview.rankField_getText());
                        for(int i = 0 ; i < rankXML.get_size();i++){
                        rank = rankXML.get_Rank(i);
                        if(staffview.rankField_getText().equals(rank.get_rank())){
                            staff.set_salary(rank.get_salary());
                        }
                }
                    int id = (int) (randomdouble*10000);
                    String id_current ="2301" + String.valueOf(id);
                    staff.set_id(Integer.parseInt(id_current));
                    staffXML.set_staffxml(staff);
                    file.File_Staff_Write(staffXML, user);
                        staffview.showStaff(staffXML);
                        staffview.viewDisable();
                        staffview.changeButton_setEnabled(true);
                        staffview.deleteButton_setEnabled(true);    
                        staffview.clearText();
                }
            }
          }
    } 

    class changeButtonSetaction implements ActionListener {
        public void actionPerformed(ActionEvent e){
            if(staffview.changbutton_viewEndable_check() == false){
                rankXML.clear_rank();
                file.File_Rank_Read(rankXML);
                staffview.rankBox_reset(rankXML);
                staffview.adressField_setEndable(true);
                staffview.nameField_setEnabled(true);
                staffview.idField_setEnabled(true);
                staffview.rankfield_setEnabled(true);
                staffview.addButton_setEndabled(false);
                staffview.deleteButton_setEnabled(false);
                staff = staffXML.get_staffxml(staffview.staffTable_getSelectedRow());
                staffview.idField_setText(String.valueOf(staff.get_id()));
                staffview.nameField_setText(staff.get_name());
                staffview.adressField_setText(staff.get_adress());
                staffview.rankField_setText(staff.get_rank());
            }
            else{
                if(staffview.idField_getText().equals("")){
                staffview.viewDisable();
                staffview.clearText();
                staffview.addButton_setEndabled(true);
                staffview.changeButton_setEnabled(true);
                staffview.deleteButton_setEnabled(true);
                }
                else{
                staffXML.setstaff(new Staff(staffview.nameField_getText(),Integer.parseInt(staffview.idField_getText()) ,staffview.rankField_getText(), rankXML.get_salary(staffview.rankField_getText()),staffview.adressField_getText()),Integer.parseInt(staffview.idField_getText()));
                staffXML.show();
                file.File_Staff_Write(staffXML, user);
                staffview.showStaff(staffXML);
                staffview.viewDisable();
                staffview.clearText();
                staffview.addButton_setEndabled(true);
                staffview.changeButton_setEnabled(true);
                staffview.deleteButton_setEnabled(true);
                }
            }
    }}

    public class deleteButtonSetaction implements ActionListener {
        public void actionPerformed(ActionEvent e){
    
            staff = staffXML.get_staffxml(staffview.staffTable_getSelectedRow());
             if(staffview.deletebutton_viewEndable_check() == false){
                rankXML.clear_rank();
                file.File_Rank_Read(rankXML);
                staffview.rankBox_reset(rankXML);
                staffview.adressField_setEndable(false);
                staffview.nameField_setEnabled(false);
                staffview.idField_setEnabled(true);
                staffview.rankfield_setEnabled(false);
                staffview.addButton_setEndabled(false);
                staffview.changeButton_setEnabled(false);
                staffview.deleteButton_setEnabled(true);
                staffview.idField_setText(String.valueOf(staff.get_id()));
            }

            else{
                 if(staffview.idField_getText().equals("")){
                    staffview.viewDisable();
                    staffview.clearText();
                    staffview.addButton_setEndabled(true);
                    staffview.changeButton_setEnabled(true);
                    staffview.deleteButton_setEnabled(true);
                 }
                 else{  
                            int id = Integer.parseInt(staffview.idField_getText());
                                for(int i = 0 ; i < staffXML.get_size() ; i ++){
                                staff = staffXML.get_staffxml(i);
                                if(id == staff.get_id()){
                                    staffXML.deletestaff(i);
                                    break;
                                }}
                            file.File_Staff_Write(staffXML, user);
                            staffview.showStaff(staffXML);
                            staffview.viewDisable();
                            staffview.clearText();
                            staffview.addButton_setEndabled(true);
                            staffview.changeButton_setEnabled(true);
                            staffview.deleteButton_setEnabled(true);    
                            }
                        }
                    }
                }
    

    public class idsortsetActon implements ActionListener {
        public void actionPerformed(ActionEvent e){
            if(staffview.idsortField_idEntable() == true){
                staffview.sortbySalary(staffview.idsortField_getText());
                staffview.idsortField_setVisible(false);
            }
            else{
                staffview.idsortField_setVisible(true);
                staffview.idsortField_clear();
                staffview.showStaff(staffXML);
            }
        }
    }

    public class ranksortAction implements ActionListener {
        public void actionPerformed(ActionEvent e){
            if(staffview.ranksortField_isEnable()){
                staffview.sortbyRank(staffview.ranksortField_getText());
                staffview.ranksortField_setVisible(false);
            }
            else{
                staffview.ranksortField_setVisible(true);
                staffview.showStaff(staffXML);
            }
        }
    }

    public class changeRankAction implements ActionListener{
        public void actionPerformed(ActionEvent e){
            rankController.rankview_setVisible(true);
        }
    }

    @Override 
    public void actionPerformed(ActionEvent e){

    }


}
