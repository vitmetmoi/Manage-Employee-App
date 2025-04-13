package com.mycompany.app.Qlnv.Mycompany;

public class Staff{
    private String name = "";
    private int ID = 0;
    private String rank = "";
    private double salary = 0.0;
    private String adress = "";


    public Staff(String name , int ID , String rank , double salary,String adress){
        this.name = name;
        this.ID = ID;
        this.rank = rank;
        this.salary = salary; 
        this.adress = adress;
    }

    public void set_name(String name){
        this.name = name;
    }

    public void set_adress(String adress){
        this.adress = adress;
    }

    public void set_id(int ID){
        this.ID = ID;
    }

    public void set_rank(String rank){
        this.rank = rank;
    }

    public void set_salary(double salary){
        this.salary = salary;
    }

    public String get_name(){
        return name;
    }

    public String get_adress(){
        return adress;
    }

    public int get_id(){
        return ID;
    }

    public String get_rank(){
        return rank;
    }

    public double get_salary(){
        return salary;
    }

    public void show(){
        System.out.println("Name: "+name);
        System.out.println("ID: "+ID);
        System.out.println("Rank: "+rank);
        System.out.println("Salary"+salary);
    }
    
}
