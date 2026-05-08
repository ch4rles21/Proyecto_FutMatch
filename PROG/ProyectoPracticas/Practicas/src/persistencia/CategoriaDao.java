package persistencia;

import java.util.HashMap;

import dominio.Categoria;

public class CategoriaDao {
	private static HashMap<String, Categoria> categorias = new HashMap<String, Categoria>();
	
	public CategoriaDao() {
		categorias.put("Concierto", new Categoria("Concierto","La gente paga por ver a otra gente tocar en un escenario"));
		categorias.put("Partido de futbol", new Categoria("Partido de futbol","La gente paga por ver a otra gente dar patadas a un balón"));
	}
	
	public Categoria obtenerCategoria(String nombre) {
		return categorias.get(nombre);
	}
	
	public HashMap<String, Categoria> obtenerCategorias(){
		return categorias;
	}
	
}
