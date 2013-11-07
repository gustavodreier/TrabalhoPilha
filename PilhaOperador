public class PilhaOperador
{

	private String[] dados;
	private int topo;
	
	public PilhaOperador (int tam)
	{
		dados = new String[tam];
		topo = 0;
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
}
