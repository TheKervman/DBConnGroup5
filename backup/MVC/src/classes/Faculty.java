package classes;

import java.sql.*;
import java.util.*;

public class Faculty {
   private int facID;
   private String facName;
   private String departmentCode;
   private int topicCode;
   private String interviewDate;
   private String presentationDate;

   
   public Faculty(){
   
  }
  
  public Faculty(int facID){
      this.facID = facID;
   }
   
   public Faculty(int facID, String facName, String departmentCode ,int topicCode, String interviewDate, String presentationDate){
      this.facID = facID;
      this.facName = facName;
      this.departmentCode = departmentCode;
      this.topicCode = topicCode;
      this.interviewDate = interviewDate;
      this.presentationDate = presentationDate;
   }
   
   public int getID(){
      return facID;
   }
   
    public String getName(){
       return facName;
   }
   
    public String getDepartmentCode(){
          return departmentCode;

   }
   
     public int getTopicCode(){
          return topicCode;

   }
   
   public String getInterviewDate(){
      return interviewDate;
   } 
   
   public String getPresentationDate(){
         return presentationDate;
   } 
   
    public void setID(int id){
      facID = id;;
   }
   
    public void setName(String name){
      facName = name;
   }
   
    public void setDepartmentCode(String dptCode){
          departmentCode = dptCode;

   }
   
     public void setTopicCode(int topic){
          topicCode = topic;

   }
   
   public void setInterviewDate(String intDate){
       interviewDate = intDate;
   } 
   
   public void setPresentationDate(String presDate){
         presentationDate = presDate;
   } 
   
   public ArrayList selectQuery(String sql, int fields){
          DBConnFive sql = new MySQLDatabase();
          query = "SELECT * from classes.Users";
         return sql.getData(query,fields);
   }
   
     public int updateQuery(String sql){
         int end = 0;
         DBConnFive sql = new MySQLDatabase();
         if(query.contains("UPDATE")){
            end = sql.setData(query);
         } 
         return end;
   }
   
     public int insertQuery(String sql){
         int end = 0;
        DBConnFive sql = new MySQLDatabase();
         if(query.contains("INSERT")){
            end = sql.setData(query);
         } 
         return end;
   }
   
     public int deleteQuery(String sql){
         int end = 0;
         DBConnFivesql = new MySQLDatabase();
         if(query.contains("DELETE")){
            end = sql.setData(query);
         }
         return end;    
   }
}