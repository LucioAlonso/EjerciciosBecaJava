package com.lucio.practica_2.artefacto_armadura;

import com.lucio.practica_2.interfaz_artefacto_armadura.ICasco;

public class Casco extends Armadura implements ICasco{

	public Casco(String nombre, int defensa) {
		super(nombre, 0, 0, defensa, 0);
	}
	
	public Casco(String nombre, int defensa , int vida) {
		super(nombre, vida, 0, defensa, 0);
	}

	@Override
	public void mitigarDaño() {
		// TODO Auto-generated method stub
		
	}



}
