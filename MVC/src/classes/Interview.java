package classes;

import java.sql.*;
import java.util.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Interview{
   
   
   public int interviewID; 
   public String interviewName;
   public String interviewDate;
   public String facultyMemeber;
   DBConnFive DBC = new DBConnFive();
   
   public Interview(){
   
   }
   
   public Interview(int interviewID){
      this.interviewID = interviewID;
   }
   
   public Interview(int interviewID, String interviewName, String interviewDate, String facultyMemeber){
      this.interviewID = interviewID;
      this.interviewName = interviewName;
      this.interviewDate = interviewDate;
      this.facultyMemeber = facultyMemeber;
   }
   
   //Mutator methods
   public void setID(int ID) { interviewID = ID; }
   
   public void setName(String name) { interviewName = name; }
   
   public void setDate(String date) { interviewDate = Date; }
   
   public void setMember(String member) { facultyMemeber = member; }
   
   
   
   //Accessor methods
   public int getID(int ID) { return interviewID; }
   
   public String getName(String name) { return interviewName; }
   
   public String getDate(String date) { return interviewDate; }
   
   public String getMember(String member) { return facultyMemeber; }



    public ArrayList selectQuery(String sql){
        DBConnFive DBCF = new DBConnFive();
        return DBCF.getData(sql);
    }
   
     public int updateQuery(String sql){
         int end = 0;
         DBConnFive sql = new DBConnFive();
         if(query.contains("UPDATE")){
            end = sql.setData(query);
         } 
         return end;
   }
   
     public int insertQuery(String sql){
         int end = 0;
         DBConnFive sql = new DBConnFive();
         if(query.contains("INSERT")){
            end = sql.setData(query);
         } 
         return end;
   }
   
     public int deleteQuery(String sql){
         int end = 0;
         DBConnFive sql = new DBConnFive();
         if(query.contains("DELETE")){
            end = sql.setData(query);
         }
         return end;    
   }
   
}