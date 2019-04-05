package parteInterna;

public enum EnumEstados {

	SOLIDO("S�lido"),
	LIQUIDO("L�quido"),
	GASEOSO("Gaseoso")
	;
	
	private String descripcionPropiedad;
	private EnumEstados(String des) {
		this.descripcionPropiedad = des;
	}
	public String getTipo() {
		return this.descripcionPropiedad;
	}
}
