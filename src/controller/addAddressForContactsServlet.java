package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Address;

/**
 * Servlet implementation class addAddressForContactsServlet
 */
@WebServlet("/addAddressForContactsServlet")
public class addAddressForContactsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addAddressForContactsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ContactHelper dao = new ContactHelper();
		AddressHelper ah = new AddressHelper();
		
		request.setAttribute("allContacts", dao.showAllContacts());
		if(dao.showAllContacts().isEmpty()) {
			request.setAttribute("allContacts", " ");
		}
		
		List<Address> abc = ah.showAllAddresses();		
		request.setAttribute("allAddresses", abc);
		if(abc.isEmpty()){
				request.setAttribute("allAddresses", " ");
		}
		
		getServletContext().getRequestDispatcher("/new-address.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
