package persistencia;

import java.util.HashMap;

import dominio.Usuario;

public class UsuarioDao {
	private static HashMap<String, Usuario> usuarios = new HashMap<String, Usuario>();
	
	public UsuarioDao() {
		usuarios.put("Pepito", new Usuario("Pepito","pepito@gmail.com","PepitoElMejor"));
		usuarios.put("Juanito", new Usuario("Juanito","juanito@gmail.com","JuanitoElMejor"));
		usuarios.put("Ana", new Usuario("Ana","ana@gmail.com","AnaLaMejor"));
		usuarios.put("Paula", new Usuario("Paula","paula@gmail.com","PaulaLaMejor"));
		usuarios.put("Pedrito", new Usuario("Pedrito","pedrito@gmail.com","PedritoElMejor"));
	}
	
	public Usuario login(String nombre, String contrasenia) {
		Usuario usuario = usuarios.get(nombre);
		
		if(usuario != null) {
			if(usuario.getContrasenia().equals(contrasenia)) {
				return usuario;	
			}
		}
		
		return null;
	}
	
	public boolean registrar(Usuario usuario) {
		if(usuarios.containsKey(usuario.getNombre())) {
			return false;
		} else {
			usuarios.put(usuario.getNombre(), usuario);
			return true;
		}
	}
}
