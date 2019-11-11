package laboral;

public class Empleado extends Persona {
	
	private int categoria;
	public int anyos;

	public Empleado(String nombre, String dni, char sexo) throws DatosNoCorrectosException {
		super(nombre, dni, sexo);
		categoria = 1;
		anyos = 0;
	}
	
	public Empleado(String nombre, String dni, char sexo, int categoria, int anyos) throws DatosNoCorrectosException {
		super(nombre, dni, sexo);
		if(categoria >0 && categoria < 11) {
			this.categoria = categoria;
		}else {
			throw new DatosNoCorrectosException("Categoria incorrecta, debe estar entre 1 y 10 incluidos");
		}
		if(anyos > 0) {
			this.anyos = anyos;
		}
	}
	
	public void setCategoria(int categoria) throws DatosNoCorrectosException {
		if(categoria >0 && categoria < 11) {
			this.categoria = categoria;
		}else {
			throw new DatosNoCorrectosException("Categoria incorrecta, debe estar entre 1 y 10 incluidos");
		}
	}
	
	public int getCategoria() {
		return categoria;
	}
	
	public int getAnyos() {
		return anyos;
	}
	
	public void incrAnyo() {
		anyos++;
	}

	@Override
	public String toString() {
		return nombre + " con dni "+ dni + " de sexo " + sexo + ". Su categoria es "+ categoria + " y lleva "+ anyos + " anyos trabajados.";
	}

}
