package com.lucio.practica_1.personaje;

public class Humano extends Personaje{

	public Humano(int vida, int ataque, int defensa, int velocidad, String nombre) {
		super(vida, ataque, defensa, velocidad, nombre);
	}
	
	public void especialHumano() {
		System.out.println("Ataque especial HUMANO...");
	}
	
}
