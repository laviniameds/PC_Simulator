import java.io.IOException;
import java.util.Scanner;

public class Main {
	
	public static boolean instrucaoOk(String instrucao) {
		String arr[] = instrucao.split(" ");
		if (arr[0].equalsIgnoreCase("POP") || arr[0].equalsIgnoreCase("PUSH")) {
			try{
				  Integer.parseInt(arr[1]);
				  return true;
				} catch (NumberFormatException e) {
					String aux[] = arr[1].split("");
					String auxString = arr[1].replace(aux[0], "");
					int auxInt = Integer.parseInt(auxString);
					if ((aux[0].equalsIgnoreCase("m") || aux[0].equalsIgnoreCase("M")) && (auxInt > 15 && auxInt < 32))
						return true;
				}
		}
		else if (arr[0].equalsIgnoreCase("ADD") || arr[0].equalsIgnoreCase("SUB") || arr[0].equalsIgnoreCase("MULT") || arr[0].equalsIgnoreCase("AND") || arr[0].equalsIgnoreCase("OR") || arr[0].equalsIgnoreCase("0")) {
			return true;
		}
		System.out.println("Instrução inválida!");
		return false;
	}
	
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

	public static void main(String[] args) throws IOException {
		
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
			instrucao = "ADD";
			while (!instrucao.equalsIgnoreCase("0")) {
				do {
					instrucao = sc.nextLine();
				}while(!instrucaoOk(instrucao));
				if (!instrucao.equalsIgnoreCase("0"))
					uc.addInstrucao(instrucao, memoria);
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
				System.in.read();
			}

			System.out.print("Continuar?(s/n)\n-> ");
			op = sc.next();
			sc.nextLine();
	}
		sc.close();
	}

}
