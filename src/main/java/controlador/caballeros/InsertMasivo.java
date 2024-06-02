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
 * Servlet implementation class Insertmasivo
 */
@WebServlet("/InsertMasivo")
public class InsertMasivo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertMasivo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("insertMasivo.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String caballerosData = request.getParameter("caballeros");
	        String[] caballerosLines = caballerosData.split("\r\n");
	        Conector conector = new Conector();
	        ModeloArma modeloArma = new ModeloArma();
	        ModeloEscudo modeloEscudo = new ModeloEscudo();
	        ModeloCaballero modeloCaballero = new ModeloCaballero();
	        modeloArma.setConector(conector);
	        modeloEscudo.setConector(conector);
	        modeloCaballero.setConector(conector);

	        for (String line : caballerosLines) {
	            String[] fields = line.split(",");
	            if (fields.length == 6) {
	                String nombre = fields[0].trim();
	                int fuerza = Integer.parseInt(fields[1].trim());
	                int experiencia = Integer.parseInt(fields[2].trim());
	                String foto = fields[3].trim();
	                int idArma = Integer.parseInt(fields[4].trim());
	                int idEscudo = Integer.parseInt(fields[5].trim());

	                Caballero caballero = new Caballero();
	                caballero.setNombre(nombre);
	    			caballero.setFuerza(fuerza);
	    			caballero.setExperiencia(experiencia);
	    	        caballero.setFoto(foto);
	    	        caballero.setArma(modeloArma.getArma(idArma));
	    	        caballero.setEscudo(modeloEscudo.getEscudo(idEscudo));

	                modeloCaballero.insert(caballero);
	            }
	        }
	        
	        ;

	        response.sendRedirect("IndexCaballeros");
	}

}
