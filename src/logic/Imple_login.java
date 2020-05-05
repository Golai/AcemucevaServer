package logic;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


import interfaces.ILogin;


public class Imple_login extends UnicastRemoteObject implements ILogin{

	public Imple_login() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public boolean registrarUsu(int cedula, String nombre, String password, String email, int celular)
			throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean login(int cedula, String password) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}



}
