import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/accountmaintenancedelete")
public class Accountmaintenancedelete extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String LIB_NO = request.getParameter("createaccountmanualbapformnamelib");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
			PreparedStatement delete=connection.prepareStatement("DELETE FROM Accounts WHERE lib_no='"+LIB_NO+"'");
			if ((delete.executeUpdate())>0) {
				response.getWriter().print("record has been deleted");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
