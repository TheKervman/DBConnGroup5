import java.sql.*;
import java.util.ArrayList;

public class DBConnFive{
   //database on our computer
       String uri = "jdbc:mysql://localhost/dbconn5?autoReconnect=true&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
       String driver = "com.mysql.cj.jdbc.Driver";
       String pass = "student";
       String user = "root";
       Connection conn = null;
       
       
    
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
            System.out.println(driver);

            conn = DriverManager.getConnection(uri,user,pass);
            if( conn!= null || !conn.isClosed() ){
              
               return conn;
            }
         }
         
         catch (SQLException e){ 
            e.printStackTrace();
            e.getCause();
            System.out.println("Error connecting");
         }
       return null;  
   }
   
   
   public ArrayList getData(String sql, int fields){
   //SELECT QUERY 
      ArrayList data = new ArrayList();
      try(Connection connect = this.connect()){
         String query= sql;
         Statement state = conn.createStatement();
         ResultSet rs = state.executeQuery(query);
         while(rs.next()){
            for(int i = 1; i <= fields; i++){
                  data.add(rs.getString(i) + '\t');
            }   
         }
      }
      catch(SQLException e){
         System.out.println("Error is at getData");
      }
      return data;
   }
   
   public int setData(String sql){
      try(Connection connect = this.connect()){
      Statement state = conn.createStatement();
         if (state.executeUpdate(sql) > 0){
            return 1;
         }
      }
      catch(SQLException e){
         System.out.println("No data  retrieved, Sorry!");
      }
      return -1;
   }
   
    public boolean close(){
      try(Connection conn = this.connect()){
          if( conn!= null || !conn.isClosed()){
               conn.close();
           }
      }
      catch(SQLException sqle){
          return false;
      }
      return false;
    }
    
    public static void main (String[] args){
      DBConnFive db = new DBConnFive();
      db.connect();
    }
       
}       