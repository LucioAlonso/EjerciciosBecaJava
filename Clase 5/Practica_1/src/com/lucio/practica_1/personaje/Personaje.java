package com.lucio.practica_1.personaje;

import java.util.Iterator;


public class Personaje {
	private int vida, ataque, defensa, velocidad;
	private String nombre;
	
	public Personaje(int vida, int ataque, int defensa, int velocidad, String nombre) {
		this.vida = vida;
		this.ataque = ataque;
		this.defensa = defensa;
		this.velocidad = velocidad;
		this.nombre = nombre;
	}
	
	public void luchar(Personaje enemigo) {
		System.out.println("\n++++++ "+ this.getNombre() + " VS " + enemigo.getNombre() +" ++++++");
		int cantidadDeGolpesAtacante = cantidadGolpes(enemigo);
		if(cantidadDeGolpesAtacante < 1) cantidadDeGolpesAtacante = 2;
		int cantidadDeGolpesDefensor = enemigo.cantidadGolpes(this);
		
		while(!(cantidadDeGolpesDefensor == 0 && cantidadDeGolpesAtacante == 0)) {
			if(cantidadDeGolpesAtacante > 0) {
				cantidadDeGolpesAtacante--;
				enemigo.takeDamage(calculatorDamage(enemigo), this);
			}
			if(cantidadDeGolpesDefensor > 0) {
				cantidadDeGolpesDefensor--;
				takeDamage(enemigo.calculatorDamage(this), enemigo);
			}	
		}
		System.out.println("------FIN DE LA BATALLA------");				
	}

	public void takeDamage(int damage, Personaje enemigo) {
		this.vida += damage;
		consoleMSG(damage,enemigo);
		System.out.println("");
	}
	
	private void consoleMSG(int damage, Personaje enemigo) {
		System.out.println("[" + enemigo.getNombre() + "] ATACA A [" + this.getNombre() +"]");
		System.out.println("[" + this.getNombre() + "] RECIBIO " + -1*damage +" de DMG!");
		System.out.println("["+ this.getNombre() +"] Vida: " + this.getVida());
	}
	
	private int calculatorDamage(Personaje enemigo) {
		int damage = this.getAtaque() -enemigo.getDefensa();
		damage += ((int) (Math.random() * enemigo.getDefensa()/4) - (enemigo.getDefensa()/8));
		if (damage > 0) damage = 0;
		return damage;
	}
	
	private int cantidadGolpes(Personaje enemigo) {
		int numeroDeGolpes = this.getVelocidad() / enemigo.getVelocidad();
		if(numeroDeGolpes < 1) numeroDeGolpes = 1;
		return numeroDeGolpes;
	}
		
	public int getVida() {
		return vida;
	}

    private void setVida(int vida) {
		this.vida = vida;
	}

	public int getAtaque() {
		return ataque;
	}
	private void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	public int getDefensa() {
		return defensa;
	}
	private void setDefensa(int defensa) {
		this.defensa = defensa;
	}

	public int getVelocidad() {
		return velocidad;
	}
	private void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	public String getNombre() {
		return nombre;
	}
	private void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Personaje [vida=" + vida + ", ataque=" + ataque + ", defensa=" + defensa + ", velocidad=" + velocidad
				+ ", nombre=" + nombre + "]";
	}
		
}
