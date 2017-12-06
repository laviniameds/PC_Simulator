import java.util.ArrayList;

public class UC {

	private static int TAMANHO_MEMORIA = 32/2;
	private static int TAMANHO_PILHA = 10;
	private ArrayList<Integer> pilha;
	
	public UC() {
		this.pilha = new ArrayList<Integer>(TAMANHO_PILHA);
	}
	
	public void mostrarPilha() {
		System.out.println("- Pilha -");
		if (pilha.size() == 0) 
			System.out.println("   vazio   ");
		else {
			for (int i = pilha.size()-1; i >= 0; i--) {
				System.out.println("[" + pilha.get(i) + "]");
			}
		}
		System.out.println("-----------");
	}
	
	public ArrayList<Integer> getPilha() {
		return this.pilha;
	}
	
	public void pop(MemoriaPrincipal m) {
		int indice = pilha.size() - 1;
		m.getMemoriaDados().add(pilha.get(indice));
		pilha.remove(indice);
	}
	
	public void push(String n, MemoriaPrincipal m) {
		int aux;
		
  		if (n.indexOf("R") >= 0) {
  			n = n.replace("R","");
  			aux = Integer.parseInt(n);
			pilha.add(m.getMemoriaDados().get(aux-TAMANHO_MEMORIA));
		}
  		else {
  			aux = Integer.parseInt(n);
  			pilha.add(aux);
  		}
	}
	
	public void add() {
		int aux = pilha.get(pilha.size() - 1) + pilha.get(pilha.size() - 2);
		pilha.add(aux);
	}
	
	public void addInstrucao(String instrucao, MemoriaPrincipal m) {
		m.getMemoriaInstrucoes().add(instrucao);
	}
	
}
