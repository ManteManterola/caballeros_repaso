package modelo;

public class Arma {

	private int id;
	private String nombre;
	private int capacidadDanio;
	private String foto;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCapacidadDanio() {
		return capacidadDanio;
	}

	public void setCapacidadDanio(int capacidadDanio) {
		this.capacidadDanio = capacidadDanio;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

}
