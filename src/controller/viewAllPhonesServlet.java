package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Address;
import model.Phone;

/**
 * Servlet implementation class viewAllPhonesServlet
 */
@WebServlet("/viewAllPhonesServlet")
public class viewAllPhonesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewAllPhonesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ContactHelper dao = new ContactHelper();
		PhoneHelper ph = new PhoneHelper();
		
		request.setAttribute("allContacts", dao.showAllContacts());
		if(dao.showAllContacts().isEmpty()) {
			request.setAttribute("allContacts", " ");
		}
		
		List<Phone> phones = ph.showAllPhones();		
		request.setAttribute("allPhones", phones);
		if(phones.isEmpty()){
				request.setAttribute("allPhones", " ");
		}
		
		getServletContext().getRequestDispatcher("/phone-list.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
