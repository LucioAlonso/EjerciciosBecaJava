package com.lucio.practica_2.artefacto_consumible;

import com.lucio.practica_2.interfaz_artefacto_consumible.IPocion;
import com.lucio.practica_2.personaje.Personaje;

public class Pocion extends Consumible implements IPocion{

	int curacion;
	
	public Pocion(String nombre, int curacion) {
		super(nombre, 0, 0, 0, 0);
		this.curacion = curacion;
	}

	@Override
	public void consumir(Personaje personaje) {
		efecto(personaje);
		
	}

	@Override
	public void efecto(Personaje personaje) {
		System.out.println(personaje.getNombre() + " esta tomando una " + this.getNombre() + "...");
		if(personaje.getVidaInicial() > personaje.getVida() + curacion) personaje.setVida(personaje.getVida() + curacion);
	}

}
