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
		setSize(min, max);
	}
	
	public void setSize(int min, int max) {
		if(min == max) {
			System.out.println("Los tamanos no pueden ser iguales.");
		} else if(max < min) {
			this.max = min;
			this.min = max;
		} else {
			this.min = min;
			this.max = max;
		}
	}
	
	public void dibujar() {
		int blanco = 0;
		int minCop = min;
		//Primera mitad
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
		//Segunda mitad
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
