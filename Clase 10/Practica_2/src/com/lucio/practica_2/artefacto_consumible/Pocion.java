package com.lucio.practica_2.artefacto_consumible;

import com.lucio.practica_2.interfaz_artefacto_consumible.IPocion;

public class Pocion extends Consumible implements IPocion{

	int curacion;
	
	public Pocion(String nombre, int curacion) {
		super(nombre, 0, 0, 0, 0);
		this.curacion = curacion;
	}

	@Override
	public void consumir() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void efecto() {
		// TODO Auto-generated method stub
		
	}

}
