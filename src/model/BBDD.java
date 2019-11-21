package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BBDD {
	
	Connection conn;
	Statement stmt;
	ResultSet rs;
	
	public BBDD() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cine","oktay","oktay");
	}
	
	//Método que nos devolverá las peliculas dirigidas por un director
	public List<String> peliculasDirector(String director) throws ClassNotFoundException, SQLException {
		
		List<String> listaPeliculas = new ArrayList<String>();
		
		stmt = conn.createStatement();
		
		String sql = "SELECT titulo FROM pelicula WHERE director = '"+director+"'";
		
		rs = stmt.executeQuery(sql);
		
		while(rs.next()) {
			listaPeliculas.add(rs.getString(0));
		}
		return listaPeliculas;
	}
	

}
