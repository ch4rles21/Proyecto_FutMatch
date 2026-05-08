package servicio;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.HashMap;
import dominio.Categoria;
import dominio.Evento;
import dominio.Organizador;
import dominio.Usuario;
import persistencia.CategoriaDao;
import persistencia.EventoDao;

public class EventoServicio implements IEventoServicio {
	private final Scanner sc;
	private EventoDao eventoDao;
	private CategoriaDao categoriaDao;

	public EventoServicio(Scanner sc) {
		this.sc = sc;
		this.eventoDao = new EventoDao();
		this.categoriaDao = new CategoriaDao();
	}

	@Override
	public void mostrarEventos() {
		System.out.println("Todos los Eventos");
		HashMap<String, Evento> eventos = eventoDao.obtenerEventos();
		if (eventos.isEmpty()) {
			System.out.println("No hay eventos registrados.");
		} else {
			for (Evento e : eventos.values()) {
				imprimirDetalleEvento(e);
			}
		}
	}

	@Override
	public void mostrarEventosUsuario(Usuario usuario) {
		System.out.println("Mis Inscripciones (" + usuario.getNombre());
		boolean tiene = false;
		for (Evento e : eventoDao.obtenerEventos().values()) {
			if (e.getAsistentes().contains(usuario)) {
				System.out.println("- " + e.getNombre() + " (" + e.getFecha() + ")");
				tiene = true;
			}
		}
		if (!tiene)
			System.out.println("No estás inscrito en ningún evento.");
	}

	@Override
	public void inscribirUsuario(Usuario usuario) {
		System.out.print("Introduce el nombre del evento al que quieres unirte: ");
		String nombre = sc.nextLine();
		Evento e = eventoDao.obtenerEventos().get(nombre);

		if (e != null) {
			if (e.getAsistentes().add(usuario)) {
				System.out.println("Inscripción realizada con éxito en: " + nombre);
			} else {
				System.out.println("Ya estabas inscrito en este evento.");
			}
		} else {
			System.out.println("El evento no existe.");
		}
	}

	@Override
	public void cancelarInscripcion(Usuario usuario) {
		System.out.print("Introduce el nombre del evento para anular inscripción: ");
		String nombre = sc.nextLine();
		Evento e = eventoDao.obtenerEventos().get(nombre);

		if (e != null && e.getAsistentes().remove(usuario)) {
			System.out.println("Inscripción cancelada.");
		} else {
			System.out.println("No se pudo realizar la cancelación");
		}
	}

	@Override
	public void mostrarEventosOrganizador(Organizador organizador) {
		System.out.println("Eventos Creados por " + organizador.getNombre());
		for (Evento e : eventoDao.obtenerEventos().values()) {
			if (e.getOrganizador().equals(organizador)) {
				System.out.println("- " + e.getNombre() + " | Asistentes: " + e.getAsistentes().size());
			}
		}
	}

	@Override
	public void crearEvento(Organizador organizador) {
		System.out.println("Crear Nuevo Evento");
		System.out.print("Nombre: ");
		String nombre = sc.nextLine();
		System.out.print("Descripción: ");
		String desc = sc.nextLine();

		LocalDate fecha = null;
		while (fecha == null) {
			try {
				System.out.print("Fecha (AAAA-MM-DD): ");
				fecha = LocalDate.parse(sc.nextLine());
			} catch (DateTimeParseException e) {
				System.out.println("Formato incorrecto.");
			}
		}

		System.out.print("Hora (HH:MM): ");
		LocalTime hora = LocalTime.parse(sc.nextLine());
		System.out.print("Duración (minutos): ");
		int duracion = Integer.parseInt(sc.nextLine());
		System.out.print("Ubicación: ");
		String ubi = sc.nextLine();

		CategoriaServicio catServ = new CategoriaServicio(sc);
		Categoria cat = catServ.buscarCategoria();

		if (cat != null) {
			Evento nuevo = new Evento(nombre, desc, fecha, hora, duracion, ubi, cat, organizador);
			if (eventoDao.insertarEvento(nuevo)) {
				System.out.println("Evento creado.");
			} else {
				System.out.println("Error: Ya existe un evento con ese nombre.");
			}
		}
	}

	private void imprimirDetalleEvento(Evento e) {
		System.out.println("[" + e.getCategoria().getNombre() + "] " + e.getNombre());
		System.out.println("Fecha: " + e.getFecha() + " a las " + e.getHora());
		System.out.println("Lugar: " + e.getUbicacion());
		System.out.println("Organizador: " + e.getOrganizador().getNombre());
	}
}