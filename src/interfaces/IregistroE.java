package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.Date;

import persistence.RegistroE;

public interface IregistroE extends Remote{
	boolean addRegistroEventos(int id_registro,
							int id_evento,
							int id_miembro,
							int id_asistente,
							Date fecha_registro,
							String asistencia) throws RemoteException;
	boolean delRegistroEvento(int id_registro) throws RemoteException;
	boolean updateRegistroEvento(Date fecha_registro, boolean asistencia) throws RemoteException;
	RegistroE seachAsisEvento(int id_asistente) throws RemoteException;
	RegistroE seachMiemEvento(int id_miembro) throws RemoteException;
}
