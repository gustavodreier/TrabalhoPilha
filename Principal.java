import java.util.Scanner;

public class Principal {

        public static void main(String[] args) throws Exception {

                ConvertePos c = new ConvertePos();
                Scanner sc;
                String aux = "";
                

                
                
                while (true) {
                		sc = new Scanner(System.in);
                        System.out.println("Digite uma operação:");
                        
                        aux = sc.nextLine();
                        
                        if (aux.equalsIgnoreCase("fim"))
                        	System.exit(0);
                        
                        aux = c.avalia(aux);
                        //System.out.println("String = "+aux);
                        System.out.println(AvaliadorRPN.avalia(aux));
                }
        //AvaliadorRPN.avalia(sc.nextLine());     
        }
        
}
