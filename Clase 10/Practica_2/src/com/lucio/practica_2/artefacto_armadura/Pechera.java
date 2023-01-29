package com.lucio.practica_2.artefacto_armadura;

import com.lucio.practica_2.interfaz_artefacto_armadura.IPechera;

public class Pechera extends Armadura implements IPechera{

	public Pechera(String nombre, int defensa) {
		super(nombre, 0, 0, defensa, 0);
	}
	
	public Pechera(String nombre, int defensa , int vida) {
		super(nombre, vida, 0, defensa, 0);
	}

}
