import com.lucio.practica_2.artefacto.Artefacto;
import com.lucio.practica_2.artefacto_arma.ArmaDistancia;
import com.lucio.practica_2.artefacto_arma.ArmaMele;
import com.lucio.practica_2.artefacto_arma.Escudo;
import com.lucio.practica_2.artefacto_armadura.Botas;
import com.lucio.practica_2.artefacto_armadura.Casco;
import com.lucio.practica_2.artefacto_armadura.Pantalon;
import com.lucio.practica_2.artefacto_armadura.Pechera;
import com.lucio.practica_2.artefacto_consumible.Carne;
import com.lucio.practica_2.artefacto_consumible.ManzanaDorada;
import com.lucio.practica_2.artefacto_consumible.Pocion;
import com.lucio.practica_2.personaje.Elfo;
import com.lucio.practica_2.personaje.Humano;
import com.lucio.practica_2.personaje.Orco;


public class main {

	public static void main(String[] args) {
		
	//CREO OBJETOS Y LOS DEJO EN UN ARRAY QUE REPRESENTA EL SUELO DEL MUNDO PARA QUE LOS PERSONAJES AGARREN SUS ARMAS
		Artefacto [] sueloDelMundo = new Artefacto[10];
		sueloDelMundo[0] = new Casco("Casco de Hierro", 2);
		sueloDelMundo[1] = new Pechera("Pechera de la vida", 10, 10);
		sueloDelMundo[2] = new Pantalon("Pantalon de Oro", 4);
		sueloDelMundo[3] = new Botas("Botas de Diamante", 5);
		sueloDelMundo[4] = new Carne("Carne", 25);
		sueloDelMundo[5] = new Pocion("Pocion de Vida", 60);
		sueloDelMundo[6] = new ManzanaDorada("Manzana de Oro", 50, 50);
		sueloDelMundo[7] = new Escudo("Escudo Protector", 10);
		sueloDelMundo[8] = new ArmaDistancia("Arco", 10);
		sueloDelMundo[9] = new ArmaMele("Espada Corta", 40);
	//================================================================================================================
		
		
		Orco lucio = new Orco(100, 4, 20, 15, "Lucio");	
		Humano javi = new Humano(200, 5, 25, 4, "Javi");
		Elfo elfoAleatorio = new Elfo(75, 3, 10, 15, "Elfi");
		
		lucio.agarrar(sueloDelMundo[9]);
		lucio.usar(0);
		
		lucio.luchar(javi);
	}

}
