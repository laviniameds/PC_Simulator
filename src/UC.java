import java.util.ArrayList;

public class UC {

	private static int TAMANHO_MEMORIA = 32/2;
	private static int TAMANHO_PILHA = 10;
	private int contInstrucao = 0;
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
	
	public void pop(String n, MemoriaPrincipal m) {
		int indice = pilha.size() - 1;
		int aux;
		n = n.replace("M","");
		n = n.replace("m","");
		aux = Integer.parseInt(n) - 16;
		m.getMemoriaDados().remove(aux);
		m.getMemoriaDados().add(aux, pilha.get(indice));
		pilha.remove(indice);
	}
	
	public void push(String n, MemoriaPrincipal m) {
		int aux;
		
  		if (n.indexOf("M") >= 0) {
  			n = n.replace("M","");
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
	
	public void sub() {
		int aux = pilha.get(pilha.size() - 2) - pilha.get(pilha.size() - 1);
		pilha.add(aux);
	}
	
	public void mult() {
		int aux = pilha.get(pilha.size() - 1) * pilha.get(pilha.size() - 2);
		pilha.add(aux);
	}
	
	public void and() {
		int aux = pilha.get(pilha.size() - 1) & pilha.get(pilha.size() - 2);
		pilha.add(aux);
	}
	
	public void or() {
		int aux = pilha.get(pilha.size() - 1) | pilha.get(pilha.size() - 2);
		pilha.add(aux);
	}
	
	
	public void addInstrucao(String instrucao, MemoriaPrincipal m) {
		m.getMemoriaInstrucoes().add(this.contInstrucao, instrucao);
		this.contInstrucao++;
	}
	
	/*
	public ArrayList<Integer> intParaBinario(int n) {
		ArrayList<Integer> aux = new ArrayList<Integer>(100);
		ArrayList<Integer> bin = new ArrayList<Integer>(100);
		while (n > 0) {
			if (n%2 == 0) aux.add(0);
			else aux.add(1);
			n = n / 2;
		}
		for(int i = 1; i <= aux.size(); i++) {
			bin.add(aux.get(aux.size()-i));
		}
	
		return bin;
	}
	*/
	
}
