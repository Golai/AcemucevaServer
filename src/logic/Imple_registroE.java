package logic;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Date;

import interfaces.IregistroE;
import persistence.RegistroE;

public class Imple_registroE extends UnicastRemoteObject implements IregistroE {

	protected Imple_registroE() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public boolean registroEventos(int id_registro, int id_evento, int id_miembro, int id_asistente,
			Date fecha_registro, boolean asistencia) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addRegistroEvento(int cedula, int id_evento) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delRegistroEvento(int cedula, int id_evento) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateRegistroEvento(int cedula, int id_evento, boolean asistencia) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public RegistroE seachAsisEvento(int id_asistente) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RegistroE seachMiemEvento(int id_miembro) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}


}
