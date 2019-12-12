package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
	
	public List<Pelicula> obtenerPeliculas() throws SQLException {
		
		stmt = conn.createStatement();
		
		List<Pelicula> pelis = new ArrayList<Pelicula>();
		
		String sql = "SELECT * FROM pelicula";
		
		rs1 = stmt.executeQuery(sql);
		
		while(rs1.next()) {
			pelis.add(new Pelicula(rs1.getString(1), rs1.getString(2), rs1.getString(3)));

		}
		
		return pelis;		
	}

	public List<Pelicula> peliculasDirector(String director) throws SQLException {
		
		stmt = conn.createStatement();

		List<Pelicula> lista = new ArrayList<Pelicula>();

		String sql = "SELECT * FROM pelicula WHERE director = '" + director + "'";

		rs1 = stmt.executeQuery(sql);

		while (rs1.next()) {
			lista.add(new Pelicula(rs1.getString(1), rs1.getString(2), rs1.getString(3)));
		
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
			pelis.add(new Pelicula(rs1.getString(1), rs1.getString(2), rs1.getString(3)));
		}
		
		return pelis;	
	}
	
	public int crearPelicula(String director, String titulo, String fecha) throws SQLException {
		
		int registro;
		
		stmt = conn.createStatement();
		
		String sql = "INSERT INTO pelicula (director, titulo, fecha) VALUES ('"+director+"','"+titulo+"','"+fecha+"')";
		
		registro = rs2 = stmt.executeUpdate(sql);
		
		return registro;
	}
	
	public int eliminarPelicula(String titulo) throws SQLException {
		
		int registro;
		
		stmt = conn.createStatement();
		
		String sql = "DELETE FROM pelicula WHERE titulo = '" +titulo+"'";
		
		registro = rs2 = stmt.executeUpdate(sql);
		
		return registro;
	}
	
	public int registroAdmin(String username, String password) throws SQLException {
		
		int registro;
		
		stmt = conn.createStatement();
		
		String sql = "INSERT INTO user (username, password) VALUES ('"+username+"','"+password+"')";
		
		registro = stmt.executeUpdate(sql);	
		
		return registro;
	}
	
	public Pelicula sacaPelicula(String titulo) throws SQLException {
		Pelicula pelicula = null;
		String consulta = "select * from pelicula where titulo like '"+titulo+"'";
		stmt = conn.createStatement();
		rs1 = stmt.executeQuery(consulta);
		
		while(rs1.next()) {
			pelicula = new Pelicula (rs1.getString("director"),
					rs1.getString("titulo"),
					rs1.getString("fecha"));

		}
		
		return pelicula;
	}
	
	public int reemplazarPelicula(Pelicula peli) throws SQLException {
		
		int registro;
		
		stmt = conn.createStatement();
		
		String sql = "UPDATE pelicula SET director = '"+peli.director+"', fecha = '"+peli.fecha+"' WHERE titulo = '"+peli.titulo+"';";
		
		registro = stmt.executeUpdate(sql);
		
		return registro;
	}
	
}