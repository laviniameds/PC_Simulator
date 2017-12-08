import java.util.ArrayList;

public class MemoriaPrincipal {
	
	private static int TAMANHO_MEMORIA = 32/2;
	private ArrayList<Integer> memoriaDados;
	private ArrayList<String> memoriaInstrucoes;
	
	public MemoriaPrincipal() {
		this.memoriaDados = new ArrayList<Integer>(TAMANHO_MEMORIA);
		this.memoriaInstrucoes = new ArrayList<String>(TAMANHO_MEMORIA);
		for (int i = 0; i < TAMANHO_MEMORIA; i++) {
			this.memoriaInstrucoes.add("-");
			this.memoriaDados.add(0);
		}
	}
	
	public void mostrarMemoria() {
		System.out.println("\n- Memória -");
		String espacamento;
		int tamanhoEspacamento;
		
		for (int i = 0; i < TAMANHO_MEMORIA; i++) {
			espacamento = "";
			tamanhoEspacamento = 20 - memoriaInstrucoes.get(i).length();
			for (int j = 0; j < tamanhoEspacamento; j++) {
				espacamento += " ";
			}
			
			if (i < 10) System.out.print("M " + i + " - " + "[" + memoriaInstrucoes.get(i) + "]" + espacamento);
			else System.out.print("M" + i + " - " + "[" + memoriaInstrucoes.get(i) + "]" + espacamento);
			System.out.println("M" + (i+16) + " - " + "[" + memoriaDados.get(i) + "]");
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
