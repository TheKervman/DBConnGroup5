import controller.MainController;
import java.util.*;
import java.util.Scanner;
import java.sql.*;
public class MainView {
   String uri = "jdbc:mysql://localhost/dbconn5?autoReconnect=true&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
   String driver = "com.mysql.cj.jdbc.Driver"; 
   String user = "root";
   String password = "student"; 
   Connection conn = null;
   public MainView(){
      connect();
      setdata();
      getdata();
      close();
   }
   public Connection connect(){
     //load the driver
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
   public void setdata(){
      Scanner input = new Scanner(System.in);
      int b;
      try{
         System.out.println("Enter the topic name ");
         String Name = input.nextLine();
         System.out.println("Enter the description for the topic ");
         String Description=input.nextLine();
         String sqlcreateTopic = "INSERT INTO Topic (topicName, topicDescription) VALUES ('" + Name + "','" + Description + "');";
         Statement statement = conn.createStatement();
         b=statement.executeUpdate(sqlcreateTopic);
      }
      catch(Exception e)
      {
         e.printStackTrace(); //does this if something goes wrong
      }
   }
   public void getdata(){
      int c;
      ArrayList<String> Names=new ArrayList<String>();
      try{
         String a="SELECT * FROM Topic;";
         Statement statement = conn.createStatement();
         ResultSet r=statement.executeQuery(a);
         ResultSetMetaData rsmd=r.getMetaData();
         int numCols=rsmd.getColumnCount();
         while(r.next())
         {
            for(int i=1; i<=numCols; i++)
            {
               Names.add(String.format("%-20s",r.getString(i)));
            }
         }
         System.out.println(Names);
      }
      catch(Exception e)
      {
         e.printStackTrace(); //does this if something goes wrong
      }
   }
   public boolean close() //the close the database method
   {
      boolean closetest; //creates a boolean
      try{
         conn.close(); //close the database command
         closetest=true; //sets the boolean to true
      }
      catch( SQLException sqle ){//if this does not work
         closetest=false; //sets the value of thew boolean to false
      }
      catch( Exception e ){ //if something else happens
         closetest=false; //sets the value of the boolean to false
         e.printStackTrace();
      }
      return closetest;
   }
   public static void main(String[] args) {
      MainView m=new MainView();
   }
}