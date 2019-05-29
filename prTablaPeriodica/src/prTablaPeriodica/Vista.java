package prTablaPeriodica;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;




@SuppressWarnings("serial")
public class Vista extends JPanel{

	private  final String[] PERIODOS= {"1","2","3","4","5","6","7"};
	private  final String[][] GRUPOS= {{"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18"},
			{"IA","IIA","IIIB","IVB","VB","VIB","VIIB","VIII","VIII","VIII","IB","IIB","IIIA","IVA","VA","VIA","VIIA","VIIIA"}};
	public final String[] TIPOS = {"No metal","Gas noble","Alcalino","Alcalino-Térreo","Semimetal","Halógeno",
			"Metal básico","Lantánido","Actínido","Metal de transición"};

	public JButton[] elementos;
	private JMenuBar barMenu;
	private JMenu mConsultas, mAñadir,mConTipo; 
	private JMenuItem itConGen, itAñadir;
	private JMenuItem[] itTipos;
	private JLabel titulo;




	public Vista() {

		// Preparar un panel intermedio con todo el contenido
		JPanel p = new JPanel();
		p.setLayout(new BorderLayout());

		titulo = new JLabel("TABLA PERIÓDICA DE LOS ELEMENTOS",JLabel.CENTER);
		Font fuente = new Font("Garamond",Font.BOLD,30);
		titulo.setFont(fuente);



		p.add(titulo,BorderLayout.NORTH);



		p.add(preparaPanelTabla(),BorderLayout.CENTER);


		// Añadir el panel anterior al panel implícito
		this.add(p);

		// Preparar la barra de menús
		preparaMenu();


	}


	private JPanel preparaPanelTabla() {

		elementos = new JButton[118];
		for(int i=0; i<elementos.length;i++) {

			elementos[i]= new JButton();

			elementos[i].setActionCommand(String.valueOf(i+1));
			elementos[i].setPreferredSize(new Dimension(40,60));
			elementos[i].setEnabled(false);


		}


		JPanel p = new JPanel(new GridLayout(11,19));


		p.add(new JLabel("<html><p style=\"text-align:center;\">Grupos</p><p style=\"text-align:center;\">Periodos</html>", JLabel.CENTER));
		p.add(new JLabel("<html><p style=\"text-align:center;\">"+GRUPOS[0][0]+"</p><p style=\"text-align:center;\">"+GRUPOS[1][0]+"</html>", JLabel.CENTER));
		for (int i=1;i<=16;i++) {
			JButton b = new JButton();
			p.add(b);
			b.setVisible(false);
		}
		p.add(new JLabel("<html><p style=\"text-align:center;\">"+GRUPOS[0][17]+"</p><p style=\"text-align:center;\">"+GRUPOS[1][17]+"</html>", JLabel.CENTER));
		p.add(new JLabel(PERIODOS[0],JLabel.CENTER));
		p.add(elementos[0]);
		p.add(new JLabel("<html><p style=\"text-align:center;\">"+GRUPOS[0][1]+"</p><p style=\"text-align:center;\">"+GRUPOS[1][1]+"</html>", JLabel.CENTER));
		for (int i=1;i<=10;i++) {
			JButton b = new JButton();
			p.add(b);
			b.setVisible(false);
		}
		for (int i=12;i<=16;i++) {
			p.add(new JLabel("<html><p style=\"text-align:center;\">"+GRUPOS[0][i]+"</p><p style=\"text-align:center;\">"+GRUPOS[1][i]+"</html>", JLabel.CENTER));
		}
		p.add(elementos[1]);
		p.add(new JLabel(PERIODOS[1],JLabel.CENTER));

		for (int i=2;i<=3;i++) {
			p.add(elementos[i]);
		}

		for (int i=1;i<=10;i++) {
			JButton b = new JButton();
			p.add(b);
			b.setVisible(false);
		}

		for (int i=4;i<=9;i++) {
			p.add(elementos[i]);
		}

		p.add(new JLabel(PERIODOS[2],JLabel.CENTER));

		for (int i=10;i<=11;i++) {
			p.add(elementos[i]);
		}

		for (int i=2;i<=11;i++) {
			p.add(new JLabel("<html><p style=\"text-align:center;\">"+GRUPOS[0][i]+"</p><p style=\"text-align:center;\">"+GRUPOS[1][i]+"</html>", JLabel.CENTER));
		}
		for (int i=12;i<=17;i++) {
			p.add(elementos[i]);
		}

		p.add(new JLabel(PERIODOS[3],JLabel.CENTER));

		for (int i=18;i<=35;i++) {
			p.add(elementos[i]);
		}
		p.add(new JLabel(PERIODOS[4],JLabel.CENTER));

		for (int i=36;i<=53;i++) {
			p.add(elementos[i]);
		}

		p.add(new JLabel(PERIODOS[5],JLabel.CENTER));

		for (int i=54;i<=55;i++) {
			p.add(elementos[i]);
		}

		p.add(new JLabel("57-71",JLabel.CENTER));

		for (int i=71;i<=85;i++) {
			p.add(elementos[i]);
		}
		p.add(new JLabel(PERIODOS[6],JLabel.CENTER));

		for (int i=86;i<=87;i++) {
			p.add(elementos[i]);
		}

		p.add(new JLabel("89-103",JLabel.CENTER));

		for (int i=103;i<=117;i++) {
			p.add(elementos[i]);
		}

		for (int i=1;i<=21;i++) {
			JButton b = new JButton();
			p.add(b);
			b.setVisible(false);
		}

		p.add(new JLabel("Lantánidos",JLabel.CENTER));

		for (int i=56;i<=70;i++) {
			p.add(elementos[i]);
		}

		for (int i=1;i<=3;i++) {
			JButton b = new JButton();
			p.add(b);
			b.setVisible(false);
		}

		p.add(new JLabel("Actínidos",JLabel.CENTER));

		for (int i=88;i<=102;i++) {
			p.add(elementos[i]);
		}




		return p;
	}




	/**
	 * Preparación de la barra de menús
	 */
	private void preparaMenu()
	{
		barMenu = new JMenuBar();

		mConsultas     = new JMenu("Consultas");
		mAñadir= new JMenu("Insertar");
		mConTipo = new JMenu("Consulta por tipo");
		itTipos = new JMenuItem[10];

		for (int i=0; i<itTipos.length;i++) {

			itTipos[i]=new JMenuItem(TIPOS[i]);
			itTipos[i].setActionCommand(TIPOS[i]);
			mConTipo.add(itTipos[i]);
		}


		itAñadir = new JMenuItem("Añadir Elemento");
		itAñadir.setActionCommand("Añadir");

		itConGen= new JMenuItem("Tabla Elementos");
		itConGen.setActionCommand("");

		mAñadir.add(itAñadir);
		mConsultas.add(itConGen);
		mConsultas.addSeparator();
		mConsultas.add(mConTipo);
		barMenu.add(mConsultas);
		barMenu.add(mAñadir);
	}


	/**
	 * Método que da control a los botones
	 *    - A los botones de navegación les añadiremos el control de ratón
	 *    - A los bototes de mantenimiento (nuevo, eliminar, ...) les añadiremos
	 *      control de acción
	 */
	public void control(Controlador ctr) {

		for(int i=0;i<elementos.length;i++) {
			elementos[i].addActionListener(ctr);
		}
		
		itAñadir.addActionListener(ctr);
		for(int i=0;i<itTipos.length;i++) {
			itTipos[i].addActionListener(ctr);
		}
		
		itConGen.addActionListener(ctr);
		
	}


	public JButton[] getElementos() {
		return elementos;
	}


	public JMenuBar getBarMenu() {
		return barMenu;
	}


	public JMenu getmConsultas() {
		return mConsultas;
	}


	public JMenu getmAñadir() {
		return mAñadir;
	}


	public JMenu getmConTipo() {
		return mConTipo;
	}


	public JMenuItem getItConGen() {
		return itConGen;
	}


	public JMenuItem[] getItTipos() {
		return itTipos;
	}


	public JLabel getTitulo() {
		return titulo;
	}


	public String[] getPERIODOS() {
		return PERIODOS;
	}


	public String[] getTIPOS() {
		return TIPOS;
	}


	public JMenuItem getItAñadir() {
		return itAñadir;
	}



}
