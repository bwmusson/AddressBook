package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Address;
import model.Contact;

/**
 * Servlet implementation class createNewAddressServlet
 */
@WebServlet("/createNewAddressServlet")
public class createNewAddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public createNewAddressServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ContactHelper ch = new ContactHelper();

		String type = request.getParameter("type");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String zip = request.getParameter("zip");

		String[] selectedContacts = request.getParameterValues("allContactsToAdd");
		Contact selectedContactInList = new Contact();
		if (selectedContacts != null && selectedContacts.length > 0) {
			for (int i = 0; i < selectedContacts.length; i++) {
				System.out.println(selectedContacts[i]);
				selectedContactInList = ch.searchForContactsById(Integer.parseInt(selectedContacts[i]));
			}
		}

		Address ad = new Address(type, address, city, state, zip);
		List<Address> newadd = new ArrayList<Address>();
		newadd.add(ad);
		
		selectedContactInList.setContactAddresses(newadd);		
		ch.insertContacts(selectedContactInList);		
		System.out.println(selectedContactInList.toString());

		getServletContext().getRequestDispatcher("/viewAllAddressServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
