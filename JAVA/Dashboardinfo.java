import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONObject;
@WebServlet("/dashboardinfo")
public class Dashboardinfo extends HttpServlet{
   public void doPost(HttpServletRequest request,HttpServletResponse response) {
	   response.setContentType("application/json");
	   response.setCharacterEncoding("UTF-8");
	   JSONObject JO=new JSONObject();
	   /* total no. of book */
	   try {
		    Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
			PreparedStatement tbookst=connection.prepareStatement("select count(ACCESSIONNO) from MAINSTOCKITEM");
			ResultSet tbook=tbookst.executeQuery();
			if (tbook.next()) {
				JO.put("totalbooks", tbook.getString(1));
			}
			
			PreparedStatement tcsebookst=connection.prepareStatement("select count(ACCESSIONNO) from MAINSTOCKITEM where DEPARTMENT='CSE'");
			PreparedStatement tITbookst=connection.prepareStatement("select count(ACCESSIONNO) from MAINSTOCKITEM where DEPARTMENT='IT'");  
	        PreparedStatement tAInMLst=connection.prepareStatement("select count(ACCESSIONNO) from MAINSTOCKITEM where DEPARTMENT='AI&ML'");
			ResultSet tcsebook=tcsebookst.executeQuery();
			ResultSet tITbook=tITbookst.executeQuery();
			if(tcsebook.next() && tITbook.next()) {
				int it=   Integer.parseInt(tITbook.getString(1));
				int cse= Integer.parseInt(tcsebook.getString(1));
				int cseit=it+cse;
				JO.put("cseit", cseit);
			}
			
	        PreparedStatement AGRICULTUREst=connection.prepareStatement("select count(ACCESSIONNO) from MAINSTOCKITEM where DEPARTMENT='AGRICULTURE'");
	        PreparedStatement MECHANICALst=connection.prepareStatement("select count(ACCESSIONNO) from MAINSTOCKITEM where DEPARTMENT='MECHANICAL'");
	        PreparedStatement BIO_TECHst=connection.prepareStatement("select count(ACCESSIONNO) from MAINSTOCKITEM where DEPARTMENT='BIOTECHNOLOGY'");
	        PreparedStatement BIO_MEDst=connection.prepareStatement("select count(ACCESSIONNO) from MAINSTOCKITEM where DEPARTMENT='BIOMEDICAL'");
	        PreparedStatement ECEst=connection.prepareStatement("select count(ACCESSIONNO) from MAINSTOCKITEM where DEPARTMENT='ECE'");
	        PreparedStatement CHEMICALst=connection.prepareStatement("select count(ACCESSIONNO) from MAINSTOCKITEM where DEPARTMENT='CHEMICAL'");
	        PreparedStatement CIVILst=connection.prepareStatement("select count(ACCESSIONNO) from MAINSTOCKITEM where DEPARTMENT='CIVIL'");
	        PreparedStatement FOOD_TECHst=connection.prepareStatement("select count(ACCESSIONNO) from MAINSTOCKITEM where DEPARTMENT='FOOD TECH'");
	        PreparedStatement PHARMACYst=connection.prepareStatement("select count(ACCESSIONNO) from MAINSTOCKITEM where DEPARTMENT='PHARMACY'");
	        PreparedStatement LLBst=connection.prepareStatement("select count(ACCESSIONNO) from MAINSTOCKITEM where DEPARTMENT='LLB'");
	        PreparedStatement BBAst=connection.prepareStatement("select count(ACCESSIONNO) from MAINSTOCKITEM where DEPARTMENT='BBA'");
	       
  
	        
	        ResultSet AGRICULTURE=AGRICULTUREst.executeQuery();
	        ResultSet MECHANICAL=MECHANICALst.executeQuery();
	        ResultSet BIO_TECH=BIO_TECHst.executeQuery();
	        ResultSet BIO_MED=BIO_MEDst.executeQuery();
	        ResultSet ECE=ECEst.executeQuery();
	        ResultSet CHEMICAL=CHEMICALst.executeQuery();
	        ResultSet CIVIL=CIVILst.executeQuery();
	        ResultSet FOOD_TECH=FOOD_TECHst.executeQuery();
	        ResultSet PHARMACY=PHARMACYst.executeQuery();
	        ResultSet LLB=LLBst.executeQuery();
	        ResultSet BBA=BBAst.executeQuery();
	        
	        AGRICULTURE.next();
	        MECHANICAL.next();
	        BIO_TECH.next();
	        BIO_MED.next();
	        ECE.next();
	        CHEMICAL.next();
	        CIVIL.next();
	        FOOD_TECH.next();
	        PHARMACY.next();
	        LLB.next();
	        BBA.next();
	        
	        JO.put("AGRICULTURE",AGRICULTURE.getString(1));
	        JO.put("MECHANICAL",MECHANICAL.getString(1));
	        JO.put("BIO_TECH",BIO_TECH.getString(1));
	        JO.put("BIO_MED",BIO_MED.getString(1));
	        JO.put("ECE",ECE.getString(1));
	        JO.put("CHEMICAL",CHEMICAL.getString(1));
	        JO.put("CIVIL",CIVIL.getString(1));
	        JO.put("FOOD_TECH",FOOD_TECH.getString(1));
	        JO.put("PHARMACY",PHARMACY.getString(1));
	        JO.put("LLB",LLB.getString(1));
	        JO.put("BBA",BBA.getString(1));

	        PreparedStatement regstudentst=connection.prepareStatement("select count(lib_no) from Accounts");
	        ResultSet regstudent=regstudentst.executeQuery();
	        regstudent.next();
	        JO.put("totalaccount", regstudent.getString(1));
	        
	        PreparedStatement visitorst=connection.prepareStatement("select count(vid) from visited where STATUS='logged in'");
	        ResultSet visitor=visitorst.executeQuery();
	        visitor.next();
	        JO.put("visitorinside", visitor.getString(1));
	        
	        
	        System.out.print(JO.toJSONString());
	        System.out.print(JO.toString());
	        response.getWriter().print(JO.toString());
	        
	   } catch (Exception e) {
	   System.out.println(e);	
	}
   }
}
