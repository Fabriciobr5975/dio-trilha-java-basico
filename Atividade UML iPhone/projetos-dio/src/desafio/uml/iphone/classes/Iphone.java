package desafio.uml.iphone.classes;

import desafio.uml.iphone.interfaces.AparelhoTelefonico;
import desafio.uml.iphone.interfaces.NavegacaoInternet;
import desafio.uml.iphone.interfaces.ReprodutorMusical;

/**
 * Classe que implementa todas as interfaces, para realizar todas as tarefas que
 * o iPhone precisa fazer
 * 
 * @author Fabrício de Araújo Santana
 * @since 21/06/2024
 * @version 1.0
 */
public class Iphone implements ReprodutorMusical, AparelhoTelefonico, NavegacaoInternet {
	// Atributos;
	private String numero;
	private String musica;
	private String url;
	
	// Métodos getters e setters;
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getMusica() {
		return musica;
	}

	public void setMusica(String musica) {
		this.musica = musica;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	// Métodos da interface NavegacaoInternet;
	@Override
	public void exibirPagina() {
		verificarInternet();
		System.out.println("URL: " + this.url + " está carregando, aguarde mais um pouco...");
	}

	@Override
	public void iniciarNovaAba() {
		System.out.println("Abrindo uma nova aba...");

	}

	@Override
	public void atualizarAba() {
		System.out.println("Atualizando aba...");

	}

	// Métodos da interface AparelhoTelefonico;
	@Override
	public void ligar() {
		System.out.println("Ligando para o número: " + this.numero + " aguarde mais um pouco!");

	}

	@Override
	public void atender() {
		System.out.println("Atendendo o celular!");

	}

	@Override
	public void iniciarCorreioVoz() {
		System.out.println("Discando para a caixa-postal");

	}

	// Métodos da interface ReprodutorMusical;
	@Override
	public void tocar() {
		System.out.println("Tocando música");

	}

	@Override
	public void pausar() {
		System.out.println("Música pausada!");

	}

	@Override
	public void selecionarMusica() {
		System.out.println("Você selecionou a música: " + this.musica);

	}

	private void verificarInternet() {
		System.out.println("Verificando a disponibilidade da rede wifi");
	}
}
