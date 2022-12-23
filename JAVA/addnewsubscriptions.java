import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/addnewsubscriptions")
public class addnewsubscriptions extends HttpServlet{
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException {
		
    	String TITLE=request.getParameter("subscriptionmagazineaddnewformlefttitle");
		String PUBLISHER=request.getParameter("subscriptionmagazineaddnewformleftpublisher");
		String PLACE=request.getParameter("subscriptionmagazineaddnewformrighttextinputplace");
		String AMOUNT=request.getParameter("subscriptionmagazineaddnewformrighttextinputAmount");
        String DEPARTMENT=request.getParameter("subscriptionmagazineaddnewformleftselectDepartment");
        String SUBSCRIPTION_NO=request.getParameter("subscriptionmagazineaddnewformrighttextinputSubscriptionNo");
        String SUBS_TYPE=request.getParameter("subscriptionmagazineaddnewformleftselecttype");
        String FROMDATE=request.getParameter("subscriptionmagazineaddnewformrightdateinputfromdateplacefordatevalue");
       
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
	    SimpleDateFormat format2 = new SimpleDateFormat("dd-MMM-yy");
	    java.util.Date date=null;
		try {
			date = format1.parse(FROMDATE);
		    FROMDATE=format2.format(date);
		    System.out.println(FROMDATE);
		} catch (Exception e) {
			System.out.println(e);
		}
        
        
        String TODATE=request.getParameter("subscriptionmagazineaddnewformrightdateinputTodateplacefordatevalue");
        
         format1 = new SimpleDateFormat("yyyy-MM-dd");
	     format2 = new SimpleDateFormat("dd-MMM-yy");
	     date=null;
		try {
			date = format1.parse(TODATE);
		    TODATE=format2.format(date);
		    System.out.println(TODATE);
		} catch (Exception e) {
			System.out.println(e);
		}
        
        String DDDATE=request.getParameter("subscriptionmagazineaddnewformrightdateinputDDdateplacefordatevalue");
        
        format1 = new SimpleDateFormat("yyyy-MM-dd");
	     format2 = new SimpleDateFormat("dd-MMM-yy");
	     date=null;
		try {
			date = format1.parse(DDDATE);
		    DDDATE=format2.format(date);
		    System.out.println(FROMDATE);
		} catch (Exception e) {
			System.out.println(e);
		}
        
        String PERIODICITY=request.getParameter("subscriptionmagazineaddnewformleftselectperiodicity");
		String DD_NO=request.getParameter("subscriptionmagazineaddnewformleftddno");
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
			PreparedStatement insert=con.prepareStatement("insert into subscriptions values('"+TITLE+"','"+PUBLISHER+"','"+PLACE+"',"+AMOUNT+",'"+DEPARTMENT+"','"+SUBSCRIPTION_NO+"','"+SUBS_TYPE+"','"+FROMDATE+"','"+TODATE+"','"+DDDATE+"','"+PERIODICITY+"','"+DD_NO+"')");
		    if (insert.executeUpdate()>0) {
				response.getWriter().print("inserted");
			}
		    else {
				response.getWriter().print("error came");
			}
		
		
		} catch (Exception e) {
           System.out.println(e);
			response.getWriter().print(e);
		}
	}
}
