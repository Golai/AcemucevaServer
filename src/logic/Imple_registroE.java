package logic;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;

import interfaces.IregistroE;
import persistence.NotFoundException;
import persistence.RegistroE;
import persistence.RegistroE_DAO;

public class Imple_registroE extends UnicastRemoteObject implements IregistroE {

	public Imple_registroE() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public RegistroE seachAsisEvento(int id_asistente) throws RemoteException {
		// crear el value object a retornar
		RegistroE r = new RegistroE(id_asistente);
		// crear los DAO a manipular
		RegistroE_DAO registro = new RegistroE_DAO();

		try {
			registro.load(getConnection(), r);
		} catch (SQLException e) {
			r = null;
			e.printStackTrace();
		} catch (NotFoundException e) {
			r = null;
			e.printStackTrace();
		}
		return r;
	}

	@Override
	public RegistroE seachMiemEvento(int id_miembro) throws RemoteException {
		// crear el value object a retornar
		RegistroE r = new RegistroE(id_miembro);
		// crear los DAO a manipular
		RegistroE_DAO registro = new RegistroE_DAO();

		try {
			registro.load(getConnection(), r);
		} catch (SQLException e) {
			r = null;
			e.printStackTrace();
		} catch (NotFoundException e) {
			r = null;
			e.printStackTrace();
		}
		return r;
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

	@Override
	public boolean addRegistroEventos(int id_registro, int id_evento, int id_miembro, int id_asistente,
			Date fecha_registro, String asistencia) throws RemoteException {
		boolean add = true;

		// crear el value object de user
		RegistroE r = new RegistroE(id_registro);
		r.setId_registro(id_registro);
		r.setId_evento(id_evento);
		r.setId_miembro(id_miembro);
		r.setId_asistente(id_asistente);
		r.setFecha_registro(fecha_registro);
		r.setAsistencia(asistencia);
		

		// crear el DAO a manipular
		RegistroE_DAO registro = new RegistroE_DAO();

		try {
			registro.create(getConnection(), r);
		} catch (SQLException e) {
			add = false;
			e.printStackTrace();
		}
		return add;
	}

	@Override
	public boolean delRegistroEvento(int id_registro) throws RemoteException {
		boolean del = true;
		// crear el value object a eliminar
		RegistroE r = new RegistroE(id_registro);
		// crear los DAO a manipular
		RegistroE_DAO registro = new RegistroE_DAO();

		try {
			registro.delete(getConnection(), r);
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
	public boolean updateRegistroEvento(Date fecha_registro, boolean asistencia) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}
}
