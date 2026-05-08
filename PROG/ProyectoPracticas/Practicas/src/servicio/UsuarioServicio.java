package servicio;

import java.util.Scanner;
import dominio.Usuario;
import persistencia.UsuarioDao;

public class UsuarioServicio implements IUsuarioServicio {
	private final Scanner sc;
	private UsuarioDao usuarioDao;

	public UsuarioServicio(Scanner sc) {
		this.sc = sc;
		this.usuarioDao = new UsuarioDao();
	}

	@Override
	public Usuario hacerLogin() {
		System.out.println("--- Login de Usuario ---");
		System.out.print("Introduce tu nombre: ");
		String nombre = sc.nextLine();
		System.out.print("Introduce tu contraseña: ");
		String contrasenia = sc.nextLine();

		Usuario usuario = usuarioDao.login(nombre, contrasenia);

		if (usuario == null) {
			System.out.println("Error: Nombre o contraseña incorrectos.");
		}
		return usuario;
	}

	@Override
	public void registrarUsuario() {
		System.out.println("Registro de Nuevo Usuario");
		System.out.print("Nombre de usuario: ");
		String nombre = sc.nextLine();
		System.out.print("Correo electrónico: ");
		String correo = sc.nextLine();
		System.out.print("Contraseña: ");
		String contrasenia = sc.nextLine();

		Usuario nuevoUsuario = new Usuario(nombre, correo, contrasenia);

		if (usuarioDao.registrar(nuevoUsuario)) {
			System.out.println("REGISTRO COMPLEATADO");
		} else {
			System.out.println("Error: El nombre de usuario '" + nombre + "' ya existe.");
		}
	}
}