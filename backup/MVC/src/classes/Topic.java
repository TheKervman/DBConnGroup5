package classes;

import java.sql.*;
import java.util.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Topic{
   
   
   public int topicID; 
   public String topicName;
   public int facID;
   public String tags;
   public String topicDescription;
   DBConnFive DBC = new DBConnFive();
   
   public void Users(){
   }
   
   public void Users(int topicID){
      this.topicID = topicID;
   }
   
   public Topic(int topicID, String topicName, int facID, String tags, String topicDescription){
      this.topicID = topicID;
      this.topicName = topicName;
      this.facID = facID;
      this.tags = tags;
      this.topicDescription = topicDescription;
   }
   
   //Mutator methods
   public void setTopicID(int ID) { topicID = ID; }
   
   public void setName(String name) { topicName = name; }
   
   public void setFacID(int ID) { facID = ID; }
   
   public void setTags(String newTags) { tags = newTags; }
   
   public void setDesc(String description) { topicDescription = description; }
   
   
   //Accessor methods
   public void getTopicID(int ID) { return topicID; }
   
   public void getName(String name) { return topicName; }
   
   public void getFacID(int ID) { return facID; }
   
   public void getTags(String newTags) { return tags; }
   
   public void getDesc(String description) { return topicDescription; }
   
   
   public ArrayList selectQuery(String sql, int fields){
          DBConnFive sql = new DBConnFive();
          query = "SELECT * from classes.Topic";
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