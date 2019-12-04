package model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import model.Pelicula;
import model.User;

public class BBDD {

	Connection conn;
	Statement stmt;
	ResultSet rs1;
	int rs2;

	public BBDD() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cine", "root", "root");
	}

	// Método que nos devolverá las peliculas dirigidas por un director
	public List<Pelicula> peliculasDirector(String director) throws SQLException {
		
		stmt = conn.createStatement();

		List<Pelicula> lista = new ArrayList<Pelicula>();

		String sql = "SELECT * FROM pelicula WHERE director = '" + director + "'";

		rs1 = stmt.executeQuery(sql);

		while (rs1.next()) {
			lista.add(new Pelicula(rs1.getString(1), rs1.getString(2), rs1.getString(3), rs1.getString(4)));
		
		}

		return lista;

	}

	public int usuariosBD(String username, String password) throws SQLException {
		
		int resultado = 0;

		stmt = conn.createStatement();
		
		String sql = "SELECT COUNT(*) FROM user WHERE username = '" + username+"' and password = '"+password+"'";

		rs1 = stmt.executeQuery(sql);
		
		if(rs1.next()) {
			resultado = rs1.getInt(1);
		}

		return resultado;
			
	}
	
	public List<User> getUsernamePassword(String username, String password) throws SQLException {
		
		List<User> usuarios = new ArrayList<User>();
		
		stmt = conn.createStatement();
		
		String sql = "SELECT username, password FROM user WHERE username = '" + username+"' and password = '"+password+"'";
		
		rs1 = stmt.executeQuery(sql);
		
		while(rs1.next()) {
			usuarios.add(new User(rs1.getString(1), rs1.getString(2)));
		}
		
		return usuarios;
		
	}
	
	public List<Pelicula> peliculas() throws SQLException {
		
		List<Pelicula> pelis = new ArrayList<Pelicula>();
		
		stmt = conn.createStatement();
		
		String sql = "SELECT * FROM pelicula";
		
		rs1 = stmt.executeQuery(sql);
		
		while(rs1.next()) {
			pelis.add(new Pelicula(rs1.getString(1), rs1.getString(2), rs1.getString(3), rs1.getString(4)));
		}
		
		return pelis;	
	}
	
	//Crear pelicula
	public void crearPelicula(String id, String director, String titulo, String fecha) throws SQLException {
		
		stmt = conn.createStatement();
		
		String sql = "INSERT INTO pelicula (id, director, titulo, fecha) VALUES ('"+id+"','"+director+"','"+titulo+"','"+fecha+"')";
		
		rs2 = stmt.executeUpdate(sql);
	}
	
	//Modificar director
//	public void modificarDirectorPelicula(String id, String director) throws SQLException {
//		
//		stmt = conn.createStatement();
//		
//		String sql = "UPDATE pelicula SET director = '" + director+"' WHERE id = '" +id+"')";
//		
//		rs2 = stmt.executeUpdate(sql);
//	}
	
	//Modificar titulo
//	public void modificarTituloPelicula(String id, String titulo) throws SQLException {
//		
//		stmt = conn.createStatement();
//		
//		String sql = "UPDATE pelicula SET titulo = '" +titulo+"' WHERE id = '" +id+"')";
//		
//		rs2 = stmt.executeUpdate(sql);
//	}
	
	//Modificar fecha
//	public void modificarFechaPelicula(String id, Date fecha) throws SQLException {
//		
//		stmt = conn.createStatement();
//		
//		String sql = "UPDATE pelicula SET fecha = '" +fecha+"' WHERE id = '" +id+"')";
//		
//		rs2 = stmt.executeUpdate(sql);
//	}
	
	//Eliminar una pelicula
	public void eliminarPelicula(String titulo) throws SQLException {
		
		stmt = conn.createStatement();
		
		String sql = "DELETE FROM pelicula WHERE titulo = '" +titulo+"'";
		
		rs2 = stmt.executeUpdate(sql);
	}
	
	//Registrar nuevo admin
	public void registroAdmin(String username, String password) throws SQLException {
		
		stmt = conn.createStatement();
		
		String sql = "INSERT INTO user (username, password) VALUES ('"+username+"','"+password+"')";
		
		rs2 = stmt.executeUpdate(sql);	
	}
	
	//Metodo que obtiene una pelicula en concreto mediante el id
	public Pelicula sacaPelicula(String id) throws SQLException {
		Pelicula pelicula = null;
		String consulta = "select * from pelicula where id like '"+id+"'";
		stmt = conn.createStatement();
		rs1 = stmt.executeQuery(consulta);
		
		while(rs1.next()) {
			pelicula = new Pelicula(rs1.getString("id"), 
					rs1.getString("director"),
					rs1.getString("titulo"), 
					rs1.getString("fecha"));

		}
		
		return pelicula;
		
	}
	
	//Metodo que reemplaza una pelicula con otra 
	public void reemplazarPelicula(Pelicula peli) throws SQLException {
		
		stmt = conn.createStatement();
		
		String sql = "UPDATE pelicula SET director = '"+peli.director+"', titulo = '"+peli.titulo+"', fecha = '"+peli.fecha+"' WHERE id = '"+peli.id+"';";
		
		rs2 = stmt.executeUpdate(sql);
	}
	
}
