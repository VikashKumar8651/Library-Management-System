import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/subscriptionmagazinerenewexisting")
public class subscriptionmagazinerenewexisting extends HttpServlet{
     public void doGet(HttpServletRequest request,HttpServletResponse response) {
		String SUBSCRIPTION_NO=request.getParameter("subscriptionmagazinerenewformrighttextinputSubscriptionNo");
		String TODATE=request.getParameter("subscriptionmagazinerenewformrightdateinputTodateplacefordatevalue");
		  SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		    SimpleDateFormat format2 = new SimpleDateFormat("dd-MMM-yy");
		    java.util.Date date=null;
			try {
				date = format1.parse(TODATE);
				TODATE=format2.format(date);
			    System.out.println(TODATE);
			} catch (Exception e) {
				System.out.println(e);
			}
		String FROMDATE=request.getParameter("subscriptionmagazinerenewformrightdateinputfromdateplacefordatevalue");
		format1 = new SimpleDateFormat("yyyy-MM-dd");
	    format2 = new SimpleDateFormat("dd-MMM-yy");
	    date=null;
		try {
			date = format1.parse(FROMDATE);
			FROMDATE=format2.format(date);
		    System.out.println(FROMDATE);
		} catch (Exception e) {
			System.out.println(e);
		}
		String DDDATE=request.getParameter("subscriptionmagazinerenewformrightdateinputDDdateplacefordatevalue");
		format1 = new SimpleDateFormat("yyyy-MM-dd");
	    format2 = new SimpleDateFormat("dd-MMM-yy");
	    date=null;
		try {
			date = format1.parse(DDDATE);
			DDDATE=format2.format(date);
		    System.out.println(DDDATE);
		} catch (Exception e) {
			System.out.println(e);
		}
		String AMOUNT=request.getParameter("subscriptionmagazinerenewformrighttextinputAmount");
		String PERIODICITY=request.getParameter("subscriptionmagazinerenewformleftselect");
		String TITLE=request.getParameter("subscriptionmagazinerenewformlefttitle");
		String PUBLISHER=request.getParameter("subscriptionmagazinerenewformleftpublisher");
		String DD_NO=request.getParameter("subscriptionmagazinerenewformleftddno");
		String DEPARTMENT=request.getParameter("subscriptionmagazinerenewformleftselect");
		String TYPE=request.getParameter("subscriptionmagazinerenewformleftselect");
    	 try {
    		 Class.forName("oracle.jdbc.driver.OracleDriver");  
    		 Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");  
    		 PreparedStatement update=con.prepareStatement("update subscriptions set SUBSCRIPTION_NO='"+SUBSCRIPTION_NO+"',TODATE='"+TODATE+"',FROMDATE='"+FROMDATE+"',DDDATE='"+DDDATE+"',PERIODICITY='"+PERIODICITY+"',DEPARTMENT='"+DEPARTMENT+"',AMOUNT="+AMOUNT+" where TITLE='"+TITLE+"' and DD_NO='"+DD_NO+"'");
    		
    		 System.out.println(SUBSCRIPTION_NO+" "+TODATE+" "+FROMDATE+" "+DDDATE+" "+AMOUNT+" "+PERIODICITY+" "+TITLE+" "+PUBLISHER+" "+DD_NO+" "+DEPARTMENT+" "+TYPE);
    		 
    		 if(update.executeUpdate()>0) {
    			 response.getWriter().println("updated");
    		 }
    		 else {
    			 response.getWriter().println("error came");
    		 }
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
