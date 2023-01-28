package com.lucio.practica_2.artefacto_arma;

import com.lucio.practica_2.interfaz_artefacto_arma.ILargaDistancia;
import com.lucio.practica_2.personaje.Personaje;

public class ArmaDistancia extends Arma implements ILargaDistancia{

	public ArmaDistancia(String nombre, int ataque, int defensa, int vida) {
		super(nombre, vida, ataque, defensa, 0);
	}	
	
	public ArmaDistancia(String nombre, int ataque, int defensa) {
		super(nombre, 0, ataque, defensa, 0);
	}	
	
	public ArmaDistancia(String nombre, int ataque) {
		super(nombre, 0, ataque, 0, 0);
	}		

	@Override
	public void recargar() {
		// TODO Auto-generated method stub
		
	}


	
}
