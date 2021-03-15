package br.com.preparasantarita.ContratoWeb.entity;

public enum EstadoCivil {

    CASADO("Casado(a)"), SOLTEIRO("Solteiro(a)"), DIVORCIADO_SEPARADO("Divorciado(a)/Separado(a)"), VIUVO("Viúvo(a)"),
    UNIAO_ESTAVEL("União Estável");

    private final String displayValue;

    private EstadoCivil(String s) {
	displayValue = s;
    }

    public String getDisplayValue() {
	return displayValue;
    }
}
