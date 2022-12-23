
import org.json.simple.JSONValue;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.time.LocalDateTime;  // Import the LocalDateTime class
import java.time.format.DateTimeFormatter;  // Import the DateTimeFormatter class
@WebServlet("/loginform")
public class attendanceform extends HttpServlet{

	public void doGet(HttpServletRequest req,HttpServletResponse res) {
		String iregno=req.getParameter("regnofromattendance");
		System.out.print(iregno);
		try {
			res.setContentType("application/json");
			res.setCharacterEncoding("UTF-8");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
			PreparedStatement select=con.prepareStatement("select sid,sname,sbranch from student where sid='"+iregno+"'");
			PreparedStatement status=con.prepareStatement("select status from visited where vid='"+iregno+"'");
		    ResultSet rs=select.executeQuery();
		    ResultSet rsst=status.executeQuery();
		    
		    JSONObject jsonObject = new JSONObject();
		    
		    PrintWriter out=res.getWriter();
		    if(rsst.next()) {
		    	rsst =status.executeQuery();
		    	rsst.next();
		    	if(rsst.getString(1).equals("logged in")) {
			    	PreparedStatement updatestatus=con.prepareStatement("UPDATE visited SET status ='logged out' WHERE vid='"+iregno+"'");
			    	updatestatus.executeUpdate();
			    	rsst =status.executeQuery();
			    	rsst.next();
				    jsonObject.put("status",rsst.getString(1));	
				    LocalDateTime myDateObj = LocalDateTime.now();  
			        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("HH:mm:ss");  
			        String formattedtime = myDateObj.format(myFormatObj); 
				    PreparedStatement updatevisited =con.prepareStatement("UPDATE visitors SET logout_time = '"+formattedtime+"' WHERE vid='"+iregno+"'");
				    updatevisited.executeUpdate();
				    System.out.println("hogya update");
		    	}
		    	else {
		    		PreparedStatement updatestatus=con.prepareStatement("UPDATE visited SET status ='logged in' WHERE vid='"+iregno+"'");
			    	updatestatus.executeUpdate();
			    	rsst =status.executeQuery();
			    	rsst.next();
				    jsonObject.put("status",rsst.getString(1));	
				}
		    }
		    else {
		    	
		    	PreparedStatement insertstatus=con.prepareStatement("insert into visited values('"+iregno+"','"+"logged in"+"')");
		    	insertstatus.executeUpdate();
		    	rsst =status.executeQuery();
		    	rsst.next();
				PreparedStatement selectforvisited=con.prepareStatement("select * from student where sid='"+iregno+"'");
				ResultSet rsforvisited= selectforvisited.executeQuery();
				rsforvisited.next();

		        LocalDateTime myDateObj = LocalDateTime.now();  
		        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("HH:mm:ss");  
		        String formattedtime = myDateObj.format(myFormatObj);  
		    	PreparedStatement insertvisitor = con.prepareStatement("insert into visitors values('"+rsforvisited.getString(1)+"','"+rsforvisited.getString(2)+"','"+rsforvisited.getString(4)+"','"+rsforvisited.getString(3)+"',sysdate,'"+formattedtime+"',null)");
                insertvisitor.executeUpdate();
		    	
		    	
			    jsonObject.put("status",rsst.getString(1));	
		    	
		    }
		    rs.next();
		    jsonObject.put("vid", rs.getString(1));
		    jsonObject.put("sname",rs.getString(2));
		    jsonObject.put("sbranch",rs.getString(3));
		    out.print(jsonObject.toString());			
		} catch (Exception e) {
          System.out.println(e);
		}
	}
}











