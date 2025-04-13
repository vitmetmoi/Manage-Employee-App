package com.mycompany.app.Qlnv.Mycompany;
import java.util.*;
import com.mycompany.app.Qlnv.Mycompany.*;
import com.mycompany.app.Qlnv.Data.*;

public class StaffXML {
     private ArrayList<Staff> staffxml;
     private Staff staff;
     private Rank rank;
     private RankXML rankXML;
     private FileUtil file;

        public StaffXML(){
            staffxml = new ArrayList<>();
        }

            public void set_staffxml(Staff staff){
                staffxml.add(staff);

            }
            
            public Staff get_staffxml(int i){
                return staffxml.get(i);
            }

            public int get_size(){
                return staffxml.size();
            }
            public boolean search_name(String str){
                boolean bol=false;

                for(int i = 0 ; i<staffxml.size();i++){
                    staff = staffxml.get(i);
                    if(staff.get_name().equals(str)){
                        bol = true;
                    }
                }

                return bol;

            }
            public boolean search_adress(String str){
                boolean bol=false;

                for(int i = 0 ; i<staffxml.size();i++){
                    staff = staffxml.get(i);
                    if(staff.get_adress().equals(str)){
                        bol = true;
                    }
                }
                return bol;

            }

            public void deleteEle_End(){
                staffxml.remove(get_size()-1);
            }
            public void clear(){
                staffxml.clear();
            }

        
            public void show(){
                for(int i = 0 ; i < staffxml.size();i++){
                Staff s = staffxml.get(i);
                s.show();
                }
            }

            public void deletestaff(int i_current){
                staffxml.remove(i_current);
            }

            public void setstaff(Staff staff_,int id_current){
                for(int i = 0 ; i < staffxml.size(); i++){
                    staff = staffxml.get(i);
                    if(staff.get_id() == id_current){
                    staffxml.set(i,staff_);
                    break;
                    }
                }
            }
}
