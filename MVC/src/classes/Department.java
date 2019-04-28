package classes;

import java.sql.*;
import java.util.ArrayList;

public class Department{

   public int departmentID;
   public String departmentName;
   public String departmentCode;

   Department(){ }

   Department(int departmentID){
      this.departmentID=deparmentID;
   }

   Department (int departmentID, String departmentName, String departmentCode) {
      this.departmentID=departmentID;
      this.departmentName=departmentName;
      this.depatmentCode=departmentCode;
      this.interestID=interestID;
   }

   //Accessors
   public int getdepartmentID(){
      return departmentID;
   }
   public String getdepartmentName(){
      return departmentName;
   }
   public String getdepartmentCode(){
      return departmentCode;
   }



   //Mutators
   public void setdepartmentID(int newdepartmentID){
      departmentID=newdepartmentID;
   }
   public void setdepartmentName(String newdepartmentName){
      departmentName=newdepartmentName;
   }
   public void setdepartmentCode(String newdepartmentCode){
      departmentCode=newdepartmentCode;
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