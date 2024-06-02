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
import modelo.ModeloLucha;

/**
 * Servlet implementation class Lucha
 */
@WebServlet("/LuchaFinal")
public class LuchaFinal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LuchaFinal() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Obtener los IDs de los caballeros que van a luchar
        int idCaballero1 = Integer.parseInt(request.getParameter("caballero1"));
        int idCaballero2 = Integer.parseInt(request.getParameter("caballero2"));

        // Conectar a la base de datos y obtener los caballeros
        Conector conector = new Conector();
        ModeloCaballero modeloCaballero = new ModeloCaballero();
        modeloCaballero.setConector(conector);

        Caballero caballero1 = modeloCaballero.getPorId(idCaballero1);
        Caballero caballero2 = modeloCaballero.getPorId(idCaballero2);

        // Determinar el ganador
        ModeloLucha modeloLucha = new ModeloLucha();
        modeloLucha.setConector(conector);
        Caballero ganador = modeloLucha.luchar(caballero1, caballero2);
        
        modeloLucha.insertLucha(caballero1, caballero2, ganador);

        // Pasar los datos a la JSP
        request.setAttribute("caballero1", caballero1);
        request.setAttribute("caballero2", caballero2);
        request.setAttribute("ganador", ganador);

        // Redirigir a la página de resultado
        request.getRequestDispatcher("resultadoLucha.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
