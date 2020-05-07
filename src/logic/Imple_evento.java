package logic;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;

import interfaces.IEvento;
import persistence.Evento;
import persistence.EventoDAO;
import persistence.NotFoundException;


public class Imple_evento extends UnicastRemoteObject implements IEvento{

	public Imple_evento() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Evento searchEvento(int id_evento) throws RemoteException {
		// crear el value object a retornar
		Evento u = new Evento(id_evento);
		// crear los DAO a manipular
		EventoDAO user = new EventoDAO();

		try {
			user.load(getConnection(), u);
		} catch (SQLException e) {
			u = null;
			e.printStackTrace();
		} catch (NotFoundException e) {
			u = null;
			e.printStackTrace();
		}
		return u;
	}

	@Override
	public boolean updateEvento(int id_evento, int id_encargado, String nombre_evento, String descripcion, Date fecha,
			String lugar, String hora, int cupos, int puntos, String tipo_evento) throws RemoteException {
		boolean update = true;
		// crear el value object a actualizar
		Evento e1 = new Evento();
		e1.setAll(id_evento, id_encargado, nombre_evento, descripcion, fecha, lugar, hora, cupos, puntos, tipo_evento);
		// crear los DAO a manipular
		EventoDAO evento = new EventoDAO();

		try {
			evento.save(getConnection(), e1);
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
	public boolean delEvento(int id_evento) throws RemoteException {
		boolean del = true;
		// crear el value object a eliminar
		Evento a = new Evento(id_evento);
		// crear los DAO a manipular
		EventoDAO evento = new EventoDAO();

		try {
			evento.delete(getConnection(), a);
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
	public boolean addEvento(int id_evento, int id_encargado, String nombre_evento, String descripcion, Date fecha,
			String lugar, String hora, int cupos, int puntos, String tipo_evento) throws RemoteException {
		
		boolean add = true;
		// crear el value object de user
		Evento a = new Evento(id_evento);
		a.setId_encargado(id_encargado);
		a.setNombre_evento(nombre_evento);
		a.setDescripcion(descripcion);
		a.setFecha(fecha);
		a.setLugar(lugar);
		a.setHora(hora);
		a.setCupos(cupos);
		a.setPuntos(puntos);
		a.setTipo_evento(tipo_evento);
		

		// crear el DAO a manipular
		EventoDAO evento = new EventoDAO();

		try {
			evento.create(getConnection(), a);
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
																											// contrase�a=postgres
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}