package br.com.preparasantarita.ContratoWeb.entity;

public enum DiaDaSemana {
    DOMINGO("Domingo"), SEGUNDA("Segunda-feira"), TERÇA("Terça-feira"), QUARTA("Quarta-feira"), QUINTA("Quinta-feira"),
    SEXTA("Sexta-feira"), SABADO("Sábado");

    private final String displayValue;

    private DiaDaSemana(String s) {
	displayValue = s;
    }

    public String getDisplayValue() {
	return displayValue;
    }
}
