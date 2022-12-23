import javax.servlet.http.HttpServlet;
import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/exportexcel")


public class exportexcel extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("application/vnd.ms-excel");
		PrintWriter out=response.getWriter();
		out.println("<html><body>"); 
		out.print("<h1 style=text-align:center;color:red;>BOOK STATISTICS</h1>");
		
		String Category = request.getParameter("BOOK_STATISTICS_fOR_ALL_BRANCH_Selct_Category");
		String Department = request.getParameter("BOOK_STATISTICS_fOR_ALL_BRANCH_Department");		
		String Accession_Number = request.getParameter("BOOK_STATISTICS_fOR_ALL_BRANCH_ACCESSNUMBER");
		String Tittle = request.getParameter("BOOK_STATISTICS_fOR_ALL_BRANCH_tittle");
		String Author= request.getParameter("BOOK_STATISTICS_fOR_ALL_BRANCH_author");
		String Publisher = request.getParameter("BOOK_STATISTICS_fOR_ALL_BRANCH_Publisher");
		String Edition = request.getParameter("BOOK_STATISTICS_fOR_ALL_BRANCH_Edition");
		
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			  
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");  
			
			PreparedStatement stmt=con.prepareStatement("select ACCESSION_NUMBER from LIBRARYBOOK where ACCESSION_NUMBER=? and DEPARTMENT=?"); 
			stmt.setString(1,Accession_Number);
			stmt.setString(2,Department);
			
			 ResultSet rs1 = stmt.executeQuery(); 
			 rs1.next();
			 String h=rs1.getString(1);
			 
			PreparedStatement vs=con.prepareStatement("select * from BOOKIssue where ACCESSIONNUMBER='"+h+"'"); 

			ResultSet rs = vs.executeQuery();  
             out.println("<table border=1 width=50% height=30%>");  
            out.println("<tr><th>LIBNO</th><th>NAME</th><th>CATEGORY</th><th>PRIVILEGE</th><th>ACCESSIONNUMBER</th><th>DEPARTMENT</th><th>CALLNO</th><th>IDCARDNO</th><th>TITTLE</th><th>AUTHORS</th><TH>PUBLISHER</TH> <TH>PRICE</TH>  <TH>DATEOFISSUE</TH>  <TH>DUEDATE</TH> <TH>DATEOFRETURN</TH>   <th>REMARKS</th>  <th>FINE_AMOUNT_RS</th> <th>CURRENT_STATUS</th>    <tr>"); 
		            
             
             while (rs.next()) 
             {  
                String LIBNO = rs.getString("LIBNO");  
                 String NAME = rs.getString("NAME");  
                 String CATEGORY = rs.getString("CATEGORY"); 
                 String PRIVILEGE =rs.getString("PRIVILEGE");
                 String ACCESSIONNUMBER =rs.getString("ACCESSIONNUMBER");
                 String DEPARTMENT =rs.getString("DEPARTMENT");
                 String CALLNO =rs.getString("CALLNO");
                 String IDCARDNO =rs.getString("IDCARDNO");
                 String TITTLE =rs.getString("TITTLE");
                 String AUTHORS =rs.getString("AUTHORS");
                 String PUBLISHER =rs.getString("PUBLISHER");
                 
                 String PRICE = rs.getString("PRICE");
                 String DATEOFISSUE = rs.getString("DATEOFISSUE");
                 String DUEDATE = rs.getString("DUEDATE");
                 String DATEOFRETURN = rs.getString("DATEOFRETURN");
                 
                 String REMARKS = rs.getString("REMARKS");
                 String FINE_AMOUNT_RS = rs.getString("FINE_AMOUNT_RS");
                 String CURRENT_STATUS = rs.getString("CURRENT_STATUS");
                
                 
                 
                 out.println("<tr><td>" + LIBNO + "</td> <td>" + NAME + "</td> <td>" + CATEGORY + "</td> <td>"+PRIVILEGE+"</td>  <td>"+ACCESSIONNUMBER+"</td>  <td>"+DEPARTMENT+"</td> <td>"+CALLNO+"</td>  <td>"+IDCARDNO+"</td>  <td>"+TITTLE+"</td>  <td>"+AUTHORS+"</td> <td>"+PUBLISHER+"</td>   <td>"+PRICE+"</td>   <td>"+DATEOFISSUE+"</td> <td>"+DUEDATE+"</td>  <td>"+DATEOFRETURN+"</td> <td>"+REMARKS+"</td>  <td>"+FINE_AMOUNT_RS+"</td>  <td>"+CURRENT_STATUS+"</td> </tr>");   
           
             }
             out.println("</table>");  
             out.println("</html></body>"); 
             
             
	            con.close();
	        } catch (ClassNotFoundException e) {
	            
	            e.printStackTrace();
	        } catch (SQLException e) {
	            
	            e.printStackTrace();
	        }
	
	         
	}
}