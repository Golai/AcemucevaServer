package interfaces;

import java.rmi.RemoteException;
import java.sql.Date;

import persistence.RegistroE;

public interface IregistroE {
	boolean registroEventos(int id_registro,
							int id_evento,
							int id_miembro,
							int id_asistente,
							Date fecha_registro,
							boolean asistencia) throws RemoteException;
	boolean addRegistroEvento(int cedula, int id_evento) throws RemoteException;
	boolean delRegistroEvento(int cedula, int id_evento) throws RemoteException;
	boolean updateRegistroEvento(int cedula, int id_evento, boolean asistencia) throws RemoteException;
	RegistroE seachAsisEvento(int id_asistente) throws RemoteException;
	RegistroE seachMiemEvento(int id_miembro) throws RemoteException;
}
