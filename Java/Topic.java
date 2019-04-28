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
   
   public Topic(){
   
   }
   
   public Topic(int topicID){
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
   public int getTopicID(int ID) { return topicID; }
   
   public String getName(String name) { return topicName; }
   
   public int getFacID(int ID) { return facID; }
   
   public String getTags(String newTags) { return tags; }
   
   public String getDesc(String description) { return topicDescription; }
   
   
   public ArrayList selectQuery(String sql){
          DBConnFive db = new DBConnFive();
          String query = "SELECT * from Topic";
         return db.getData(query);
   }
   
     public int updateQuery(String sql){
         int end = 0;
         DBConnFive db = new DBConnFive();
         if(sql.contains("UPDATE")){
            end = db.setData(sql);
         } 
         return end;
   }
   
     public int insertQuery(String sql){
         int end = 0;
         DBConnFive db = new DBConnFive();
         if(sql.contains("INSERT")){
            end = db.setData(sql);
         } 
         return end;
   }
   
     public int deleteQuery(String sql){
         int end = 0;
         DBConnFive db = new DBConnFive();
         if(sql.contains("DELETE")){
            end = db.setData(sql);
         }
         return end;    
   }
   
}