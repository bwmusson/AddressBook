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

/**
 * Servlet implementation class addressNavigationServlet
 */
@WebServlet("/addressNavigationServlet")
public class addressNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public addressNavigationServlet() {
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
		AddressHelper ah = new AddressHelper();
		ContactHelper ch = new ContactHelper();
		String act = request.getParameter("doThisToItem");

		if (act == null) {
			// no button has been selected
			getServletContext().getRequestDispatcher("/viewAllAddressServlet").forward(request, response);

		} 
		else if (act.equals("Delete")) {
			try {
				int tempId = Integer.parseInt(request.getParameter("id"));
				int contId = Integer.parseInt(request.getParameter("contId"));
				Contact cont = ch.searchForContactsById(contId);
				Address addressToDelete = ah.searchForAddressById(tempId);
				cont.removeAddress(addressToDelete);
				ch.updateContacts(cont);

			} catch (NumberFormatException e) {
				System.out.println("Forgot to click a button");
			} finally {
				getServletContext().getRequestDispatcher("/viewAllAddressServlet").forward(request, response);
			}

		} 
		else if (act.equals("Edit")) {
			try {
				
				int tempId = Integer.parseInt(request.getParameter("id"));
				int contId = Integer.parseInt(request.getParameter("contId"));
				
				Contact contactToEdit = ch.searchForContactsById(contId);
								
				Address addressToEdit = new Address();
				List<Address> contactAddresses = contactToEdit.getContactAddresses();

				for(Address a : contactAddresses) {
					if(a.getAddressId() == tempId) {
						addressToEdit = a;
					}
				}

				request.setAttribute("contactToEdit", contactToEdit);
				request.setAttribute("addressToEdit", addressToEdit);
				getServletContext().getRequestDispatcher("/edit-address.jsp").forward(request, response);
			} catch (NumberFormatException e) {
				getServletContext().getRequestDispatcher("/viewAllAddressServlet").forward(request, response);
			}

		} 
		else if (act.equals("Add New")) {
			getServletContext().getRequestDispatcher("/addAddressForContactsServlet").forward(request, response);
		}
		else {
			System.out.println("Bad Parameter Passed");
		}
	}

}
