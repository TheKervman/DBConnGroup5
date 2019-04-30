package driver;

import view.MainView;

import java.util.*;
import java.sql.*;

public class Faculty {

    Connection conn = null;

    public ArrayList displayTopics() {
        //SELECT QUERY
        ArrayList<String> data = new ArrayList<String>();
        DBConnFive db = new DBConnFive();
        String firstCol = null;
        Statement state = null;
        conn = db.connect();
        String sql = "SELECT topic.topicID, topic.topicName FROM Topic join Faculty on topic.facID=faculty.facID WHERE faculty.facID=9;";
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

    public void editTopics() {
        Scanner top = new Scanner(System.in);
        String facTop = "";
        while ((facTop = top.nextLine()) != "") {
            try {
                int facTop2 = Integer.parseInt(facTop);

                switch (facTop2) {
                    case 1:
                        System.out.println("Create new topic");
                        break;

                    case 2:
                        System.out.println("Edit topic");
                        break;

                    case 3:
                        System.out.println("Delete topic");
                        break;

                    case 4:
                        MainView main = new MainView();
                        main.facultyPrompt();
                        break;
                } // end of switch

            } catch (NumberFormatException nfe) {
                System.out.println("\n");
                System.out.print("Please enter a valid number: ");
            } // end of try/catch
        } // end of while
    } // end of edit topics

    public void editTopicMessage() {
        System.out.println("Please choose what you would like to do with your topics");
        System.out.println("1: Create a new topic\n2: Edit an existing topic\n3: Delete a topic\n4: Go back");
        System.out.print("Please enter a number: ");
    } // end of edit topic message


} // end of class