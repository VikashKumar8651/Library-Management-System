import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.PrintWriter;
import java.sql.*;
@WebServlet("/visitorstable")
public class visitorstable extends HttpServlet {
     public void doGet(HttpServletRequest request,HttpServletResponse response) {
    	    response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
				PreparedStatement selectvisitor=con.prepareStatement("select * from visitors");
				 ResultSet rs=selectvisitor.executeQuery();
				    JSONObject jsonObject = new JSONObject();
				    JSONArray array1 = new JSONArray();
				    JSONArray array2 = new JSONArray();
				    JSONArray array3 = new JSONArray();
				    JSONArray array4 = new JSONArray();
				    JSONArray array5 = new JSONArray();
				    JSONArray array6 = new JSONArray();
				    JSONArray array7 = new JSONArray();
				    while (rs.next()) {
						  array1.add(rs.getString(1)); array2.add(rs.getString(2));
						  array3.add(rs.getString(3));
						  array4.add(rs.getString(4)); array5.add(rs.getString(5));
						  array6.add(rs.getString(6));
						  array7.add(rs.getString(7));
					}
				    jsonObject.put("VID", array1);
				    jsonObject.put("VNAME", array2);
				    jsonObject.put("VCOURSE", array3);
				    jsonObject.put("VBRANCH", array4);
				    jsonObject.put("VISITING_DATE", array5);
				    jsonObject.put("LOGIN_TIME", array6);
				    jsonObject.put("LOGOUT_TIME", array7);
				    PrintWriter out=response.getWriter();
				    out.print(jsonObject.toString());
				    
			} catch (Exception e) {
				System.out.println(e);
			} 
			
	}
}