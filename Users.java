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
   
   public ArrayList selectQuery(String sql, int fields){
   }
   
     public ArrayList updateQuery(String sql){
   }
   
     public ArrayList insertQuery(String sql){
   }
   
     public ArrayList deleteQuery(String sql){
   }
}