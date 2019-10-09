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
 * Servlet implementation class editExistingPhoneServlet
 */
@WebServlet("/editExistingPhoneServlet")
public class editExistingPhoneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public editExistingPhoneServlet() {
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
		PhoneHelper ph = new PhoneHelper();
		ContactHelper ch = new ContactHelper();

		int idToEdit = Integer.parseInt(request.getParameter("id"));
		int contId = Integer.parseInt(request.getParameter("contactId"));
		
		Contact contToEdit = ch.searchForContactsById(contId);
		List<Phone> contPhones = contToEdit.getContactPhones();
		
		Phone toEdit = new Phone();
		int indexOf = 0;
		
		for(Phone p : contPhones) {
			if(p.getPhoneId() == idToEdit) {
				toEdit = p;
				indexOf = contPhones.indexOf(p);
			}
		}

		String type = request.getParameter("type");
		toEdit.setType(type);
		String number = request.getParameter("number");
		toEdit.setNumber(number);

		contPhones.set(indexOf, toEdit);
		contToEdit.setContactPhones(contPhones);
		ch.updateContacts(contToEdit);
		
		System.out.println(toEdit.toString());

		getServletContext().getRequestDispatcher("/viewAllPhonesServlet").forward(request, response);
	}

}
