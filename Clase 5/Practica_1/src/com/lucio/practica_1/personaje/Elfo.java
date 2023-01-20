package com.lucio.practica_1.personaje;

public class Elfo extends Personaje{
	
	public Elfo(int vida, int ataque, int defensa, int velocidad, String nombre) {
		super(vida, ataque, defensa, velocidad, nombre);
	}
	
	public void especialElfo() {
		System.out.println("Ataque especial ELFO...");
	}

}
