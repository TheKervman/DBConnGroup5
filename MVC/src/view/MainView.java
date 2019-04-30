package view;

/**
 * Command Line Interface program that allows the user to see and edit a
 * variety of topics based on their level of authorization (Guest, Student, Faculty)
 *
 * @author Kevin Gleason, Brantley Wyche, Regine Thimothee, Patrick Bell
 * @version 4-29-2019
 */

import controller.MainController;
import driver.DBConnFive;
import driver.Guest;
//import classes.Interview;
//import classes.Presentation;
import java.util.*;
import java.util.Scanner;

public class MainView {

    public MainView() {
        introMessage();
        mainUserPrompt();
    }

    /**
     * These messages get printed out when the program first starts
     */
    private void introMessage() {
        System.out.println("DBConn Student/Faculty Project");
        System.out.println("Please select one of the following options to continue");
        System.out.println("1: Continue as a guest\n2: Log in as a faculty or student\n3: Exit the program");
        System.out.print("Please enter a number: ");
    }

    /**
     * These messages get printed out when the User is a guest
     */
    private void guestMessage() {
        System.out.println("Welcome to the Guest Menu");
        System.out.println("Please select one of the following options to continue");
        System.out.println("1: Display all topics\n2: Set up an interview\n3: Set up a presentation\n4: Go back to the main menu\n5: Exit the program");
        System.out.print("Please enter a number: ");
    }

    /**
     * These messages get printed out when the User is asked to
     * login with their username and password
     */
    private void loginMessage() {
        System.out.println("Welcome to the Login Menu");
        System.out.println("Please enter your login credentials");
    }

    /**
     * These messages get printed out when the User is verfied as a faculty member
     */
    private void facultyMessage() {
        System.out.println("Welcome to the Faculty Menu");
        System.out.println("Please select one of the following options to continue");
        System.out.println("1: Display all topics you own\n2: Edit your topics\n3: View interviews and presentations assigned to you\n4: Logout");
        System.out.print("Please enter a number: ");
    }

    /**
     * These messages get printed out when the User is verfied as a student
     */
    private void studentMessage() {
        System.out.println("Welcome to the Student Menu");
        System.out.println("Please select one of the following options to continue");
        System.out.println("1: List all topics\n2: List all topics you've shown interest in\n3: Logout");
        System.out.print("Please enter a number: ");
    }


    /**
     * Contains all the prompts that allow the program to function
     */

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
                       clearScreen();
                       loginMessage();
                       loginPrompt();
                       break;

                   case 3:
                       clearScreen();
                       System.out.println("Thank you for using this program.");
                       System.exit(0);

                   default:
                       System.out.println("Not a valid number.");
                       System.out.println("Please enter a valid number: ");
                       break;
                } // end of main switch
                System.out.println("\n");
                introMessage();
           } catch (NumberFormatException nfe) {
               System.out.println("\n");
               System.out.println("Please enter a valid number: ");
           } // end of try/catch
       } // end of while

   } // end of main user prompt

    /**
     * Brings up the prompt to allow the guest user to select an action
     */
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
                        Guest guest = new Guest();
                        guest.displayTopics();
                        break;

                    case 2:
                        System.out.println("test");
//                 
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
                        clearScreen();
                        introMessage();
                        mainUserPrompt();
                        break;

                    case 5:
                        clearScreen();
                        System.out.println("Thank you for using this program");
                        System.exit(1);

                    default:
                        System.out.println("Not a valid number.");
                        System.out.println("Please enter a valid number: ");
                        break;
                } // end of guest switch
                System.out.println("\n");
                guestMessage();
            } catch (NumberFormatException nfe) {
                System.out.println("\n");
                System.out.print("Please enter a valid number: ");
            } // end of try/catch
        } // end of while
    } // end of guest prompt

    /**
     * Brings up the login prompt that checks whether the user
     * is a faculty member or student
     */
   public void loginPrompt(){
      try {
        System.out.println("Enter your username:");
        Scanner input = new Scanner(System.in);
        String loginName = input.nextLine();

        System.out.println("Enter your password: ");
        Scanner input2 = new Scanner(System.in);
        String loginPassword = input2.nextLine();

          if((loginName != "") && (loginPassword != "")) {
            String loginName2 = loginName;
            String loginPass2 = loginPassword;
            String checkRole = "SELECT role FROM Users WHERE userName='"+loginName2+"' AND password = '"+loginPass2+"';";
            DBConnFive db = new DBConnFive();
            ArrayList<String> role = db.getData(checkRole);
            String roleCheck =  role.get(0);
            
            if ((!loginName2.isEmpty()) && (!loginPass2.isEmpty())){
                  if (roleCheck.equals("Faculty")){
                     facultyMessage();
                     facultyPrompt();
                  }
                if(roleCheck.equals("Student")){
                    System.out.println("You are a student");
                    studentMessage();
                    studentPrompt();
                 }
             }
           }  
           
         }
        catch(Exception e){
         System.out.println("Something went wrong. Please Try Again");
        } 
          
       } // end of login prompt

    /**
     * Brings up the prompt to allow the faculty member to select an action
     */
    private void facultyPrompt() {
        Scanner input = new Scanner(System.in);
        String facInput = "";
        while ((facInput = input.nextLine()) != "") {
            try {
                int facInput2 = Integer.parseInt(facInput);

                //checks
                switch (facInput2) {
                    case 1:
                        System.out.println("List all topics");
                        break;

                    case 2:
                        System.out.println("Edit topics (test student prompt)");
                        clearScreen();
                        studentMessage();
                        studentPrompt();
                        break;

                    case 3:
                        System.out.println("View interviews and presentations");
                        break;

                    case 4:
                        clearScreen();
                        introMessage();
                        mainUserPrompt();
                        break;

                    default:
                        System.out.println("Not a valid number.");
                        System.out.println("Please enter a valid number: ");
                        break;
                } // end of faculty switch
                System.out.println("\n");
                facultyMessage();
            } catch (NumberFormatException nfe){
                System.out.println("\n");
                System.out.print("Please enter a valid number: ");
            } // end of try/catch
        } // end of while
    } // end of faculty prompt

    /**
     * Brings up the prompt to allow the student to select an action
     */
    private void studentPrompt() {
        Scanner input = new Scanner(System.in);
        String studInput = "";
        while ((studInput = input.nextLine()) != "") {
            try {
                int studInput2 = Integer.parseInt(studInput);

                //checks
                switch (studInput2) {
                    case 1:
                        System.out.println("List all topics");
                        break;

                    case 2:
                        System.out.println("List topics you're interested in");
                        break;

                    case 3:
                        clearScreen();
                        introMessage();
                        mainUserPrompt();
                        break;

                    default:
                        System.out.println("Not a valid number.");
                        System.out.println("Please enter a valid number: ");
                        break;
                } // enf of student switch
                System.out.println("\n");
                studentMessage();
            } catch (NumberFormatException nfe) {
                System.out.println("\n");
                System.out.println("Please enter a valid number: ");
            } // enf of try/catch
        } // end of while
    } // end of student prompt


    /**
     * Clears the screen
     */

    public static void clearScreen() {
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("\n");
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

} // end of main view