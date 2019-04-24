

import java.sql.*;
import java.util.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Presentation{
   
   
   public int presentationID; 
   public String presentationName;
   public String presentationDate;
   public String facultyMemeber;
   DBConnFive DBC = new DBConnFive();
   
   public Presentation(){
   
   }
   
   public Presentation(int presentationID){
      this.presentationID = presentationID;
   }
   
   public Presentation(int presentationID, String presentationName, String presentationDate, String facultyMemeber){
      this.presentationID = presentationID;
      this.presentationName = presentationName;
      this.presentationDate = presentationDate;
      this.facultyMemeber = facultyMemeber;
   }
   
   //Mutator methods
   public void setID(int ID) { presentationID = ID; }
   
   public void setName(String name) { presentationName = name; }
   
   public void setDate(String date) { presentationDate = Date; }
   
   public void setMember(String member) { facultyMemeber = member; }
   
   
   
   //Accessor methods
   public void getID(int ID) { return presentationID; }
   
   public void getName(String name) { return presentationName; }
   
   public void getDate(String date) { return presentationDate; }
   
   public void getMember(String member) { return facultyMemeber; }
   
   
   
   public ArrayList selectQuery(String sql, int fields){
          DBConnFive sql = new DBConnFive();
          query = "SELECT * from Presentation";
         return sql.getData(query,fields);
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