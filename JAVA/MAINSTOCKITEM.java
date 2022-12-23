import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/MAINSTOCKITEMoflibrary")
public class MAINSTOCKITEM extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String  Accession_No = request.getParameter("stkaccno");
		String  DEPARTMENT   = request.getParameter("mainstkrrDEPARTMENTLIB");
		String  Call_No      = request.getParameter("stkcallno");
		String  Booktype     = request.getParameter("stkbooktp");
		String  Title        = request.getParameter("stktitle");
		String  Entered_Date = request.getParameter("stkenterdtKKKK");
		
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
	    SimpleDateFormat format2 = new SimpleDateFormat("dd-MMM-yy");
	    java.util.Date date=null;
		try {
			date = format1.parse(Entered_Date);
			Entered_Date=format2.format(date);
		    System.out.println(Entered_Date);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		String  author       = request.getParameter("stkauthor");
		String  Bill_Date    = request.getParameter("stkbilldt");
		
		 format1 = new SimpleDateFormat("yyyy-MM-dd");
	     format2 = new SimpleDateFormat("dd-MMM-yy");
	     date=null;
		try {
			date = format1.parse(Bill_Date);
			Bill_Date=format2.format(date);
		    System.out.println(Bill_Date);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		String  Publisher    = request.getParameter("stkpub");
		String  No_of_Copies = request.getParameter("stknoofcpy");
		String  DATEs        = request.getParameter("stkdtyr");
		
		 format1 = new SimpleDateFormat("yyyy-MM-dd");
	     format2 = new SimpleDateFormat("dd-MMM-yy");
	     date=null;
		try {
			date = format1.parse(DATEs);
			DATEs=format2.format(date);
		    System.out.println(DATEs);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		String  ISBN         = request.getParameter("stkisbn");
		String  Edition      = request.getParameter("stkedition");
		String  FloorRackSelf = request.getParameter("stkfrs");
		String  noofpage     = request.getParameter("stknoofpage");
		String  Key_Words    = request.getParameter("stkkywrd");
		String  Sizes        = request.getParameter("stksize");
		String  Bill_Number  = request.getParameter("stkbillno");  
		String  Price        = request.getParameter("stkprice");
		String  VENDER       = request.getParameter("stkvend");
		
		try{  
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String username="system";
			String password="1234";
			Connection con=DriverManager.getConnection(url,username,password); 
			System.out.println("Created DB Connection....");
			PreparedStatement stmt=con.prepareStatement("insert into MAINSTOCKITEM values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");  
			stmt.setString(1,Accession_No);
			stmt.setString(2,DEPARTMENT);  
			stmt.setString(3,Call_No);  
			stmt.setString(4,Booktype);  
			stmt.setString(5,Title); 
			stmt.setString(6,Entered_Date);  
			stmt.setString(7,author); 
			stmt.setString(8,Bill_Date);
			stmt.setString(9,Publisher);
			stmt.setString(10,No_of_Copies);
			stmt.setString(11,DATEs);
			stmt.setString(12,ISBN);
			stmt.setString(13,Edition);
			stmt.setString(14,FloorRackSelf);
			stmt.setString(15,noofpage);
			stmt.setString(16,Key_Words);
			stmt.setString(17,Sizes);
			stmt.setString(18,Bill_Number);			
			stmt.setString(19,Price);
			stmt.setString(20,VENDER);
			
			

					    
			stmt.executeUpdate();
			
		         out.print("success fully");
		         
		            con.close();
		        } catch (ClassNotFoundException e) {
		            
		            e.printStackTrace();
		        } catch (SQLException e) {
		            
		            e.printStackTrace();
		        }
		
		
	
		
		
		
	}

}