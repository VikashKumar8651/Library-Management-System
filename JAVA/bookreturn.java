import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/bookreturn")
public class bookreturn extends HttpServlet{
   public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException {
	PrintWriter outPrintWriter=response.getWriter();
	String LIBNO=request.getParameter("LibraryNumberforlicf");
    String NAME=request.getParameter("nameforricf");
    String CATEGORY=request.getParameter("Categoryforlicf");
	String TITLE=request.getParameter("titleformcf");
	String DATEOFISSUE=request.getParameter("doissueforrdcf"); 
	String DATEOFRETURN=request.getParameter("doreturnforrdcf");
	String ACCESSIONNUMBER=request.getParameter("Accessionnoforlicf");
    String CURRENT_STATUS="issued";
    String famount=null;
    if(request.getParameter("famountforrdcf") != null) {
    	famount="yes";
    }else {
		famount="no";
	}
     try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
		PreparedStatement select=connection.prepareStatement("select * from bookissue where LIBNO='"+LIBNO+"' and TITTLE='"+TITLE+"' and DATEOFISSUE='"+DATEOFISSUE+"' and ACCESSIONNUMBER='"+ACCESSIONNUMBER+"'");
		ResultSet rSet=select.executeQuery();
		if(rSet.next()) {
		if(rSet.getString("CURRENT_STATUS").equals("issued") || rSet.getString("CURRENT_STATUS").equals("renewed")) {
			PreparedStatement update=connection.prepareStatement("UPDATE bookissue set CURRENT_STATUS = 'returned',DATEOFRETURN='"+DATEOFRETURN+"' WHERE LIBNO = '"+LIBNO+"' and NAME = '"+NAME+"' and CATEGORY = '"+CATEGORY+"' and TITTLE='"+TITLE+"' and DATEOFISSUE = '"+DATEOFISSUE+"' and ACCESSIONNUMBER='"+ACCESSIONNUMBER+"'");
			if(update.executeUpdate()>0) {
				outPrintWriter.println("updated");
			}
			else {
				outPrintWriter.print("book has already returned");
			}
		}
		}
     } catch (Exception e) {
		System.out.println(e);
		outPrintWriter.print(e);
	}
}
}