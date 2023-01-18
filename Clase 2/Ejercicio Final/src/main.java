import java.util.Scanner;
public class main {

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		System.out.print("Coloque cuantas contrasenas va a generar: ");
		int cant = scr.nextInt();
		Password [] passwords = new Password[cant];
		Password [] passwordsCopia = new Password[cant];
		Boolean [] passwordsFuerte = new Boolean[cant];
		
		System.out.print("Coloque la longitud de las contrasenas: ");
		int longitud = scr.nextInt();
		
		for(int i = 0; i < passwords.length; i++) {
			passwords[i] = new Password(longitud);
		}
		
		passwordsCopia = passwords.clone();
		
		Password aux;
		int tam = passwordsCopia.length - 1;
		
		//ME INVENTE UN ORDENAMIENTO BURBUJA
		for(int k = tam; k > 0; k--) {
			for(int i = 0; tam > i; i++) {
				for(int j = 0; passwordsCopia[i].getPws().length() > j; j++) {
					if(passwordsCopia[i].getPws().toUpperCase().charAt(j) > passwordsCopia[i+1].getPws().toUpperCase().charAt(j) || (passwordsCopia[i].getPws().length() > passwordsCopia[i+1].getPws().length() && (passwordsCopia[i].getPws().toUpperCase().charAt(j) == passwordsCopia[i+1].getPws().toUpperCase().charAt(j)))) {   //Verifico si la palabra tiene que ir antes o despues o si tienen el mismo tamaño y lo cambio de posicion.                   
						aux = passwordsCopia[i];
						passwordsCopia[i] = passwordsCopia[i+1];
						passwordsCopia[i+1] = aux;
						break;
					}  else {
						break;
					}
				}
			}
		}
		//FIN DEL ORDENAMIENTO 
		
		System.out.println("====================Array de Copias====================");	
		for (Password password : passwordsCopia) {
			System.out.println(password.getPws());
		}
		
		System.out.println("====================Array de Fuertes====================");
		for (int i = 0; i < cant; i++) {
			passwordsFuerte[i] = passwords[i].esFuerte();
		}
		
		for (Boolean bool : passwordsFuerte) {
			System.out.println(bool);
		}
		
	}

}
