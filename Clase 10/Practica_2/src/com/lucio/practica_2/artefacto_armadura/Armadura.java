package com.lucio.practica_2.artefacto_armadura;

import com.lucio.practica_2.artefacto.Artefacto;
import com.lucio.practica_2.interfaz_artefacto_armadura.IArmadura;

public abstract class Armadura extends Artefacto implements IArmadura{

	public Armadura(String nombre, int vida, int ataque, int defensa, int velocidad) {
		super(nombre, vida, ataque, defensa, velocidad);
	}
	
}
