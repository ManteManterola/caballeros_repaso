package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModeloCaballero {

	private Conector conector;

	ModeloArma modeloArma = new ModeloArma();
	ModeloEscudo modeloEscudo = new ModeloEscudo();

	public void setConector(Conector conector) {
		this.conector = conector;
		modeloArma.setConector(conector);
		modeloEscudo.setConector(conector);
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
				caballero.setArma(modeloArma.getArma(rs.getInt("arma_id")));
				caballero.setEscudo(modeloEscudo.getEscudo(rs.getInt("escudo_id")));

				caballeros.add(caballero);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return caballeros;

	}

	public Caballero getPorId(int id) {
		try {
			PreparedStatement pst = conector.getConexion().prepareStatement("SELECT * FROM CABALLEROS WHERE id = ?");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				Caballero caballero = new Caballero();

				caballero.setId(rs.getInt("id"));
				caballero.setNombre(rs.getString("nombre"));
				caballero.setFuerza(rs.getInt("fuerza"));
				caballero.setExperiencia(rs.getInt("experiencia"));
				caballero.setFoto(rs.getString("foto"));
				caballero.setArma(modeloArma.getArma(rs.getInt("arma_id")));
				caballero.setEscudo(modeloEscudo.getEscudo(rs.getInt("escudo_id")));

				return caballero;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void insert(Caballero caballero) {
		String sql = "INSERT INTO CABALLEROS (nombre, fuerza, experiencia, foto, arma_id, escudo_id) VALUES (?, ?, ?, ?, ?, ?)";

		PreparedStatement pst;

		try {
			pst = conector.getConexion().prepareStatement(sql);

			pst.setString(1, caballero.getNombre());
			pst.setInt(2, caballero.getFuerza());
			pst.setInt(3, caballero.getExperiencia());
			pst.setString(4, caballero.getFoto());
			pst.setInt(5, caballero.getArma().getId());
			pst.setInt(6, caballero.getEscudo().getId());

			pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean checkNombreRepetido(String nombre) {
		try {
			PreparedStatement pst = conector.getConexion()
					.prepareStatement("SELECT * FROM CABALLEROS WHERE nombre = ?");
			pst.setString(1, nombre);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	public void delete(int id) {
		String sql = "DELETE FROM CABALLEROS WHERE id=?";

		try {
			PreparedStatement pst = conector.getConexion().prepareStatement(sql);
			pst.setInt(1, id);
			pst.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void actualizarCaballero(Caballero caballero) {
		try {
			PreparedStatement pst = conector.getConexion().prepareStatement(
					"UPDATE caballeros SET nombre = ?, fuerza = ?, experiencia = ?, foto = ?, arma_id = ?, escudo_id = ? WHERE id = ?");
			pst.setString(1, caballero.getNombre());
			pst.setInt(2, caballero.getFuerza());
			pst.setInt(3, caballero.getExperiencia());
			pst.setString(4, caballero.getFoto());
			pst.setInt(5, caballero.getArma().getId());
			pst.setInt(6, caballero.getEscudo().getId());
			pst.setInt(7, caballero.getId());

			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
