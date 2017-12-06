import java.util.ArrayList;

public class MemoriaPrincipal {
	
	private static int TAMANHO_MEMORIA = 32/2;
	private ArrayList<Integer> memoriaDados;
	private ArrayList<String> memoriaInstrucoes;
	
	public MemoriaPrincipal() {
		this.memoriaDados = new ArrayList<Integer>(TAMANHO_MEMORIA);
		this.memoriaInstrucoes = new ArrayList<String>(TAMANHO_MEMORIA);
		//for (int i = 0; i < TAMANHO_MEMORIA; )
	}
	
	public void mostrarMemoria() {
		System.out.println("\n- Memória -");
		if (memoriaDados.size() == 0 && memoriaInstrucoes.size() == 0) 
			System.out.println("   vazio   ");
		else {
			if (memoriaInstrucoes.size() > 0) {
				for (int i = 0; i < memoriaInstrucoes.size(); i++) {
					System.out.println("R" + i + " - " + "[" + memoriaInstrucoes.get(i) + "]");
				}
			}
			if (memoriaDados.size() > 0) {
				for (int i = 0; i < memoriaDados.size(); i++) {
					System.out.println("R" + (i+16) + " - " + "[" + memoriaDados.get(i) + "]");
				}
			}
		}
		System.out.println("-----------");
	}
	
	public int getValueReg(int reg) {
		return memoriaDados.get(reg);
	}
	
	public ArrayList<Integer> getMemoriaDados() {
		return this.memoriaDados;
	}
	
	public ArrayList<String> getMemoriaInstrucoes() {
		return this.memoriaInstrucoes;
	}
	
	
}
