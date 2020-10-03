import java.lang.reflect.Array;

public class Lista<T> {
		
		private T[] elementos;
		private int tamanho;
		
		
		public Lista(int capacidade) {
			this.elementos = (T[]) new Object[capacidade];
			this.tamanho = 0;
		}
		
		
		
		public Lista(int capacidade, Class<T> tipoClasse) {
			this.elementos = (T[]) Array.newInstance(tipoClasse, capacidade);
			this.tamanho = 0;
		}
		
		/*Adicionar Elementos*/
		public boolean adiciona(T elemento) {
			this.aumentaCapacidade();
			if(this.tamanho < this.elementos.length) {
				this.elementos[tamanho] = elemento;
				this.tamanho++;
				return true;
			}
			return false;
		}
		
		
		/*Verificar Tamanho */
		public int tamanho() {
			return this.tamanho;
		}
		
		
		public T obtem(int posicao) {
			return this.busca(posicao);
		}
		
		
		/* Obter elemento de uma posição*/
		public T busca(int posicao) {
			if(!(posicao>=0 && posicao < tamanho)){
				throw new IllegalArgumentException("Posição inválida");
			}
			return this.elementos[posicao];
		}
		
		
		
		/*Verificar se elemento existe*/
		public int busca(T elemento) {
			for (int i=0; i<this.tamanho;i++) {
				if(this.elementos[i].equals(elemento)) {
					return i;
					
				}
			}
			return -1;
		}
		
		
		/*Adiciona elemento no ultimo indice*/
		public int ultimoIndice(T elemento) {
			
			for(int i=this.tamanho-1;i>=0;i--) {
				if(this.elementos[i].equals(elemento))
					return i;
			}
			return -1;
		}
		
		
		
		/* Método contém*/
		public boolean contem(T elemento) {
			
			/*int pos = busca(elemento);
			 if (pos> -1){
			 	return true;
			 }
			 return false;
			 */
			
			return busca(elemento)>-1;
		}
		
		
		
		
		
		/*Adicionar elemento em qualquer posicao ocupada*/
		public boolean adiciona(int posicao,T elemento) {
			if (!(posicao>=0 && posicao < tamanho)) {
				throw new IllegalArgumentException("Posição inválida");
			}
			
			for(int i=tamanho-1;i>=posicao;i--) {
				this.elementos[i+1] = this.elementos[i];
			}
			
			this.elementos[posicao] = elemento;
			this.tamanho++;
			return true;
			
		}
				
		
		/*Aumenta capacidade vetor*/
		private void aumentaCapacidade() {
			if(this.tamanho == this.elementos.length) {
				T[] elementosNovos = (T[]) new Object[this.elementos.length*2];
				for(int i=0;i<this.elementos.length;i++) {
					elementosNovos[i] = elementos[i];
				}
				this.elementos = elementosNovos;
			}
		}
		
		
		/*Remover elemento de uma posicao*/
		public void remove(int posicao) {
			if (!(posicao>=0 && posicao < tamanho)) {
				throw new IllegalArgumentException("Posição inválida");
			}
			for(int i=posicao;i<tamanho-1;i++) {
				this.elementos[i] = this.elementos[i+1];
			}
			this.tamanho--;
		}
		
		
		public void remove(T elemento) {
			int pos = this.busca(elemento);
			if (pos > -1) {
				this.remove(pos);			}
		}
		
		
		public void limpar() {
			
			//opção 1
			this.elementos = (T[]) new Object[this.elementos.length];
			
			
			//opção 2
			for(int i=0;i<this.tamanho;i++) {
				this.elementos[i] = null;
			}
			this.tamanho = 0;
		}
		
		
		/*Imprime sem NULL*/
		@Override
		public String toString() {
			StringBuilder s = new StringBuilder();
			s.append("[");
			
			for(int i=0; i<this.tamanho-1;i++) {
				s.append(this.elementos[i]);
				s.append(",");
			}
			
			if(this.tamanho>0) {
				s.append(this.elementos[this.tamanho-1]);
			}
			
			s.append("]");
			
			return s.toString();
		}
		
		
	}


