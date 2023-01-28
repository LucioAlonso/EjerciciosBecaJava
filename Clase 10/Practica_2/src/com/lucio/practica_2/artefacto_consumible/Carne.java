package com.lucio.practica_2.artefacto_consumible;

import com.lucio.practica_2.interfaz_artefacto_consumible.IComida;

public class Carne extends Consumible implements IComida{

	int hambre;
	public Carne(String nombre, int hambre) {
		super(nombre, 0, 0, 0, 0);
		this.hambre = hambre;
	}

	@Override
	public void consumir() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saciarHambre() {
		// TODO Auto-generated method stub
		
	}


}
