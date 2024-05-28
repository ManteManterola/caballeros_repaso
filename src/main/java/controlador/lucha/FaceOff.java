package controlador.lucha;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Caballero;
import modelo.Conector;
import modelo.ModeloCaballero;

/**
 * Servlet implementation class FaceOff
 */
@WebServlet("/FaceOff")
public class FaceOff extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FaceOff() {
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
		
		//Conseguir los caballeros
		int caballeroId1 = Integer.parseInt(request.getParameter("caballero1"));
		int caballeroId2 = Integer.parseInt(request.getParameter("caballero2"));
		
		Caballero caballero1 = modeloCaballero.getPorId(caballeroId1);
		Caballero caballero2 = modeloCaballero.getPorId(caballeroId2);
		
		request.setAttribute("caballero1", caballero1);
		request.setAttribute("caballero2", caballero2);
		request.getRequestDispatcher("faceOff.jsp").forward(request, response);
	}

}
