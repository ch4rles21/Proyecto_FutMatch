package persistencia;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;

import dominio.Evento;

public class EventoDao {
	private static HashMap<String, Evento> eventos = new HashMap<String, Evento>();
	private CategoriaDao categoriaDao;
	private OrganizadorDao organizadorDao;
	
	public EventoDao() {
		this.categoriaDao = new CategoriaDao();
		this.organizadorDao = new OrganizadorDao();
		
		eventos.put("Final Champions", new Evento("Final Champions", "Final de la Champions League", LocalDate.of(2026, 5, 30), LocalTime.of(21, 0), 105, "Puskás Aréna", categoriaDao.obtenerCategoria("Partido de futbol"), organizadorDao.obtenerOrganizador("Florentino")));
		eventos.put("Concierto Rosalia", new Evento("Concierto Rosalia", "Viene la Rosalía a tocar. ¡Tra tra!.", LocalDate.of(2026, 4, 4), LocalTime.of(20, 30), 100, "WiZink Center", categoriaDao.obtenerCategoria("Concierto"), organizadorDao.obtenerOrganizador("Empresa")));
	}
	
	public HashMap<String,Evento> obtenerEventos() {
		return eventos;
	}
	
	public boolean insertarEvento(Evento evento) {
		if(eventos.containsKey(evento.getNombre())) {
			return false;
		} else {
			eventos.put(evento.getNombre(), evento);
			return true;
		}
	}
	
	
}
