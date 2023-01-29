package com.lucio.practica_2.artefacto;
import java.util.ArrayList;

import com.lucio.practica_2.artefacto_arma.ArmaDistancia;
import com.lucio.practica_2.artefacto_arma.ArmaMele;
import com.lucio.practica_2.artefacto_armadura.Botas;
import com.lucio.practica_2.artefacto_armadura.Casco;
import com.lucio.practica_2.artefacto_armadura.Escudo;
import com.lucio.practica_2.artefacto_armadura.Pantalon;
import com.lucio.practica_2.artefacto_armadura.Pechera;
import com.lucio.practica_2.artefacto_consumible.Carne;
import com.lucio.practica_2.artefacto_consumible.ManzanaDorada;
import com.lucio.practica_2.artefacto_consumible.Pocion;

public class Mundo {
	
	public static final int ARMA = 0;
	public static final int ESCUDO = 1;
	public static final int CASCO = 2;
	public static final int PECHERA = 3;
	public static final int PANTALON = 4;
	public static final int BOTAS = 5;
	
	public static Artefacto [] itemsMundo = new Artefacto[50];
	
	public static void crearItemsMundo() {
		itemsMundo[0] = new Casco("Casco de Hierro", 2);
		itemsMundo[1] = new Pechera("Pechera de la vida", 10, 10);
		itemsMundo[2] = new Pantalon("Pantalon de Oro", 4);
		itemsMundo[3] = new Botas("Botas de Diamante", 5);
		itemsMundo[4] = new Carne("Carne", 25);
		itemsMundo[5] = new Pocion("Pocion de Vida", 60);
		itemsMundo[6] = new ManzanaDorada("Manzana de Oro", 50, 50);
		itemsMundo[7] = new Escudo("Escudo Protector", 10);
		itemsMundo[8] = new ArmaDistancia("Arco", 10); 
		itemsMundo[9] = new ArmaMele("Espada Corta", 40);
		 
	}
	
	public static void agregarItemMundo(Artefacto obj) {
		for (Artefacto artefacto : itemsMundo) {
			if(artefacto == null) {
				artefacto = obj;
				return;
			}
		}
		System.out.println("No hay mas espacio para items en el mundo");
	}
	
	public static String verItemsMundo() {
		return "============================================================================================================================================================================================\n"+
				visorDeInventarios(itemsMundo) +
				"\n============================================================================================================================================================================================";
	}
	
	public static String visorDeInventarios(Artefacto [] obj) {		
		StringBuilder str = new StringBuilder();
		//str.append("============================================================================================================================================================================================\n");
		ArrayList<Integer> tamPalabras = new ArrayList<>();
		for (Artefacto artefacto : obj) {
			if(artefacto != null) {
				str.append("[" + artefacto + "] ");
				tamPalabras.add(("[" + artefacto + "] ").length());
			}
		}
		
		int espacios=0;
		int contador = 0;
		int tamMax = str.length();
		str.append("\n");
		for (Integer i : tamPalabras) {
			tamMax = str.length()+i;
			espacios = i/2 - ("[" + contador + "]").length()/2 - 1;
			
			for(int j =0; j < espacios; j++) {
				str.append(" ");
			}
			
			str.append("[" + contador + "]");
			
			for(int j =0; str.length() < tamMax; j++) {
				str.append(" ");
			}
			contador++;
		}
		str.append("\n");
		return str.toString();
	}
	
	public static Artefacto tomarItemDelSuelo(int num) {
		Artefacto aux = itemsMundo[num];
		itemsMundo[num] = null;
		return aux;
	}
	
}
