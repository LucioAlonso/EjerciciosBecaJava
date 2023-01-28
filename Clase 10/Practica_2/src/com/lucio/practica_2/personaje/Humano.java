package com.lucio.practica_2.personaje;

public class Humano extends Personaje{

	public Humano(int vida, int ataque, int defensa, int velocidad, String nombre) {
		super(vida, ataque, defensa, velocidad, nombre);
	}
	
	public void rezar() {
		System.out.println(this.getNombre() + " está rezando y... ");
		if(Math.random() < 0.25f) {
			this.setVida(getVida()+10);
			System.out.print("ahora tiene 10 puntos mas de vida!");
		} else {
			System.out.print("no ocurrio nada!");
		}
	}
	
}
