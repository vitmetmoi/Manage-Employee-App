package com.mycompany.app.Qlnv.Mycompany;
import java.util.*;

public class UserXML {
    private ArrayList<User> userXML;

    public UserXML(){
        userXML = new ArrayList<>();
    }
    public void set_user(User user){
        userXML.add(user);
    }
    public User get_user(int i){
        return userXML.get(i);
    }
    public int get_size(){
        return userXML.size();
    }

    

    public void show(){
        for(int i = 0 ; i< userXML.size() ; i++){
            User user = userXML.get(i);
        System.out.println(user.get_username() + "\n" + user.get_password());
        }
    }


}
