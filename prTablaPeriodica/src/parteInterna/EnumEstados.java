package parteInterna;

public enum EnumEstados {

	SOLIDO("Sólido"),
	LIQUIDO("Líquido"),
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
