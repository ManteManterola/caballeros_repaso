package controlador.caballeros;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Arma;
import modelo.Caballero;
import modelo.Conector;
import modelo.Escudo;
import modelo.ModeloArma;
import modelo.ModeloCaballero;
import modelo.ModeloEscudo;

/**
 * Servlet implementation class EditarCaballero
 */
@WebServlet("/EditarCaballero")
public class EditarCaballero extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditarCaballero() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int idCaballero = Integer.parseInt(request.getParameter("id"));

		Conector conector = new Conector();
		ModeloCaballero modeloCaballero = new ModeloCaballero();
		modeloCaballero.setConector(conector);

		Caballero caballero = modeloCaballero.getPorId(idCaballero);

		ModeloArma modeloArma = new ModeloArma();
		modeloArma.setConector(conector);
		ArrayList<Arma> armas = modeloArma.getAll();

		ModeloEscudo modeloEscudo = new ModeloEscudo();
		modeloEscudo.setConector(conector);
		ArrayList<Escudo> escudos = modeloEscudo.getAll();

		request.setAttribute("caballero", caballero);
		request.setAttribute("armas", armas);
		request.setAttribute("escudos", escudos);

		request.getRequestDispatcher("editCaballero.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
	    String nombre = request.getParameter("nombre");
	    int fuerza = Integer.parseInt(request.getParameter("fuerza"));
	    int experiencia = Integer.parseInt(request.getParameter("experiencia"));
	    String foto = request.getParameter("foto");
	    int idArma = Integer.parseInt(request.getParameter("idArma"));
	    int idEscudo = Integer.parseInt(request.getParameter("idEscudo"));

	    Conector conector = new Conector();
	    ModeloCaballero modeloCaballero = new ModeloCaballero();
	    ModeloArma modeloArma = new ModeloArma();
	    ModeloEscudo modeloEscudo = new ModeloEscudo();
	    modeloArma.setConector(conector);
	    modeloEscudo.setConector(conector);
	    modeloCaballero.setConector(conector);

	    Caballero caballero = new Caballero();
	    caballero.setId(id);
	    caballero.setNombre(nombre);
	    caballero.setFuerza(fuerza);
	    caballero.setExperiencia(experiencia);
	    caballero.setFoto(foto);
	    caballero.setArma(modeloArma.getArma(idArma));
	    caballero.setEscudo(modeloEscudo.getEscudo(idEscudo));

	    modeloCaballero.actualizarCaballero(caballero);

	    response.sendRedirect("IndexCaballeros");
	}

}
