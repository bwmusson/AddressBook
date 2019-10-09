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
 * Servlet implementation class editExistingListServlet
 */
@WebServlet("/editExistingAddressServlet")
public class editExistingAddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public editExistingAddressServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AddressHelper ah = new AddressHelper();
		ContactHelper ch = new ContactHelper();

		int idToEdit = Integer.parseInt(request.getParameter("id"));
		int contId = Integer.parseInt(request.getParameter("contactId"));
		
		Contact contToEdit = ch.searchForContactsById(contId);
		List<Address> contAddresses = contToEdit.getContactAddresses();
		
		Address toEdit = new Address();
		int indexOf = 0;
		
		for(Address a : contAddresses) {
			if(a.getAddressId() == idToEdit) {
				toEdit = a;
				indexOf = contAddresses.indexOf(a);
			}
		}

		String type = request.getParameter("type");
		toEdit.setType(type);
		String address = request.getParameter("address");
		toEdit.setAddress(address);
		String city = request.getParameter("city");
		toEdit.setCity(city);
		String state = request.getParameter("state");
		toEdit.setState(state);
		String zip = request.getParameter("zip");
		toEdit.setZip(zip);

		contAddresses.set(indexOf, toEdit);
		contToEdit.setContactAddresses(contAddresses);
		ch.updateContacts(contToEdit);
		
		System.out.println(toEdit.toString());

		getServletContext().getRequestDispatcher("/viewAllAddressServlet").forward(request, response);
	}

}
