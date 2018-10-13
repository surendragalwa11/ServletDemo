
import java.sql.Connection;
import java.sql.DriverManager;


public class DbConnection
{
    public static Connection con=null; 
    static
    {
       try
        {    
         Class.forName("com.mysql.cj.jdbc.Driver");
         con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ServletAssignments?useSSL=false","root","sigma@321");
        }
        catch(Exception e)
        {
         e.printStackTrace();
        }
    }
    public static Connection getConnection()
    {
        return con;
    }  
}
