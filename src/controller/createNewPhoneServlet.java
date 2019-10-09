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
import model.Phone;

/**
 * Servlet implementation class createNewPhoneServlet
 */
@WebServlet("/createNewPhoneServlet")
public class createNewPhoneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public createNewPhoneServlet() {
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
		String number = request.getParameter("number");
		Phone p = new Phone(type, number);
		
		String[] selectedContacts = request.getParameterValues("allContactsToAdd");
		
		for(String s : selectedContacts) {
			int contactId = Integer.parseInt(s);
			Contact c = ch.searchForContactsById(contactId);
			c.addPhone(p);
			ch.updateContacts(c);
			System.out.println(c.toString());
		}

		getServletContext().getRequestDispatcher("/viewAllPhonesServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
