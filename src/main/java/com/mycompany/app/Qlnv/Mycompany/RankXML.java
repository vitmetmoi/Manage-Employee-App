package com.mycompany.app.Qlnv.Mycompany;
import java.util.*;

public class RankXML {
    private ArrayList<Rank> rankxml;
    Rank rank;

    public RankXML(){
        rankxml = new ArrayList<>();
    }

    public void set_rankxml(Rank rank){
        rankxml.add(rank);
    }

    public Rank get_Rank(int i){
        return rankxml.get(i);
    }

    public double get_salary(String r){
        double salary = 0.0;
        for(int i = 0 ; i < rankxml.size();i++){
            rank = rankxml.get(i);
            if(r.equals(rank.get_rank())){
                salary = rank.get_salary();
                break;
            }
        }
        return salary;
    }

    public void clear_rank(){
        rankxml.clear();
    }

    public void delete_rank(int i){
        rankxml.remove(i);
    }
    public void set_rank(Rank rank,int i){
        rankxml.set(i, rank);
    }

    public int get_size(){
        return rankxml.size();
    }
    
}
