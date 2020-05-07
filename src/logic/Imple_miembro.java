package logic;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import interfaces.IMiembro;
import persistence.Miembro;
import persistence.MiembroDAO;
import persistence.NotFoundException;

public class Imple_miembro extends UnicastRemoteObject implements IMiembro{

	public Imple_miembro() throws RemoteException {
		super();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Miembro searchMiembro(int cedula) throws RemoteException {
		// crear el value object a retornar
		Miembro a = new Miembro(cedula);
		// crear los DAO a manipular
		MiembroDAO miembro = new MiembroDAO();

		try {
			miembro.load(getConnection(), a);
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
	public boolean updateMiembro(int cedula, int id_cargo, String nombre, int celular, int semestre, int puntos)
			throws RemoteException {
		boolean update = true;
		// crear el value object a actualizar
		Miembro m = new Miembro();
		m.setAll(cedula,id_cargo, nombre, celular, semestre, puntos);
		// crear los DAO a manipular
		MiembroDAO miembro = new MiembroDAO();

		try {
			miembro.save(getConnection(), m);
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
	public boolean delMiembro(int cedula) throws RemoteException {
		boolean del = true;
		// crear el value object a eliminar
		Miembro m = new Miembro(cedula);
		// crear los DAO a manipular
		MiembroDAO miembro = new MiembroDAO();

		try {
			miembro.delete(getConnection(), m);
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
	public boolean addEvento(int cedula, int id_cargo, String nombre, int celular, int semestre, int puntos)
			throws RemoteException {
		boolean add = true;

		// crear el value object de user
		Miembro a = new Miembro(cedula);
		a.setId_cargo(id_cargo);
		a.setNombre(nombre);
		a.setCelular(celular);
		a.setSemestre(semestre);
		a.setPuntos(puntos);

		// crear el DAO a manipular
		MiembroDAO asistente = new MiembroDAO();

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
