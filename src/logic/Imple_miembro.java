package logic;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import interfaces.IMiembro;
import persistence.Miembro;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateMiembro(int cedula, int id_cargo, String nombre, int celular, int semestre, int puntos)
			throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delMiembro(int cedula) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addEvento(int cedula, int id_cargo, String nombre, int celular, int semestre, int puntos)
			throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}


}
