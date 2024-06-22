package desafio.uml.iphone.classes;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Classe principal, feita para simular a iteração de um usuário com um celular,
 * onde o mesmo através da classe "Iphone" pode realizar várias ações, como se
 * fosse um celular real
 * 
 * @author Fabrício de Araújo Santana
 * @since 21/06/2024
 * @version 1.0
 */
public class Usuario {
	public static void main(String[] args) {
		// Criando o objeto scanner apartir do instanciamento da classe Scanner;
		Scanner scanner = new Scanner(System.in);

		// Tratamento para as execeções que possam aparecer;
		try {
			// Instanciando a classe iphone;
			Iphone iphone = new Iphone();
			// Variável para controlar o while;
			boolean controle = true;

			// Loop para ficar rodando as opções do celular;
			while (controle) {
				// Variável para pegar qual aplicativo o usuário quer abrir;
				int opcao = 0;
				menuOpcaoCelular();
				int valorOpcao = opcaoCelular(opcao, scanner);
				System.out.println();

				// Condições para as ações do iPhone;
				switch (valorOpcao) {
				case 1 -> {
					iphone.setMusica("And on Beyond the Cloud's Firmament");
					iphone.selecionarMusica();
					iphone.tocar();
					iphone.pausar();
					System.out.println();
				}
				case 2 -> {
					iphone.setNumero("(11)91234-5678");
					iphone.ligar();
					iphone.iniciarCorreioVoz();
					iphone.atender();
					System.out.println();
				}
				case 3 -> {
					iphone.setUrl("https://www.google.com.br/");
					iphone.exibirPagina();
					iphone.atualizarAba();
					iphone.iniciarNovaAba();
					System.out.println();
				}
				case 4 -> {
					System.out.println("Fechando todos os aplicativos...");
					controle = false;
				}
				default -> System.out.println("Nenhuma opção selecionada");
				}
			}
		} catch (InputMismatchException ex) {
			System.out.println("A aplicação recebeu um valor inválido para a váriavel opção");
		
		} catch(Exception ex) {
			System.out.println("A aplicação parou por conta de um erro! Erro: " + ex.getMessage());
		}
	}

	/**
	 * Método sem retorno, para colocar na tela as opções possíveis que o usuário
	 * pode escolher
	 * 
	 */
	public static void menuOpcaoCelular() {
		System.out.println("Digite o número do aplicativo que deseja usar:");
		System.out.println("*--*--*--*--*--*--*--*--*");
		System.out.println("1- Música\n2- Telefone\n3- Navegação na Internet\n4- Sair");
		System.out.println("*--*--*--*--*--*--*--*--*");
	}

	/**
	 * Método com retorno, que pega a opção escolhida pelo usuário para usar o
	 * celular
	 * 
	 * @param opcao   - Parâmetro que pega a variável para pegar o valor da opção
	 * @param scanner - Parâmetro que pega o objeto scanner da classe Scanner
	 * @return - Retorna o valor do parâmetro opcao após receber um valor do usuário
	 * @throws Exception - Caso haja uma execeção o programa envia as informações
	 *                   para o try-catch
	 */
	public static int opcaoCelular(int opcao, Scanner scanner) {
		opcao = scanner.nextInt();
		
		if (opcao < 1 || opcao > 4) {
			System.out.println("Digite um opção válida!");
			menuOpcaoCelular();
		}
		
		return opcao;
	}
}
