
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lti.training.dto.Employee;
import com.lti.training.dto.EmployeeDao;
import com.lti.training.servlet.DatabaseUserService2;

@WebServlet("AddEmployeeServlet")
public class AddEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmployeeDao dao=new EmployeeDao();
		Employee emp=new Employee();
		
		emp.setEmpno(Integer.parseInt(request.getParameter("empno")));
		emp.setName(request.getParameter("name"));
		emp.setSalary(Double.parseDouble(request.getParameter("salary")));
		
		//String name = request.getParameter("name");
		//String salary = request.getParameter("salary");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
	
		dao.add(emp);
		
		HttpSession session=request.getSession();
		session.setAttribute("message","Record added successfully");
		
		response.sendRedirect("addEmployee.jsp");//redirecting 
	}

}
