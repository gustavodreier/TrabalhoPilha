import java.util.Scanner;


//classe que recebe um valor infixo e traduz para o pos fixo
public class ConvertePos {

	int prioridade;
	private String saida;
	private String[] dados;
	private int topo;
	
	//PilhaOperador p = new PilhaOperador(50);
	
	public ConvertePos() {
		topo = 0;
		dados = new String[50];
		saida = "";
		prioridade = 0;
	}
	
	//ve o ultimo valor inserido na pilha (peek = espiar)
	//não altera para operador
	public String peek () throws PilhaVazia
	{
		if (isEmpty())
			throw new PilhaVazia();
		
		return dados[topo - 1]; 
	}
	
	public String consulta() {
		return dados[topo];
	}

	//insere um elemento na pilha na proxima posição
	//deve ser passado um valor para o metodo
	public void push (String valor) throws PilhaCheia
	{
		if (isFull())
			throw new PilhaCheia();
		
		dados[topo] = valor;
		topo++;
	}
	
	//remove o ultimo valor da pilha
	
	public String pop () throws PilhaVazia
	{
		if (isEmpty())
			throw new PilhaVazia();
		
		topo--;
		return dados[topo];
	}
	
	public int popTopo () {
		return topo;
	}
	
	//pilha esta cheia
	private boolean isFull() {
		return topo == dados.length;
	}

	public boolean isEmpty() {
		return topo == 0;
	}
	
	
	
	
	
	
	//main
	public int prioridade(String s) throws Exception{
		switch (s) {
		case "+":
		case "-":
			prioridade = 1;
			break;
		case "*":
		case "/":
			prioridade = 2;
			break;
		case "(":
		case ")":
			prioridade = 3;
			break;
		default:
			throw new Exception("Operador " + s + "Inválido.");
		}
		return prioridade;
	}
	
	public void desempilha() throws PilhaVazia {

		String aux = "";
		while(topo != 0) {//enquanto tiver elementos
			aux = pop(); //desempilha
			if (aux == "(")//e o elemento não for parenteses
				break;
			saida += " " + aux;
		}
	}
	
	public boolean isOperador(String s) {
		switch (s) {
		case "+":
		case "-":
		case "*":
		case "/":
		case "(":
		case ")":
			return true;
		default:
			return false;
		}
	}
	
	public String avalia(Scanner sc) throws Exception {

		String aux = "";//elemento atual
		int intAux = 0;//elemento atual
		
		while(sc.hasNext()) {
			if (sc.hasNextInt()) {
				
				intAux = sc.nextInt();
				saida += " "+ intAux;
			} else {
				aux = sc.next();
				if (aux == "fim") {
					sc.close();
					System.exit(0);
				}
				
				if (topo == 0) {//se topo vazio empilha
					push(aux);
					//System.out.println("pop = "+peek());
				} else if (aux == "(") {//se parenteses empilha
					push(aux);
				} else if (aux == ")"){
					desempilha();
				} else if (prioridade(aux) > prioridade(peek())) {//se a prioridade for maior joga na saida
					saida += " " + aux;
				} else {
					push(aux);
				}
			}
		}
		desempilha();
		return saida;
	}
}
