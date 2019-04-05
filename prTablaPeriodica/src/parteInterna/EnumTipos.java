package parteInterna;

public enum EnumTipos {
	ALCALINO("Alcalino"),
	ALCALINOTERREO("Alcalinotérreo"),
	TRANSICION("Metal de transición"),
	METAL("Metal básico"),
	SEMIMETAL("Metaloide o Semimetal"),
	NOMETAL("No metal"),
	HALOGENO("Halógeno"),
	NOBLE("Gas Noble"),
	LANTANIDO("Lantánido"),
	ACTINIDO("Actínido")
	;
	
	private String descripcionPropiedad;
	private EnumTipos(String des) {
		this.descripcionPropiedad = des;
	}
	public String getTipo() {
		return this.descripcionPropiedad;
	}
}
