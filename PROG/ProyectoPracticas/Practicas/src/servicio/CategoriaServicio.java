package servicio;

import java.util.Scanner;
import java.util.HashMap;
import dominio.Categoria;
import persistencia.CategoriaDao;

public class CategoriaServicio implements ICategoriaServicio {
	private final Scanner sc;
	private CategoriaDao categoriaDao;

	public CategoriaServicio(Scanner sc) {
		this.sc = sc;
		this.categoriaDao = new CategoriaDao();
	}

	@Override
	public Categoria buscarCategoria() {
		System.out.println("Categorías Disponibles");
		HashMap<String, Categoria> categorias = categoriaDao.obtenerCategorias();

		for (String nombre : categorias.keySet()) {
			System.out.println("- " + nombre);
		}

		System.out.print("Escribe el nombre de la categoría: ");
		String seleccion = sc.nextLine();

		Categoria cat = categoriaDao.obtenerCategoria(seleccion);
		if (cat == null) {
			System.out.println("Categoría no encontrada.");
		}
		return cat;
	}
}