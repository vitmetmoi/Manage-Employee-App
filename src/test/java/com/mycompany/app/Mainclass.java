package com.mycompany.app;
import java.util.*;

public class Mainclass {
    
    public static void main(String[] args){
        student std = new student("",0);
       ArrayList<String> std_name = new ArrayList<String>();
       ArrayList<Integer>std_age  = new ArrayList<Integer>();

            std.get();

            std_name.add(std.get_name());
            std_age.add(std.get_age());

            std.get();
            
            std_name.add(std.get_name());
            std_age.add(std.get_age());

            System.out.println("Name: ");
            for(String i : std_name){
                System.out.println(i);
            }
            System.out.println("Age: ");
            for(int i : std_age){
                System.out.println(i);
            }
    }
    
}
