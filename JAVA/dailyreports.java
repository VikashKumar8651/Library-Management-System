import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/dailyreports")
public class dailyreports extends HttpServlet{
   public void doGet(HttpServletRequest request,HttpServletResponse response) {
	   response.setContentType("application/vnd.ms-excel");
	   String fromdate=request.getParameter("placefordailyreportkabapfromdate");
	   SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
	    SimpleDateFormat format2 = new SimpleDateFormat("dd-MMM-yy");
	    java.util.Date date=null;
		try {
			date = format1.parse(fromdate);
		    fromdate=format2.format(date);
		    System.out.println(fromdate);
		} catch (Exception e) {
			System.out.println(e);
		}
	   String todateString=request.getParameter("placefordailyreportkabaptodate");
	   format1 = new SimpleDateFormat("yyyy-MM-dd");
	   format2 = new SimpleDateFormat("dd-MMM-yy");
	   date=null;
	   try {
			date = format1.parse(todateString);
			todateString=format2.format(date);
		    System.out.println(todateString);
		} catch (Exception e) {
			System.out.println(e);
		}
	   String department=request.getParameter("dailyreportkabapformbasicinputdepartmentinput");
	   String type=request.getParameter("dailyreportkabapformbasicinputreporttypeinput");
	   System.out.println(" "+todateString+department+" "+type);
	   if(department.equals("") && type.equals("")) {
	   try {
		   Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
			PreparedStatement select=connection.prepareStatement("select * from bookissue where DATEOFISSUE between '"+fromdate+"' and '"+todateString+"'");
			String opString="<table>"
					+ "            <tr>"
					+ "              <th>Title</th>"
					+ "              <th>Publisher</th>"
					+ "              <th>Department</th>"
					+ "              <th>name</th>"
					+ "              <th>status</th>"
					+ "              <th>Reg no.</th>"
					+ "              <th>DUE DATE</th>"
					+ "            </tr>";
			ResultSet rSet=select.executeQuery();
			while(rSet.next()) {
				opString=opString+"<tr>"
						+ "<td>"+rSet.getString("TITTLE")+"</td>"
								+ "<td>"+rSet.getString("PUBLISHER")+"</td>"
								+ "<td>"+rSet.getString("DEPARTMENT")+"</td>"
								+ "<td>"+rSet.getString("NAME")+"</td>"
								+ "<td>"+rSet.getString("CURRENT_STATUS")+"</td>"
								+ "<td>"+rSet.getString("LIBNO")+"</td>"
								+ "<td>"+rSet.getString("DUEDATE")+"</td></tr>";
			}
			response.getWriter().print(opString);
			
			
		} catch (Exception e) {
			System.out.print(e);
		}
	   }
	   else if ((!department.equals("")) && (type.equals(""))) {
		   try {
			   Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
				PreparedStatement select=connection.prepareStatement("select * from bookissue where DATEOFISSUE between '"+fromdate+"' and '"+todateString+"' and DEPARTMENT='"+department+"'");
				String opString="<table>"
						+ "            <tr>"
						+ "              <th>Title</th>"
						+ "              <th>Publisher</th>"
						+ "              <th>Department</th>"
						+ "              <th>name</th>"
						+ "              <th>status</th>"
						+ "              <th>Reg no.</th>"
						+ "              <th>DUE DATE</th>"
						+ "            </tr>";
				ResultSet rSet=select.executeQuery();
				while(rSet.next()) {
					opString=opString+"<tr>"
							+ "<td>"+rSet.getString("TITTLE")+"</td>"
									+ "<td>"+rSet.getString("PUBLISHER")+"</td>"
									+ "<td>"+rSet.getString("DEPARTMENT")+"</td>"
									+ "<td>"+rSet.getString("NAME")+"</td>"
									+ "<td>"+rSet.getString("CURRENT_STATUS")+"</td>"
									+ "<td>"+rSet.getString("LIBNO")+"</td>"
									+ "<td>"+rSet.getString("DUEDATE")+"</td></tr>";
				}
				response.getWriter().print(opString);
			} catch (Exception e) {
				System.out.print(e);
			}
	}
	   else if ((!department.equals("")) && (!type.equals("")) ) {
		
		   LocalDate myObj = LocalDate.now();  // Create a date object
		    String td=myObj.toString();
		    System.out.println(td);
			   format1 = new SimpleDateFormat("yyyy-MM-dd");
			   format2 = new SimpleDateFormat("dd-MMM-yy");
			   date=null;
			   try {
					date = format1.parse(td);
					td=format2.format(date);
				    System.out.println(td);
				} catch (Exception e) {
					System.out.println(e);
				}
		    
		    if(type.equals("TODAYS_DUES")) {
		    try {
				   Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
					PreparedStatement select=connection.prepareStatement("select * from bookissue where DATEOFISSUE between '"+fromdate+"' and '"+todateString+"' and DEPARTMENT='"+department+"' and DUEDATE='"+td+"'");
					String opString="<table>"
							+ "            <tr>"
							+ "              <th>Title</th>"
							+ "              <th>Publisher</th>"
							+ "              <th>Department</th>"
							+ "              <th>name</th>"
							+ "              <th>status</th>"
							+ "              <th>Reg no.</th>"
							+ "              <th>DUE DATE</th>"
							+ "            </tr>";
					ResultSet rSet=select.executeQuery();
					while(rSet.next()) {
						opString=opString+"<tr>"
								+ "<td>"+rSet.getString("TITTLE")+"</td>"
										+ "<td>"+rSet.getString("PUBLISHER")+"</td>"
										+ "<td>"+rSet.getString("DEPARTMENT")+"</td>"
										+ "<td>"+rSet.getString("NAME")+"</td>"
										+ "<td>"+rSet.getString("CURRENT_STATUS")+"</td>"
										+ "<td>"+rSet.getString("LIBNO")+"</td>"
										+ "<td>"+rSet.getString("DUEDATE")+"</td></tr>";
					}
					response.getWriter().print(opString);
				} catch (Exception e) {
					System.out.print(e);
				}
	        }
		    else if (type.equals("DUES")) {
		    	 try {
					   Class.forName("oracle.jdbc.driver.OracleDriver");
						Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
						PreparedStatement select=connection.prepareStatement("select * from bookissue where DATEOFISSUE between '"+fromdate+"' and '"+todateString+"' and DEPARTMENT='"+department+"' and CURRENT_STATUS='issued'");
						String opString="<table>"
								+ "            <tr>"
								+ "              <th>Title</th>"
								+ "              <th>Publisher</th>"
								+ "              <th>Department</th>"
								+ "              <th>name</th>"
								+ "              <th>status</th>"
								+ "              <th>Reg no.</th>"
								+ "              <th>DUE DATE</th>"
								+ "            </tr>";
						ResultSet rSet=select.executeQuery();
						while(rSet.next()) {
							opString=opString+"<tr>"
									+ "<td>"+rSet.getString("TITTLE")+"</td>"
											+ "<td>"+rSet.getString("PUBLISHER")+"</td>"
											+ "<td>"+rSet.getString("DEPARTMENT")+"</td>"
											+ "<td>"+rSet.getString("NAME")+"</td>"
											+ "<td>"+rSet.getString("CURRENT_STATUS")+"</td>"
											+ "<td>"+rSet.getString("LIBNO")+"</td>"
											+ "<td>"+rSet.getString("DUEDATE")+"</td></tr>";
						}
						response.getWriter().print(opString);
					} catch (Exception e) {
						System.out.print(e);
					}
			}
		    else if (type.equals("RETURNED")) {
		    	try {
					   Class.forName("oracle.jdbc.driver.OracleDriver");
						Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
						PreparedStatement select=connection.prepareStatement("select * from bookissue where DATEOFISSUE between '"+fromdate+"' and '"+todateString+"' and DEPARTMENT='"+department+"' and CURRENT_STATUS='returned'");
						String opString="<table>"
								+ "            <tr>"
								+ "              <th>Title</th>"
								+ "              <th>Publisher</th>"
								+ "              <th>Department</th>"
								+ "              <th>name</th>"
								+ "              <th>status</th>"
								+ "              <th>Reg no.</th>"
								+ "              <th>DUE DATE</th>"
								+ "            </tr>";
						ResultSet rSet=select.executeQuery();
						while(rSet.next()) {
							opString=opString+"<tr>"
									+ "<td>"+rSet.getString("TITTLE")+"</td>"
											+ "<td>"+rSet.getString("PUBLISHER")+"</td>"
											+ "<td>"+rSet.getString("DEPARTMENT")+"</td>"
											+ "<td>"+rSet.getString("NAME")+"</td>"
											+ "<td>"+rSet.getString("CURRENT_STATUS")+"</td>"
											+ "<td>"+rSet.getString("LIBNO")+"</td>"
											+ "<td>"+rSet.getString("DUEDATE")+"</td></tr>";
						}
						response.getWriter().print(opString);
					} catch (Exception e) {
						System.out.print(e);
					}
			}
		    else if (type.equals("TODAYS_TRANSACTION")) {
		    	try {
					   Class.forName("oracle.jdbc.driver.OracleDriver");
						Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
						PreparedStatement select=connection.prepareStatement("select * from (select * from bookissue where DATEOFISSUE='09-JUL-22' or DUEDATE='12-JUL-22') where PUBLISHER='6rytcuvh'");
						String opString="<table>"
								+ "            <tr>"
								+ "              <th>Title</th>"
								+ "              <th>Publisher</th>"
								+ "              <th>Department</th>"
								+ "              <th>name</th>"
								+ "              <th>status</th>"
								+ "              <th>Reg no.</th>"
								+ "              <th>DUE DATE</th>"
								+ "            </tr>";
						ResultSet rSet=select.executeQuery();
						while(rSet.next()) {
							opString=opString+"<tr>"
									+ "<td>"+rSet.getString("TITTLE")+"</td>"
											+ "<td>"+rSet.getString("PUBLISHER")+"</td>"
											+ "<td>"+rSet.getString("DEPARTMENT")+"</td>"
											+ "<td>"+rSet.getString("NAME")+"</td>"
											+ "<td>"+rSet.getString("CURRENT_STATUS")+"</td>"
											+ "<td>"+rSet.getString("LIBNO")+"</td>"
											+ "<td>"+rSet.getString("DUEDATE")+"</td></tr>";
						}
						response.getWriter().print(opString);
					} catch (Exception e) {
						System.out.print(e);
					}
			}
   }
 }
}
