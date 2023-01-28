package com.lucio.practica_2.personaje;

public class Elfo extends Personaje{
	
	int vidaInicial;
	
	public Elfo(int vida, int ataque, int defensa, int velocidad, String nombre) {
		super(vida, ataque, defensa, velocidad, nombre);
		this.vidaInicial = vida;
	}
	
	public void meditar() {
		this.setVida(vidaInicial);
		System.out.println(this.getNombre() + " se puso a meditar y recuperó toda su vida!");
	}

}
