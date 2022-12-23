import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Login")
public class AdminLogin extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String name=request.getParameter("name");
		String pass=request.getParameter("Password");
		
		try {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");  
		  
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");  
		  
		PreparedStatement stmt=con.prepareStatement("select Adminpassword from AdminRegister where Adminid=?");  
		stmt.setString(1,name);
		String dbpass=null;
		 
		ResultSet rs=stmt.executeQuery();
		if(rs.next())
		{
			dbpass=rs.getString(1);
		}
	
		
		if(pass.equals(dbpass)) {			
			Cookie ck=new Cookie("user",request.getParameter("username"));
			   response.addCookie(ck);
			   response.sendRedirect("dashboard.html");
		}
		else
		{
			out.println("please Enter Your correct Email and Password");
		}
		con.close();  
		  
		}catch(Exception e){ System.out.println(e);}  
		  
		  
		 
		
		
	}

}