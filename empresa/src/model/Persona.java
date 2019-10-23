package model;

public class Persona {
	public String nombre;
	public String dni;
	public char sexo;
	
	public Persona (String nombre, String dni, char sexo) throws DatosNoCorrectosException {
		this.nombre = nombre;
		this.dni = dni;
		
		String sex = String.valueOf(sexo);
		if(sex.equals("M") || sex.equals("F")) {
			this.sexo = sexo;
		}else {
			throw new DatosNoCorrectosException("El sexo debe ser M o F (Mayus)");
		}
		
	}
	
	public Persona(String nombre, char sexo) {
		this.nombre = nombre;
		this.sexo = sexo;
	}
	
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	public String getNombre() {
		return nombre;
	}

	public String getDni() {
		return dni;
	}

	public char getSexo() {
		return sexo;
	}

	public String Imprime() {
		return nombre + " " + dni;
	}
}
