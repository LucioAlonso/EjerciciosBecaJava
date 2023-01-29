package com.lucio.practica_2.artefacto_armadura;

import com.lucio.practica_2.artefacto.Artefacto;
import com.lucio.practica_2.interfaz_artefacto_armadura.IArmadura;
import com.lucio.practica_2.personaje.Personaje;

public abstract class Armadura extends Artefacto implements IArmadura{

	public Armadura(String nombre, int vida, int ataque, int defensa, int velocidad) {
		super(nombre, vida, ataque, defensa, velocidad);
	}
	
	public void colocarAtributos(Personaje p) {
		p.setAtaque(p.getAtaque() + this.getAtaque());
		p.setDefensa(p.getDefensa() + this.getDefensa());
		p.setVelocidad(p.getVelocidad() + this.getVelocidad());
		p.setVida(p.getVida() + this.getVida());
	}
	
	public void quitarAtributos(Personaje p) {
		p.setAtaque(p.getAtaque() - this.getAtaque());
		p.setDefensa(p.getDefensa() - this.getDefensa());
		p.setVelocidad(p.getVelocidad() - this.getVelocidad());
		p.setVida(p.getVida() - this.getVida());
	}
	
}
