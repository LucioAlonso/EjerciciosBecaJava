package com.lucio.practica_2.personaje;

public class Orco extends Personaje{

	public Orco(int vida, int ataque, int defensa, int velocidad, String nombre) {
		super(vida, ataque, defensa, velocidad, nombre);
	}
	
	public void gritoDeGuerra() {
		System.out.println(this.getNombre() + " hace un grito de guerra y... ");
		if(Math.random() < 0.25f) {
			this.setAtaque(getAtaque()+3);
			System.out.print("ahora tiene 3 puntos mas de ataque!");
		} else {
			System.out.print("no ocurrio nada!");
		}
	}
	
}
