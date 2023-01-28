package com.lucio.practica_2.artefacto_consumible;

import com.lucio.practica_2.interfaz_artefacto_consumible.IComida;
import com.lucio.practica_2.interfaz_artefacto_consumible.IPocion;

public class ManzanaDorada extends Consumible implements IPocion, IComida{

	int hambre, curacion;
	
	public ManzanaDorada(String nombre, int hambre, int curacion) {
		super(nombre, 0, 0, 0, 0);
		this.hambre = hambre;
		this.curacion = curacion;
	}

	@Override
	public void consumir() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saciarHambre() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void efecto() {
		// TODO Auto-generated method stub
		
	}

	
	

}
