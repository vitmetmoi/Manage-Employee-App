package com.mycompany.app.Qlnv.Data;
import com.mycompany.app.Qlnv.Mycompany.*;
import java.util.*;
import java.io.*;


public class FileUtil {

ArrayList<String> arr;
ArrayList<String> arr_list;
Set<String> set;

  public FileUtil(){
    arr = new ArrayList<>();
    set = new LinkedHashSet<>(); 
  }

   
    public void File_Staff_Write(StaffXML staffXML,User user){
      try {
        File myObj = new File("Staff.txt");
        if (myObj.createNewFile()) {
          System.out.println("File created: " + myObj.getName());
        } else {
          System.out.println("Access file succesful");
        }
      } catch (IOException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
      }

        try {
          File_Staff_Read_all(staffXML,user);
          File_Staff_Write_all(staffXML, user);
            
            FileWriter myWriter = new FileWriter("Staff.txt");
            
            
              
                for(int i = 0 ; i<arr.size(); i++){
                  String str =(String) arr.get(i);
                  String[] words =str.split(",");
                  if(words[0].equals(user.get_username())){
                    arr.remove(i);
                  }
                }

          
                for(int i = 0 ; i< staffXML.get_size(); i++){
                  Staff staff = staffXML.get_staffxml(i);
                  String strID = String.valueOf(staff.get_id());
                  String str = user.get_username() + "," + staff.get_name()+"," + strID + "," + staff.get_rank() +","+staff.get_adress() + ","+ Double.toString(staff.get_salary());
                  arr.add(str);
                }
                duplicate_(staffXML,user);

                File_Staff_Write_all(staffXML,user);

                myWriter.close();

                
                

            System.out.println("Successfully wrote to the file.");
          } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
    }

    public void File_Staff_Read(StaffXML staffXML,User user){
      staffXML.clear();
    try {
      File myObj = new File("Staff.txt");
      Scanner myReader = new Scanner(myObj);
      boolean bol = false;
      Staff staff = new Staff(null, 0, null, 0,null);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        String[] words = data.split(",");
        String str = "";
          if(words[0].equals(user.get_username())){
            staff = new Staff(data, 0, data, 0,null);
            staff.set_name(words[1]);
            staff.set_id(Integer.parseInt(words[2]));
            staff.set_rank(words[3]);
            staff.set_adress(words[4]);
            staff.set_salary(Double.parseDouble(words[5]));
            staffXML.set_staffxml(staff);
            }
            
            
          }
          myReader.close();
      
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    }



    public long File_Staff_Checkempty(){
   File myFile = new File("Staff.txt");
   return myFile.length();
    }
    /*public void File_Rank_Read(RankXML rankXML){
      try {
        File myObj = new File("Rank.txt");
        Scanner myReader = new Scanner(myObj);
        Rank rank = new Rank();
        int i = 0;
        while (myReader.hasNextLine()) {
          rank = new Rank();
            String data = myReader.nextLine();
            String[] words = data.split(" ");
            rank.set_rank(words[0]);
            rank.set_salary(Double.parseDouble(words[1]));
            rankXML.set_rankxml(rank);
            i++;
        }
        myReader.close();
      } catch (FileNotFoundException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
      }
    }*/
  

  public void File_Staff_Read_all(StaffXML staffXML,User user){

    try {
      File myObj = new File("Staff.txt");
      if (myObj.createNewFile()) {
        System.out.println("File created: " + myObj.getName());
      } else {
        System.out.println("Access file succesful");
      }
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }


  try {
    File myObj = new File("Staff.txt");
    Scanner myReader = new Scanner(myObj);
    while (myReader.hasNextLine()) {
      String data = myReader.nextLine();
      arr.add(data);
    }
    duplicate_(staffXML, user);

    myReader.close();
  }
  catch (FileNotFoundException e) {
    System.out.println("An error occurred.");
    e.printStackTrace();
  }

        
      }

public void File_Staff_Write_all(StaffXML staffXML,User user){
          try {
            File myObj = new File("Staff.txt");
            if (myObj.createNewFile()) {
              System.out.println("File created: " + myObj.getName());
            } else {
              System.out.println("Access file succesful");
            }
          } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }



          try {
              FileWriter myWriter = new FileWriter("Staff.txt");
                for(int i = 0 ; i<arr.size(); i++){
                  myWriter.write(arr.get(i)+"\n");
                }
                duplicate_(staffXML,user);
                myWriter.close();
    
              System.out.println("Successfully wrote to the file.");
            } catch (IOException e) {
              System.out.println("An error occurred.");
              e.printStackTrace();
            }
        }
      


  public void File_Rank_Write(RankXML rankXML){
      try {
          File myObj = new File("Rank.txt");
          if (myObj.createNewFile()) {
            System.out.println("File created: " + myObj.getName());
          } else {
            System.out.println("Access file succesful");
          }
        } catch (IOException e) {
          System.out.println("An error occurred.");
          e.printStackTrace();
        }

      try {
          FileWriter myWriter = new FileWriter("Rank.txt");
            for(int i = 0 ; i<rankXML.get_size(); i++){
              Rank rank = rankXML.get_Rank(i);
              myWriter.write(rank.get_rank() + "," + rank.get_salary() + "\n");
            }
            myWriter.close();

          System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
          System.out.println("An error occurred.");
          e.printStackTrace();
        }
  }

  public void File_Rank_Read(RankXML rankXML){
    try {
      File myObj = new File("Rank.txt");
      Scanner myReader = new Scanner(myObj);
      System.out.println(myObj.length());
      if(myObj.length() >1){
      Rank rank = new Rank();
      int i = 0;
      while (myReader.hasNextLine()) {
        rank = new Rank();
          String data = myReader.nextLine();
          String[] words = data.split(",");
          rank.set_rank(words[0]);
          rank.set_salary(Double.parseDouble(words[1]));
          rankXML.set_rankxml(rank);
          i++;
      }
    }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  
  }

  public long File_Rank_isEmpty(){
    File myObj = new File("Rank.txt");
    return myObj.length();
  }

  public void File_User_Write(UserXML userxml){
    try {
        File myObj = new File("User.txt");
        if (myObj.createNewFile()) {
          System.out.println("File created: " + myObj.getName());
        } else {
          System.out.println("Access file succesful");
        }
      } catch (IOException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
      }

    try {
        FileWriter myWriter = new FileWriter("User.txt");
          for(int i = 0 ; i<userxml.get_size(); i++){
            User user = userxml.get_user(i);
            myWriter.write(user.get_username() + "\n" + user.get_password() + "\n");
          }
          myWriter.close();

        System.out.println("Successfully wrote to the file.");
      } catch (IOException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
      }
}


  public void File_User_Read(UserXML userXML){
      try {
        File myObj = new File("User.txt");
        Scanner myReader = new Scanner(myObj);
        User user = new User();
        int i = 0;
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            if(i == 0){
              user.set_username(data);
              i++;
              continue;
            }
            if(i == 1){
              user.set_password(data);
              userXML.set_user(user);
              user = new User();
              i = 0;
            }
            
        }
        myReader.close();
      } catch (FileNotFoundException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
      }
    }

    public void duplicate_(StaffXML staffXML,User user){
      for(int i = 0 ; i < arr.size() ; i ++){
        set.add(arr.get(i));
      }

      arr.clear();

      Iterator<String> iterator = set.iterator();
      while (iterator.hasNext()) {
       arr.add(iterator.next());
    }
    set.clear();

        
      boolean bol = false;      
       for(int i = 0 ; i < arr.size() ; i ++){
        String[] words = arr.get(i).split(",");
        if(words[0].equals(user.get_username())){       
        bol = false;
        for(int j = 0 ; j < staffXML.get_size(); j++){
            Staff staff = staffXML.get_staffxml(j);
            String strID = String.valueOf(staff.get_id());
            String str = user.get_username() + "," + staff.get_name()+"," + strID + "," + staff.get_rank() +","+staff.get_adress() + ","+ Double.toString(staff.get_salary());
            
            if(arr.get(i).equals(str)){
              bol = true;
            }
          
        }
        if(bol == false){
          arr.remove(i);
        }
      }
      }

      
    }
}



