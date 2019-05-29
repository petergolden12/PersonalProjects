package prTablaPeriodica;

import java.util.List;

public class Elemento {
	
	/**
	 * Variables de instancia
	 */

	private int numAtomico;
	private String simbolo;
	private String nombre;
	private double pesoAtomico;
	private String tipo;
	private String estadoAmbiente;
	private List<String> caracteristicas;
	
	
	public Elemento(int
			num, String simbolo, String nombre, double pesoA, String estadoamb, List<String> caract) {
		this.numAtomico=num;
		this.nombre=nombre;
		this.simbolo=simbolo;
		this.pesoAtomico=pesoA;
		this.estadoAmbiente= estadoamb;
		this.caracteristicas=caract;
		
		obtenerTipo();
		
	}
	
	public void añadirCaracteristica(String st) {
		this.caracteristicas.add(st);
	}
	
	private void obtenerTipo() {
		switch(this.numAtomico) {
		case 1: case 6: case 7: case 8: case 15: case 16: case 34: this.tipo="No metal";break;
		case 2: case 10: case 18: case 36: case 54: case 86: case 118: this.tipo="Gas noble";break;
		case 3: case 11: case 19: case 37: case 55: case 87:  this.tipo="Alcalino";break;
		case 4: case 12: case 20: case 38: case 56: case 88:  this.tipo="Alcalino-Térreo";break;
		case 5: case 14: case 32: case 33: case 51: case 52: case 84: this.tipo="Semimetal";break;
		case 9: case 17: case 35: case 53: case 85: case 117:  this.tipo="Halógeno";break;
		case 13: case 31: case 49: case 50: case 81: case 82: case 83: case 113: case 114: case 115: case 116:  this.tipo="Metal básico";break;
		default: 
			if (this.numAtomico>=57 && this.numAtomico<=71)
				this.tipo="Lantánido";
				else if (this.numAtomico>=89 && this.numAtomico<=103)
					this.tipo="Actínido";
				else 
					this.tipo="Metal de transición";break;
		}
	}

	public int getNumAtomico() {
		return numAtomico;
	}

	public String getSimbolo() {
		return simbolo;
	}

	public String getNombre() {
		return nombre;
	}

	public double getPesoAtomico() {
		return pesoAtomico;
	}


	public String getTipo() {
		return tipo;
	}

	public String getEstadoAmbiente() {
		return estadoAmbiente;
	}

	public List<String> getCaracteristicas() {
		return caracteristicas;
	}
	
	

	
}
