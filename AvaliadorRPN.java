import java.util.Scanner;

public class AvaliadorRPN {
        public static double avalia (String expressao) throws PilhaCheia, PilhaVazia, OperadorInvalido
        {        
                Pilha pilha = new Pilha(50);
                
                Scanner sc = new Scanner(expressao);
                
                while (sc.hasNext()) {
                        if (sc.hasNextInt()) {
                                pilha.push(sc.nextInt());
                        } else {
                                String op = sc.next();
                                double rhs = pilha.pop();
                                double lhs = pilha.pop();
                                pilha.push( executaOperador(op.charAt(0), lhs, rhs) );
                        }
                }
                
                return pilha.pop();
        }

        private static double executaOperador(char op, double lhs, double rhs) throws OperadorInvalido
        {
                switch (op) {
                        case '+': return lhs + rhs;
                        case '-': return lhs - rhs;
                        case '*': return lhs * rhs;
                        case '/': return lhs / rhs;
                        default: throw new OperadorInvalido(op);
                }
        }
}
