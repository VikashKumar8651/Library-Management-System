import java.sql.*;
import java.text.SimpleDateFormat;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MAINSTOCKITEMoflibraryllll")
public class ModifyMAINSTOCK extends HttpServlet {
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
		
//		
//		System.out.print(Accession_No);
//		System.out.print(DEPARTMENT);
//		System.out.print(Bill_Date);
		
		
		 try{  
				Class.forName("oracle.jdbc.driver.OracleDriver");
				String url="jdbc:oracle:thin:@localhost:1521:xe";
				String username="system";
				String password="1234";
				Connection con=DriverManager.getConnection(url,username,password); 
				
				System.out.println("Created DB Connection....");
				PreparedStatement select = con.prepareStatement("select DEPARTMENT,	CALLNO,	BOOK_TYPE, TITLE, ENTERED_DATE, AUTHOR, BILL_DATE, PUBLISHER, NO_OF_COPIES,	DATES, ISBN, EDITION, FLOOR_RACK_SELF, NO_OF_PAGE, KEYWORD,	SIZES, BILL_NUMBER,	PRICE, VENDOR from  MAINSTOCKITEM where ACCESSIONNO='"+Accession_No+"'");
			     ResultSet rsp=select.executeQuery();
			     if (rsp.next()) {
			    	 Statement stmt=con.createStatement();
						String s1="update MAINSTOCKITEM set   DEPARTMENT='"+DEPARTMENT+"', CALLNO='"+Call_No+"', BOOK_TYPE='"+Booktype+"', TITLE='"+Title+"', ENTERED_DATE='"+Entered_Date+"', AUTHOR='"+author+"', BILL_DATE='"+Bill_Date+"', PUBLISHER='"+Publisher+"', NO_OF_COPIES='"+No_of_Copies+"',	DATES='"+DATEs+"', ISBN='"+ISBN+"', EDITION='"+Edition+"', FLOOR_RACK_SELF='"+FloorRackSelf+"', NO_OF_PAGE='"+noofpage+"', KEYWORD='"+Key_Words+"',	SIZES='"+Sizes+"', BILL_NUMBER='"+Bill_Number+"',	PRICE='"+Price+"', VENDOR='"+VENDER+"'  where ACCESSIONNO='"+Accession_No+"'";
						
						stmt.executeUpdate(s1);
						  out.print("successfully updated ");

			     }
			     else {
			    	 out.print("Accession no of  doesn't exist");
			     }
		            con.close();
		        } catch (ClassNotFoundException e) {
		            
		            e.printStackTrace();
		        } catch (SQLException e) {
		            
		            e.printStackTrace();
		        }

		
		
		
	}

}