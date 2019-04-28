package view;

import controller.MainController;
import classes.Interview;
import classes.Presentation;
import java.util.*;

public class MainView {

    public MainView() {
        testGuest();
    }
   
   public void testGuest() {
       Scanner input = new Scanner(System.in);  // Create a Scanner object
       System.out.println("Welcome");

       int numInput = input.nextInt();

       //checks
       switch (numInput) {
           case 1:
               System.out.println("Welcome Guest");
               Scanner guestInput = new Scanner(System.in);
               int options = guestInput.nextInt();
               switch (guestInput) {
                   case 4:
                       System.out.println("Showing all topics");

                   case 5:
                       System.out.println("Enter your name: ");
                       String Name = Scanner.nextLine();

                       System.out.println("Enter the date: ");
                       String Date = Scanner.nextLine();

                       System.out.println("Enter the faculty member: ");
                       String facMember = Scanner.nextLine();

                       String sql2 = "INSERT INTO Interview (interviewName, interviewDate, facultyMemeber) VALUES ('" + Name + "','" + Date + "','" + facMember + "');";
                       Interview.insertQuery(sql2);

                       String sql3 = "INSERT INTO Presentation (presentationName, presentationDate, facultyMemeber) VALUES ('" + Name + "','" + Date + "','" + facMember + "');";
                       Presentation.insertQuery(sql3);
               } // end of guest switch
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
   } // end of testGuest
} // end of main view