package controlador.lucha;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Caballero;
import modelo.Conector;
import modelo.ModeloCaballero;

/**
 * Servlet implementation class Lucha2Stage
 */
@WebServlet("/Lucha2Stage")
public class Lucha2Stage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Lucha2Stage() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Rellenar conector
		Conector conector = new Conector();
		ModeloCaballero modeloCaballero = new ModeloCaballero();
		modeloCaballero.setConector(conector);

		// Obtener el ID del caballero seleccionado
		int CaballeroId1 = Integer.parseInt(request.getParameter("selectedCaballeroId"));

		// Obtener caballero
		Caballero caballero1 = modeloCaballero.getPorId(CaballeroId1);

		ArrayList<Caballero> caballeros = modeloCaballero.getAll();

		// Filtrar la lista excluyendo el caballero seleccionado
		Iterator<Caballero> iterator = caballeros.iterator();
		while (iterator.hasNext()) {
			Caballero caballero = iterator.next();
			if (caballero.getId() == CaballeroId1) {
				iterator.remove();
				break;
			}
		}

		// Enviar la lista de caballeros restantes a la nueva página JSP
		request.setAttribute("caballeros", caballeros);
		request.setAttribute("caballero1", caballero1);
		request.getRequestDispatcher("elegirSegundoLuchador.jsp").forward(request, response);
	}

}
