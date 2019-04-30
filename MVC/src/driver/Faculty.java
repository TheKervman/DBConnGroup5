package driver;

import java.util.Scanner;

public class Faculty{
String a;
public static DBConnFive DB=new DBConnFive();

    private void facultyMessage2() {
        System.out.println("Welcome to the Faculty Menu if you want to edit you topics");
        System.out.println("Please select one of the following options to continue");
        System.out.println("1: Update your topics\n2: Insert a new topic\n3: Delete one of your topics\n4: Logout");
        System.out.print("Please enter a number: ");
    }
    

    private void facultyPrompt() {
        Scanner input = new Scanner(System.in);
        String facultyInput = "";
        while ((facultyInput = input.nextLine()) != "") {
            try {
                int facultyInput2 = Integer.parseInt(facultyInput);

                //checks
                switch (facultyInput2) {
                    case 1:
                        System.out.println("What is your faculty ID");
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


}