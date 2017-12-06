import java.util.Scanner;

public class Main {
	
	public static void executarInstrucao(String instrucao, UC uc, MemoriaPrincipal memoria) {
		String arr[] = instrucao.split(" ");
		
		if (arr[0].equalsIgnoreCase("PUSH")) {
			uc.push(arr[1], memoria);
		}
		else if (arr[0].equalsIgnoreCase("POP")) {
			uc.pop(memoria);
		}
		else if (arr[0].equalsIgnoreCase("ADD")) {
			uc.add();
		}
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		UC uc = new UC();
		MemoriaPrincipal memoria = new MemoriaPrincipal();
		String IR;
		
		String instrucao;
		
		System.out.println("Instruções:");
		instrucao = sc.nextLine();
		while (!instrucao.equalsIgnoreCase("0")) {
			uc.addInstrucao(instrucao, memoria);
			instrucao = sc.nextLine();
		}
				
		for(int i = 0; i < memoria.getMemoriaInstrucoes().size(); i++) {
			memoria.mostrarMemoria();
			uc.mostrarPilha();
			System.out.println("PC - [R" + i + "]");
			IR = memoria.getMemoriaInstrucoes().get(i);
			System.out.println("IR - [" + IR + "]\n\nExecutando...");
			executarInstrucao(IR, uc, memoria);
		}
		memoria.mostrarMemoria();
		uc.mostrarPilha();
		
		
		
		
		
		//System.out.println(memoria.getValueReg(1));
		
		sc.close();
	}

}
