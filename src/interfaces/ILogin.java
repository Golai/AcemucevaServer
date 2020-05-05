package interfaces;

import java.rmi.RemoteException;

import persistence.Login;

public interface ILogin {
	Login ingresar(int cedula, String nombre, String password, String email, int celular) throws RemoteException;

}
