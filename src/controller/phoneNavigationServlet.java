package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Address;
import model.Contact;
import model.Phone;

/**
 * Servlet implementation class phoneNavigationServlet
 */
@WebServlet("/phoneNavigationServlet")
public class phoneNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public phoneNavigationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PhoneHelper ph = new PhoneHelper();
		ContactHelper ch = new ContactHelper();
		String act = request.getParameter("doThisToItem");

		if (act == null) {
			// no button has been selected
			getServletContext().getRequestDispatcher("/viewAllPhonesServlet").forward(request, response);

		} 
		else if (act.equals("Delete")) {
			try {
				int tempId = Integer.parseInt(request.getParameter("id"));
				int contId = Integer.parseInt(request.getParameter("contId"));
				Contact cont = ch.searchForContactsById(contId);
				Phone phoneToDelete = ph.searchForPhoneById(tempId);		
				cont.removePhone(phoneToDelete);
				ch.updateContacts(cont);

			} catch (NumberFormatException e) {
				System.out.println("Forgot to click a button");
			} finally {
				getServletContext().getRequestDispatcher("/viewAllPhonesServlet").forward(request, response);
			}

		} 
		else if (act.equals("Edit")) {
			try {
				
				int tempId = Integer.parseInt(request.getParameter("id"));
				int contId = Integer.parseInt(request.getParameter("contId"));
				
				Contact contactToEdit = ch.searchForContactsById(contId);
								
				Phone phoneToEdit = new Phone();
				List<Phone> contactPhones = contactToEdit.getContactPhones();

				for(Phone p : contactPhones) {
					if(p.getPhoneId() == tempId) {
						phoneToEdit = p;
					}
				}

				request.setAttribute("contactToEdit", contactToEdit);
				request.setAttribute("phoneToEdit", phoneToEdit);
				getServletContext().getRequestDispatcher("/edit-phone.jsp").forward(request, response);
			} catch (NumberFormatException e) {
				getServletContext().getRequestDispatcher("/viewAllPhonesServlet").forward(request, response);
			}

		} 
		else if (act.equals("Add New")) {
			getServletContext().getRequestDispatcher("/addPhoneForContactsServlet").forward(request, response);
		}
		else {
			System.out.println("Bad Parameter Passed");
		}
	}

}
