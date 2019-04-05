package parteInterna;

public enum EnumTipos {
	ALCALINO("Alcalino"),
	ALCALINOTERREO("Alcalinot�rreo"),
	TRANSICION("Metal de transici�n"),
	METAL("Metal b�sico"),
	SEMIMETAL("Metaloide o Semimetal"),
	NOMETAL("No metal"),
	HALOGENO("Hal�geno"),
	NOBLE("Gas Noble"),
	LANTANIDO("Lant�nido"),
	ACTINIDO("Act�nido")
	;
	
	private String descripcionPropiedad;
	private EnumTipos(String des) {
		this.descripcionPropiedad = des;
	}
	public String getTipo() {
		return this.descripcionPropiedad;
	}
}
