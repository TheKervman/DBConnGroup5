package view;

import controller.MainController;
import classes.*;
import java.util.*;
import java.util.Scanner;

public class MainView {

    Scanner input = new Scanner(System.in);  // Create a Scanner object

    public MainView() {
        introMessage();
        mainUserPrompt();
    }

    private void introMessage() {
        System.out.println("DBConn Student/Faculty Project");
        System.out.println("Please select one of the following options to continue");
        System.out.println("1: Continue as a guest\n2: Log in as a faculty or student\n3: Exit the program");
        System.out.print("Please enter a number: ");
    }
   
   private void mainUserPrompt() {
       String userInput = "";
       while ((userInput = input.nextLine()) != "") {
           try {
               int input = Integer.parseInt(userInput);

                //checks
                switch (input) {
                   case 1:
                       System.out.println("Welcome Guest");
                       Scanner guestInput = new Scanner(System.in);
                       System.out.println("4: List all the topics\n5: Select a specific topic\n6: Set up an interview/presentation");
                       int options = guestInput.nextInt();
                       guestPrompt();
                       break;

                   case 2:
                       System.out.println("Please Log in");
                       loginPrompt();
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

           int numInput = input.nextInt();
       }


   } // end of main user prompt

    private void guestPrompt() {
        switch (options) {
            case 4:
                System.out.println("Showing all topics");
                String sql = "SELECT * FROM TOPIC;";
                Topic.selectQuery(sql);
                break;
            case 5:
                System.out.println("Enter your name: ");
                String Name = Scanner.nextLine();

                System.out.println("Enter the date: ");
                String Date = Scanner.nextLine();

                System.out.println("Enter the faculty member: ");
                String facMember = Scanner.nextLine();

                System.out.println("Do you want an interview or a presentation?")

                String sql2 = "INSERT INTO Interview (interviewName, interviewDate, facultyMemeber) VALUES ('" + Name + "','" + Date + "','" + facMember + "');";
                Interview.insertQuery(sql2);

                String sql3 = "INSERT INTO Presentation (presentationName, presentationDate, facultyMemeber) VALUES ('" + Name + "','" + Date + "','" + facMember + "');";
                Presentation.insertQuery(sql3);
                break;
        } // end of guest switch
    }
} // end of main view