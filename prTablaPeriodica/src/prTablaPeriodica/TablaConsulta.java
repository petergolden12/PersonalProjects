package prTablaPeriodica;

/**
 *  Clase que muestra el diálogo para pedir el número de intentos
 *  para hundir el barco, y las coordenadas del barco del usuario
 *  
 *  */


import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;

public class TablaConsulta extends JDialog 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	// Constructor
	public TablaConsulta(DefaultTableModel datos)
	{ 
		// Poner el dialogo modal, darle título y gestor de esquemas
		this.setModal(true);
		this.setTitle("Consulta de discos vendidos en este año");
		this.setLayout(new FlowLayout());
	
		JTable tablaResultados = new JTable(datos);
	//	tablaResultados.setModel(datos);
		JScrollPane sp = new JScrollPane(tablaResultados);

		this.add(sp);
	   
	    this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    	this.pack();  
		this.setVisible(true);   // Para mostrar el dialogo
		this.setResizable(false);

	}
}
