package prTablaPeriodica;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;




@SuppressWarnings("serial")
public class DialogoGestion extends JDialog {

	
	private final String[] ESTADOS= {"Gaseoso","Líquido","Sólido"};
	
	/**
	 * Variables de instancia
	 */
	private JTextField tfNumAto, tfSimbolo,tfNombre, tfPesoAt, tfTipo;
	private JTextArea taCaract;
	private JComboBox<String> cbEstados;
	private JButton bNuevo, bGuardar, bModificar, bEliminar, bCancelar;
	private JLabel titulo;
	private JPanel p;
	private Elemento elem;
	
	
	/**
	 * Constructor
	 */
	public DialogoGestion(Modelo modelo) {
		
		
		
		this.setModal(true);
		this.setTitle("Gestión de la Tabla Periódica");
		
		
		// Preparar un panel intermedio con todo el contenido
		p = new JPanel();
		p.setLayout(new BoxLayout(p,BoxLayout.Y_AXIS));
	
		p.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 20));
		
		titulo = new JLabel("Datos del Elemento");
		Font fuente = new Font("Arial",Font.HANGING_BASELINE,14);
		titulo.setFont(fuente);
		titulo.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		p.add(titulo);
		
		p.add(preparaPanelDatos());
		p.add( preparaPanelCaract());
		p.add(preparaPanelOperaciones());
		
		
		// Añadir el panel anterior al panel implícito
		this.add(p);
		
	
		ControladorDialogo ctr = new ControladorDialogo(this, modelo);
		control(ctr);
		
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		Dimension d1= new Dimension(350,500);
		this.setPreferredSize(d1);
		this.setResizable(false);
		this.pack(); 
		this.setVisible(true);
			

	}
	
	public DialogoGestion( Modelo modelo,Elemento ob) {
		this.setModal(true);
		this.setTitle("Gestión de la Tabla Periódica");
		this.elem=ob;
		
		
		// Preparar un panel intermedio con todo el contenido
		p = new JPanel();
		p.setLayout(new BoxLayout(p,BoxLayout.Y_AXIS));
	
		p.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 20));
		
		titulo = new JLabel("Datos del Elemento");
		Font fuente = new Font("Arial",Font.HANGING_BASELINE,14);
		titulo.setFont(fuente);
		titulo.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		p.add(titulo);
		
		p.add(preparaPanelDatos());
		p.add( preparaPanelCaract());
		p.add(preparaPanelOperaciones());
		
		
		// Añadir el panel anterior al panel implícito
		this.add(p);
		
	
		ControladorDialogo ctr = new ControladorDialogo(this, modelo);
		control(ctr);
		
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		Dimension d1= new Dimension(350,550);
		this.setPreferredSize(d1);
		this.setResizable(false);
		this.pack(); 
		this.setVisible(true);
			
	}
	
	
	/**
	 * Método que prepara el panel con los datos del disco
	 * @return
	 */
	private JPanel preparaPanelDatos() {
		
		// Pedir memoria para el panel y ponerle un borde
		JPanel panelDatos = new JPanel(new GridLayout(7,2,20,20));
		
		// Pedir memoria para los JTextField
		tfNumAto = new JTextField();
		tfSimbolo  = new JTextField();
		tfNombre = new JTextField();
		tfPesoAt = new JTextField(18);
		tfTipo= new JTextField();// 18 será el tamaño de todos los JTextField
		cbEstados = new JComboBox<String>(this.ESTADOS);
		
		
		// Poner no editables los JTextField 
		tfNumAto.setEditable(false);
		tfSimbolo.setEditable(false);
		tfNombre.setEditable(false);
		tfPesoAt.setEditable(false);
		tfTipo.setEditable(false);
		cbEstados.setEnabled(false);
		
		
		
	

		
		
		// Al poner los campos no editables le cambia el color a gris, por
		// tanto se lo volveremos a poner en blanco
		tfNumAto.setBackground(Color.white);
		tfSimbolo.setBackground(Color.white);
		tfNombre.setBackground(Color.white);
		tfPesoAt.setBackground(Color.white);
		tfTipo.setBackground(Color.white);
		cbEstados.setBackground(Color.white);
		
		
		
		
		// Añadir los campos de texto y los JLabel que los preceden
		// al panel
		panelDatos.add(new JLabel("Nº Atómico",JLabel.RIGHT));
		panelDatos.add(tfNumAto);
		panelDatos.add(new JLabel("Símbolo",JLabel.RIGHT));
		panelDatos.add(tfSimbolo);
		panelDatos.add(new JLabel("Nombre",JLabel.RIGHT));
		panelDatos.add(tfNombre);
		panelDatos.add(new JLabel("Peso atómico",JLabel.RIGHT));
		panelDatos.add(tfPesoAt);
		panelDatos.add(new JLabel("Tipo",JLabel.RIGHT));
		panelDatos.add(tfTipo);
		panelDatos.add(new JLabel("Estado",JLabel.RIGHT));
		panelDatos.add(cbEstados);
		
		
		
		return panelDatos;
	}
	
	
	private JPanel preparaPanelCaract() {
		
		JPanel panelDatos =new JPanel(new GridLayout(1,2,20,80));
		panelDatos.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		taCaract = new JTextArea();
		taCaract.setEditable(false);
		taCaract.setBackground(Color.white);
		
		panelDatos.add(new JLabel("Características",JLabel.RIGHT));
		JScrollPane sp = new JScrollPane(taCaract);
		
		Dimension d = new Dimension(20,80);
		sp.setPreferredSize(d);
		panelDatos.add(sp);
		
		return panelDatos;
	}
	
	/**
	 * Mëtodo que prepara un panel con todos los botones de 
	 * operaciones permitidas sobre la BD
	 */
	private JPanel preparaPanelOperaciones() {
		
		JPanel p = new JPanel();
		p.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
		
		// Pedir memoria para los botones
		bNuevo = new JButton("Nuevo");
		bNuevo.setActionCommand("Añadir");
		bGuardar = new JButton("Guardar");
		bModificar = new JButton("Modificar");
		bEliminar = new JButton("Eliminar");
		bCancelar = new JButton("Cancelar");
		
		// Poner un borde resaltado a los botones
		bNuevo.setBorder(new BevelBorder(BevelBorder.RAISED));
		bGuardar.setBorder(new BevelBorder(BevelBorder.RAISED));
		bModificar.setBorder(new BevelBorder(BevelBorder.RAISED));
		bEliminar.setBorder(new BevelBorder(BevelBorder.RAISED));
		bCancelar.setBorder(new BevelBorder(BevelBorder.RAISED));
		
		// Deshabilitar el botón Guardar
		bGuardar.setEnabled(false);
		
		
		// Añadir los botones al panel
		p.add(bNuevo);
		p.add(bGuardar);
		p.add(bModificar);
		p.add(bEliminar);
		p.add(bCancelar);
		
		return p;
		
		
	}
	


	
	
	
	
	
	/**
	 * Método que da control a los botones
	 *    - A los botones de navegación les añadiremos el control de ratón
	 *    - A los bototes de mantenimiento (nuevo, eliminar, ...) les añadiremos
	 *      control de acción
	 */
	public void control(ControladorDialogo ctr) {

		
		
		// Control de los botones de operaciones
	bNuevo.addActionListener(ctr);
	bGuardar.addActionListener(ctr);
	bModificar.addActionListener(ctr);
	bCancelar.addActionListener(ctr);
	bEliminar.addActionListener(ctr);
		
		
	}


	/** 
	 * Métodos get de todas la variables de instancia
	 */
	public JTextField getTfNumAto() {return tfNumAto;}
	public JTextField getTfSimbolo() {return tfSimbolo;}
	public JTextField getTfNombre() {return tfNombre;}
	public JTextField getTfPesoAt() {return tfPesoAt;}
	public JTextField getTfTipo() {return tfTipo;}
	public JTextArea getTaCaract() {return taCaract;}
	public JComboBox<String> getCbEstados() {return cbEstados;}

	public Elemento getElem() {return elem;}

	public JButton getbNuevo()     {return bNuevo;}
	public JButton getbGuardar()   {return bGuardar;}
	public JButton getbModificar() {return bModificar;}
	public JButton getbEliminar()  {return bEliminar;}
	public JButton getbCancelar()  {return bCancelar;	}
 	
}
class ControladorDialogo implements ActionListener {

	private Modelo miModelo;
	private DialogoGestion miDialogo;
	
	public ControladorDialogo(DialogoGestion miDialog, Modelo mod) {
		
		this.miDialogo=miDialog;
		
		
		
		try {
			// Crear el modelo
			miModelo = mod;
		    	
			if (miDialogo.getElem()==null)
				procesoNuevo();
			else
				muestraElemento(miDialogo.getElem());
			
		}
		catch (NullPointerException e) {
			JOptionPane.showMessageDialog(miDialogo, "Problema al cargar la BD");
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(miDialogo, "El programa se debe reiniciar");
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		
		if (arg0.getSource()==miDialogo.getbNuevo())
			procesoNuevo();
		else if (arg0.getSource()==miDialogo.getbGuardar())
			procesoGuardar();
		else if (arg0.getSource()==miDialogo.getbCancelar())
			procesoCancelar();
		else if (arg0.getSource()==miDialogo.getbModificar())
			procesoModificar();
		else 
			procesoEliminar();
		
	}
	
	/**
	 * -----------------------------------------------------------------
	 * 			Métodos privados del controlador
	 * -----------------------------------------------------------------
	 */
	
	/**
	 * Método que muetra los datos de un disco en el formulario 
	 */
	private void muestraElemento(Elemento ob) {
		
		miDialogo.getTfNumAto().setText(Integer.toString(ob.getNumAtomico()));
		miDialogo.getTfSimbolo().setText(ob.getSimbolo());
		miDialogo.getTfNombre().setText(ob.getNombre());
		miDialogo.getTfPesoAt().setText(Double.toString(ob.getPesoAtomico()));
		miDialogo.getTfTipo().setText(ob.getTipo());
		
		String item;
        for (int i = 0; i < miDialogo.getCbEstados().getItemCount(); i++)
        {
            item = miDialogo.getCbEstados().getItemAt(i);
            if (item.equalsIgnoreCase(ob.getEstadoAmbiente()))
            {
            	miDialogo.getCbEstados().setSelectedIndex(i);
            }
        }
        
        
       
        Iterator<String> it = ob.getCaracteristicas().iterator();
		item="";
		
		
		while (it.hasNext())
		{
			
		item=item+it.next()+"\n";
		
		
		} 
        
        miDialogo.getTaCaract().setText(item);
		
		
		
		
		
		
	}
	
	
	/**
	 * Método que permite añadir un nuevo disco
	 */
	private void procesoNuevo() {
		
		// Habilitar/Deshabilitar los botones de operaciones
		miDialogo.getbNuevo().setEnabled(false);
		miDialogo.getbGuardar().setEnabled(true);
		miDialogo.getbModificar().setEnabled(false);
		miDialogo.getbEliminar().setEnabled(false);
		miDialogo.getbCancelar().setEnabled(true);
		
		
		activacionEntradaDatos(true);
		limpiarEntradaDatos();
	}
	

	
	
	/**
	 * Habilita o deshabilita los campos de texto de entrada de datos
	 */
	public void activacionEntradaDatos(boolean estado)
	{
		miDialogo.getTfNumAto().setEditable(estado);
		miDialogo.getTfSimbolo().setEditable(estado);
		miDialogo.getTfNombre().setEditable(estado);
		miDialogo.getTfPesoAt().setEditable(estado);
		miDialogo.getTaCaract().setEditable(estado);
		miDialogo.getCbEstados().setEnabled(estado);
	}
	
	/**
	 * Limpia los textField de entrada de datos
	 */
	public void limpiarEntradaDatos()
	{
		miDialogo.getTfNumAto().setText("");
		miDialogo.getTfSimbolo().setText("");
		miDialogo.getTfNombre().setText("");
		miDialogo.getTfPesoAt().setText("");
		miDialogo.getTaCaract().setText("");
		miDialogo.getTfTipo().setText("");
	}
	
	/**
	 * Este método permitirá guardar o modificar un disco
	 */
	private void procesoGuardar() {
		try {
			// Crearnos un objeto tipo Disco con los datos que hay en el formulario
			
			List<String> caract = new ArrayList<String>();
			for (String line : miDialogo.getTaCaract().getText().split("\\n")) {
				caract.add(line);
			}
			
			Elemento miElemento = new Elemento(
					Integer.parseInt(miDialogo.getTfNumAto().getText()),
					miDialogo.getTfSimbolo().getText(),
					miDialogo.getTfNombre().getText(),
					Double.parseDouble(miDialogo.getTfPesoAt().getText()),
					String.valueOf(miDialogo.getCbEstados().getSelectedItem()),
					caract);
			miDialogo.getTfTipo().setText(miElemento.getTipo());
			
			if (miElemento.getNumAtomico()>118) throw new SQLException();
			
			if (miDialogo.getbGuardar().getText().equals("Guardar")) { // Alta de nuevo disco
				miModelo.insertarElemento(miElemento);
				miModelo.insertarCaracteristicas(miElemento);
				JOptionPane.showMessageDialog(miDialogo,"Elemento almacenado");
			}
			else {  // Modificación de disco
				miModelo.modificarElemento(miElemento);
				JOptionPane.showMessageDialog(miDialogo,"Elemento modificado");
			}
			
			procesoCancelar(); 
		}
		catch (SQLException e) {
			miModelo.printSQLException(e);
			JOptionPane.showMessageDialog(miDialogo, "Error al grabar los datos, puede\n"
											     + "que los datos ya existan.\n"
											     + "Compruebe que el elemento no exista.");
			
			
		}
		catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(miDialogo, "Datos erróneos");
		}
		
	}
	
	/**
	 * Este método se encarga de dejar el formulario como estaba al principio
	 */
	private void procesoCancelar() {
		try {
			this.muestraElemento(miModelo.getElemento(miDialogo.getElem().getNumAtomico()));
		}
		catch (SQLException e) {
			//miModelo.printSQLException(e);
			JOptionPane.showMessageDialog(miDialogo, "Problema SQL");
		}
		
		
		activacionEntradaDatos(false);  // Poner no editables los JTextField
		
		// Habilitar/Deshabilitar los botones de operaciones
		miDialogo.getbNuevo().setEnabled(true);
		miDialogo.getbGuardar().setEnabled(false);
		miDialogo.getbModificar().setEnabled(true);
		miDialogo.getbEliminar().setEnabled(true);
		miDialogo.getbCancelar().setEnabled(true);
		
		// Cambiar el texto al botón "Guardar" por si tenia "Guardar Cambios"
		miDialogo.getbGuardar().setText("Guardar");
	}
	
	
	/**
	 * Método que prepara la apliacion para modificar
	 */
	private void procesoModificar() {
		
		// Habilitar/Deshabilitar los botones de operaciones
		miDialogo.getbNuevo().setEnabled(false);
		miDialogo.getbGuardar().setEnabled(true);
		miDialogo.getbModificar().setEnabled(false);
		miDialogo.getbEliminar().setEnabled(false);
		miDialogo.getbCancelar().setEnabled(true);
		
	
		activacionEntradaDatos(true);  // Poner editables los JTextField
		miDialogo.getTfNumAto().setEditable(false);  // Poner no editable el codigo
		miDialogo.getbGuardar().setText("Guardar cambios");
	}
	
	/**
	 * Método que permite porder eliminar un disco
	 */
	private void procesoEliminar() {
		
		int resp = JOptionPane.showConfirmDialog(
				miDialogo, 
				"¿Está seguro de querer elimnar el disco actual?");
		if (resp==JOptionPane.YES_OPTION) {
			try {
				miModelo.eliminarElemento(Integer.parseInt(miDialogo.getTfNumAto().getText()));
				JOptionPane.showMessageDialog(miDialogo, "El disco ha sido borrado");
				procesoCancelar();
			}
			catch(SQLException e) {
			//	miModelo.printSQLException(e);
				JOptionPane.showMessageDialog(miDialogo, "Error al borrar los datos");
			}
		}
		else {
			JOptionPane.showMessageDialog(miDialogo, "Eliminación cancelada");
		}
	}
	
}
