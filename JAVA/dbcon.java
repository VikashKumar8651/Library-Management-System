import java.sql.*;
public class dbcon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
				System.out.print("success");
				PreparedStatement selectStudent = connection.prepareStatement("select sid,sname,sbranch from student where sid='201FA07078'");
			//	selectStudent.setString(1, iregno);
				ResultSet rSet =selectStudent.executeQuery();
				rSet.next();
				System.out.print(" "+rSet.getString(1)+" ");
		 }catch (Exception e) {
			// TODO: handle exception
			 System.out.print(e);
		}
	}

}
