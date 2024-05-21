package controlador.caballeros;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Caballero;
import modelo.Conector;
import modelo.ModeloArma;
import modelo.ModeloCaballero;
import modelo.ModeloEscudo;

/**
 * Servlet implementation class StoreCaballeros
 */
@WebServlet("/StoreCaballeros")
public class StoreCaballeros extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StoreCaballeros() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nombre = request.getParameter("nombre");
        int fuerza = Integer.parseInt(request.getParameter("fuerza"));
        int experiencia = Integer.parseInt(request.getParameter("experiencia"));
        String foto = request.getParameter("foto");
        int idArma = Integer.parseInt(request.getParameter("idArma"));
        int idEscudo = Integer.parseInt(request.getParameter("idEscudo"));
        
        Conector conector = new Conector();
		ModeloArma modeloArma = new ModeloArma();
		ModeloEscudo modeloEscudo = new ModeloEscudo();
		modeloArma.setConector(conector);
		modeloEscudo.setConector(conector);
		
		Caballero caballero = new Caballero();
		caballero.setNombre(nombre);
		caballero.setFuerza(fuerza);
		caballero.setExperiencia(experiencia);
        caballero.setFoto(foto);
        caballero.setArma(modeloArma.getArma(idArma));
        caballero.setEscudo(modeloEscudo.getEscudo(idEscudo));
   
        ModeloCaballero modeloCaballero = new ModeloCaballero();
        modeloCaballero.setConector(conector);
        modeloCaballero.insert(caballero);
        
        response.sendRedirect("IndexCaballeros");
	}

}
