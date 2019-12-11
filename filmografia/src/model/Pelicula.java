package model;

public class Pelicula {
	
	public String director;
	public String titulo;
	public String fecha;
	
	public Pelicula(String director, String titulo, String fecha) {
		
		this.director = director;
		this.titulo = titulo;
		this.fecha = fecha;
	}
	
	public Pelicula() {
		super();
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "Pelicula [director=" + director + ", titulo=" + titulo + ", fecha="
				+ fecha + "]";
	}	
}