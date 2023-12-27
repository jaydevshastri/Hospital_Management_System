package hospital_controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Hospital1.dao.hospital_dao;
import hospital.bo.hospital1_bo;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/EditServlet2")
public class EditServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		 PrintWriter pw=response.getWriter();
		
		 
		// String cssTag="<link rel='stylesheet' type='text/css' href='css/table.css'>";
		
	      String id=request.getParameter("id");
          
	      int pid= Integer.parseInt(id);
		hospital1_bo eb= hospital_dao.getEmployeeById(pid);
	      pw.print("<html>");
	    
			 pw.print("<link rel='stylesheet' href='css/edit.css'>");

		pw.print("<form  action='updateController' method='Get'> ");
		
		 
		pw.print("<table>");
		
		pw.print("<tr><td></td><td><input type='hidden' name='id' value='"+eb.getId()+"'/></td></tr>");  
		pw.print("<tr><td>Name: </td> <td><input type='text' name='name' id='na' value='"+eb.getName()+"'/></td></tr>");
	   	pw.print("<tr><td>Email: </td> <td><input type='text' name='email' id='na'  value='"+eb.getEmail()+"'/></td></tr>");
	   	pw.print("<tr><td>Phone:</td> <td><input type='text' name='phone' id='na'  value='"+eb.getPhone()+"'/></td></tr>");
	   	pw.print("<tr><td>Date of Birth : </td> <td><input type='text' name='dob' id='na' value='"+eb.getDob()+"'/></td></tr>");
	   	pw.print("<tr><td>Diseased: </td> <td><input type='text' name='diseased' id='na'  value='"+eb.getDiseased()+"'/></td></tr>");
	   	pw.print("<tr><td>blood_group: </td> <td><input type='text' name='blood_group' id='na'  value='"+eb.getBlood_group()+"'/></td></tr>");
		
	    pw.print("<tr><td><input type='submit' id='btn' value='Update '/></td></tr>"); 
	    
		pw.print("</table>"); 
	    pw.print("</form>");
		  pw.print("</body>");
		  pw.print("</html>");
	}

}
