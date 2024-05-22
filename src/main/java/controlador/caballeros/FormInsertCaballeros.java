package controlador.caballeros;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Arma;
import modelo.Conector;
import modelo.Escudo;
import modelo.ModeloArma;
import modelo.ModeloEscudo;

/**
 * Servlet implementation class FormInsertCaballeros
 */
@WebServlet("/FormInsertCaballeros")
public class FormInsertCaballeros extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormInsertCaballeros() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("msg", request.getParameter("msg"));
		
		Conector conector = new Conector();
		ModeloArma modeloArma = new ModeloArma();
		ModeloEscudo modeloEscudo = new ModeloEscudo();
		modeloArma.setConector(conector);
		modeloEscudo.setConector(conector);
		
		ArrayList<Arma> armas = modeloArma.getAll();
		ArrayList<Escudo> escudos = modeloEscudo.getAll();
		request.setAttribute("armas", armas);
		request.setAttribute("escudos", escudos);
		
		request.getRequestDispatcher("insertCaballero.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
