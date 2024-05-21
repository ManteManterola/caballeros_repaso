package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModeloEscudo {

	private Conector conector;

	public void setConector(Conector conector) {
		this.conector = conector;
	}
	
	public Escudo getEscudo (int id) {
		
		try {
			PreparedStatement pst = conector.getConexion().prepareStatement("SELECT * FROM escudos WHERE id = ?");
			pst.setInt(1, id);
			
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				Escudo escudo = new Escudo();
				escudo.setId(rs.getInt("id"));
				escudo.setNombre(rs.getString("nombre"));
				escudo.setCapacidadDefensa(rs.getInt("capacidad_defensa"));
				
				return escudo;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<Escudo> getAll() {
		ArrayList<Escudo> escudos = new ArrayList<>();
		
		String sql = "SELECT * FROM ESCUDOS";
		
		try {
			ResultSet rs = conector.getConexion().createStatement().executeQuery(sql);
			while (rs.next()) {
				Escudo escudo = new Escudo();
				
				escudo.setId(rs.getInt("id"));
				escudo.setNombre(rs.getString("nombre"));
				escudo.setCapacidadDefensa(rs.getInt("capacidad_defensa"));
				
				
				escudos.add(escudo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return escudos;
	}
}
