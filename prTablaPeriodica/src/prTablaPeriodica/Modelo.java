package prTablaPeriodica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.swing.table.DefaultTableModel;



public class Modelo {

	private Connection conex; // Objecto con la conexión a la BD
	private Statement stmt; // Objeto que permite ejecutar sentencias SQL
	private ResultSet rs; // Resultados de la consulta
	
	
	public Modelo () throws SQLException, MiExcepcion {
		this.estableceConexion();
		
		this.crearStatement();
		
	
	}
	
	
	public void estableceConexion() throws SQLException, MiExcepcion {
		String driver   = "com.mysql.jdbc.Driver";
		String url      = "jdbc:mysql://localhost:3306/tabla_periodica";
	        String login    = "admin";
	    String password = "1234";
		
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			throw new MiExcepcion("Driver erróneo");
		}
		this.conex = DriverManager.getConnection(url, login, password);
	}

	public void cerrarConexion() throws SQLException {

		conex.close();
	}

	public void crearStatement() throws SQLException {

		stmt = conex.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
	}

	public void cerrarStatement() throws SQLException {
		stmt.close();
	}
	
	public void crearConsultaElementos(int nAtomico) throws SQLException {
		String sqlString = "SELECT * FROM ELEMENTOS where n_atomico="+nAtomico+";";
		rs= stmt.executeQuery(sqlString);
		
	}
	
	public void crearConsultaCaract(int nAtomico) throws SQLException {
		String sqlString = "SELECT descripcion FROM caracteristicas where n_atomico="+nAtomico+";";
		rs= stmt.executeQuery(sqlString);
		
	}

	
	
	public Elemento getElemento(int nAtomico) throws SQLException {
		crearConsultaElementos(nAtomico);
		
		rs.first();
		return this.crearElemento();
		
	}
	
	
	
	public List<String> getCaractElemento(int nAtomico) throws SQLException {
		crearConsultaCaract(nAtomico);
		List<String> lista = new ArrayList<String>();
	
			while(rs.next()) {
			lista.add(rs.getString("descripcion"));
			
		}
		
		return lista;
	}
	
	
	
	private Elemento crearElemento() throws SQLException {
		return new Elemento(rs.getInt("n_atomico"),
				rs.getString("simbolo"),
				rs.getString("nombre"),
				rs.getDouble("peso_Atomico"),
				rs.getString("estado_ambiente"), getCaractElemento(rs.getInt("n_atomico")));
	}
	
	public void insertarElemento(Elemento ob) throws SQLException {
		String sqlString="insert into tabla_periodica.elementos values("+
				ob.getNumAtomico()+", '"+
				ob.getSimbolo()+"', '"+
				ob.getNombre()+"', "+
				ob.getPesoAtomico()+",'"+
				ob.getTipo()+"', '"+
				ob.getEstadoAmbiente()+"')";
		
		stmt.executeUpdate(sqlString);
		
		
	}
	public void insertarCaracteristicas(Elemento ob) throws SQLException {
		
		Iterator<String> it = ob.getCaracteristicas().iterator();
		int numAtomico =ob.getNumAtomico();
		
		while (it.hasNext()) {
			
		
		String sqlString="insert into tabla_periodica.caracteristicas (n_atomico, descripcion) values("+
				numAtomico+", '"+
				it.next()+"')";
		
		
		stmt.executeUpdate(sqlString);
		
		}
	}
	
	public void modificarElemento(Elemento ob) throws SQLException {
		
		eliminarCaracteristicas(ob.getNumAtomico());
		
		String sqlString="update tabla_periodica.elementos set "+
				"simbolo= '"+ob.getSimbolo()+"',"+
				"nombre= '"+ob.getNombre()+"', "+
				"peso_atomico= "+ob.getPesoAtomico()+", "+
				"tipo= '"+ob.getTipo()+"',"+
				"estado_ambiente= '"+ob.getEstadoAmbiente()+"' "+
				"where n_atomico= "+ob.getNumAtomico()+";";
		
	
		
		stmt.executeUpdate(sqlString);
		
		insertarCaracteristicas(ob);
		
	
	}
	
	public void eliminarCaracteristicas (int cod) throws SQLException {
		String sqlString="delete from tabla_periodica.caracteristicas where caracteristicas.n_atomico="+cod;

		stmt.executeUpdate(sqlString);

		
	}
	
	public void eliminarElemento(int cod) throws SQLException {
		eliminarCaracteristicas(cod);
		
		String sqlString="delete from tabla_periodica.elementos where elementos.n_atomico="+cod;
		
		stmt.executeUpdate(sqlString);
		
		
	}
	
	public void printSQLException(SQLException ex)
	{
		ex.printStackTrace(System.err);
		System.err.println("SQLState: "+ex.getSQLState());
		System.err.println("Error code: "+ex.getErrorCode());
		System.err.println("Message: "+ex.getMessage());
		Throwable t = ex.getCause();
		while (t!=null) {
			System.out.println("Cause: "+t);
			t = t.getCause();
		}
	}
	
	
	/**
	 * --- FORMA 2 ----

	 * Método que devuelve un objeto DefaultTableModel
	 * que contiene el resultado de una consulta
	 * @return
	 * @throws SQLException
	 */
	public DefaultTableModel datosConsulta(String consul) throws SQLException{
		// Crear la consulta	
		String consulta;
		
		
		if( consul.equals("Tabla Completa")) 
			 consulta = "select * from elementos;";
		
		else
			consulta = "select * from elementos where tipo='"+consul+"';";
			
		
	
		ResultSet rsConsulta = this.stmt.executeQuery(consulta);
			
		// Obtener un objeto ResultSetMetaData, para obtener información de la tabla
		ResultSetMetaData rsmd = rsConsulta.getMetaData();
		
		// Obtener el número de columnas de esta consulta
		int numColumnas = rsmd.getColumnCount();
	
		// Crear un objeto DefaultTableModel, para guardar el resultado de la consulta
		DefaultTableModel datos = new DefaultTableModel();
		
		
		
		// Segunda forma
			String [] nombreColumnas = {"Nº Atómico","Símbolo","Nombre","Peso Atómico","Tipo","Estado a Tª ambiente"};
			datos.setColumnIdentifiers(nombreColumnas);
		
		// Añadir los datos 	
		while (rsConsulta.next()) {
			Object [] tupla = new Object[numColumnas];
			for (int i=0; i<numColumnas; i++) {
					tupla[i] = rsConsulta.getObject(i+1);
			}
		System.out.println("Tupla"+Arrays.toString(tupla));
			datos.addRow(tupla);
		}
		
		
		return datos; 
	}


	public Statement getStmt() {
		return stmt;
	}


	
	
}

