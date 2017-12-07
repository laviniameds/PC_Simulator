import java.util.Scanner;

public class Main {
	
	public static void executarInstrucao(String instrucao, UC uc, MemoriaPrincipal memoria) {
		String arr[] = instrucao.split(" ");
		
		if (arr[0].equalsIgnoreCase("PUSH")) {
			uc.push(arr[1], memoria);
		}
		else if (arr[0].equalsIgnoreCase("POP")) {
			uc.pop(arr[1], memoria);
		}
		else if (arr[0].equalsIgnoreCase("ADD")) {
			uc.add();
		}
		else if (arr[0].equalsIgnoreCase("SUB")) {
			uc.sub();
		}
		else if (arr[0].equalsIgnoreCase("MULT")) {
			uc.mult();
		}
		else if (arr[0].equalsIgnoreCase("AND")) {
			uc.and();
		}
		else if (arr[0].equalsIgnoreCase("OR")) {
			uc.or();
		}
		
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		UC uc = new UC();
		MemoriaPrincipal memoria = new MemoriaPrincipal();
		String IR = " - ";
		String instrucao;
		int i = 0;
		String op = "s";
		
		System.out.println("Iniciando o PC...");
		
		System.out.println("\nPC - [ - ] | IR - [ - ]");
		memoria.mostrarMemoria();
		uc.mostrarPilha();
		
		while(op.equalsIgnoreCase("s")) {
			System.out.println("Instruções:");
			instrucao = sc.nextLine();
			while (!instrucao.equalsIgnoreCase("0")) {
				uc.addInstrucao(instrucao, memoria);
				instrucao = sc.nextLine();
			}
			
			System.out.println("\nExecutando...");
			System.out.println("\nPC - [M" + i + "] - IR - [" + IR + "]");
			memoria.mostrarMemoria();
			uc.mostrarPilha();
			
			while(i < memoria.getMemoriaInstrucoes().size()) {
				IR = memoria.getMemoriaInstrucoes().get(i);
				if (IR.equalsIgnoreCase("-")) {
					IR = memoria.getMemoriaInstrucoes().get(i-1);
					break;
				}
				System.out.println("\nPC - [M" + ++i + "] | IR - [" + IR + "]");
				executarInstrucao(IR, uc, memoria);
				memoria.mostrarMemoria();
				uc.mostrarPilha();
			}

			System.out.print("Continuar?(s/n)\n-> ");
			op = sc.next();
			sc.nextLine();
	}
		sc.close();
	}

}
