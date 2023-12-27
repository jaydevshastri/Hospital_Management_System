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
import hospital.bo.hospital1_bo;

/**
 * Servlet implementation class patientController
 */
@WebServlet("/patientController")
public class patientController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public patientController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		String dob=request.getParameter("dob");
		String diseased=request.getParameter("diseased");
		String blood_group=request.getParameter("blood_group");
		
		//pw.print(name+" "+email+" "+phone+" "+doj+" "+dob+" "+adhar);
	
	hospital1_bo eb=new hospital1_bo(name, email, phone, dob, diseased, blood_group);
		
	        int status =hospital_dao.Addpatient(eb);
		
		if(status>0) {
		pw.print("Your data has been successfully added!!!!!!");
		
		RequestDispatcher rd=request.getRequestDispatcher("Allpatientcontroller");
		rd.forward(request, response);
	}
		else 
		{
			
		pw.print("Something went wrong");
		RequestDispatcher rd=request.getRequestDispatcher("patientController");
		rd.include(request, response);
		}
		
			
		}
		
	}
