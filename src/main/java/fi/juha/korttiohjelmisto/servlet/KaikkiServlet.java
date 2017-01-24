package fi.juha.korttiohjelmisto.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fi.juha.korttiohjelmisto.bean.Osoite;
import fi.juha.korttiohjelmisto.dao.DAOPoikkeus;
import fi.juha.korttiohjelmisto.dao.OsoiteDAO;


/**
 * Servlet implementation class KaikkiServlet
 */
@WebServlet(name="listaa",urlPatterns={"/listaa"})
public class KaikkiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public KaikkiServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		List<Osoite> osoitteet;

		try {
			// tietokannasta henkilöt
			OsoiteDAO oDao = new OsoiteDAO();
			osoitteet = oDao.haeKaikki();
		} catch (DAOPoikkeus e) {
			throw new ServletException(e);
		}

		// requestiin talteen
		request.setAttribute("osoitteet", osoitteet);

		// jsp hoitaa muotoilun
		request.getRequestDispatcher("nayta.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
