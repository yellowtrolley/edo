package it.verding.edo.util;


public enum Combustibili {
	GASOLIO("Alimentato a gasolio"), GPL("Alimentato a GPL"), PROPANO("Alimentato a aria propanata"), GAS_NATURALE("Alimentato a gas naturale");
	
	String nome;
	
	Combustibili(String nome) {
		this.nome = nome;
	}
	
	public String nome() {
		return nome;
	}
}
