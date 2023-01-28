package com.lucio.practica_2.artefacto_arma;

import com.lucio.practica_2.interfaz_artefacto_arma.IEscudo;
import com.lucio.practica_2.personaje.Personaje;

public class Escudo extends Arma implements IEscudo{

	public Escudo(String nombre, int defensa, int ataque, int vida) {
		super(nombre, vida, ataque, defensa, 0);
	}
	
	public Escudo(String nombre, int defensa, int ataque) {
		super(nombre, 0, ataque, defensa, 0);
	}
	
	public Escudo(String nombre, int defensa) {
		super(nombre, 0, 0, defensa, 0);
	}

	@Override
	public void defenderse() {
		// TODO Auto-generated method stub
		
	}



	
}
