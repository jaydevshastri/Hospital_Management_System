package hospital_controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Hospital1.dao.hospital_dao;
import hospital.bo.hospital_bo;

/**
 * Servlet implementation class SignupController
 */
@WebServlet("/SignupController")
public class SignupController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignupController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		String pwd=request.getParameter("password");
		
		
		//pw.print(name+" "+email+" "+phone+" "+pwd);
		
		hospital_bo em= new hospital_bo();
		
		em.setName(name);
		em.setEmail(email);
		em.setPhone(phone);
        em.setPassword(pwd);	
        
        int status=hospital_dao.signup(em);
        
        if(status>0) {
        	
        	RequestDispatcher rd=request.getRequestDispatcher("login.html");
			rd.forward(request, response);
			pw.print("We are done with signup!!!!!!");
        }
        else {
        	pw.print("Something went wrong!!!!!!");
        }
		
	}

}
