package br.com.preparasantarita.ContratoWeb.entity;

public enum Sexo {

    MASCULINO("Masculino"), FEMININO("Feminino");

    private final String displayValue;

    private Sexo(String s) {
	displayValue = s;
    }

    public String getDisplayValue() {
	return displayValue;
    }
}
