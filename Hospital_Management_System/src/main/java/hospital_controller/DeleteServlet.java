package hospital_controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Hospital1.dao.hospital_dao;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public DeleteServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();

        int id = Integer.parseInt(request.getParameter("id"));

        // Assuming hospital_dao has a method for deleting a patient by ID
        hospital_dao dao = new hospital_dao();
        int success = dao.delete(id);

        if (success>0) {
            pw.println("<html><body>");
            pw.println("<h2>Patient deleted successfully!</h2>");
 		   pw.print("<a href='home.html'>Back</a>");

            pw.println("</body></html>");
        } else {
            pw.println("<html><body>");
            pw.println("<h2>Error deleting patient. Please try again.</h2>");
 		   pw.print("<a href='home.html'>Back</a>");
            pw.println("</body></html>");
        }
    }
}