package modelo;

import java.util.Date;

public class Lucha {

	private int id;
	private Date fecha;
	private Caballero caballero1;
	private Caballero caballero2;
	private Caballero caballeroGanador;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Caballero getCaballero1() {
		return caballero1;
	}
	public void setCaballero1(Caballero caballero1) {
		this.caballero1 = caballero1;
	}
	public Caballero getCaballero2() {
		return caballero2;
	}
	public void setCaballero2(Caballero caballero2) {
		this.caballero2 = caballero2;
	}
	public Caballero getCaballeroGanador() {
		return caballeroGanador;
	}
	public void setCaballeroGanador(Caballero caballeroGanador) {
		this.caballeroGanador = caballeroGanador;
	}
	
	
}
