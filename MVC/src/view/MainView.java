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
import driver.Faculty;
//import classes.Interview;
//import classes.Presentation;
import java.util.*;
import java.util.Scanner;

public class MainView {

   public MainView() {
      facultyMessage();
      facultyPrompt();
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
     * These messages get printed if the user wants to edit there topics
     */
   private void facultyMessage2() {
      System.out.println("Welcome to the Faculty Menu if you want to edit you topics");
      System.out.println("Please select one of the following options to continue");
      System.out.println("1: Update your topics\n2: Insert a new topic\n3: Delete one of your topics\n4: Logout");
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

    /**
     * Brings up the login prompt that checks whether the user
     * is a faculty member or student
     */
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

    /**
     * Brings up the prompt to allow the faculty member to select an action
     */
   private void facultyPrompt() {
      Scanner input = new Scanner(System.in);
      String facultyInput = "";
      while ((facultyInput = input.nextLine()) != "") {
         try {
            int facultyInput2 = Integer.parseInt(facultyInput);
         
                //checks
            switch (facultyInput2) {
               case 1:
                  System.out.println("What is you faculty ID");
                  Scanner scn = new Scanner(System.in);
                  String ID=scn.nextLine();
                  String fc1="SELECT * FROM Topic WHERE facID="+ID+";";
                  Faculty.DB.getData(fc1);
                  break;
               case 2:
                  facultyMessage2();
                  facultyPrompt2();
                  break;
               case 3:
                  System.out.println("Enter your name ");
                  Scanner scn2 = new Scanner(System.in);
                  String Name = scn2.nextLine();
                  String fc3 = "SELECT * FROM Interview, Presentation WHERE Interview.facID='"+Name+"' OR Presentation.facID='"+Name+"';";
                  Faculty.DB.getData(fc3);
                  break;
               case 4:
                  System.out.println("Thank you for using this program.");
                  System.exit(0);
                  break;
               default:
                  System.out.println("Not a valid number.");
                  break;
            }
            System.out.println("\n");
            introMessage();
         } catch (NumberFormatException nfe) {
            System.out.println("Please enter a valid number");
         } // end of try/catch
      } // end of while
   
   } // end of main user prompt
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
    /**
     * runs if User wish to edit faculty
     */
   private void facultyPrompt2() {
      Scanner input = new Scanner(System.in);
      String facultyInput = "";
      while ((facultyInput = input.nextLine()) != "") {
         try {
            int facultyInput2 = Integer.parseInt(facultyInput);
         
                //checks
            switch (facultyInput2) {
               case 1:
                  System.out.println("What is you faculty ID");
                  Scanner scn = new Scanner(System.in);
                  String ID=scn.nextLine();
                  System.out.println("Enter the topic name ");
                  String Name = scn.nextLine();
                  System.out.println("Enter the new topic name ");
                  String Name3 = scn.nextLine();
                  System.out.println("Enter the new description for the topic ");
                  String Description=scn.nextLine();
                  String f2c1 = "UPDATE Topic SET topicName='"+Name3+"', topicDescription='"+Description+"' WHERE facID='"+ID+"' AND topicName='"+Name+"';";
                  Faculty.DB.setData(f2c1);
                  break;
               case 2:
                  System.out.println("What is you faculty ID");
                  Scanner scn2 = new Scanner(System.in);
                  String ID2=scn2.nextLine();
                  System.out.println("Enter the topic name ");
                  String Name2 = scn2.nextLine();
                  System.out.println("Enter the description for the topic ");
                  String Description2=scn2.nextLine();
                  String f2c2 = "INSERT INTO Topic (topicName, topicDescription, facID) VALUES ('" + Name2 + "','" + Description2 + "','"+ID2+"');";
                  Faculty.DB.setData(f2c2);
                  break;
               case 3:
                  System.out.println("What is you faculty ID");
                  Scanner scn3 = new Scanner(System.in);
                  String facID=scn3.nextLine();
                  System.out.println("Enter the Name of the topic you wish to delete ");
                  String Name4=scn3.nextLine();
                  String f2c3 = "DELETE FROM Topic WHERE topicName='"+Name4+"' AND facID='"+facID+"';";
                  Faculty.DB.setData(f2c3);;
                  break;
               case 4:
                  System.out.println("Thank you for using this program.");
                  System.exit(0);
                  break;
               default:
                  System.out.println("Not a valid number.");
                  break;
            }
            System.out.println("\n");
            introMessage();
         } catch (NumberFormatException nfe) {
            System.out.println("Please enter a valid number");
         } // end of try/catch
      } // end of while
   
   }
   public static void main(String[] args) {
      MainView m=new MainView();
   }
} // end of main view