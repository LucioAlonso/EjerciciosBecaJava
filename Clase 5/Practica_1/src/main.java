import com.lucio.practica_1.personaje.Elfo;
import com.lucio.practica_1.personaje.Humano;
import com.lucio.practica_1.personaje.Orco;


public class main {

	public static void main(String[] args) {
		Orco lucio = new Orco(100, 4, 20, 7, "Lucio");
		Humano javi = new Humano(200, 5, 25, 4, "Javi");
		Elfo elfoAleatorio = new Elfo(75, 3, 10, 15, "Elfi");
		
		javi.luchar(lucio);
		javi.luchar(elfoAleatorio);
		
		elfoAleatorio.luchar(lucio);
		elfoAleatorio.especialElfo();
		
		javi.especialHumano();
	}

}
