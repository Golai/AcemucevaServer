package logic;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import interfaces.ILogin;
import persistence.Asistente;
import persistence.AsistenteDAO;


public class Imple_login extends UnicastRemoteObject implements ILogin{

	public Imple_login() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public boolean registrarUsu(int cedula, String nombre, String password, String email, int celular)
			throws RemoteException {
		boolean registro = true;

		// crear el value object de user
		Asistente a = new Asistente(cedula);
		a.setNombre(nombre);
		a.setCelular(celular);
		a.setEmail(email);
		

		// crear el DAO a manipular
		AsistenteDAO asistente = new AsistenteDAO();

		try {
			asistente.create(getConnection(), a);
		} catch (SQLException e) {
			registro = false;
			e.printStackTrace();
		}
		return registro;
	}

	@Override
	public boolean login(int cedula, String password) throws RemoteException {
		return false;
	}

	
	private Connection getConnection() {
		Connection conn = null;
		try {
			// registrar la clase del driver
			Class.forName("org.postgresql.Driver");
			// obtener el objeto de conexion
			conn = DriverManager.getConnection("jdbc:postgresql://localhost/acemuceva", "postgres", "2301");// login=postgres
																											// ,
																											// contraseña=postgres
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}


}
