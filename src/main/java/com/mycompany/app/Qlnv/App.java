
package com.mycompany.app.Qlnv;
import com.mycompany.app.Qlnv.Controller.Logincontroller;
import com.mycompany.app.Qlnv.Data.FileUtil;
import com.mycompany.app.Qlnv.Mycompany.RankXML;
import com.mycompany.app.Qlnv.Mycompany.StaffXML;
import com.mycompany.app.Qlnv.Mycompany.UserXML;

public class App {
    public static void main(String[] args) {

        StaffXML staffXML = new StaffXML();
        RankXML rankXML = new RankXML();
        UserXML userXML = new UserXML();
        FileUtil file = new FileUtil();
        file.File_User_Read(userXML);
        file.File_Rank_Read(rankXML);
        
       Logincontroller logincontroller = new Logincontroller(userXML, staffXML, rankXML);

       logincontroller.show_login_view();

       
       //Author : Bao Duy 
       //Line ammount : 2421     
}
}