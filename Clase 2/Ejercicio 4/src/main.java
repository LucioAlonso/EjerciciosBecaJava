
public class main {

	public static void main(String[] args) {
		Rombo romb1 = new Rombo(4,20);
		Rombo romb2 = new Rombo(1);
		Rombo romb3 = new Rombo();
		
		System.out.println("Size: " + romb1);
		romb1.dibujar();
		System.out.println("=================");
		
		System.out.println("Size: " + romb2);
		romb2.dibujar();
		System.out.println("=================");
		
		System.out.println("Size: " + romb3);
		romb3.dibujar();
		System.out.println("=================");
	}
	
	

}
