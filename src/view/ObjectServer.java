package view;

import java.net.MalformedURLException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import logic.*;

public class ObjectServer {

	public static void main(String[] args) throws RemoteException, MalformedURLException{
		Imple_asistente impl1 = new Imple_asistente();
		Imple_evento impl2 = new Imple_evento();
		Imple_login impl3 = new Imple_login();
		Imple_miembro impl4 = new Imple_miembro();
		Imple_novedad impl5 = new Imple_novedad();
		Imple_registroE impl6 = new Imple_registroE();
		Imple_visualizarR impl7 = new Imple_visualizarR();
		
		Registry r = LocateRegistry.createRegistry(10000);
		r.rebind("Asistente", (Remote) impl1);
		System.out.println("Objeto Asistente Publicado");
		
		r.rebind("Evento", (Remote) impl2);
		System.out.println("Objeto Evento Publicado");
		
		r.rebind("Login", (Remote) impl3);
		System.out.println("Objeto Login Publicado");
		
		r.rebind("Miembro", (Remote) impl4);
		System.out.println("Objeto Miembro Publicado");
		
		r.rebind("Novedad", (Remote) impl5);
		System.out.println("Objeto Novedad Publicado");
		
		r.rebind("RegistroEventos", (Remote) impl6);
		System.out.println("Objeto Registro Eventos Publicado");
		
		r.rebind("VisualizarRanking", (Remote) impl6);
		System.out.println("Objeto Visualizar Ranking Publicado");
		
		


	}

}
