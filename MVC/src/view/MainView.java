package view;

import controller.MainController;
import driver.DBConnFive;
//import classes.Interview;
//import classes.Presentation;
import java.util.*;
import java.util.Scanner;

public class MainView {

    public MainView() {
        introMessage();
        mainUserPrompt();
    }

    // Messages
    private void introMessage() {
        System.out.println("DBConn Student/Faculty Project");
        System.out.println("Please select one of the following options to continue");
        System.out.println("1: Continue as a guest\n2: Log in as a faculty or student\n3: Exit the program");
        System.out.print("Please enter a number: ");
    }

    private void guestMessage() {
        System.out.println("Welcome to the Guest Menu");
        System.out.println("Please select one of the following options to continue");
        System.out.println("1: Display all topics\n2: Set up an interview\n3: Set up a presentation\n4: Go back to the main menu\n5: Exit the program");
        System.out.print("Please enter a number: ");
    }

    private void loginMessage() {
        System.out.println("Welcome to the Login Menu");
        System.out.println("Please enter your login credentials");
    }

    private void facultyMessage() {
        System.out.println("Welcome to the Faculty Menu");
        System.out.println("Please select one of the following options to continue");
        System.out.println("1: Display all topics you own\n2: Edit your topics\n3: View interviews and presentations assigned to you\n4: Logout");
        System.out.print("Please enter a number: ");
    }

    private void studentMessage() {
        System.out.println("Welcome to the Student Menu");
        System.out.println("Please select one of the following options to continue");
        System.out.println("1: List all topics\n2: List all topics you've shown interest in\n3: Logout");
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
                        DBConnFive drive = new DBConnFive();
                        drive.getData("SELECT topicName FROM Topic");
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

    private void loginPrompt() {
        String userName = "test";
        String password = "password";

        System.out.print("Please enter your username: ");
        Scanner name = new Scanner(System.in);
        String uName = name.nextLine();

        System.out.print("Please enter your password: ");
        Scanner pass = new Scanner(System.in);
        String pWord = pass.nextLine();

        if (uName.equals(userName) && pWord.equals(password)) {
            System.out.println("Login successfull!");
            clearScreen();
            facultyMessage();
            facultyPrompt();
        } else {
            System.out.println("Incorrect username or password, please try again.");
        }

    } // end of login prompt

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

    // Clear Screen
    public static void clearScreen() {
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("\n");
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

} // end of main view