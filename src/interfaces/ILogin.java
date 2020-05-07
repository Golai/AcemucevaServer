package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface ILogin extends Remote{
	boolean registrarUsu(int cedula, String nombre, String password, String email, int celular) throws RemoteException;
	boolean login(int cedula, String password)  throws RemoteException;

}
