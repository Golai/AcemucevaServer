package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

import persistence.VisualizarR;;

public interface IVisualizarR extends Remote {
	VisualizarR listarRanking() throws RemoteException;
}
