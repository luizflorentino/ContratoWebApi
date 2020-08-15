package br.com.preparasantarita.ContratoWeb.helpers;

public enum FlashMessageType {
	success("alert alert-success"), 
	danger("alert alert-success"),
	warning("alert alert-success"), 
	info("alert alert-success"), 
	light("alert alert-success"), 
	dark("alert alert-success"), 
	primary("alert alert-success"), 
	secondary("alert alert-success");
	
	private final String displayValue;
    
    private FlashMessageType(String displayValue) {
        this.displayValue = displayValue;
    }
     
    public String getDisplayValue() {
        return displayValue;
    }
}
