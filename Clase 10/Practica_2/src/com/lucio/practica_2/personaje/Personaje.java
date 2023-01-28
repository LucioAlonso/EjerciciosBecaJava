package com.lucio.practica_2.personaje;

import com.lucio.practica_2.artefacto.Artefacto;
import com.lucio.practica_2.artefacto_arma.Arma;
import com.lucio.practica_2.artefacto_arma.Escudo;
import com.lucio.practica_2.artefacto_armadura.Armadura;
import com.lucio.practica_2.artefacto_armadura.Botas;
import com.lucio.practica_2.artefacto_armadura.Casco;
import com.lucio.practica_2.artefacto_armadura.Pantalon;
import com.lucio.practica_2.artefacto_armadura.Pechera;
import com.lucio.practica_2.artefacto_consumible.Consumible;

public class Personaje {
	private int vida, ataque, defensa, velocidad, hambre;
	private String nombre;
	private Artefacto [] inventario = new Artefacto[5];
	private Casco slotCasco = null;
	private Pechera slotPechera = null;
	private Pantalon slotPantalon = null;
	private Botas slotBotas = null;
	private Arma slotArma = null;
	private Escudo slotEscudo = null;
	
	public Personaje(int vida, int ataque, int defensa, int velocidad, String nombre) {
		this.setVida(vida);
		this.setAtaque(ataque);
		this.setDefensa(defensa);
		this.setVelocidad(velocidad);
		this.setNombre(nombre);
		this.hambre = 100;
	}
	
	public void luchar(Personaje enemigo) {
		System.out.println("\n++++++ "+ this.getNombre() + " VS " + enemigo.getNombre() +" ++++++");
		int cantidadDeGolpesAtacante = cantidadGolpes(enemigo);
		if(cantidadDeGolpesAtacante < 1) cantidadDeGolpesAtacante = 2;
		int cantidadDeGolpesDefensor = enemigo.cantidadGolpes(this);
		
		while(!(cantidadDeGolpesDefensor == 0 && cantidadDeGolpesAtacante == 0)) {
			if(cantidadDeGolpesAtacante > 0 && this.getHambre() > 0) {
				cantidadDeGolpesAtacante--;
				enemigo.takeDamage(calculatorDamage(enemigo), this);
				setHambre(getHambre()-5);
			}
			if(cantidadDeGolpesDefensor > 0 && enemigo.getHambre() > 0) {
				cantidadDeGolpesDefensor--;
				takeDamage(enemigo.calculatorDamage(this), enemigo);
				enemigo.setHambre(getHambre()-5);
			}	
		}
		System.out.println("------FIN DE LA BATALLA------");				
	}
	
	public Arma getSlotArma() {
		return slotArma;
	}
	
	public void removeArma() {
		agarrar(this.getSlotArma());
		this.setAtaque(this.getAtaque() - slotArma.getAtaque());
		this.setVelocidad(this.getVelocidad() - slotArma.getVelocidad());
		this.slotArma = null;
	}


	public void setSlotArma(Arma slotArmaDistancia) {
		if(getSlotArma() == null) {
			this.slotArma = slotArmaDistancia;
			this.setAtaque(this.getAtaque() + slotArma.getAtaque());
			this.setVelocidad(this.getVelocidad() + slotArma.getVelocidad());
		}
		else System.out.println("No se puede realizar esta accion.");
	}


	public Escudo getSlotEscudo() {
		return slotEscudo;
	}

	public void setSlotEscudo(Escudo slotEscudo) {
		if(getSlotEscudo() == null) this.slotEscudo = slotEscudo;
		else System.out.println("No se puede realizar esta accion.");
	}

	public void removeEscudo() {
		agarrar(this.getSlotEscudo());
		this.slotEscudo = null;
	}
	
	public Casco getSlotCasco() {
		return slotCasco;
	}

	public void setSlotCasco(Casco slotCasco) {
		if(getSlotCasco() == null) this.slotCasco = slotCasco;
		else System.out.println("No se puede realizar esta accion.");
	}
	
	public void removeCasco() {
		agarrar(this.getSlotCasco());
		this.slotCasco = null;
	}

	public Pechera getSlotPechera() {
		return slotPechera;
	}
	
	public void removePechera() {
		agarrar(this.getSlotPechera());
		this.slotPechera = null;
	}

	public void setSlotPechera(Pechera slotPechera) {
		if(getSlotPechera() == null)  this.slotPechera = slotPechera;
		else System.out.println("No se puede realizar esta accion.");
	}

	public Pantalon getSlotPantalon() {
		return slotPantalon;
	}
	
	public void removePantalon() {
		agarrar(this.getSlotPantalon());
		this.slotPantalon = null;
	}

	public void setSlotPantalon(Pantalon slotPantalon) {
		if(getSlotPantalon() == null) this.slotPantalon = slotPantalon;
		else System.out.println("No se puede realizar esta accion.");
	}

	public Botas getSlotBotas() {
		return slotBotas;
	}

	public void removeBotas() {
		agarrar(this.getSlotBotas());
		this.slotBotas = null;
	}
	
	public void setSlotBotas(Botas slotBotas) {
		if(getSlotBotas() == null)  this.slotBotas = slotBotas;
		else System.out.println("No se puede realizar esta accion.");
	}

	public int getHambre() {
		return hambre;
	}

	public void setHambre(int hambre) {
		this.hambre = hambre;
	}

	public void agarrar(Artefacto obj) {
		if(obj == null) return;
		for(int i=0; i<inventario.length; i++) {
			if(inventario[i] == null) {
				inventario[i] = obj;
				return;
			}
		}
		this.soltar(obj);
	}
	
	public Artefacto soltar(int invSlot) { //no voy a aplicar la logica para que el objeto vuelva a al array de items en el suelo.
		Artefacto tirar = this.inventario[invSlot];
		this.inventario[invSlot] = null;
		return tirar;
	}
	
	public Artefacto soltar(Artefacto obj) { //no voy a aplicar la logica para que el objeto vuelva a al array de items en el suelo.
		Artefacto tirar = obj;
		obj = null;
		return tirar;
	}

	
	public void usar(int invSlot) {
		if(inventario[invSlot] == null) return;
		
		if(inventario[invSlot] instanceof Consumible) {
			((Consumible) inventario[invSlot]).consumir();
			inventario[invSlot] = null;
			
		} else if (inventario[invSlot] instanceof Armadura) {
			
			if(inventario[invSlot] instanceof Casco) {
				this.setSlotCasco((Casco)inventario[invSlot]);
				inventario[invSlot] = null;
			} else if (inventario[invSlot] instanceof Pechera){
				this.setSlotPechera((Pechera)inventario[invSlot]);
				inventario[invSlot] = null;
			} else if (inventario[invSlot] instanceof Pantalon){
				this.setSlotPantalon((Pantalon)inventario[invSlot]);
				inventario[invSlot] = null;
			} else if (inventario[invSlot] instanceof Botas){
				this.setSlotBotas((Botas)inventario[invSlot]);
				inventario[invSlot] = null;
			}
			
		} else if (inventario[invSlot] instanceof Arma) {
			
			if(inventario[invSlot] instanceof Escudo) {
				this.setSlotEscudo((Escudo)inventario[invSlot]);
				inventario[invSlot] = null;
			} else if (inventario[invSlot] instanceof Arma){
				this.setSlotArma((Arma)inventario[invSlot]);
				inventario[invSlot] = null;
			} 
			
		}else {
			System.out.println("El objeto que tiene en la mano no tiene acciones.");
		}
	}
	
	public void takeDamage(int damage, Personaje enemigo) {
		if (enemigo.getDefensa() > 0 && enemigo.getDefensa() > damage) {
			this.setDefensa(this.getDefensa() - damage);
		} else this.setVida(this.getVida() - damage);
		consoleMSG(damage,enemigo);
		System.out.println("");
	}
	
	private void consoleMSG(int damage, Personaje enemigo) {
		System.out.println("[" + enemigo.getNombre() + "] ATACA A [" + this.getNombre() +"]");
		System.out.println("[" + this.getNombre() + "] RECIBIO " + -1*damage +" de DMG!");
		System.out.println("["+ this.getNombre() +"] Defensa: " + this.getDefensa());
		System.out.println("["+ this.getNombre() +"] Vida: " + this.getVida());
	}
	
	private int calculatorDamage(Personaje enemigo) {
		int damage = this.getAtaque() - enemigo.getDefensa();
		damage += ((int) (Math.random() * enemigo.getDefensa()/2) - (enemigo.getDefensa()/4));
		if (damage < 0) damage *= -1;
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

    protected void setVida(int vida) {
		this.vida = vida;
	}

	public int getAtaque() {
		return ataque;
	}
	protected void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	public int getDefensa() {
		return defensa;
	}
	protected void setDefensa(int defensa) {
		this.defensa = defensa;
	}

	public int getVelocidad() {
		return velocidad;
	}
	protected void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	public String getNombre() {
		return nombre;
	}
	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Personaje [vida=" + vida + ", ataque=" + ataque + ", defensa=" + defensa + ", velocidad=" + velocidad
				+ ", nombre=" + nombre + "]";
	}
	
	public String verInventario() {
		StringBuilder str = new StringBuilder();
		for (int i = 0; i<inventario.length; i++) {
			if(inventario[i] != null) str.append("[" + (i+1) + "] " + inventario[i].toString() + "\n");
		}
		
		if (this.getSlotCasco() != null) str.append("[Casco]: " + this.getSlotCasco() + "\n");
		if (this.getSlotPechera() != null) str.append("[Pechera]: " + this.getSlotPechera() + "\n");
		if (this.getSlotPantalon() != null) str.append("[Pantalones]: " + this.getSlotPantalon() + "\n");
		if (this.getSlotBotas() != null) str.append("[Botas]: " + this.getSlotBotas() + "\n");
		if (this.getSlotEscudo() != null) str.append("[Escudo]: " + this.getSlotEscudo() + "\n");
		if (this.getSlotArma() != null) str.append("[Arma]: " + this.getSlotArma() + "\n");
		
		
		if(str.length() == 0) return "El inventario de " + this.getNombre() + " esta vacio.";
		return str.toString();
	}
		
}
