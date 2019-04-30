package driver;
import java.util.*;
import java.sql.*;
public class Guest{
 Connection conn = null;
 
   public ArrayList displayTopics(){
   //SELECT QUERY
          ArrayList<String> data = new ArrayList<String>();
          DBConnFive db = new DBConnFive();
          String firstCol = null;
          Statement state = null; 
          conn = db.connect();
          String sql = "SELECT topicID,topicName FROM Topic;";
          int col = 0;
          try{
            state = conn.createStatement();            
            ResultSet rs = state.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();
            int colCount = rsmd.getColumnCount();
             
               while(rs.next()){
                 int id = rs.getInt("topicID");
                 String name = rs.getString("topicName");
                 System.out.print(id + ":   " + name + '\n');
                 System.out.println("---------------------------");
                     
                  for( int i = 1; i <=colCount; i++){
                     data.add(rs.getString(i));    
                  }
              }
          } 
         
       catch(SQLException e){
         e.printStackTrace();
      }

     return data;
  }
   
}