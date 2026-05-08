package servicio;

import dominio.Organizador;
import dominio.Usuario;

public interface IEventoServicio {
	public void mostrarEventos();
	public void mostrarEventosUsuario(Usuario usuario);
	public void inscribirUsuario(Usuario usuario);
	public void cancelarInscripcion(Usuario usuario);
	public void mostrarEventosOrganizador(Organizador organizador);
	public void crearEvento(Organizador organizador);
}
