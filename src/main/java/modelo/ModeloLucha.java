package modelo;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Random;

public class ModeloLucha {
	private Conector conector;
	
	public void setConector(Conector conector) {
		this.conector = conector;
	}

	public Caballero luchar(Caballero caballero1, Caballero caballero2) {
		Random random = new Random();
		int numeroAleatorio = random.nextInt(11);
		int poderCaballero1 = (caballero1.getExperiencia() * 2) + caballero1.getFuerza();
		int poderCaballero2 = (caballero2.getExperiencia() * 2) + caballero2.getFuerza();
		if (poderCaballero1 > poderCaballero2) {
			return caballero1;
		} else if (poderCaballero2 > poderCaballero1) {
			return caballero2;
		} else if (numeroAleatorio > 5) {
			return caballero1;
		} else {
			return caballero2;
		}
	}
	
	public void insertLucha(Caballero caballero1,Caballero caballero2, Caballero caballeroGanador) {
		String sql = "INSERT INTO LUCHAS (fecha, caballero1_id, caballero2_id, ganador_id) VALUES (?, ?, ?, ?)";
		PreparedStatement pst;
		
	    try {
	        pst = conector.getConexion().prepareStatement(sql);

	        // Obtener la fecha actual
	        LocalDate currentDate = LocalDate.now();
	        
	        // Convertir LocalDate a java.sql.Date
	        Date fechaActual = Date.valueOf(currentDate);

	        // Establecer la fecha en el PreparedStatement
	        pst.setDate(1, fechaActual);

	        // Establecer los demás parámetros
	        pst.setInt(2, caballero1.getId());
	        pst.setInt(3, caballero2.getId());
	        pst.setInt(4, caballeroGanador.getId());

	        pst.executeUpdate(); // Ejecutar la inserción
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
}
