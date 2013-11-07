import java.util.Scanner;

public class Principal {

	public static void main(String[] args) throws Exception {

		ConvertePos c = new ConvertePos();
		Scanner sc;
		String aux = "";
		

		
		sc = new Scanner(System.in);
		while (true) {
			
			System.out.println("Digite uma operação:");
			aux = c.avalia(sc);
			//System.out.println("String = "+aux);
			System.out.println(AvaliadorRPN.avalia(aux));
		}
        //AvaliadorRPN.avalia(sc.nextLine());     
	}
	
}
