import java.util.ArrayList;

public class UC {

	private static int TAMANHO_PILHA = 3;
	private ArrayList<Integer> pilha;
	
	public UC() {
		this.pilha = new ArrayList<Integer>(TAMANHO_PILHA);
	}
	
	public void mostrarPilha() {
		System.out.println("- Pilha -");
		if (pilha.size() == 0) 
			System.out.println("   vazio   ");
		else {
			for (int i = 0; i < TAMANHO_PILHA; i++) {
				System.out.println("R" + i + " - " + "[" + pilha.get(i) + "]");
			}
		}
		System.out.println("-----------");
	}
	
	public void pop(int n, MemoriaPrincipal m) {
		m.getMemoria().add(pilha.get(n));
	}
	
	public void push(String n, MemoriaPrincipal m) {
		int aux;
  		if (n.indexOf("R") >= 0) {
  			n = n.replace("R","");
  			aux = Integer.parseInt(n);
			pilha.add(m.getMemoria().get(aux));
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
	
}
