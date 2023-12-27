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
 * Servlet implementation class updateController
 */
@WebServlet("/updateController")
public class updateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Object hopital_dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		int id=Integer.parseInt(request.getParameter("id"));
		
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		String dob=request.getParameter("dob");
		String diseased=request.getParameter("diseased");
		String blood_group=request.getParameter("blood_group");
		
		
		hospital1_bo eb=new hospital1_bo();
		eb.setId(id);
		eb.setName(name);
		eb.setEmail(email);
		eb.setPhone(phone);
		eb.setDob(dob);
		eb.setDiseased(diseased);
		eb.setBlood_group(blood_group);
	
		
		
		int status=hospital_dao.Update(eb);
		
		if(status>0) 
		{
			
			RequestDispatcher rd=request.getRequestDispatcher("Allpatientcontroller");
			rd.forward(request, response);
		}
		
		
		
	}

}
