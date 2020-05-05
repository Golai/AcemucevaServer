package interfaces;

import java.rmi.RemoteException;

import persistence.VisualizarR;;

public interface IVisualizarR {
	VisualizarR listarRanking() throws RemoteException;
}
