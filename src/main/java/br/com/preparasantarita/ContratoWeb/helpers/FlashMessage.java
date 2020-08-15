package br.com.preparasantarita.ContratoWeb.helpers;

public class FlashMessage {

	private String mensagem;
	private FlashMessageType tipo;

	public FlashMessage(FlashMessageType tipo, String mensagem) {
		super();
		this.mensagem = mensagem;
		this.tipo = tipo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public FlashMessageType getTipo() {
		return tipo;
	}

}
