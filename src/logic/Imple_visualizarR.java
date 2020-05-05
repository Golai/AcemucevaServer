package logic;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import interfaces.IVisualizarR;
import persistence.VisualizarR;

public class Imple_visualizarR extends UnicastRemoteObject implements IVisualizarR {

	protected Imple_visualizarR() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public VisualizarR listarRanking() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
