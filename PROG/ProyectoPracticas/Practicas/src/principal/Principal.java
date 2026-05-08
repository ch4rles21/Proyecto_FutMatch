package principal;

import java.util.Scanner;

import dominio.Organizador;
import dominio.Usuario;
import servicio.EventoServicio;
import servicio.OrganizadorServicio;
import servicio.UsuarioServicio;
import util.Util;

public class Principal {

	private static Scanner sc = new Scanner(System.in);

	

	public static void main(String[] args) {
		int opcion = 0;
		boolean salir;
		
		UsuarioServicio usuarioServicio = new UsuarioServicio(sc);
		OrganizadorServicio organizadorServicio = new OrganizadorServicio(sc);
		EventoServicio eventoServicio = new EventoServicio(sc);
		
		System.out.println("¡Bienvenido!");
		
		do {
			salir = false;
			opcion = Util.pedirNumeroEntero(sc, "\nSelecciona una de las siguientes opciones:\n1.- Hacer login\n2.- Registrarse\n0.- Salir");
			
			switch(opcion) {
			case 1:
				opcion = Util.pedirNumeroEntero(sc, "\n¿Quiere hacer login como usuario normal o como organizador?:\n1.- Usuario normal\n2.- Organizador\n0.- Dar marcha atrás");
				Usuario usuario = null;
				switch(opcion) {
				case 1:
					usuario = usuarioServicio.hacerLogin();
					
					if(usuario != null) {
						System.out.println("\nBienvenido " + usuario.getNombre());
						do {
							opcion = Util.pedirNumeroEntero(sc, "¿Que desea hacer?\n1.- Ver eventos disponibles\n2.- Ver eventos a los que estoy inscrito\n3.- Inscribirme a un evento\n4.- Anular mi inscrición a un evento\n0.- Ir atrás");
							
							switch(opcion) {
							case 1:
								eventoServicio.mostrarEventos();
								System.out.println();
								break;
							case 2:
								eventoServicio.mostrarEventosUsuario(usuario);
								System.out.println();
								break;
							case 3:
								eventoServicio.inscribirUsuario(usuario);
								System.out.println();
								break;
							case 4:
								eventoServicio.cancelarInscripcion(usuario);
								System.out.println();
								break;
							case 0:
								System.out.println();
								salir = true;
								usuario = null;
								break;
							default :
								System.out.println("Por favor, introduzca una de las opciones");	
							}
						} while(!salir);
						salir = false;
					}
					break;
				case 2:
					usuario = organizadorServicio.hacerLogin();
					
					if(usuario != null) {
							System.out.println("\nBienvenido " + usuario.getNombre());
							do {
								opcion = Util.pedirNumeroEntero(sc, "¿Que desea hacer?\n1.- Ver eventos creados\n2.- Crear evento\n0.- Ir atrás");
								
								switch(opcion) {
								case 1:
									eventoServicio.mostrarEventosOrganizador((Organizador) usuario);
									System.out.println();
									break;
								case 2:
									eventoServicio.crearEvento((Organizador) usuario);
									System.out.println();
									break;
								case 0:
									salir = true;
									usuario = null;
									break;
								default :
									System.out.println("Por favor, introduzca una de las opciones");	
								}
							} while(!salir);
						}
					salir = false;
					System.out.println();
					break;
				case 0:
					System.out.println();
					break;
				default:
					System.out.println("Por favor, introduzca una de las opciones\n");
				}
				break;
			case 2:
				opcion = Util.pedirNumeroEntero(sc, "\n¿Quiere registrarse como usuario normal o como organizador?:\n1.- Usuario normal\n2.- Organizador");
				
				switch(opcion) {
				case 1:
					usuarioServicio.registrarUsuario();
					break;
				case 2:
					organizadorServicio.registrarOrganizador();
					break;
				default:
					System.out.println("Por favor, introduzca una de las opciones\n");
				}
				System.out.println();
				break;
			case 0:
				salir = true;
				break;
			default:
				System.out.println("Por favor, introduzca una de las opciones\n");
			}
		}while(!salir);sc.close();

	}

}
