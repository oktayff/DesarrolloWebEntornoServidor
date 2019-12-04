package model;

import java.sql.Date;

public class Pelicula {
	
	public String id;
	public String director;
	public String titulo;
	public String fecha;
	
	public Pelicula(String id, String director, String titulo, String fecha) {
		
		this.setId(id);
		this.director = director;
		this.titulo = titulo;
		this.fecha = fecha;
	}
	
	public Pelicula() {
		super();
	}

	public String getIdentificador() {
		return getId();
	}

	public void setIdentificador(String id) {
		this.setId(id);
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
		return "Pelicula [id=" + getId() + ", director=" + director + ", titulo=" + titulo + ", fecha="
				+ fecha + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
