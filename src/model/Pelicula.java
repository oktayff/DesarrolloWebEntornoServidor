package model;

import java.sql.Date;

public class Pelicula {
	
	private String id;
	private String director;
	private String titulo;
	private Date fecha;
	
	public Pelicula(String id, String director, String titulo, Date fecha) {
		
		this.id = id;
		this.director = director;
		this.titulo = titulo;
		this.fecha = fecha;
	}
	
	public Pelicula() {
		super();
	}

	public String getIdentificador() {
		return id;
	}

	public void setIdentificador(String id) {
		this.id = id;
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

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "Pelicula [id=" + id + ", director=" + director + ", titulo=" + titulo + ", fecha="
				+ fecha + "]";
	}
	
}
