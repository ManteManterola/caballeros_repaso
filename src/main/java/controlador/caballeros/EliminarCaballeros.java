package controlador.caballeros;

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
 * Servlet implementation class EliminarCaballeros
 */
@WebServlet("/EliminarCaballeros")
public class EliminarCaballeros extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EliminarCaballeros() {
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
		String caballerosAEliminarStr = request.getParameter("caballerosAEliminar");
        String[] caballerosAEliminar = caballerosAEliminarStr.split(",");

        // Conectar con la base de datos
        Conector conector = new Conector();
        ModeloCaballero modeloCaballero = new ModeloCaballero();
        modeloCaballero.setConector(conector);

        // Eliminar los caballeros
        boolean existe = true;
        for (String idStr : caballerosAEliminar) {
            try {
            	int id = Integer.parseInt(idStr);
            	if(modeloCaballero.getPorId(id) != null) {
            		existe = true;
            	} else {
            		existe = false;
            		break;
            	}
                
                
            } catch (NumberFormatException e) {
                // Manejar el caso en el que el ID no sea un número válido
            }
            
        }
        
        if (existe) {
        	for (String idStr : caballerosAEliminar) {
        		int id = Integer.parseInt(idStr);
        		modeloCaballero.delete(id);
			}
        	
		}

        // Redirigir a una página de éxito o actualizar la vista
        response.sendRedirect("IndexCaballeros");
    }
}
