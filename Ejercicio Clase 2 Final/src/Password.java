import java.util.Random;

public class Password {
	private int longitud = 8;
	private String pws;
	
	public Password(int longitud) {
		setPws(generarPassword(longitud));
	}
	
	public Password(String pws, int longitud) {
		setPws(pws);
		setLongitud(longitud);
	}
	
	public Password(Password contra) {
		setPws(contra.pws);
		setLongitud(contra.longitud);
	}
	
	public boolean esFuerte() { //devuelve un booleano si es fuerte o no, para que sea fuerte debe tener mas de 2 mayúsculas, mas de 1 minúscula y mas de 5 números.
		boolean min = false;
		int may = 0;
		int nums = 0;
		
		for(int i =0; i < pws.length(); i++) {
			if(isNumber(pws.charAt(i)) && nums < 5) {
				nums ++;
			} else if(Character.isUpperCase(pws.charAt(i)) && may < 2) {
				may ++;
			} else if (Character.isLowerCase(pws.charAt(i)) && min == false){
				min = true;
			}
		}
		
		if(min == true && may == 2 && nums == 5) return true;
		else return false; //CAMBIAR
	}
	
	private boolean isNumber(char c) {
		try {
            Integer.parseInt(c+"");
            return true;
        } catch (NumberFormatException excepcion) {
            return false;
        }
	}
	
	public String generarPassword(int logintud){ //genera la contraseña del objeto con la longitud que tenga de manera aleatoria.
	    String pws = "";
    	char c;
    	Random rnd = new Random();

		for (int i = 0; i < logintud; i++)
		{
			pws += (char)(rnd.nextInt(91) + 48);;
		}
		return pws;
	}
	
	public String getPws() { //Método get para contraseña (LO HAGO PUBLICO SOLO PORQUE EL EJERCICIO LO PIDE)
		return pws;
	}
	
	private int getLongitud() { //Método get para longitud
		return this.longitud;
	}
	
	private void setLongitud(int longitud) { //Método get para longitud
		this.longitud = longitud;
	}
	
	private void setPws(String pws) { //Método get para longitud
		this.pws = pws;
	}
	
}
