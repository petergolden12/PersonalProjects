package prTablaPeriodica;

import java.awt.Dimension;

import javax.swing.JFrame;


public class Main {

	
	
	public static void main(String[] args) {
		Vista miVista = new Vista();
		
		Controlador ctr = new Controlador(miVista);

		//Llamar al método que da control a los componentes
		miVista.control(ctr);

		JFrame ventana = new JFrame("Tabla periódica");
		ventana.setContentPane(miVista);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setJMenuBar(miVista.getBarMenu());
		Dimension d1= new Dimension(1400,800);
		ventana.setPreferredSize(d1);
		ventana.setResizable(false);
		ventana.pack();
		ventana.setVisible(true);
		

		
		
		
		
		
		
		
		
	}
}
