package view;
import controller.MainController;
import classes.*;

import java.util.*;
import java.sql.*;

public class MainView {

    public MainView() {
        testGuest();
    }
   
   public void testGuest(){
    Scanner input = new Scanner(System.in);  // Create a Scanner object
    System.out.println("Welcome");

    int numInput = input.nextInt();
    
    //checks
    switch(numInput){
      case 1:
      System.out.println("Welcome Guest");
          Scanner guestInput = new Scanner(System.in); 
          int options = guestInput.nextInt();
          switch(options){
            case 4:          
               System.out.println("Showing all topics");
               String sql = "SELECT Topic.topicName,Topic.topicDescription,Faculty.facName FROM Topic INNER JOIN Faculty ON Topic.facID = Faculty.facID";
               Topic topic = new Topic();
               System.out.println(topic.getData(sql));
               
               
          }
      break;
      
       case 2:
      System.out.println("Please Log in");
      break;
     }
   }

} // end of main view