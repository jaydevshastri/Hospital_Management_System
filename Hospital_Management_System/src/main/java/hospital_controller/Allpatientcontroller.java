package hospital_controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Hospital1.dao.hospital_dao;
import hospital.bo.hospital1_bo;
/**
 * Servlet implementation class Allpatientcontroller
 */
@WebServlet("/Allpatientcontroller")
public class Allpatientcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Allpatientcontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
		 response.setContentType("text/html");
		   PrintWriter pw=response.getWriter();
		   
		  pw.print ("<link rel='stylesheet' type='text/css' href='css/Table.css'>");
			
		   pw.print("<html>");
		   
		   			
			pw.print("<body>");
			
		   
		   pw.print("<a href='home.html'>Back</a>");
		   
		   pw.print("<table border='1px' width='100%'> ");
		    
		    pw.print("<tr> <th> Id </th> <th> Name </th> <th> Email </th> <th> Phone </th> <th> Date Of Birth</th> <th> diseased</th>  <th>blood_group</th> <th>Actions</th> <th>Delete</th></tr>");
		   
		   
		   
		  List<hospital1_bo> list= hospital_dao.getAllpatient();
		   
		  for(hospital1_bo eb:list) {
			  
			   pw.print("<tr><td>"+eb.getId()+"</td><td>"+eb.getName()+"</td><td>"+eb.getEmail()+"</td><td>"+eb.getPhone()+"</td><td>"+eb.getDob()+"</td><td>"+eb.getDiseased()+"</td><td>"+eb.getBlood_group()+"</td><td>"+"<a href='EditServlet2?id="+eb.getId()+"'>edit</a></td><td><a href='DeleteServlet?id="+eb.getId()+"'>delete</a></td></tr>"); 
			  
		  }
		   
		  pw.print("</table>");
		 
		  pw.print("</body>");
		  pw.print("</html>");
	}


	}


