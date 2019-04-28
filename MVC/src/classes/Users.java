package classes;

import java.sql.*;
import java.util.*;

public class Users {

   private int userID;
   private String userName;
   private String password;
   private String role;
   
   public Users(){
   
   }
   
   public Users(int userID){
      this.userID = userID;
   }
   
   public Users(int userID, String userName, String password, String role){
      this.userID = userID;
      this.userName = userName;
      this.password = password;
      this.role = role;
   }

   //Accessors
   public int getID(){
      return userID;
   }
   
   public String getName(){
       return userName;
   }
   
   public String getPassword(){
       return password;
   }
   
   public String getRole(){
       return role;
   }



   //Mutators
   public void setID(int id){
      return userID = id;
   }
   
   public void setName(String name){
       return userName = name;
   }
   
   public void setPassword(String pass){
       return password = pass;
   }
   
   public void setRole(String newRole){
       return role = newRole;
   }



    public ArrayList selectQuery(String sql){
        DBConnFive DBCF = new DBConnFive();
        return DBCF.getData(sql);
    }
   
   public int updateQuery(String sql){
         int end = 0;
         MySQLDatabase sql = new MySQLDatabase();
         if(query.contains("UPDATE")){
            end = sql.setData(query);
         } 
         return end;
   }
   
   public int insertQuery(String sql){
         int end = 0;
         MySQLDatabase sql = new MySQLDatabase();
         if(query.contains("INSERT")){
            end = sql.setData(query);
         } 
         return end;
   }
   
   public int deleteQuery(String sql){
         int end = 0;
         MySQLDatabase sql = new MySQLDatabase();
         if(query.contains("DELETE")){
            end = sql.setData(query);
         }
         return end;    
   }
}