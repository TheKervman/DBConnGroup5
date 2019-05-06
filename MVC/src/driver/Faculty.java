package driver;

import view.MainView;

import java.util.*;
import java.sql.*;

public class Faculty {

    Connection conn = null;

    public ArrayList displayTopics(int id) {
        ArrayList<String> data = new ArrayList<String>();
        DBConnFive db = new DBConnFive();
        String firstCol = null;
        Statement state = null;
        conn = db.connect();
        String sql = "SELECT topic.topicID, topic.topicName FROM Topic join Faculty on topic.facID=faculty.facID WHERE faculty.facID = " + Integer.toString(id);
        int col = 0;
        try{
            state = conn.createStatement();
            ResultSet rs = state.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();
            int colCount = rsmd.getColumnCount();

            while(rs.next()){
                int idTopic = rs.getInt("topicID");
                String name = rs.getString("topicName");
                System.out.print(idTopic + ":   " + name + '\n');
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

    public void editTopics(int id) {
        Scanner top = new Scanner(System.in);
        String facTop = "";
        while ((facTop = top.nextLine()) != "") {
            try {
                int facTop2 = Integer.parseInt(facTop);

                switch (facTop2) {
                    case 1:
                        System.out.println("Create new topic");
                        System.out.println("Please give the topicName, your Faculty ID, and a description to create a new Topic");
                        
                        System.out.println("Input Topic Name");
                        Scanner topicName = new Scanner(System.in);
                        String nameTopic = topicName.nextLine();
                        
                        System.out.println("Input your Faculty ID ");
                        Scanner facultyID = new Scanner(System.in);
                        int idFac = facultyID.nextInt();
                                               
                        System.out.println("Input Topic Description");
                        Scanner topicDesc = new Scanner(System.in);
                        String descTopic = topicDesc.nextLine();
                        
                        String insertSQL = "INSERT INTO Topic (topicName, facID, topicDescription) VALUES('"+nameTopic+"' ," + Integer.toString(idFac) + ",  '"+descTopic+"') ";
                        DBConnFive insertDB = new DBConnFive();
                        insertDB.setData(insertSQL);
                        System.out.println("Successfully Inserted");
                        break;

                    case 2:
                        DBConnFive updateDB = new DBConnFive();

                        System.out.println("Edit topic");
                        System.out.println("Please input the name of the topic you would like to edit as well as a new name and new description");
                        Scanner tpName = new Scanner(System.in);
                        String oldTopicName = tpName.nextLine();
                        
                        System.out.println("Please input new name");
                        Scanner newTpName = new Scanner(System.in);
                        String newName = newTpName.nextLine();
                        
                        System.out.println("Please Input new description");
                        Scanner tpDesc = new Scanner(System.in);
                        String newDesc = tpDesc.nextLine();
                        
                        System.out.println("Please Input Faculty ID");
                        Scanner idFaculty = new Scanner(System.in);
                        int tpfacID = idFaculty.nextInt();
                        
                        String updateSQL = "UPDATE TOPIC SET topicName = '"+newName+"', topicDescription = '"+newDesc+"' WHERE facID = " + Integer.toString(tpfacID); 
                        updateDB.setData(updateSQL);
                        break;

                    case 3:
                        System.out.println("Delete topic");
                        DBConnFive deleteDB = new DBConnFive();
                        System.out.println("Please input the name of the Topic you wish to delete");
                         
                        Scanner delete = new Scanner(System.in);
                        String topicDeleted = delete.nextLine();
                        String deleteSQL = "DELETE FROM Topic WHERE topicName = '"+topicDeleted+"' " ;
                        deleteDB.setData(deleteSQL);
                        System.out.println("Successfully Deleted");
                        break;

                    
                    case 4:
                        MainView main = new MainView();
                        main.facultyPrompt();
                        break;
                } // end of switch
                editTopicMessage();
            } catch (NumberFormatException nfe) {
                System.out.println("\n");
                System.out.print("Please enter a valid number: ");
            } // end of try/catch
        } // end of while
    } // end of edit topics

    public void editTopicMessage() {
        System.out.println("Please choose what you would like to do with your topics");
        System.out.println("1: Create a new topic\n2: Edit an existing topic\n3: Delete a topic\n4:Logout");
        System.out.print("Please enter a number: ");
    } // end of edit topic message

   public void showAllPres(int id){
      ArrayList<String> data = new ArrayList<String>();
      DBConnFive presDB = new DBConnFive();
      String interSQL = "SELECT presentationName ,presentationDate FROM Presentation WHERE facID = " + Integer.toString(id);
      DBConnFive db = new DBConnFive();
      Statement state = null;
      conn = db.connect();
      int col = 0;
        try{
            state = conn.createStatement();
            ResultSet rs = state.executeQuery(interSQL);
            ResultSetMetaData rsmd = rs.getMetaData();
            int colCount = rsmd.getColumnCount();

            while(rs.next()){
                String name = rs.getString("presentationName");
                String date = rs.getString("presentationDate");
                System.out.print("Presentation Name: " + name + " || " + "Presentation Date: " + date + '\n');
                System.out.println("------------------------------------------------------------------");

                for( int i = 1; i <=colCount; i++){
                    data.add(rs.getString(i));
                }
            }
            if(data.size() == 0){
               System.out.println("You have no Presentations");
            }
        }

        catch(SQLException e){
            e.printStackTrace();
        } 
      }
   
     public void showAllInterviews(int id){
      ArrayList<String> data = new ArrayList<String>();
      DBConnFive interDB = new DBConnFive();
      String interSQL = "SELECT interviewName ,interviewDate FROM Interview WHERE facID = " + Integer.toString(id);
      DBConnFive db = new DBConnFive();
      Statement state = null;
      conn = db.connect();
      int col = 0;
        try{
            state = conn.createStatement();
            ResultSet rs = state.executeQuery(interSQL);
            ResultSetMetaData rsmd = rs.getMetaData();
            int colCount = rsmd.getColumnCount();

            while(rs.next()){
                String name = rs.getString("interviewName");
                String date = rs.getString("interviewDate");
                System.out.print("Interview Name: " + name + " || " + "Interview Date: " + date + '\n');
                System.out.println("------------------------------------------------------------------");

                for( int i = 1; i <=colCount; i++){
                    data.add(rs.getString(i));
                }
            }
            if(data.size() == 0){
               System.out.println("You have no Interviews");
            }
        }

        catch(SQLException e){
            e.printStackTrace();
        }
   }

} // end of class