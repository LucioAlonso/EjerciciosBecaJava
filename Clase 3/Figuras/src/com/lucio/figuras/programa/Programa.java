package com.lucio.figuras.programa;

import com.lucio.figuras.figura.Circunferencia;
import com.lucio.figuras.figura.Punto;
import com.lucio.figuras.figura.SegmentoLinea;
import com.lucio.figuras.figura.Triangulo;

public class Programa {
	public static void main(String[] args) {
		Punto p1 = new Punto(10, 20);
		Punto p2 = new Punto(20, 30);
		Punto p3 = new Punto(10, 20);
		
		Circunferencia cir1 = new Circunferencia(p1, 5);
		
		Triangulo tri1 = new Triangulo(p1, p2, p3);
		
		System.out.println(p1.dibujar());
		System.out.println(p2.dibujar());
		
		System.out.println("La distancia de P1 a P2 es " + p1.distanciaEntrePuntos(p2));
		
		SegmentoLinea sl1 = new SegmentoLinea(p1, p2);
		
		sl1.dibujar();
		System.out.print("El punto medio de sl1 es: ");
		System.out.println(sl1.puntoMedio().dibujar());
		
		System.out.println("==========================");
		System.out.println("=====CIRCUNFERENCIA=======");
		System.out.println(cir1.dibujar());
		System.out.println(cir1.longitud());
		
		System.out.println("==========================");
		System.out.println("========TRIANGULO=========");
		System.out.println(tri1.dibujar());
		System.out.println(tri1.longitud());
	};
}
