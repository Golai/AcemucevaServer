package logic;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import interfaces.IAsistente;
import persistence.Asistente;
import persistence.AsistenteDAO;
import persistence.NotFoundException;


public class Imple_asistente extends UnicastRemoteObject implements IAsistente {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Imple_asistente() throws RemoteException{
		// TODO Auto-generated constructor stub
		super();
	}

	@Override
	public boolean registrarAEventos(int id_asistente) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Asistente searchAsistente(int id_evento) throws RemoteException {
		// crear el value object a retornar
		Asistente a = new Asistente(id_evento);
		// crear los DAO a manipular
		AsistenteDAO asistente = new AsistenteDAO();

		try {
			asistente.load(getConnection(), a);
		} catch (SQLException e) {
			a = null;
			e.printStackTrace();
		} catch (NotFoundException e) {
			a = null;
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public boolean updateAsistente(int cedula, String nombre, int celular, String email) throws RemoteException {
		boolean update = true;
		// crear el value object a actualizar
		Asistente a = new Asistente();
		a.setAll(cedula, nombre, celular, email);
		// crear los DAO a manipular
		AsistenteDAO asistente = new AsistenteDAO();

		try {
			asistente.save(getConnection(), a);
		} catch (SQLException e) {
			update = false;
			e.printStackTrace();
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			update = false;
			e.printStackTrace();
		}
		return update;
	}

	@Override
	public boolean delAsistente(int id_evento) throws RemoteException {
		boolean del = true;
		// crear el value object a eliminar
		Asistente a = new Asistente(id_evento);
		// crear los DAO a manipular
		AsistenteDAO asistente = new AsistenteDAO();

		try {
			asistente.delete(getConnection(), a);
		} catch (SQLException e) {
			del = false;
			e.printStackTrace();
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			del = false;
			e.printStackTrace();
		}
		return del;
	}

	@Override
	public boolean addAsistente(int cedula, String nombre, int celular, String email) throws RemoteException {
		boolean add = true;

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
			add = false;
			e.printStackTrace();
		}
		return add;
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
