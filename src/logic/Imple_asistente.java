package logic;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


import interfaces.IAsistente;

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

	
}
