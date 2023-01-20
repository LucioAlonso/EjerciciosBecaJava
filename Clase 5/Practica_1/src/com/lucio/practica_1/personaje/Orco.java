package com.lucio.practica_1.personaje;

public class Orco extends Personaje{

	public Orco(int vida, int ataque, int defensa, int velocidad, String nombre) {
		super(vida, ataque, defensa, velocidad, nombre);
	}
	
	public void especialOrco() {
		System.out.println("Ataque especial ORCO...");
	}
	
}
