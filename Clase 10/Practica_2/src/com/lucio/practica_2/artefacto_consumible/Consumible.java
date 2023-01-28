package com.lucio.practica_2.artefacto_consumible;

import com.lucio.practica_2.artefacto.Artefacto;
import com.lucio.practica_2.interfaz_artefacto_consumible.IConsumible;

public abstract class Consumible extends Artefacto implements IConsumible{

	public Consumible(String nombre, int vida, int ataque, int defensa, int velocidad) {
		super(nombre, vida, ataque, defensa, velocidad);
	}
	
}
