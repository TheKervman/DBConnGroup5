package driver;
import java.sql.*;
import java.util.ArrayList;

public class DBConnFive{
   //database on our computer
       String uri = "jdbc:mysql://localhost/dbconn5?autoReconnect=true&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
       String driver = "com.mysql.cj.jdbc.Driver"; 
       String user = "root";
       String password = "student"; 
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
   
   
  
   public ArrayList getData(String sql){
   //SELECT QUERY
          ArrayList<String> data = new ArrayList<String>();
          String firstCol = null;
          Statement state = null; 
          conn = connect();
          int col = 0;
          try{
            state = conn.createStatement();            
            ResultSet rs = state.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();
            int colCount = rsmd.getColumnCount();
             
               while(rs.next()){
               
                  for( int i = 1; i <=colCount; i++){
                     data.add(rs.getString(i));
                     
                  }
              }
               for(String s: data){
                 System.out.println(s);
               }
          } 
         
       catch(SQLException e){
         e.printStackTrace();
      }

     return data;
  }
   
   public int setData(String sql){
      try{
      conn = connect();
      Statement state = conn.createStatement();
         if (state.executeUpdate(sql) > 0){
            return 1;
         }
      }
      catch(SQLException e){
         e.printStackTrace();
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
    
    /*public static void main (String[] args){
      DBConnFive db = new DBConnFive();
      db.connect();
    }*/
       
}       