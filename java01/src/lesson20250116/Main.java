package lesson20250116;
import lesson20250116.date.*;

public class Main {
	
	class testClass {
		
	}
	
	public static void main(String[] args) {		
		Example[] mExample = {
				new Example00(),
				new Example01(),
				new Example02(),
		};
		
		for(int i=0; i < mExample.length; i++) {
			
			mExample[i].NameTag();
			System.out.println("----------------------------");
			mExample[i].Prt();
			System.out.println("\n============================");
		}
		
		
		
		
	}
}
