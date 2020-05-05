package logic;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


import interfaces.ILogin;
import persistence.Login;

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
	public Login ingresar(int cedula, String nombre, String password, String email, int celular)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}



}
