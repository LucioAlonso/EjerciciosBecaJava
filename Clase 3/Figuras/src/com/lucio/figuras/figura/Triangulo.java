package com.lucio.figuras.figura;

public class Triangulo implements Figura  {
	private Punto puntoA, puntoB, puntoC;
	
	public Triangulo(Punto puntoA, Punto puntoB, Punto puntoC){
		setPuntoA(puntoA);
		setPuntoB(puntoB);
		setPuntoC(puntoC);
	}
	
	public String dibujar() {
		return getPuntoA().dibujar() + " ---- " + getPuntoB().dibujar() + " ---- " + getPuntoC().dibujar();
	}
	
	public double longitud() {
		return puntoA.distanciaEntrePuntos(puntoB) + puntoC.distanciaEntrePuntos(puntoB) + puntoA.distanciaEntrePuntos(puntoC);
	}

	public Punto getPuntoA() {
		return puntoA;
	}

	public void setPuntoA(Punto puntoA) {
		this.puntoA = puntoA;
	}

	public Punto getPuntoB() {
		return puntoB;
	}

	public void setPuntoB(Punto puntoB) {
		this.puntoB = puntoB;
	}

	public Punto getPuntoC() {
		return puntoC;
	}

	public void setPuntoC(Punto puntoC) {
		this.puntoC = puntoC;
	}
	
	
	
}
