package dominio;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;

public class Evento {
	private String nombre;
	private String descripcion;
	private LocalDate fecha;
	private LocalTime hora;
	private int duracion;
	private String ubicacion;
	private Categoria categoria;
	private Organizador organizador;
	private HashSet<Usuario> asistentes;

	public Evento(String nombre, String descripcion, LocalDate fecha, LocalTime hora, int duracion, String ubicacion,
			Categoria categoria, Organizador organizador) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.hora = hora;
		this.duracion = duracion;
		this.ubicacion = ubicacion;
		this.categoria = categoria;
		this.organizador = organizador;
		this.asistentes = new HashSet<>(); 
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Organizador getOrganizador() {
		return organizador;
	}

	public void setOrganizador(Organizador organizador) {
		this.organizador = organizador;
	}

	public HashSet<Usuario> getAsistentes() {
		return asistentes;
	}

	public void setAsistentes(HashSet<Usuario> asistentes) {
		this.asistentes = asistentes;
	}

	@Override
	public String toString() {
		return "Evento [nombre=" + nombre + ", descripcion=" + descripcion + ", fecha=" + fecha + ", hora=" + hora
				+ ", duracion=" + duracion + ", ubicacion=" + ubicacion + ", categoria=" + categoria + ", organizador="
				+ organizador + ", asistentes=" + asistentes + "]";
	}


}
