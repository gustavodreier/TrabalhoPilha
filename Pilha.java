public class Pilha {

        private double[] dados;
        private int topo;
        
        public Pilha (int tam)
        {
                dados = new double[tam];
                topo = 0;
        }
        
        //ve o ultimo valor inserido na pilha (peek = espiar)
        //nÃ£o altera para operador
        public double peek () throws PilhaVazia
        {
                if (isEmpty())
                        throw new PilhaVazia();
                
                return dados[topo - 1]; 
        }

        //insere um elemento na pilha na proxima posiÃ§Ã£o
        //deve ser passado um valor para o metodo
        //para operador deve passar uma String
        public void push (double valor) throws PilhaCheia
        {
                if (isFull())
                        throw new PilhaCheia();
                
                dados[topo] = valor;
                topo++;
        }
        
        //remove o ultimo valor da pilha
        
        public double pop () throws PilhaVazia
        {
                if (isEmpty())
                        throw new PilhaVazia();
                
                topo--;
                return dados[topo];
        }
        
        //pilha esta cheia
        private boolean isFull() {
                return topo == dados.length;
        }

        private boolean isEmpty() {
                return topo == 0;
        }
}
