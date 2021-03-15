package br.com.preparasantarita.ContratoWeb.entity;

public enum Modalidade {

    PRESENCIAL("Presencial"), A_DISTANCIA("a Distância");

    private final String displayValue;

    private Modalidade(String s) {
	displayValue = s;
    }

    public String getDisplayValue() {
	return displayValue;
    }
}
