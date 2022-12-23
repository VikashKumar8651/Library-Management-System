import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/subscriptionmagazineedit")
public class subscriptionmagazineedit extends HttpServlet{
public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException {
	String TITLE=request.getParameter("subscriptionmagazineeditformlefttitle");
	String PUBLISHER=request.getParameter("subscriptionmagazineeditformleftpublisher");
	String PLACE=request.getParameter("subscriptionmagazineeditformrighttextinputplace");
	String AMOUNT=request.getParameter("subscriptionmagazineeditformrighttextinputAmount");
    String DEPARTMENT=request.getParameter("subscriptionmagazineaeditformleftselect");
    String SUBSCRIPTION_NO=request.getParameter("subscriptionmagazineeditformrighttextinputSubscriptionNo");
    String SUBS_TYPE=request.getParameter("subscriptionmagazineeditformleftselect");
    String FROMDATE=request.getParameter("subscriptionmagazineeditformrightdateinputfromdateplacefordatevalue");
   
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
    
    
    String TODATE=request.getParameter("subscriptionmagazineeditformrightdateinputTodateplacefordatevalue");
    
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
    
    String DDDATE=request.getParameter("subscriptionmagazineeditformrightdateinputDDdateplacefordatevalue");
    
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
    
    String PERIODICITY=request.getParameter("subscriptionmagazineeditformleftselect");
	String DD_NO=request.getParameter("subscriptionmagazineeditformleftddno");
	System.out.println(" "+TITLE+" "+PUBLISHER+" "+PLACE+" "+AMOUNT+" "+DEPARTMENT+" "+SUBSCRIPTION_NO+" "+SUBS_TYPE+" "+FROMDATE+" "+TODATE+" "+DDDATE+" "+PERIODICITY+" "+DD_NO);
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
		PreparedStatement insert=con.prepareStatement("update subscriptions set SUBSCRIPTION_NO='"+SUBSCRIPTION_NO+"',TODATE='"+TODATE+"',FROMDATE='"+FROMDATE+"',DDDATE='"+DDDATE+"',PERIODICITY='"+PERIODICITY+"',DEPARTMENT='"+DEPARTMENT+"',AMOUNT="+AMOUNT+" where TITLE='"+TITLE+"' and DD_NO='"+DD_NO+"'");
	    	if(insert.executeUpdate()>0) {
	    		response.getWriter().println("updated");
	    	}
	    	else {
	    		response.getWriter().println("error came");
			}
			/*
			 * response.getWriter().print("inserted");
			 * 
			 * 
			 * response.getWriter().print("error came");
			 */
	
	
	
	} catch (Exception e) {
       System.out.println(e);
		response.getWriter().print(e);
	}
}
}
