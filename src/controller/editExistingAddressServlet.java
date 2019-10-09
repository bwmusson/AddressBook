package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Address;

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
		// TODO Auto-generated method stub

		AddressHelper ah = new AddressHelper();

		int idToEdit = Integer.parseInt(request.getParameter("id"));
		Address toEdit = ah.searchForAddressById(idToEdit);

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

		ah.updateAddress(toEdit);

		System.out.println(toEdit.toString());

		getServletContext().getRequestDispatcher("/viewAllAddressServlet").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
