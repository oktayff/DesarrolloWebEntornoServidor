package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Pelicula;

public class BBDD {
	
	Connection conn;
	Statement stmt;
	ResultSet rs;
	
	public BBDD() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cine","root","root");
	}
	
	//Método que nos devolverá las peliculas dirigidas por un director
	public List<Pelicula> peliculasDirector(String director) throws SQLException {
	
		stmt = conn.createStatement();
		
		List<Pelicula> lista = new ArrayList<Pelicula>();
		
		String sql = "SELECT * FROM pelicula WHERE director = '"+director+"'";
		
		rs = stmt.executeQuery(sql);
		
		while(rs.next()) {
			lista.add(new Pelicula(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4)));
		}
		
		return lista;
			
	}
	

}
