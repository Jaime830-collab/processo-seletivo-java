package candidatura;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
	private static double salarioBase;

	public static void main(String[] args) {
		System.out.println("Processo seletivo!");
		String [] candidatos = {"Claudio", "Ludmilo", "Cerejo", "Mussarelo", "Calabreso"};
		
		for(String cadidato: candidatos) {
			entrandoEmContato(cadidato);
		}
	}
	
	static void entrandoEmContato(String cadidato) {
		int tentativasRealizadas = 1;
		boolean constinuarTentando = true;
		boolean atendeu = false;
		
		do {
			//as variaveis precisaram ter alterações durante o loop
			atendeu = atender();
			constinuarTentando = !atendeu;
			if (constinuarTentando) 
				tentativasRealizadas++;
			else
				System.out.println("CONTATO REALIZADO COM SUCESSO!!!");
		} while (constinuarTentando && tentativasRealizadas < 3);
		
		if (atendeu) 
			System.out.println("CONSEGUIMOS CONTATO "+cadidato+ " NA TENTATIVA "+ tentativasRealizadas);
		else
			System.out.println("NÃO CONSEGUIMOS CONTATO COM "+cadidato+ " TENTATIVAS REALIZADAS: "+ tentativasRealizadas);
	}
	
	//metodo auxiliar
	static boolean atender() {
		return new Random().nextInt(3)==1;
	}
	
	static void imprimirSelecionados() {
		String [] candidatos = {"Claudio", "Ludmilo", "Cerejo", "Mussarelo", "Calabreso"};
		System.out.println("Seleceinando os candidatos pelo indice: ");
		
		for(int indice = 0; indice < candidatos.length; indice++) {
			System.out.println("O candidato n "+(indice+1)+ " é o "+candidatos[indice]);
		}
		System.out.println("Forma abrevidad usando for each:");
		
		for (String candidato: candidatos) {
			System.out.println("O candidato selecionado foi: "+ candidato);
		}
	}
	
	static void selecaoCandidatos() {
		String [] candidatos = {"Claudio", "Ludmilo", "Cerejo", "Mussarelo", "Calabreso", "Silos", "Kiko", "Luiz", "Bia", "Bill"};
		
		int candidatosSelecionados = 0;
		int candidatoAtual = 0;
		while (candidatosSelecionados < 5 && candidatoAtual < candidatos.length) {
			String candidato = candidatos[candidatoAtual];
			double salarioPretendido = valorPretendido();
			
			System.out.println("O candidato "+candidato+" solicitou este salário "+salarioPretendido);
			if(salarioBase >= salarioPretendido ) {
				System.out.println("O candidato "+candidato+" foi selecionadpata a vaga!");
				candidatosSelecionados++;
			}
			candidatoAtual++;
		}
	}
	
	static double valorPretendido() {
		return ThreadLocalRandom.current().nextDouble(1800,2000);
	}

	static void analisarCandidato(double salarioPretendido) {
		double salarioBase = 2000.0;
		if(salarioBase > salarioPretendido) {
			System.out.println("LIGAR CANDIDATO...");
		}
		else if(salarioBase == salarioPretendido) {
			System.out.println("LIGAR CANDIDATO COM OUTRA PROPOSTA...");
		}
		else {
			System.out.println("AGUARDADOS DEMAIS CANDIDATOS...");
		}
	}

}
