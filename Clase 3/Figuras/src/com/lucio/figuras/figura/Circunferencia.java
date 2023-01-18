package com.lucio.figuras.figura;

public class Circunferencia implements Figura {
	private Punto centro;
	private double radio;
	
	public Circunferencia(Punto centro, double radio) {
		this.centro = centro;
		this.radio = radio;
	}
	
	public String dibujar() {
		return getCentro().dibujar() + " ---- " + this.radio;
	}
	
	public double longitud() {
		return 2 * Math.PI * radio;
	}

	public Punto getCentro() {
		return centro;
	}

	public void setCentro(Punto centro) {
		this.centro = centro;
	}

	public double getRadio() {
		return radio;
	}

	public void setRadio(double radio) {
		this.radio = radio;
	}
	
	
}
