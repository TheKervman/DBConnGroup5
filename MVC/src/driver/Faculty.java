package driver;

import view.MainView;

import java.util.*;
import java.sql.*;
import java.util.Date;

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

    public ArrayList displayInterviews() {
        //SELECT QUERY
        ArrayList<String> data = new ArrayList<String>();
        DBConnFive db = new DBConnFive();
        String firstCol = null;
        Statement state = null;
        conn = db.connect();
        String sql = "SELECT faculty.facName, interview.interviewName, interview.interviewDate FROM faculty JOIN interview ON interview.facId=faculty.facId WHERE faculty.facId = 1;";
        int col = 0;
        try {
            state = conn.createStatement();
            ResultSet rs = state.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();
            int colCount = rsmd.getColumnCount();

            System.out.println("Here is a list of your interviews");
            System.out.println("----------------------------------------------");

            while(rs.next()) {
                String name = rs.getString("facName");
                String interview = rs.getString("interviewName");
                String date = rs.getString("interviewDate");
                System.out.println(name + " | " + interview + " | " + date);
                System.out.println("----------------------------------------------");

                for( int i = 1; i <= colCount; i++) {
                    data.add(rs.getString(i));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return data;
    } // end of display interviews

    public ArrayList displayPresentations() {
        //SELECT QUERY
        ArrayList<String> data = new ArrayList<String>();
        DBConnFive db = new DBConnFive();
        String firstCol = null;
        Statement state = null;
        conn = db.connect();
        String sql = "SELECT faculty.facName, presentation.presentationName, presentation.presentationDate FROM faculty JOIN presentation ON presentation.facId=faculty.facId WHERE faculty.facId = 1;";
        int col = 0;
        try {
            state = conn.createStatement();
            ResultSet rs = state.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();
            int colCount = rsmd.getColumnCount();

            System.out.println("Here is a list of your presentations");
            System.out.println("----------------------------------------------");

            while(rs.next()) {
                String name = rs.getString("facName");
                String interview = rs.getString("presentationName");
                String date = rs.getString("presentationDate");
                System.out.println(name + " | " + interview + " | " + date);
                System.out.println("----------------------------------------------");

                for( int i = 1; i <= colCount; i++) {
                    data.add(rs.getString(i));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return data;
    } // end of display presentations


} // end of class