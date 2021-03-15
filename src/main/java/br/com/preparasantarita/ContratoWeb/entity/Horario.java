package br.com.preparasantarita.ContratoWeb.entity;

public enum Horario {

    AM_08("08:00"), AM_09("09:00"), AM_10("10:00"), AM_11("10:00"), PM_12("12:00"), PM_13("13:00"), PM_14("14:00"),
    PM_15("15:00"), PM_16("16:00"), PM_17("17:00"), PM_18("18:00"), PM_19("19:00"), PM_20("20:00");

    private final String displayValue;

    private Horario(String s) {
	displayValue = s;
    }

    public String getDisplayValue() {
	return displayValue;
    }
}
