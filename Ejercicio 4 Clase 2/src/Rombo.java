public class Rombo {
	
	private int min, max;
	
	public Rombo() {
		min = 4;
		max = 10;
	}
	
	public Rombo(int min) {
		this.min = min;
		max = 10;
	}
	
	public Rombo(int min, int max) {
		this.min = min;
		this.max = max;
	}
	
	public void dibujar() {
		int blanco = 0;
		
		if(max < min) {
			int aux = max;
			max = min;
			min = aux;
		}
		
		int minCop = min;

		while(minCop <= max) {
				// blanco = max - minCop;
				for(int i = 0; i < (max - minCop)/2; i++) {
					System.out.print(" ");
				}
				
				for(int k = 0; k < minCop; k++) {
					System.out.print("+");
				}
				
				for(int j = 0; j < (max - minCop)/2; j++) {
					System.out.print(" ");
				}
				System.out.println("");
				minCop += 2;
		}
		minCop -= 4;
		while(minCop >= min) {
				blanco = max - minCop;
				for(int i = 0; i < (max - minCop)/2; i++) {
					System.out.print(" ");
				}
				
				for(int k = 0; k < minCop; k++) {
					System.out.print("+");
				}
				
				for(int j = 0; j < (max - minCop)/2; j++) {
					System.out.print(" ");
				}
				System.out.println("");
				minCop -= 2;
		}	
	}
	
	@Override
	public String toString() {
		return ("min: " + min + ", max: " + max);
	}
}
