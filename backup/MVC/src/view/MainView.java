package view;

import controller.MainController;

import java.util.*;

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
          switch(guestInput){
            case 4:          
               System.out.println("Showing all topics");
          }
      break;
      
       case 2:
      System.out.println("Please Log in");
      break;
     }
   }

} // end of main view