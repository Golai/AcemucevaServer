package logic;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


import interfaces.IAsistente;
import persistence.Asistente;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateAsistente(int cedula, String nombre, int celular, String email) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delAsistente(int id_evento) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAsistente(int cedula, String nombre, int celular, String email) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	
}
