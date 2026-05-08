package persistencia;

import java.util.HashMap;

import dominio.Organizador;

public class OrganizadorDao {
	private static HashMap<String, Organizador> organizadores = new HashMap<String, Organizador>();

	public OrganizadorDao() {
		organizadores.put("Florentino", new Organizador("Florentino", "florentino@gmail.com", "Champions15", "612345678"));
		organizadores.put("Empresa", new Organizador("Empresa", "empresa@gmail.com", "GanasDinero", "698765432"));
	}

	public Organizador login(String nombre, String contrasenia) {
		Organizador organizador = organizadores.get(nombre);

		if (organizador != null) {
			if (organizador.getContrasenia().equals(contrasenia)) {
				return organizador;
			}
		}

		return null;
	}

	public boolean registrar(Organizador organizador) {
		if (organizadores.containsKey(organizador.getNombre())) {
			return false;
		} else {
			organizadores.put(organizador.getNombre(), organizador);
			return true;
		}
	}

	public Organizador obtenerOrganizador(String nombre) {
		return organizadores.get(nombre);
	}
}
