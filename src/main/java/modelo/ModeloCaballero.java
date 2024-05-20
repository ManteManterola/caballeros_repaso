package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModeloCaballero {

	private Conector conector;
	


	public void setConector(Conector conector) {
		this.conector = conector;
	}



	public ArrayList<Caballero> getAll() {
		ArrayList<Caballero> caballeros = new ArrayList<>();
		
		String sql = "SELECT * FROM CABALLEROS";
		
		try {
			ResultSet rs = conector.getConexion().createStatement().executeQuery(sql);
			while (rs.next()) {
				Caballero caballero = new Caballero();
				
				caballero.setId(rs.getInt("id"));
				caballero.setNombre(rs.getString("nombre"));
				caballero.setFuerza(rs.getInt("fuerza"));
				caballero.setExperiencia(rs.getInt("experiencia"));
				caballero.setFoto(rs.getString("foto"));
				
				caballeros.add(caballero);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return caballeros;
		
	}
}
