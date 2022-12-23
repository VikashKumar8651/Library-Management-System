import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AdminRegister")
public class AdminRegister extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
			
		String Name = request.getParameter("name");		
		String ID=request.getParameter("aID");
		String Password=request.getParameter("Password");
				
		try{  
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String username="system";
			String password="1234";
			Connection con=DriverManager.getConnection(url,username,password); 
			
			System.out.println("Created DB Connection....");
			
			PreparedStatement idcheck=con.prepareStatement("select * from AdminRegister where ADMINID='"+ID+"'");
		    
			ResultSet rs=idcheck.executeQuery();
			if(rs.next()) {
				out.println("<h1><b>admin id already exists</b></h1>");
				RequestDispatcher rd=request.getRequestDispatcher("AdminRegister.html");
				rd.include(request, response);
				
				// response.sendRedirect("AdminRegister.html");
			}
			else {
				PreparedStatement stmt=con.prepareStatement("insert into AdminRegister values(?,?,?)");  
				
				stmt.setString(1,ID);  
				stmt.setString(2,Name);
				stmt.setString(3,Password);  
				    
			    
			    
				int i= stmt.executeUpdate();
				if(i>0) {
				
			         out.print(" <h1>Registered success fully</h1>");
			        
				}
			}
	
		         
		            con.close();
		        } catch (ClassNotFoundException e) {
		            
		            e.printStackTrace();
		        } catch (SQLException e) {
		            
		            e.printStackTrace();
		        }
		
		
		
		
		
		
		
	}

}