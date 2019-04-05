package parteInterna;

import java.util.ArrayList;
import java.util.List;

public class Elemento {

	
	/**
	 * Variables de Clase
	 */
	private static final String[][] ORBITALES={{"1s"}};
	private static final byte[] PERIODOS= {1,2,3,4,5,6,7};
	private static final String[][] GRUPOS= {{"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18"},
{"IA","IIA","IIIB","IVB","VB","VIB","VIIB","VIII","VIII","VIII","IB","IIB","IIIA","IVA","VA","VIA","VIIA","VIIIA"}};
	private static final short[] VALENCIA= {1,2,3,4,5,6,7,-1,-2,-3,-4,-5,-6,-7};
	
	
	/**
	 * Variables de instancia
	 */

	private short numAtomico;
	private String simbolo;
	private String nombre;
	private byte periodo;
	private byte grupo;
	private double pesoAtomico;
	private String configElectr;
	private List<Byte> valencias;
	private EnumTipos tipo;
	private double densidad;
	private Float pFusion;
	private Float pEbullicion;
	private EnumEstados estadoAmbiente;
	private short añoDescubrimiento;
	private String descubridor;
	private List<String> caracteristicas;
	private String enlaceVideo;
	
	public Elemento(short num, String simbolo, String nombre) {
		this.numAtomico=num;
		this.nombre=nombre;
		this.simbolo=simbolo;
		this.caracteristicas=new ArrayList<String>();
		this.valencias=new ArrayList<Byte>();
	}
	

	/**
	 * @return the enlaceVideo
	 */
	public String getEnlaceVideo() {
		return enlaceVideo;
	}


	/**
	 * @param enlaceVideo the enlaceVideo to set
	 */
	public void setEnlaceVideo(String enlaceVideo) {
		this.enlaceVideo = enlaceVideo;
	}


	/**
	 * @return the configElectr
	 */
	public String getConfigElectr() {
		return configElectr;
	}

	/**
	 * @param configElectr the configElectr to set
	 */
	public void setConfigElectr(String configElectr) {
		this.configElectr = configElectr;
	}

	/**
	 * @return the valencias
	 */
	public List<Byte> getValencias() {
		return valencias;
	}

	/**
	 * @param valencias the valencias to set
	 */
	public void setValencias(List<Byte> valencias) {
		this.valencias = valencias;
	}
	
	/**
	 * @return the numAtomico
	 */
	public short getNumAtomico() {
		return numAtomico;
	}

	/**
	 * @param numAtomico the numAtomico to set
	 */
	public void setNumAtomico(short numAtomico) {
		this.numAtomico = numAtomico;
	}

	/**
	 * @return the simbolo
	 */
	public String getSimbolo() {
		return simbolo;
	}

	/**
	 * @param simbolo the simbolo to set
	 */
	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the periodo
	 */
	public byte getPeriodo() {
		return periodo;
	}

	/**
	 * @param periodo the periodo to set
	 */
	public void setPeriodo(byte periodo) {
		this.periodo = periodo;
	}

	/**
	 * @return the grupo
	 */
	public byte getGrupo() {
		return grupo;
	}

	/**
	 * @param grupo the grupo to set
	 */
	public void setGrupo(byte grupo) {
		this.grupo = grupo;
	}

	/**
	 * @return the pesoAtomico
	 */
	public double getPesoAtomico() {
		return pesoAtomico;
	}

	/**
	 * @param pesoAtomico the pesoAtomico to set
	 */
	public void setPesoAtomico(double pesoAtomico) {
		this.pesoAtomico = pesoAtomico;
	}

	/**
	 * @return the tipo
	 */
	public EnumTipos getTipo() {
		return tipo;
	}

	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(EnumTipos tipo) {
		this.tipo = tipo;
	}

	/**
	 * @return the densidad
	 */
	public double getDensidad() {
		return densidad;
	}

	/**
	 * @param densidad the densidad to set
	 */
	public void setDensidad(double densidad) {
		this.densidad = densidad;
	}

	/**
	 * @return the pFusion
	 */
	public float getpFusion() {
		return pFusion.floatValue();
	}

	/**
	 * @param pFusion the pFusion to set
	 */
	public void setpFusion(float pFusion) {
		this.pFusion= new Float (pFusion);
	}

	/**
	 * @return the pEbullicion
	 */
	public float getpEbullicion() {
		return pEbullicion.floatValue();
	}

	/**
	 * @param pEbullicion the pEbullicion to set
	 */
	public void setpEbullicion(float pEbullicion) {
		this.pEbullicion = new Float (pEbullicion);
	}

	/**
	 * @return the estadoAmbiente
	 */
	public EnumEstados getEstadoAmbiente() {
		return estadoAmbiente;
	}

	/**
	 * @param estadoAmbiente the estadoAmbiente to set
	 */
	public void setEstadoAmbiente(EnumEstados estadoAmbiente) {
		this.estadoAmbiente = estadoAmbiente;
	}

	/**
	 * @return the añoDescubrimiento
	 */
	public short getAñoDescubrimiento() {
		return añoDescubrimiento;
	}

	/**
	 * @param añoDescubrimiento the añoDescubrimiento to set
	 */
	public void setAñoDescubrimiento(short añoDescubrimiento) {
		this.añoDescubrimiento = añoDescubrimiento;
	}

	/**
	 * @return the descubridor
	 */
	public String getDescubridor() {
		return descubridor;
	}

	/**
	 * @param descubridor the descubridor to set
	 */
	public void setDescubridor(String descubridor) {
		this.descubridor = descubridor;
	}

	/**
	 * @return the caracteristicas
	 */
	public List<String> getCaracteristicas() {
		return caracteristicas;
	}

	/**
	 * @param caracteristicas the caracteristicas to set
	 */
	public void setCaracteristicas(List<String> caracteristicas) {
		this.caracteristicas = caracteristicas;
		
	}
	
	
	
	
	

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numAtomico;
		result = prime * result + ((simbolo == null) ? 0 : simbolo.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Elemento other = (Elemento) obj;
		if (numAtomico != other.numAtomico)
			return false;
		if (simbolo == null) {
			if (other.simbolo != null)
				return false;
		} else if (!simbolo.equals(other.simbolo))
			return false;
		return true;
	}
	
	public void añadirCaracteristica (String caract) {
		this.caracteristicas.add(caract);

	}
	
	public void añadirValencia (byte caract) {
		this.valencias.add(caract);

	}
	
	
	
	
	
	
	
	
}
