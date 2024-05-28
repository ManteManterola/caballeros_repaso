package modelo;

import java.util.Random;

public class ModeloLucha {

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
}
