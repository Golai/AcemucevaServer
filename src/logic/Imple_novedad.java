package logic;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import interfaces.INovedad;
import persistence.Novedad;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateNovedad(int id_novedades, int id_encargado, String titulo, String descripcion,
			String tipo_novedad) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delNovedad(int id_novedades) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addNovedad(int id_novedades, int id_encargado, String titulo, String descripcion,
			String tipo_novedad) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}


}
