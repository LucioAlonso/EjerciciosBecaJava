package com.lucio.figuras.figura;

public class SegmentoLinea implements Figura  {
	private Punto inicio, fin;
	
	public SegmentoLinea(Punto inicio, Punto fin) {
		this.inicio = inicio;
		this.fin = fin;
	}
	
	public String dibujar(){
		return this.inicio.dibujar() + " ---- " + this.fin.dibujar();
	}
	
	public double longitud(){
		return this.inicio.distanciaEntrePuntos(this.fin);
	}
	
	public Punto puntoMedio() {
		return new Punto((this.inicio.getX() + this.fin.getX())/2, (this.inicio.getY() + this.fin.getY())/2 );
	}
	
}
