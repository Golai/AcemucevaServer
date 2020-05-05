package logic;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Date;

import interfaces.IEvento;
import persistence.Evento;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateEvento(int id_evento, int id_encargado, String nombre_evento, String descripcion, Date fecha,
			String lugar, String hora, int cupos, int puntos, String tipo_evento) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delEvento(int id_evento) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addEvento(int id_evento, int id_encargado, String nombre_evento, String descripcion, Date fecha,
			String lugar, String hora, int cupos, int puntos, String tipo_evento) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}


}
