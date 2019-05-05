package driver;

import java.sql.*;
import java.util.*;

public class Student{
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

    public void commonTopics(){
        //SELECT QUERY
        //ArrayList<String> data = new ArrayList<String>();
        DBConnFive db = new DBConnFive();
        String firstCol = null;
        Statement state = null;
        conn = db.connect();
        String sql = "SELECT topicOne,topicTwo,topicThree FROM Student";


        int col = 0;
        try{
            state = conn.createStatement();
            ResultSet rs = state.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();
            int colCount = rsmd.getColumnCount();

            while(rs.next()){
                //int id = rs.getInt("topicID");
                String name = rs.getString("topicOne");
                String nameTwo = rs.getString("topicOne");
                String nameThree = rs.getString("topicOne");
                System.out.println(name);
                System.out.println(nameTwo);
                System.out.println(nameThree);
                
            }
        }

        catch(SQLException e){
            e.printStackTrace();
        }

    }
    
    public void addTopic(){
    /*notes maybe have three scanners and check to see if the other string are null
    if not add to topic 2 and three id they are then dont
    maybe have seperate case for three topics
    */
  
     Scanner topicInput = new Scanner(System.in);
     System.out.println("Please enter topic name for your first Topic");
     String topicOne = topicInput.nextLine();
     
     Scanner topicInputTwo = new Scanner(System.in);
     System.out.println("Please enter topic name for your second Topic");
     String topicTwo = topicInput.nextLine();
     
     
     Scanner topicInputThree = new Scanner(System.in);
     System.out.println("Please enter topic name for your third Topic ");
     String topicThree = topicInput.nextLine();
     
     
     System.out.println("Please enter studentID");
     int id = topicInput.nextInt();
     
     DBConnFive db = new DBConnFive();
     String sql = "UPDATE Student SET topicOne =  '"+topicOne+"', topicTwo =  '"+topicTwo+"', topicThree =  '"+topicThree+"'  WHERE studID = " + Integer.toString(id); 
     db.setData(sql);
     
    }
    
    public void sameFacultyTopics(int id){
    DBConnFive db = new DBConnFive();
    String sql = "SELECT topicName FROM Topic WHERE facID = " + Integer.toString(id);
    db.getData(sql);
    }
    
    public void listInterestedStuds(String topicOne, String topicTwo, String topicThree){
    DBConnFive db = new DBConnFive();
    String sql = "SELECT studName FROM Student WHERE topicOne = '"+topicOne+"' OR topicTwo = '"+topicTwo+"' OR topicThree = '"+topicThree+"' ";
    db.getData(sql);
    }
}
