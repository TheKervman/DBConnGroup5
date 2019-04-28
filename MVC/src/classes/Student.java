package classes;

import java.sql.*;
import java.util.ArrayList;
public class Student{
public int studID, interestID;
public String studName, email;
Student(){
}
Student(int studID){
this.studID=studID;
}
Student (int studID, String studName, String email, int interestID)
   {
      this.studID=studID;
      this.studName=studName;
      this.email=email;
      this.interestID=interestID;
   }
public int getstudID(){
      return studID;
   }
public String getstudName(){
      return studName;
   }
public String getEmail() {
      return email;
   }
public int getinterestID(){
      return equipID;
   }
public void setstudID(int newstudID){
      studID=newstudID;
   }
public void setstudName(String newstudName){
      studName=newstudName;
   }
public void setemail(String newemail){
      email=newemail;
   }
public void setinterestID(int newinterestID){
      interestID=newinterestID;
   }

public ArrayList selectQuery(String sql){
   DBConnFive sql = new DBConnFive();
   query = "SELECT * from classes.Student";
   return sql.getData(query,fields);
   }

public ArrayList updateQuery(String sql){
   int end = 0;
   DBConnFive sql = new DBConnFive();
   if(query.contains("UPDATE")){
      end = sql.setData(query);
      } 
   return end;
   }

public ArrayList insertQuery(String sql){
   int end = 0;
   DBConnFive sql = new DBConnFive();
   if(query.contains("INSERT")){
      end = sql.setData(query);
      } 
   return end;
   }

public ArrayList deleteQuery(String sql){
   int end = 0;
   DBConnFive sql = new DBConnFive();
   if(query.contains("DELETE")){
      end = sql.setData(query);
      }
   return end;   
   }
}