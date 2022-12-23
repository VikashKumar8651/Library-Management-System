import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/dateinsert")
public class dateinsert extends HttpServlet{
   public void doGet(HttpServletRequest request,HttpServletResponse response) {
	String dateString =request.getParameter("date");
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
		PreparedStatement insert=connection.prepareStatement("insert into checkingdate values ('A','"+dateString+"')");
		if (insert.executeUpdate()>0) {
			response.getWriter().print("inserted");
		}
		else {
			response.getWriter().print("problem came");
		}
	} catch (Exception e) {
        System.out.println(e);
	}
}
}
