package view;

import controller.MainController;
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

    public void loginPrompt(){
        System.out.println("Enter your username:");
        Scanner input = new Scanner(System.in);

        System.out.println("Enter your password: ");
        Scanner input2 = new Scanner(System.in);

        String loginName = input.nextLine();
        String loginPassword = input2.nextLine();

        while ((loginName != "") && (loginPassword != "")) {
            loginName2 = loginName;
            loginPass2 = loginPassword;
            String checkRole = "SELECT role FROM Users WHERE username='"+loginName2+"' AND '"+loginPass2+"';";
            Users.selectQuery(checkRole);
            String role;
            if ((!loginName2.isEmpty()) && (!loginPass2.isEmpty())){
                role = rs.getString(1);

                if (role == "Faculty"){
                    facultyPrompt();
                }
                if(role == "Student"){
                    studentPrompt();
                }
            }
            else if(!rs.isBeforeFirst() ){
                System.out.println("Enter a valid username and password!")
            }
            else{
                System.out.println("Something went wrong!");
            }
        } // end of while
    }

    // Clear Screen
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

} // end of main view