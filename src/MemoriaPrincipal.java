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
		for (int i = 0; i < TAMANHO_MEMORIA; i++) {
			espacamento = "";
			if (i < 10)	espacamento = espacamento + " ";
			System.out.print("M" + espacamento + i + " - " + "[" + memoriaInstrucoes.get(i) + "]");
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
