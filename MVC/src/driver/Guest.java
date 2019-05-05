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
  
  public void getTopic(int id){
      String sql = "SELECT * FROM Topic WHERE topicID = " + Integer.toString(id);
      int col = 0;
          try{
            DBConnFive dbFive = new DBConnFive();
            conn = dbFive.connect();
            Statement state = conn.createStatement();            
            ResultSet rs = state.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();
            int colCount = rsmd.getColumnCount();
             
               while(rs.next()){
                  for(int i = 1; i <= colCount; i++){
                  System.out.println(rs.getString(i));
               }             
             }
          } 
         
       catch(SQLException e){
         e.printStackTrace();
      }
  
  }
  
  public void addInterview(String name, String date, int facID){
    DBConnFive dbFive= new DBConnFive();
    dbFive.setData("INSERT INTO Interview (interviewName, interviewDate, facID) VALUES( '"+name+"' , '"+date+"','"+Integer.toString(facID)+"');");
    System.otu.println("Sucessfully Added");
  
  }
  
   public void addPresentation(String name, String date, int facID){
    DBConnFive dbFive= new DBConnFive();
    dbFive.setData("INSERT INTO Presentation (presentationName, presentationDate, facID) VALUES( '"+name+"' , '"+date+"','"+Integer.toString(facID)+"');");
    System.otu.println("Sucessfully Added");

  
  }
     
}