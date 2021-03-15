package br.com.preparasantarita.ContratoWeb.entity;

public enum Familia {

    TECNOLOGIA_E_INFORMATICA("Tecnologia e Informática"), SAUDE("Saúde"), COMERCIO_E_SERVICO("Comércio e Serviço"),
    INGLES("Inglês"), DESENVOLVIMENTO_EDUCACIONAL_E_SOCIAL("Desenvolvimento Educacional e Social"),
    INFRAESTRUTURA("Infraestrutura"), PREPARATORIO("Preparatório"), RECURSOS_NATURAIS("Recursos Naturais"),
    SEGURANCA("Segurança"), INDUSTRIAL("Industrial");

    private final String displayValue;

    private Familia(String s) {
	displayValue = s;
    }

    public String getDisplayValue() {
	return displayValue;
    }

}
