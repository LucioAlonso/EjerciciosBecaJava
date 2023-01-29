import java.io.IOException;

import com.lucio.practica_2.artefacto.Mundo;
import com.lucio.practica_2.personaje.Elfo;
import com.lucio.practica_2.personaje.Humano;
import com.lucio.practica_2.personaje.Orco;
import com.lucio.practica_2.personaje.Personaje;

public class main {

	public static void main(String[] args) {
		
	//CREO OBJETOS Y LOS DEJO EN UN ARRAY QUE REPRESENTA EL SUELO DEL MUNDO PARA QUE LOS PERSONAJES AGARREN SUS ARMAS
		Mundo.crearItemsMundo();
		System.out.println(Mundo.verItemsMundo());
	//================================================================================================================
		
		
		Orco lucio = new Orco(100, 4, 20, 15, "Lucio");	
		Humano javi = new Humano(200, 5, 25, 4, "Javi");
		Elfo elfoAleatorio = new Elfo(75, 3, 10, 15, "Elfi");
	
		lucio.agarrar(1); //no lo hago desde aca, lo tengo que hacer desde el personaje 
		lucio.agarrar(4);
		lucio.agarrar(2);
		System.out.println(lucio.verInventario());
		lucio.usar(0);

		
		lucio.luchar(javi);
		
		lucio.usar(1);
		lucio.desequipar(0);

		lucio.luchar(javi);
		
		lucio.guardarPersonaje();

	}

}
