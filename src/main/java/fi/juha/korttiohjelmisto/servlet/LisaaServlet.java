package fi.juha.korttiohjelmisto.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fi.juha.korttiohjelmisto.bean.Osoite;
import fi.juha.korttiohjelmisto.dao.DAOPoikkeus;
import fi.juha.korttiohjelmisto.dao.OsoiteDAO;

/**
 * Servlet implementation class LisaaServlet
 */
@WebServlet("/LisaaServlet")
public class LisaaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LisaaServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String henkilonNimi = request.getParameter("henkilonNimi");
		String osoite = request.getParameter("osoite");
		String postinro = request.getParameter("postinro");
		String postitmp = request.getParameter("postitmp");

		Osoite o = new Osoite(henkilonNimi, osoite, postinro, postitmp);

		try {
			OsoiteDAO oDao = new OsoiteDAO();
			oDao.lisaa(o);
		} catch (DAOPoikkeus e) {
			throw new ServletException(e);
		}

		response.sendRedirect("vahvistus.jsp"); // redirect doGet
	}

}
