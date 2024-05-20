package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ModeloArma {

	
private Conector conector;
	


	public void setConector(Conector conector) {
		this.conector = conector;
	}
	
	public Arma getArma (int id) {
		try {
			PreparedStatement pst = conector.getConexion().prepareStatement("SELECT * FROM armas WHERE id = ?");
			pst.setInt(1, id);
			
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				Arma arma = new Arma();
				arma.setId(rs.getInt("id"));
				arma.setNombre(rs.getString("nombre"));
				arma.setCapacidadDanio(rs.getInt("capacidad_danio"));
				arma.setFoto(rs.getString("foto"));
				
				return arma;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
