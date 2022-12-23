import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/bookissue")
public class Bookissue extends HttpServlet{
   public void doGet(HttpServletRequest request,HttpServletResponse response) {
	 String LIBNO=request.getParameter("LibraryNumberforlicf");
	 String NAME=request.getParameter("nameforricf");
     String CATEGORY=request.getParameter("Categoryforlicf");
	 String PRIVILEGE=request.getParameter("privilegeforricf");
	 String ACCESSIONNUMBER=request.getParameter("Accessionnoforlicf");
	 String DEPARTMENT=request.getParameter("departmentforricf");
	 String CALLNO=request.getParameter("Callnoforlicf");
	 String IDCARDNO=request.getParameter("idcardnoforricf");
	 String TITLE=request.getParameter("titleformcf");
	 String AUTHORS=request.getParameter("Authorsforldcf");
	 String PUBLISHER=request.getParameter("publisherforldcf");
	 String PRICE=request.getParameter("priceforldcf");
	 String DATEOFISSUE=request.getParameter("doissueforrdcf");
	 
	 SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
	    SimpleDateFormat format2 = new SimpleDateFormat("dd-MMM-yy");
	    java.util.Date date=null;
	    String dString=null;
	    String dUString=null;
		try {
			date = format1.parse(DATEOFISSUE);
		    dString=format2.format(date);
		    System.out.println(dString);
		} catch (Exception e) {
			System.out.println(e);
		}
	 
	 String DUEDATE=request.getParameter("duedateforrdcf");
	 try {
			date = format1.parse(DUEDATE);
		    dUString=format2.format(date);
		    System.out.println(dUString);
		} catch (Exception e) {
			System.out.println(e);
		}
	 String DATEOFRETURN=request.getParameter("doreturnforrdcf");
	 String REMARKS=request.getParameter("remarksforldcf");
	
	 String CURRENT_STATUS="issued";
     try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
		PreparedStatement insert=connection.prepareStatement("insert into bookissue values('"+LIBNO+"','"+NAME+"','"+CATEGORY+"','"+PRIVILEGE+"','"+ACCESSIONNUMBER+"','"+DEPARTMENT+"','"+CALLNO+"','"+IDCARDNO+"','"+TITLE+"','"+AUTHORS+"','"+PUBLISHER+"','"+PRICE+"','"+dString+"','"+dUString+"',null,'"+REMARKS+"','"+"null"+"','"+CURRENT_STATUS+"')");
	   int i=insert.executeUpdate();
		if(i>0) {
		   PrintWriter outPrintWriter=response.getWriter();
		   outPrintWriter.print("inserted");
	   }
       
     } catch (Exception e) {
		System.out.println(e);
	}


}
}