import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/createaccmanually")
public class createaccmanually extends HttpServlet{
 public void doGet(HttpServletRequest request,HttpServletResponse response) {
	String createaccountmanualbapformnamelib=request.getParameter("createaccountmanualbapformnamelib");
	String createaccountmanualbapformnameregno=request.getParameter("createaccountmanualbapformnameregno");
	String createaccountmanualbapformnamename=request.getParameter("createaccountmanualbapformnamename");
	String createaccountmanualbapacademicdetailprivilege=request.getParameter("createaccountmanualbapacademicdetailprivilege");
	String createaccountmanualbapacademicdetaildepartment=request.getParameter("createaccountmanualbapacademicdetaildepartment");
	String createaccountmanualbapacademicdetailCourse=request.getParameter("createaccountmanualbapacademicdetailCourse");
	String createaccountmanualbapacademicdetailYears=request.getParameter("createaccountmanualbapacademicdetailYears");
	String createaccountmanualbapformemailinp=request.getParameter("createaccountmanualbapformemailinp");
	String createaccountmanualbapformaddressinp=request.getParameter("createaccountmanualbapformaddressinp");
	String createaccountmanualbapformidnoinp=request.getParameter("createaccountmanualbapformidnoinp");
	String createaccountmanualbapformphnoinp=request.getParameter("createaccountmanualbapformphnoinp");
	String createaccountmanualbapformremarks=request.getParameter("createaccountmanualbapformremarks");
}
}
