package logic;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import interfaces.INovedad;
import persistence.NotFoundException;
import persistence.Novedad;
import persistence.NovedadDAO;
public class Imple_novedad  extends UnicastRemoteObject implements INovedad {

	public Imple_novedad() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Novedad searchNovedad(int id_novedad) throws RemoteException {
		// crear el value object a retornar
		Novedad n = new Novedad(id_novedad);
		// crear los DAO a manipular
		NovedadDAO novedad = new NovedadDAO();

		try {
			novedad.load(getConnection(), n);
		} catch (SQLException e) {
			n = null;
			e.printStackTrace();
		} catch (NotFoundException e) {
			n = null;
			e.printStackTrace();
		}
		return n;
	}


	@Override
	public boolean updateNovedad(int id_novedades, int id_encargado, String titulo, String descripcion,
			String tipo_novedad) throws RemoteException {
		boolean update = true;
		// crear el value object a actualizar
		Novedad n = new Novedad();
		n.setAll(id_novedades, id_encargado, titulo, descripcion, tipo_novedad);
		// crear los DAO a manipular
		NovedadDAO novedad = new NovedadDAO();

		try {
			novedad.save(getConnection(), n);
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
	public boolean delNovedad(int id_novedades) throws RemoteException {
		boolean del = true;
		// crear el value object a eliminar
		Novedad n = new Novedad(id_novedades);
		// crear los DAO a manipular
		NovedadDAO novedad = new NovedadDAO();

		try {
			novedad.delete(getConnection(), n);
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
	public boolean addNovedad(int id_novedades, int id_encargado, String titulo, String descripcion,
			String tipo_novedad) throws RemoteException {
		boolean add = true;

		Novedad n = new Novedad(id_novedades);
		n.setId_encargado(id_encargado);
		n.setTitulo(titulo);
		n.setDescripcion(descripcion);
		n.setTipo_novedad(tipo_novedad);

		NovedadDAO novedad = new NovedadDAO();

		try {
			novedad.create(getConnection(), n);
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
