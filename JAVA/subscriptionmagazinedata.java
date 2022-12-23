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
@WebServlet("/subscriptionmagazinedata")
public class subscriptionmagazinedata extends HttpServlet{
     public void doGet(HttpServletRequest request,HttpServletResponse response) {
    	 response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
				PreparedStatement selectvisitor=con.prepareStatement("select * from subscriptions");
				 ResultSet rs=selectvisitor.executeQuery();
				    JSONObject jsonObject = new JSONObject();
				    JSONArray array1 = new JSONArray();
				    JSONArray array2 = new JSONArray();
				    JSONArray array3 = new JSONArray();
				    JSONArray array4 = new JSONArray();
				    JSONArray array5 = new JSONArray();
				    JSONArray array6 = new JSONArray();
				    JSONArray array7 = new JSONArray();
				    JSONArray array8 = new JSONArray();
				    JSONArray array9 = new JSONArray();
				    while (rs.next()) {
						  array1.add(rs.getString("TITLE")); array2.add(rs.getString("PUBLISHER"));
						  array3.add(rs.getString("DEPARTMENT"));
						  array4.add(rs.getString("SUBS_TYPE")); array5.add(rs.getString("PERIODICITY"));
						  array6.add(rs.getString("PLACE"));
						  array7.add(rs.getString("FROMDATE"));
						  array8.add(rs.getString("TODATE"));
						  array9.add(rs.getString("DD_NO"));
					}
				    jsonObject.put("Title", array1);
				    jsonObject.put("Publisher", array2);
				    jsonObject.put("Department", array3);
				    jsonObject.put("Type", array4);
				    jsonObject.put("Periodicity", array5);
				    jsonObject.put("Place", array6);
				    jsonObject.put("FROM_Date", array7);
				    jsonObject.put("To_Date", array8);
				    jsonObject.put("ddno", array9);
				    PrintWriter out=response.getWriter();
				    out.print(jsonObject.toString());
				    
			} catch (Exception e) {
				System.out.println(e);
			} 
	}
}
