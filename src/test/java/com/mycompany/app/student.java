package com.mycompany.app;
import java.util.*;

public class student {
    protected String name;
    protected int age;

        public student(String name , int age){
            this.name = name; this.age = age;

        }

        public void get(){
            Scanner scn = new Scanner(System.in);
            System.out.println("Name: "); this.name = scn.nextLine();
            System.out.println("Age: "); this.age = scn.nextInt(); 
        }
        public void show(){
            System.out.println(name + age);
        }

        public String get_name(){
            return name;
        }

        public int get_age(){
            return age;
        }

}
