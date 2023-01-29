package com.lucio.practica_2.personaje;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import com.lucio.practica_2.artefacto.Artefacto;
import com.lucio.practica_2.artefacto.Mundo;
import com.lucio.practica_2.artefacto_arma.Arma;
import com.lucio.practica_2.artefacto_armadura.Armadura;
import com.lucio.practica_2.artefacto_armadura.Botas;
import com.lucio.practica_2.artefacto_armadura.Casco;
import com.lucio.practica_2.artefacto_armadura.Escudo;
import com.lucio.practica_2.artefacto_armadura.Pantalon;
import com.lucio.practica_2.artefacto_armadura.Pechera;
import com.lucio.practica_2.artefacto_consumible.Consumible;

public class Personaje {
	private int vida, ataque, defensa, velocidad, vidaInicial;
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
	}
	
	public void guardarPersonaje(){
		try(OutputStreamWriter oew=new OutputStreamWriter(new FileOutputStream("D:\\"+this.getNombre()+".txt"))) {
			oew.write(this.toString() + "\n" + this.toStringInventario());
			oew.close();
		} 
		catch (IOException e) {
			System.out.println("Error al guardar");
		}

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
	
	public void desequipar(int slot) {
		if (slot == Mundo.ARMA && this.getSlotArma() != null) removeArma(); 
		else if (slot == Mundo.ESCUDO && this.getSlotEscudo() != null) removeEscudo();
		else if (slot == Mundo.CASCO  && this.getSlotCasco() != null) removeCasco();
		else if (slot == Mundo.PECHERA && this.getSlotPechera() != null) removePechera();
		else if (slot == Mundo.PANTALON && this.getSlotPantalon() != null) removePantalon();
		else if (slot == Mundo.BOTAS && this.getSlotBotas() != null) removeBotas();
	}
	
	private Arma getSlotArma() {
		return slotArma;
	}
	
	private void removeArma() {
		agarrar(this.getSlotArma());
		this.setAtaque(this.getAtaque() - slotArma.getAtaque());
		this.setVelocidad(this.getVelocidad() - slotArma.getVelocidad());
		this.slotArma = null;
	}


	private void setSlotArma(Arma slotArmaDistancia) {
		if(getSlotArma() == null) {
			this.slotArma = slotArmaDistancia;
			this.setAtaque(this.getAtaque() + slotArma.getAtaque());
			this.setVelocidad(this.getVelocidad() + slotArma.getVelocidad());
		}
		else System.out.println("No se puede realizar esta accion.");
	}


	private Escudo getSlotEscudo() {
		return slotEscudo;
	}

	private void setSlotEscudo(Escudo slotEscudo) {
		if(getSlotEscudo() == null) {
			this.slotEscudo = slotEscudo;
			slotEscudo.colocarAtributos(this); 
		}
		else System.out.println("No se puede realizar esta accion.");
	}

	private void removeEscudo() {
		agarrar(this.getSlotEscudo());
		this.slotEscudo = null;
		this.getSlotEscudo().quitarAtributos(this);
	}
	
	private Casco getSlotCasco() {
		return slotCasco;
	}

	private void setSlotCasco(Casco slotCasco) {
		if(getSlotCasco() == null) {
			this.slotCasco = slotCasco;
			slotCasco.colocarAtributos(this); 
		}
		else System.out.println("No se puede realizar esta accion.");
	}
	
	private void removeCasco() {
		agarrar(this.getSlotCasco());
		this.slotCasco = null;
		this.getSlotCasco().quitarAtributos(this);
	}

	private Pechera getSlotPechera() {
		return slotPechera;
	}
	
	private void removePechera() {
		agarrar(this.getSlotPechera());
		this.slotPechera = null;
		this.getSlotPechera().quitarAtributos(this);
	}

	private void setSlotPechera(Pechera slotPechera) {
		if(getSlotPechera() == null) {
			this.slotPechera = slotPechera;
			slotPechera.colocarAtributos(this); 
		}
		else System.out.println("No se puede realizar esta accion.");
	}

	private Pantalon getSlotPantalon() {
		return slotPantalon;
	}
	
	private void removePantalon() {
		agarrar(this.getSlotPantalon());
		this.slotPantalon = null;
		this.getSlotPantalon().quitarAtributos(this);
	}

	private void setSlotPantalon(Pantalon slotPantalon) {
		if(getSlotPantalon() == null) {
			this.slotPantalon = slotPantalon;
			slotPantalon.colocarAtributos(this);
		}
		else System.out.println("No se puede realizar esta accion.");
	}

	private Botas getSlotBotas() {
		return slotBotas;
	}

	private void removeBotas() {
		agarrar(this.getSlotBotas());
		this.slotBotas = null;
		this.getSlotBotas().quitarAtributos(this);
	}
	
	private void setSlotBotas(Botas slotBotas) {
		if(getSlotBotas() == null) {
			this.slotBotas = slotBotas;
			slotBotas.colocarAtributos(this);
		}
		else System.out.println("No se puede realizar esta accion.");
	}

	public void agarrar(int slotMundo) {
		Artefacto obj = Mundo.tomarItemDelSuelo(slotMundo);
		if(obj == null) return; 
		for(int i=0; i<inventario.length; i++) {
			if(inventario[i] == null) {
				inventario[i] = obj;
				return;
			}
		}
		this.soltar(obj);
	}
	
	private void agarrar(Artefacto obj) {
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
	
	private void soltar(Artefacto obj) { //no voy a aplicar la logica para que el objeto vuelva a al array de items en el suelo.
		Mundo.agregarItemMundo(obj);
		obj = null;
	}


	public void usar(int invSlot) {
		if(inventario[invSlot] == null) return;
		
		if(inventario[invSlot] instanceof Consumible) {
			((Consumible) inventario[invSlot]).consumir(this);
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

    public void setVida(int vida) {
		this.vida = vida;
	}

	public int getAtaque() {
		return ataque;
	}
	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	public int getDefensa() {
		return defensa;
	}
	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}

	public int getVelocidad() {
		return velocidad;
	}
	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getVidaInicial() {
		return this.vidaInicial;
	}
	
	@Override
	public String toString() {
		return "Personaje [vida=" + vida + ", ataque=" + ataque + ", defensa=" + defensa + ", velocidad=" + velocidad
				+ ", nombre=" + nombre +"]";
	}
	
	public String verInventario() {
		for (Artefacto artefacto : inventario) {
			if(artefacto != null) {
				return ("\n============================================================================================================================================================================================"+
						"\nInventario de "+ this.getNombre() + "\n" +
						Mundo.visorDeInventarios(inventario));		
			}
		}
		return "- "+ this.getNombre()+" no tiene items en el inventario.";
	}
	
	public String toStringInventario() {
		StringBuilder str = new StringBuilder();
		if(this.getSlotArma() != null) str.append("[" + this.getSlotArma().toString() + "]\n");
		if(this.getSlotEscudo() != null) str.append("[" + this.getSlotEscudo().toString() + "]\n");
		if(this.getSlotCasco() != null) str.append("[" + this.getSlotCasco().toString() + "]\n");
		if(this.getSlotPechera() != null) str.append("[" + this.getSlotPechera().toString() + "]\n");
		if(this.getSlotPantalon() != null) str.append("[" + this.getSlotPantalon().toString() + "]\n");
		if(this.getSlotBotas() != null) str.append("[" + this.getSlotBotas().toString() + "\n");
		
		for (Artefacto artefacto : inventario) {
			if(artefacto != null)str.append(artefacto.toString() + "\n");
		}
		return str.toString();
	}
		
}
