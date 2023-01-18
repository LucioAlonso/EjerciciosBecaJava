package com.lucio.figuras.figura;

public class Punto {
	private int x;
	private int y;
	
	public Punto(int x, int y) {
		setX(x);
		setY(y);
	}
	
	public String dibujar() {
		return "(" + getX() + ", " + getY() + ")";
	}
	
	public double distanciaEntrePuntos(Punto elOtro) {
		return Math.sqrt(Math.pow(this.x-elOtro.x, 2) + Math.pow(this.x-elOtro.x, 2));
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setX(int x) {
		if(x<0) throw new IllegalArgumentException("No se puede colocar un valor menor que 0");
		else this.x = x;
	}
	
	public void setY(int y) {
		if(y<0) throw new IllegalArgumentException("No se puede colocar un valor menor que 0");
		else this.y = y;
	}
	
}
