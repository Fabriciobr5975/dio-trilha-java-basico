package sistemabancario;

import java.util.InputMismatchException;
import java.util.Scanner;

import sistemabancario.conta.ContaCorrente;
import sistemabancario.conta.ContaPoupanca;
import sistemabancario.dados.Cliente;

/**
 * @author Fabrício de Araújo Santana
 * @since 01/07/2024
 */
public class Main {
	public static void main(String[] args) {
		// Declaração e criação do objeto da classe Scanner;
		Scanner scanner = new Scanner(System.in);

		// Variáveis para a manipulação do programa;
		double saldo = 0;
		int opcao = 0;

		try {
		
		// Criando o objeto cliente, contendo dados referente ao cliente e suas contas;
		Cliente cliente = criarUsuario(scanner);

		/*
		 * Criando os objetos das contas, onde o usuário poderá manipular as suas
		 * contas.
		 * 
		 * Obs: Os objetos não foram instanciados, pois, um usúario optar por criar uma
		 * conta, seja ela corrente ou poupança, ou criar as duas contas de uma vez.
		 * Eles só serão instanciados no momento em que o usuário escolher qual conta
		 * criar.
		 */
		ContaPoupanca contaPoupanca;
		ContaCorrente contaCorrente;

		// Variável que guarda o resultado do método de criação da contaBancária;
		int resultado = criarConta(scanner);

		/*
		 * Estrutara que irá a partir da variável "resultado" cria a conta selecionada
		 * pelo usuário, ou apenas fecha o sistema;
		 */
		switch (resultado) {
		case 1 -> {
			/*
			 * Criando a conta Poupança, instanciando com os dados obrigatorios no
			 * construtor;
			 */
			contaPoupanca = new ContaPoupanca(primeiroDeposito(saldo, scanner), cliente);

			/*
			 * Ações que o usuário pode realizar na conta Poupança. Será Explicado na parte
			 * dos métodos;
			 */
			contaPoupanca = operacoesContaPoupanca(contaPoupanca, new ContaCorrente(), scanner, opcao);

		}
		case 2 -> {
			/*
			 * Criando a conta Corrente, instanciando com os dados obrigatorios no
			 * construtor;
			 */
			contaCorrente = new ContaCorrente(primeiroDeposito(saldo, scanner), cliente);

			/*
			 * Ações que o usuário pode realizar na conta Corrente. Será Explicado na parte
			 * dos métodos;
			 */
			contaCorrente = operacoesContaCorrente(contaCorrente, new ContaPoupanca(), scanner, opcao);
		}
		case 3 -> {
			/*
			 * Criando a conta Poupança, instanciando com os dados obrigatorios no
			 * construtor;
			 */
			System.out.println("Conta Poupança:");
			contaPoupanca = new ContaPoupanca(primeiroDeposito(saldo, scanner), cliente);

			/*
			 * Criando a conta Corrente, instanciando com os dados obrigatorios no
			 * construtor;
			 */
			System.out.println("Conta Corrente:");
			contaCorrente = new ContaCorrente(primeiroDeposito(saldo, scanner), cliente);

			// Variável para o usuário poder escolher qual conta irá manipular;
			int opcaoConta = 0;

			do {
				// Pegando o resultado para a variável;
				System.out.println("Deseja visualizar qual conta: 1 - Poupança | 2 - Corrente | 3 - Sair");
				opcaoConta = scanner.nextInt();
			} while (opcaoConta < 1 || opcaoConta > 3);

			// Loop para o usuário iterar sobre os objetos contaPoupanca e contaCorrente;
			while (true) {

				// Verificando qual opcao o usuário escolheu;
				if (opcaoConta == 1) {
					// Ações que o usuário pode realizar na conta Poupança;
					System.out.println("Conta Poupança:");
					contaPoupanca = operacoesContaPoupanca(contaPoupanca, contaCorrente, scanner, opcao);

				} else if (opcaoConta == 2) {
					// Ações que o usuário pode realizar na conta Corrente;
					System.out.println("Conta Corrente:");
					contaCorrente = operacoesContaCorrente(contaCorrente, contaPoupanca, scanner, opcao);

				} else { // Caso o resultado seja 3, o usuário sai da conta e do programa;
					break;
				}

				// Pedindo novamente para o usuário inserir uma opção para minipular na conta
				do {
					System.out.println("Deseja visualizar : 1 - Poupança | 2 - Corrente | 3 - Sair");
					opcaoConta = scanner.nextInt();
				} while (opcaoConta < 1 || opcaoConta > 3);
			}
		}
		case 4 -> { // Sair do programa;
			System.out.println("Saindo...");
		}
		}

		// Fechamento do Scanner;
		scanner.close();

		} catch(InputMismatchException ex) {
			System.out.println("A aplicação recebeu um valor inválido para a váriavel opção");
		
		} catch(Exception ex) {
			System.out.println("A aplicação parou por conta de um erro! Erro: " + ex.getMessage());
		}
	}

	/**
	 * Método para criar as contas disponíveis no sistema
	 * 
	 * @param scanner - Recebe um objeto da classe Scanner para permitir a entrada
	 *                de dados via console
	 * @return - Retorna o valor da opção escolhida pelo usuário
	 */
	public static int criarConta(Scanner scanner) throws Exception {
		// Variável para pegar a opção que o usuário quer;
		int opcao = 0;

		// Pegando a opção;
		do {
			System.out.println("--- Criar conta ---");
			System.out.println("1 - Conta Poupança\n2 - Conta Corrente\n3 - Criar as duas\n4 - Sair");
			System.out.println("---*-----------*---");
			opcao = scanner.nextInt();
		} while (opcao < 1 || opcao > 4);

		// retornando o valor da opção;
		return opcao;
	}

	/**
	 * Criando o usuário\cliente que irá manipular as contas
	 * 
	 * @param scanner - Recebe um objeto da classe Scanner para permitir a entrada
	 *                de dados via console
	 * @return - Retorna um novo cliente, que será criado no método Main (linha 23)
	 */
	public static Cliente criarUsuario(Scanner scanner) throws Exception{
		// Variáveis para pegar os dados do cliente;
		String nome, endereco;
		int idade;

		// Pegando o nome;
		System.out.println("Digite o seu nome completo:");
		nome = scanner.nextLine();

		// Pegando a idade e fazendo um simples verificação da idade informada;
		System.out.println("Digite a sua idade:");
		idade = scanner.nextInt();

		while (idade < 14 || idade > 120) {
			System.out.println("Idade inválida, digite novamente:");
			idade = scanner.nextInt();
		}

		// Pegando o endereço do usuário;
		System.out.println("Digite o seu endereço: ");
		endereco = scanner.nextLine();

		// Retornando os dados do novo usuário;
		return new Cliente(nome, idade, endereco);
	}

	/**
	 * Método que possibilita o usuário criar a sua conta com um valor específico,
	 * caso não pretenda adicionar um valor a conta, ela é criada com valor 0
	 * (Padrão)
	 * 
	 * @param saldo   - Recebe o valor do saldo
	 * @param scanner - Recebe um objeto da classe Scanner para permitir a entrada
	 *                de dados via console
	 * @return - Retorna o valor do saldo informado ou não pelo usuário. Obs: Esse
	 *         valor é colocando diretamente no construtor.
	 */
	public static double primeiroDeposito(double saldo, Scanner scanner) throws Exception{
		// Variável para pegar a opção que o usuário quer;
		int opcao;

		// Pegando a opção;
		System.out.println("Deseja depositar um valor inicial? Digite 1 para sim e 0 para não:");
		opcao = scanner.nextInt();

		// Verificando se a opção é válida;
		while (opcao < 0 || opcao > 1) {
			System.out.println("Opção inválida, digite novamente:");
			opcao = scanner.nextInt();
		}

		// Pegando o valor e fazendo uma verificação simples do valor;
		if (opcao == 1) {
			System.out.println("Digite um valor:");
			saldo = scanner.nextDouble();

			while (saldo < 0) {
				System.out.println("Digite um valor válido:");
				saldo = scanner.nextDouble();
			}
		} else {
			saldo = 0;
		}
		// Retornando o valor;
		return saldo;
	}

	/**
	 * Método que pega valores para usar nas ações que o usuário pode fazer nas
	 * contas, sacar, depositar e transferencia. Obs: Esté método não é usado no
	 * método Main, ele é usando nos métodos referentes as ações dos usuários.
	 * 
	 * @param scanner - Recebe um objeto da classe Scanner para permitir a entrada
	 *                de dados via console;
	 * @return - Retorna o valor que o usuário escolheu para realizar as operações
	 *         nos próximos métodos;
	 */
	public static double pegarValor(Scanner scanner) throws Exception{
		// Criando a variável que o usuário poderá escolher um valor;
		double valor;

		// Pegando o valor;
		System.out.println("Digite um valor:");
		valor = scanner.nextDouble();

		// Verificando se o valor é válido;
		while (valor < 0) {
			System.out.println("Valor inválido! Digite novamente:");
			valor = scanner.nextDouble();
		}

		// Retornando o valor;
		return valor;
	}

	/**
	 * Método que contém as ações que o usuário poderá fazer em sua conta Poupança.
	 * As ações são: sacar, depositar, transferencia, imprimirExtratoBancario.
	 * 
	 * @param conta   - Recebe o objeto da contaPoupanca para realizar a manipulação
	 * @param conta2  - Recebe o objeto de uma contaCorrente, caso o usuário não
	 *                tenha criado uma conta corrente ela será criada apenas para
	 *                realizar a transferencia, mas o usuário não terá acesso a ela
	 * @param scanner - Recebe um objeto da classe Scanner para permitir a entrada
	 *                de dados via console;
	 * @param opcao   - Recebe a variável opcao que será usada para deixar o usuário
	 *                escolher qual ação deseja realizar em sua conta;
	 * @return - Retorna todas as ações que o usuário pode realizar, ficando em um
	 *         Loop até que o usuário pare.
	 */
	public static ContaPoupanca operacoesContaPoupanca(ContaPoupanca conta, ContaCorrente conta2, Scanner scanner,
			int opcao) throws Exception{
		while (true) {
			// Pegando a opção;
			do {
				System.out.println("1 - Sacar\n2 - Depositar\n3 - Trasferir\n4 - Imprimir Extrato\n5 - Sair");
				opcao = scanner.nextInt();
			} while (opcao < 1 || opcao > 5);

			// Opções disponíveis;
			switch (opcao) {
			case 1 -> {
				conta.sacar(pegarValor(scanner));
			}
			case 2 -> {
				conta.depositar(pegarValor(scanner));
			}
			case 3 -> {
				conta.transferencia(pegarValor(scanner), conta2);
			}
			case 4 -> {
				conta.imprimirExtratoBancario();
			}
			case 5 -> {
				System.out.println("Saindo...");
			}
			}
			if (opcao == 5) {
				break;
			}
		}
		// retornando as ações para a manipulação no programa;
		return conta;
	}

	/**
	 * Método que contém as ações que o usuário poderá fazer em sua conta Corrente.
	 * As ações são: sacar, depositar, transferencia, imprimirExtratoBancario.
	 * 
	 * @param conta   - Recebe o objeto da contaCorrente para realizar a manipulação
	 * @param conta2  - Recebe o objeto de uma contaPoupanca, caso o usuário não
	 *                tenha criado uma conta poupanca ela será criada apenas para
	 *                realizar a transferencia, mas o usuário não terá acesso a ela
	 * @param scanner - Recebe um objeto da classe Scanner para permitir a entrada
	 *                de dados via console
	 * @param opcao   - Recebe a variável opcao que será usada para deixar o usuário
	 *                escolher qual ação deseja realizar em sua conta
	 * @return - Retorna todas as ações que o usuário pode realizar, ficando em um
	 *         Loop até que o usuário pare.
	 */
	public static ContaCorrente operacoesContaCorrente(ContaCorrente conta, ContaPoupanca conta2, Scanner scanner,
			int opcao) throws Exception{
		while (true) {
			// Pegando a opção;
			do {
				System.out.println("1 - Sacar\n2 - Depositar\n3 - Trasferir\n4 - Imprimir Extrato\n5 - Sair");
				opcao = scanner.nextInt();
			} while (opcao < 1 || opcao > 5);

			// Opções disponíveis;
			switch (opcao) {
			case 1 -> {
				conta.sacar(pegarValor(scanner));
			}
			case 2 -> {
				conta.depositar(pegarValor(scanner));
			}
			case 3 -> {
				conta.transferencia(pegarValor(scanner), conta2);
			}
			case 4 -> {
				conta.imprimirExtratoBancario();
			}
			case 5 -> {
				System.out.println("Saindo...");
			}
			}
			if (opcao == 5) {
				break;
			}
		}
		// retornando as ações para a manipulação no programa;
		return conta;
	}
}
