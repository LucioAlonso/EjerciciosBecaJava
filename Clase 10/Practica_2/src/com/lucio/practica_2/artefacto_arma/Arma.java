package com.lucio.practica_2.artefacto_arma;

import com.lucio.practica_2.artefacto.Artefacto;
import com.lucio.practica_2.interfaz_artefacto_arma.IArma;

public abstract class Arma extends Artefacto implements IArma{

	public Arma(String nombre, int vida, int ataque, int defensa, int velocidad) {
		super(nombre, vida, ataque, defensa, velocidad);
	}	

}
