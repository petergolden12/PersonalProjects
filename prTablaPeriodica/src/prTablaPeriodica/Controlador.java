package prTablaPeriodica;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;
import javax.swing.UIManager;





public class Controlador extends WindowAdapter
implements ActionListener {

	

	
	/**
	 * Variables de instancia
	 */
	private Vista miVista;
	private Modelo miModelo;
	
	
	
	/**
	 * Constructor
	 */
	public Controlador(Vista v) {
		miVista = v;
		
		try {
			// Crear el modelo
			miModelo = new Modelo();
		    	
			// Rellenar la tabla
			rellenarTabla();
			
		}
		catch (SQLException e) {
		//	miModelo.printSQLException(e);
			JOptionPane.showMessageDialog(miVista, "Problema SQL");
			
		}
		catch (NullPointerException e) {
			JOptionPane.showMessageDialog(miVista, "Problema al cargar la BD");
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(miVista, "El programa se debe reiniciar");
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		try {
		if (arg0.getSource()==miVista.getItAñadir()) {
			new DialogoGestion(miModelo);	
				rellenarTabla();		
		}
			
		else if (Arrays.stream(miVista.TIPOS).anyMatch(arg0.getActionCommand()::equals)) 
			new TablaConsulta(miModelo.datosConsulta(arg0.getActionCommand()));
		else if (arg0.getSource()==miVista.getItConGen())
			new TablaConsulta(miModelo.datosConsulta("Tabla Completa"));
		else {
			new DialogoGestion (miModelo, miModelo.getElemento(Integer.parseInt(arg0.getActionCommand())));
			
			rellenarTabla();
		}	
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(miVista, "Problema SQL");
			miModelo.printSQLException(e);
		}
		
	}
	
	
	public void windowClosing(WindowEvent e) {

		try {
			miModelo.cerrarStatement();
			miModelo.cerrarConexion();
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(miVista, "Problema al crear la consulta");
		}
		System.exit(0);
	}
	
	
	private void rellenarTabla() throws SQLException {
		// Crear la consulta	
				
		
		for(int i=0; i<miVista.elementos.length;i++) {
			miVista.elementos[i].setText("");
			miVista.elementos[i].setBackground(UIManager.getColor("Button.background"));
			miVista.elementos[i].setForeground(Color.BLACK);
			miVista.elementos[i].setEnabled(false);
			
		}
		
		
		
		String consulta="select * from elementos;";
					
				
		/*	
				ResultSet rsConsulta = miModelo.getStmt().executeQuery(consulta);
					
			
			
				while (rsConsulta.next()) {
					miVista.elementos[rsConsulta.getInt("n_atomico")-1].setText("<html><p style=\"text-align:center;\">"+
							rsConsulta.getInt("n_atomico")+"</p><p style=\"text-align:center;\"><font size=\"5\">"+rsConsulta.getString("simbolo")+"</font></html>");
					switch (rsConsulta.getString("tipo")) {
					case "No metal": miVista.elementos[rsConsulta.getInt("n_atomico")-1].setBackground(Color.decode("#1184f2")); break;
					case "Gas noble": miVista.elementos[rsConsulta.getInt("n_atomico")-1].setBackground(Color.decode("#fbbc27")); break;
					case "Alcalino": miVista.elementos[rsConsulta.getInt("n_atomico")-1].setBackground(Color.decode("#f449dc")); break;
					case "Alcalino-Térreo": miVista.elementos[rsConsulta.getInt("n_atomico")-1].setBackground(Color.decode("#ac52f9")); break;
					case "Semimetal": miVista.elementos[rsConsulta.getInt("n_atomico")-1].setBackground(Color.decode("#8BEDB7")); break;
					case "Halógeno": miVista.elementos[rsConsulta.getInt("n_atomico")-1].setBackground(Color.decode("#f9fb27")); break;
					case "Metal básico": miVista.elementos[rsConsulta.getInt("n_atomico")-1].setBackground(Color.decode("#F27F11")); break;
					case "Lantánido": miVista.elementos[rsConsulta.getInt("n_atomico")-1].setBackground(Color.decode("#F67070")); break;
					case "Actínido": miVista.elementos[rsConsulta.getInt("n_atomico")-1].setBackground(Color.decode("#DB3157")); break;
						default: miVista.elementos[rsConsulta.getInt("n_atomico")-1].setBackground(Color.decode("#03acef")); break;
					}
					
					switch (rsConsulta.getString("estado_ambiente")) {
					case "Gaseoso": miVista.elementos[rsConsulta.getInt("n_atomico")-1].setForeground(Color.RED); break;
					case "Líquido": miVista.elementos[rsConsulta.getInt("n_atomico")-1].setForeground(Color.BLUE); break;
						default: miVista.elementos[rsConsulta.getInt("n_atomico")-1].setForeground(Color.BLACK); break;
					}
					
					miVista.elementos[rsConsulta.getInt("n_atomico")-1].setEnabled(true);
					}
			*/	
				
		for (int i=0;i<miVista.elementos.length;i++) {
			
			Elemento aux = new Elemento (i+1,"","",0,"",new ArrayList<String>());
			
			miVista.elementos[i].setText("<html><p style=\"text-align:center;\">"+
					(i+1)+"</p><p style=\"text-align:center;\"><font size=\"5\">Hee</font></html>");
			switch (aux.getTipo()) {
			case "No metal": miVista.elementos[i].setBackground(Color.decode("#1184f2")); break;
			case "Gas noble": miVista.elementos[i].setBackground(Color.decode("#fbbc27")); break;
			case "Alcalino": miVista.elementos[i].setBackground(Color.decode("#f449dc")); break;
			case "Alcalino-Térreo": miVista.elementos[i].setBackground(Color.decode("#ac52f9")); break;
			case "Semimetal": miVista.elementos[i].setBackground(Color.decode("#8BEDB7")); break;
			case "Halógeno": miVista.elementos[i].setBackground(Color.decode("#f9fb27")); break;
			case "Metal básico": miVista.elementos[i].setBackground(Color.decode("#F27F11")); break;
			case "Lantánido": miVista.elementos[i].setBackground(Color.decode("#F67070")); break;
			case "Actínido": miVista.elementos[i].setBackground(Color.decode("#DB3157")); break;
				default: miVista.elementos[i].setBackground(Color.decode("#03acef")); break;
			}
			
	
			
			miVista.elementos[i].setEnabled(true);
			}
			
		}
				
	}
	


