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
   
   public void setID(int id){
      return userID = id;;
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
   
   public ArrayList selectQuery(String sql, int fields){
          MySQLDatabase sql = new MySQLDatabase();
          query = "SELECT * from Users";
         return sql.getData(query,fields);
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