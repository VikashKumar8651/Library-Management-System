import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ForgetPasswordqwertyuioppoiuytrewq")
public class ForgetPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String AminID           =  request.getParameter("fgtresetpss");
		String Passwords        =  request.getParameter("fgtnewpassl");
		String ConfirmPassword  =  request.getParameter("fgtconfpssl");
		
		System.out.println(AminID);
		System.out.println(Passwords);
		System.out.println(ConfirmPassword);
		
	if(Passwords.equals( ConfirmPassword))
	{
		System.out.println("done");

		 try{  
				Class.forName("oracle.jdbc.driver.OracleDriver");
				String url="jdbc:oracle:thin:@localhost:1521:xe";
				String username="system";
				String password="1234";
				Connection con=DriverManager.getConnection(url,username,password); 
				
				System.out.println("Created DB Connection....");
				PreparedStatement select = con.prepareStatement("select ADMINPASSWORD from  AdminRegister where ADMINID='"+AminID+"'");
			     ResultSet rsp=select.executeQuery();
			     if (rsp.next()) {
			    	 Statement stmt=con.createStatement();
						String s1="update AdminRegister set ADMINPASSWORD='"+ConfirmPassword+"' where ADMINID='"+AminID+"'";
						
						stmt.executeUpdate(s1);
						  out.print("success fully");

			     }
			     else {
			    	 out.print("admin doesnt exist");
			     }
		            con.close();
		        } catch (ClassNotFoundException e) {
		            
		            e.printStackTrace();
		        } catch (SQLException e) {
		            
		            e.printStackTrace();
		        }
   }
	
	else
	{
		 
		 System.out.println("please confirm the password with correct input");
	}
		 
		 
		
		
		
	}

}