package prTablaPeriodica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CrearTablas {

	public static void main(String[] args) {
		Connection conexion = null;
		try {
			String driver   = "com.mysql.jdbc.Driver";
			String url      = "jdbc:mysql://localhost:3306/tabla_periodica";
  	        String login    = "admin";
		    String password = "1234";
			
			Class.forName(driver);
			conexion = DriverManager.getConnection(url, login, password);
			         
			System.out.println("Conexión establecida");
			creaTablaElementos(conexion, "tabla_periodica");  // Crea la tabla
			creaTablaCaracteristicas(conexion, "tabla_periodica");
			
		}
		
		catch (SQLException e2) {
			printSQLException(e2); 
		}
		catch (Exception e1) {
			e1.printStackTrace();
		}
		finally {
			try {
				conexion.close();
			} catch (SQLException e) {
				e.printStackTrace();;
			}
		}
	}

	
	public static void creaTablaElementos(Connection con, String BDNombre) throws SQLException
	{
  	    String creaTabla =
				 "create table " + BDNombre + ".ELEMENTOS " +
                 "(n_atomico INT NOT NULL, "  +
                 "simbolo VARCHAR(30) NOT NULL, " +
                 "nombre VARCHAR(30) NOT NULL, "+
                 "peso_atomico double NOT NULL, " +
                 "tipo VARCHAR(30) NOT NULL, "+
                 "estado_ambiente VARCHAR(30) NOT NULL, "+
                 " PRIMARY KEY(n_atomico));";
   	    
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			stmt.executeUpdate(creaTabla);
			System.out.println("Tabla ELEMENTOS creada.");
		}
		catch(SQLException e) {
			printSQLException(e);
		}
		finally {
			stmt.close();
		}
	}

	public static void creaTablaCaracteristicas(Connection con, String BDNombre) throws SQLException
	{
  	    String creaTabla =
				 "create table " + BDNombre + ".CARACTERISTICAS " +
                 "(cod_caract INT NOT NULL AUTO_INCREMENT, "  +
                 "n_atomico INT NOT NULL, " +
                 "descripcion VARCHAR(1000) NOT NULL, "+
                 " PRIMARY KEY(cod_caract),"+ 
                 "FOREIGN KEY (n_atomico) REFERENCES ELEMENTOS(n_atomico));";
   	    
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			stmt.executeUpdate(creaTabla);
			System.out.println("Tabla CARACTERISTICAS creada.");
		}
		catch(SQLException e) {
			printSQLException(e);
		}
		finally {
			stmt.close();
		}
	}
		
	
	
	
	public static void printSQLException(SQLException ex){
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

}
