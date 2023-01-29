package com.lucio.practica_2.artefacto_arma;

import com.lucio.practica_2.interfaz_artefacto_arma.ICortaDistancia;
import com.lucio.practica_2.personaje.Personaje;

public class ArmaMele extends Arma implements ICortaDistancia{
	
	public ArmaMele(String nombre, int ataque, int defensa, int vida) {
		super(nombre, vida, ataque, defensa, 0);
	}	
	
	public ArmaMele(String nombre, int ataque, int defensa) {
		super(nombre, 0, ataque, defensa, 0);
	}	
	
	public ArmaMele(String nombre, int ataque) {
		super(nombre, 0, ataque, 0, 0);
	}

	@Override
	public void accion() {
		reparar();		
	}
	
	@Override
	public void reparar() {
		System.out.println("Reparando " + this.getNombre() + "...");
	}



}
