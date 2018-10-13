
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/MainServlet"})
public class MainServlet extends HttpServlet
{

    
    protected void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
    {
       
        String EmpId=request.getParameter("eid");
        try
        {
         Connection con=DbConnection.getConnection();  
         String query="select * from Employee where EmpId=?";
         
         
//         Statement st=con.createStatement();
//         ResultSet rs=st.executeQuery(query);
            
         PreparedStatement ps=con.prepareStatement(query);
         ps.setString(1, EmpId);
         ResultSet rs=ps.executeQuery();
         
         while(rs.next())
         {
             
             response.getWriter().println("EmpId: "+rs.getString(1)+"\nEmpName: "+rs.getString(2)+"\nAge :"+rs.getInt(3)+"\nDesignation: "+rs.getNString(4)+"\nDeptId: "+rs.getString(5)+"\nSalary: "+rs.getDouble(6));
         }
       
       }
       catch(Exception e)
       {
          response.getWriter().println(e);
       }
    }
    
     

}
