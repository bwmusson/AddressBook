package controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Contact;

/**
 * Servlet implementation class editContactServlet
 */
@WebServlet("/editContactServlet")
public class editContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editContactServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ContactHelper dao = new ContactHelper();		
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		Contact contactToEdit = dao.searchForContactsById(tempId);
		
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");

		//update date of birth
		LocalDate dob;
		try {
			dob = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		} catch (NumberFormatException ex) {
			dob = LocalDate.now();
		}
		contactToEdit.setDob(dob);
			
		//update contact
		contactToEdit.setFirstName(firstName);
		contactToEdit.setLastName(lastName);
				
		dao.updateContacts(contactToEdit);

		getServletContext().getRequestDispatcher("/viewAllContactsServlet").forward(request, response);

	}

}
