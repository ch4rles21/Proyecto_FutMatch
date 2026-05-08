package servicio;

import java.util.Scanner;
import dominio.Organizador;
import persistencia.OrganizadorDao;

public class OrganizadorServicio implements IOrganizadorServicio {
	private final Scanner sc;
	private OrganizadorDao organizadorDao;

	public OrganizadorServicio(Scanner sc) {
		this.sc = sc;
		this.organizadorDao = new OrganizadorDao();
	}

	@Override
	public Organizador hacerLogin() {
		System.out.println("--- Login de Organizador ---");
		System.out.print("Introduce nombre del organizador: ");
		String nombre = sc.nextLine();
		System.out.print("Introduce contraseña: ");
		String contrasenia = sc.nextLine();

		Organizador organizador = organizadorDao.login(nombre, contrasenia);

		if (organizador == null) {
			System.out.println("Error: Credenciales de organizador no válidas.");
		}
		return organizador;
	}

	@Override
	public void registrarOrganizador() {
		System.out.println("Registro de Nuevo Organizador");
		System.out.print("Nombre Organizador: ");
		String nombre = sc.nextLine();
		System.out.print("Correo de contacto: ");
		String correo = sc.nextLine();
		System.out.print("Contraseña: ");
		String contrasenia = sc.nextLine();
		System.out.print("Teléfono de contacto: ");
		String telefono = sc.nextLine();

		Organizador nuevoOrganizador = new Organizador(nombre, correo, contrasenia, telefono);

		if (organizadorDao.registrar(nuevoOrganizador)) {
			System.out.println("REGISTRO COMPLETADO");
		} else {
			System.out.println("Error: El nombre '" + nombre + "' ya está registrado.");
		}
	}
}