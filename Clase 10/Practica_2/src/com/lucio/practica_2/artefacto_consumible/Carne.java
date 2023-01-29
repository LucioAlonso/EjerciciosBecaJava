package com.lucio.practica_2.artefacto_consumible;

import com.lucio.practica_2.interfaz_artefacto_consumible.IComida;
import com.lucio.practica_2.personaje.Personaje;

public class Carne extends Consumible implements IComida{

	int hambre;
	public Carne(String nombre, int hambre) {
		super(nombre, 0, 0, 0, 0);
		this.hambre = hambre;
	}

	@Override
	public void consumir(Personaje personaje) {
		saciarHambre(personaje);
	}

	@Override
	public void saciarHambre(Personaje personaje) {
		System.out.println(personaje.getNombre() +" esta comiendo " + this.getNombre() + "...");
	}


}
