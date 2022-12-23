import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/accountmaintenancecreate")
public class Accountmaintenancecreate extends HttpServlet{
     public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException {
		PrintWriter out=response.getWriter();
		String LIB_NO = request.getParameter("createaccountmanualbapformnamelib");
		String REG_NO = request.getParameter("createaccountmanualbapformnameregno");
		String NAME=request.getParameter("createaccountmanualbapformnamename");
		String PRIVILEGE = request.getParameter("createaccountmanualbapacademicdetailprivilege");
		String COURSE = request.getParameter("createaccountmanualbapacademicdetailCourse");
		String DEPARTMENT = request.getParameter("createaccountmanualbapacademicdetaildepartment");	
		String YEARS = request.getParameter("createaccountmanualbapacademicdetailYears");
		String EMAIL = request.getParameter("createaccountmanualbapformemailinp");
		String ADDRESS = request.getParameter("createaccountmanualbapformaddressinp");
		String ID_NO = request.getParameter("createaccountmanualbapformidnoinp");
		String PHONE_NO = request.getParameter("createaccountmanualbapformphnoinp");
		String REMARKS = request.getParameter("createaccountmanualbapformremarks");
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
			PreparedStatement insert=connection.prepareStatement("insert into Accounts values('"+LIB_NO+"','"+REG_NO+"','"+NAME+"','"+PRIVILEGE+"','"+COURSE+"','"+DEPARTMENT+"','"+YEARS+"','"+EMAIL+"','"+ADDRESS+"','"+ID_NO+"','"+PHONE_NO+"','"+REMARKS+"')");
	        
			if(LIB_NO.equals("") && REG_NO.equals("")  && NAME.equals("")  && COURSE.equals("")  && YEARS.equals("") && PHONE_NO.equals("")) {
				out.println("please insert important fields");
			}else {
				if((insert.executeUpdate())>0) {
		        	out.println("inserted");
		        }
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
