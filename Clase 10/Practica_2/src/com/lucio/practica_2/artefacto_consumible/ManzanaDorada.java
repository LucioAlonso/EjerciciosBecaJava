package com.lucio.practica_2.artefacto_consumible;

import com.lucio.practica_2.interfaz_artefacto_consumible.IComida;
import com.lucio.practica_2.interfaz_artefacto_consumible.IPocion;
import com.lucio.practica_2.personaje.Personaje;

public class ManzanaDorada extends Consumible implements IPocion, IComida{

	int hambre, curacion;
	
	public ManzanaDorada(String nombre, int hambre, int curacion) {
		super(nombre, 0, 0, 0, 0);
		this.hambre = hambre;
		this.curacion = curacion;
	}

	@Override
	public void consumir(Personaje personaje) {
		saciarHambre(personaje);
		efecto(personaje);
	}

	@Override
	public void saciarHambre(Personaje personaje) {
		System.out.println("Comiendo " + this.getNombre() + "...");
	}

	@Override
	public void efecto(Personaje personaje) {
		System.out.println(personaje.getNombre() + " esta regenerando se salud... ");			
		if(personaje.getVidaInicial() > personaje.getVida() + curacion) personaje.setVida(personaje.getVida() + curacion);
	}

}
