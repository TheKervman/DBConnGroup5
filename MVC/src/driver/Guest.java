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
      ArrayList<String> data = new ArrayList<String>();
      String sql = "SELECT * FROM Topic WHERE topicID = " + Integer.toString(id);
      DBConnFive db = new DBConnFive();
      Statement state = null;
      conn = db.connect();
      int col = 0;
      
        try{
            state = conn.createStatement();
            ResultSet rs = state.executeQuery(sql);
            
            while(rs.next()){
                int tpid = rs.getInt("topicID");
                String name = rs.getString("topicName");
                int facid = rs.getInt("facID");
                String desc = rs.getString("topicDescription");
                
                System.out.println("Topic ID number: " + tpid); 
                System.out.println("Topic Name: " + name);
                System.out.println("Id number of Faculty memeber who owns the topic: " + facid);
                System.out.println("Topic Description: " + desc);      
            }
          }  
         
         catch(Exception exc){
            System.out.println("Something went wrong");
            exc.printStackTrace();
       }
    }        
  
  public void addInterview(String name, String date, int facID){
    DBConnFive dbFive= new DBConnFive();
    dbFive.setData("INSERT INTO Interview (interviewName, interviewDate, facID) VALUES( '"+name+"' , '"+date+"','"+Integer.toString(facID)+"');");
    System.out.println("Sucessfully Added");
  
  }
  
   public void addPresentation(String name, String date, int facID){
    DBConnFive dbFive= new DBConnFive();
    dbFive.setData("INSERT INTO Presentation (presentationName, presentationDate, facID) VALUES( '"+name+"' , '"+date+"','"+Integer.toString(facID)+"');");
    System.out.println("Sucessfully Added");

  }
     
}