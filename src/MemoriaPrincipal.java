import java.util.ArrayList;

public class MemoriaPrincipal {
	
	private static int TAMANHO = 8;
	private ArrayList<Integer> memoria;
	
	public MemoriaPrincipal() {
		this.memoria = new ArrayList<Integer>(TAMANHO);	
	}
	
	public void mostrarMemoria() {
		System.out.println("- Memória -");
		if (memoria.size() == 0) 
			System.out.println("   vazio   ");
		else {
			for (int i = 0; i < TAMANHO; i++) {
				System.out.println("R" + i + " - " + "[" + memoria.get(i) + "]");
			}
		}
		System.out.println("-----------");
	}
	
	public int getValueReg(int reg) {
		
		return memoria.get(reg);
		
	}
	
	
}
