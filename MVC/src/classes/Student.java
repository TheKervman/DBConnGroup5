package classes;

import java.sql.*;
import java.util.ArrayList;

public class Student{


   public int studID;
   public int interestID;
   public String studName;
   public String email;
   DBConnFive DBC = new DBConnFive();

   Student(){ }

   Student(int studID){
      this.studID=studID;
   }

   Student (int studID, String studName, String email, int interestID) {
      this.studID=studID;
      this.studName=studName;
      this.email=email;
      this.interestID=interestID;
   }
   //Mutators
   public int setStudID(int newStudID){
      studID=newStudID;
   }

   public String setStudName(String newStudName){
      studName=newStudName;
   }

   public String setEmail(String newEmail){
      email=newEmail;
   }

   public int setInterestID(int newInterestID){
      interestID=newInterestID;
   }



   //Accessors
   public int getStudID(){
         return studID;
   }

   public String getStudName(){
         return studName;
   }

   public String getEmail() {
         return email;
   }

   public int getInterestID(){
         return equipID;
   }



   public ArrayList selectQuery(String sql){
      DBConnFive DBCF = new DBConnFive();
      return DBCF.getData(sql);
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