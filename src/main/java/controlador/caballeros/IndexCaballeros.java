package controlador.caballeros;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.*;


/**
 * Servlet implementation class IndexCaballeros
 */
@WebServlet("/IndexCaballeros")
public class IndexCaballeros extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public IndexCaballeros() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("msg", request.getParameter("msg"));
		
		// Obtener el parámetro de búsqueda
        String search = request.getParameter("search");
        
		//Rellenar conector
		Conector conector = new Conector();
		ModeloCaballero modeloCaballero = new ModeloCaballero();
		modeloCaballero.setConector(conector);

		
		ArrayList<Caballero> caballeros = modeloCaballero.getAll();
		
		// Ordenar los caballeros por nombre
        Collections.sort(caballeros, new Comparator<Caballero>() {
            @Override
            public int compare(Caballero c1, Caballero c2) {
                return c1.getNombre().compareToIgnoreCase(c2.getNombre());
            }
        });
		
		// Filtrar la lista si hay un término de búsqueda
        if (search != null && !search.isEmpty()) {
            Iterator<Caballero> iterator = caballeros.iterator();
            while (iterator.hasNext()) {
                Caballero caballero = iterator.next();
                if (!caballero.getNombre().toLowerCase().contains(search.toLowerCase())) {
                    iterator.remove();
                }
            }
        }
        
		request.setAttribute("caballeros", caballeros);
		request.getRequestDispatcher("indexCaballero.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
