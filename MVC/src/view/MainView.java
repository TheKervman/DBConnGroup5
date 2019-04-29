package view;

import controller.MainController;
//import classes.Interview;
//import classes.Presentation;
import java.util.*;
import java.util.Scanner;
import java.sql.*;

public class MainView {
      
       String uri = "jdbc:mysql://localhost/dbconn5?autoReconnect=true&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
       String driver = "com.mysql.cj.jdbc.Driver"; 
       String user = "root";
       String password = "student"; 
       Connection conn = null;
       
    public MainView() {
        introMessage();
        mainUserPrompt();
    }

    // Messages
    private void introMessage() {
        System.out.println("\n");
        System.out.println("DBConn Student/Faculty Project");
        System.out.println("Please select one of the following options to continue");
        System.out.println("1: Continue as a guest\n2: Log in as a faculty or student\n3: Exit the program");
        System.out.print("Please enter a number: ");
    }

    private void guestMessage() {
        System.out.println("\n");
        System.out.println("Welcome to the Guest Menu");
        System.out.println("Please select one of the following options to continue");
        System.out.println("1: Display all topics\n2: Set up an interview\n3: Set up a presentation\n4: Go back to the main menu\n5: Exit the program");
        System.out.print("Please enter a number: ");
    }

    // User Prompts
    private void mainUserPrompt() {
       Scanner input = new Scanner(System.in);  // Create a Scanner object
       String userInput = "";
       while ((userInput = input.nextLine()) != "") {
           try {
               int mainInput = Integer.parseInt(userInput);

                //checks
                switch (mainInput) {
                   case 1:
                       clearScreen();
                       guestMessage();
                       guestPrompt();
                       break;

                   case 2:
                       System.out.println("Please Log in");
                       break;

                   case 3:
                       System.out.println("Thank you for using this program.");
                       System.exit(0);

                   default:
                       System.out.println("Not a valid number.");
                       break;
                } // end of main switch
                System.out.println("\n");
                introMessage();
           } catch (NumberFormatException nfe) {
               System.out.println("Please enter a valid number");
           } // end of try/catch
       } // end of while

   } // end of main user prompt

    private void guestPrompt() {
        Scanner input = new Scanner(System.in);
        String guestInput = "";
        while ((guestInput = input.nextLine()) != "") {
            try {
                int guestInput2 = Integer.parseInt(guestInput);

                //checks
                switch (guestInput2) {
                    case 1:
                        System.out.println("Showing all topics");
                        String sql = "SELECT topicName FROM Topic";
                        getData(sql);
                        break;

                    case 2: 
                        System.out.println("test");
//                        System.out.println("Enter your name: ");
//                        String Name = Scanner.nextLine();
//
//                        System.out.println("Enter the date: ");
//                        String Date = Scanner.nextLine();
//
//                        System.out.println("Enter the faculty member: ");
//                        String facMember = Scanner.nextLine();
//
//                        String sql2 = "INSERT INTO Interview (interviewName, interviewDate, facultyMemeber) VALUES ('" + Name + "','" + Date + "','" + facMember + "');";
//                        Interview.insertQuery(sql2);
                        break;

                    case 3:
                        System.out.println("test");
//                        System.out.println("Enter your name: ");
//                        String Name = Scanner.nextLine();
//
//                        System.out.println("Enter the date: ");
//                        String Date = Scanner.nextLine();
//
//                        System.out.println("Enter the faculty member: ");
//                        String facMember = Scanner.nextLine();
//
//                        String sql3 = "INSERT INTO Presentation (presentationName, presentationDate, facultyMemeber) VALUES ('" + Name + "','" + Date + "','" + facMember + "');";
//                        Presentation.insertQuery(sql3);
                        break;

                    case 4:
                        introMessage();
                        mainUserPrompt();
                        break;

                    case 5:
                        System.out.println("Thank you for using this program");
                        System.exit(1);

                    default:
                        System.out.println("Not a valid number.");
                        break;
                } // end of guest switch
                System.out.println("\n");
                guestMessage();
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter a valid number");
            } // end of try/catch
        } // end of while
    } // end of guestPrompt

    // Clear Screen
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

 // end of main view

//dummy connect method
 public Connection connect(){
     try{
         Class.forName(driver);
      }
      catch(ClassNotFoundException cnfe){
         cnfe.printStackTrace();
      }
         //check if database will open 
         try{
            conn = DriverManager.getConnection(uri,user,password);
            if( conn!= null || !conn.isClosed() ){
              
               return conn;
            }
         }
         
         catch (SQLException e){ 
            System.out.println("Error connecting");
            e.printStackTrace();
         }
       return null;      
     }

   
   
   public ArrayList getData(String sql){
   //SELECT QUERY
          ArrayList<String> data = new ArrayList<String>();
          String firstCol = null;
          Statement state = null; 
          conn = connect();
          int col = 0;
          try{
            state = conn.createStatement();            
            ResultSet rs = state.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();
            int colCount = rsmd.getColumnCount();
             
               while(rs.next()){
                  for( int i = 1; i <=colCount; i++){
                     data.add(rs.getString(i));
                     
                  }
              }
               for(String s: data){
                 System.out.println(s);
               }
          } 
         
       catch(SQLException e){
         e.printStackTrace();
      }

     return data;
  }
   
   public int setData(String sql){
      try(Connection connect = this.connect()){
      Statement state = conn.createStatement();
         if (state.executeUpdate(sql) > 0){
            return 1;
         }
      }
      catch(SQLException e){
         System.out.println("No data  retrieved, Sorry!");
      }
      return -1;
   }
   
   
    public boolean close(){
      try(Connection conn = this.connect()){
          if( conn!= null || !conn.isClosed()){
               conn.close();
           }
      }
      catch(SQLException sqle){
          return false;
      }
      return false;
    }
    


//dummy main for connect

  public static void main(String[] args){
      MainView mv = new MainView();
       mv.guestPrompt();
       mv.close();
       
   }
}
/*NOTES:*/