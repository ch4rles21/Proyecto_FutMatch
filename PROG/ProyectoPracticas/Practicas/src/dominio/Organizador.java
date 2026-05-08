package dominio;

public class Organizador extends Usuario {
	private String telefono;

	public Organizador(String nombre, String correo, String contrasenia, String telefono) {
		super(nombre, correo, contrasenia);
		this.telefono = telefono;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Organizador [telefono=" + telefono + "]";
	}

}
