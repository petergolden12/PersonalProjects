package parteInterna;

/**
 * Clase propia de control de excepciones
 * @author profesor
 *
 */
public class ExcepcionElemento extends Exception{

	private static final long serialVersionUID = 1L;

	/**
	 * Constructores
	 */
	public ExcepcionElemento() {
		super();
	}
	
	public ExcepcionElemento(String mensaje) {
		super(mensaje);
	}
	
}
