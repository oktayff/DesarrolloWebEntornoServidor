package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import laboral.DatosNoCorrectosException;
import laboral.Empleado;
import laboral.Nomina;

public class EmpleadoService {

	Connection con;
	Statement stmt;
	ResultSet rs;

	public EmpleadoService() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empleados","root","root");
	}

	public List<String> todoslosempleados() throws ClassNotFoundException, SQLException {
		stmt = con.createStatement();

		List<String> lista = new ArrayList<String>();

		rs = stmt.executeQuery("select * from Empleados");
		while (rs.next()) {
			char sexo = rs.getString(3).trim().charAt(0);
			String empleado = rs.getString(1) + "," + rs.getString(2) + "," + sexo + "," + rs.getInt(4) + ","
					+ rs.getInt(5);
			lista.add(empleado);
		}

		return lista;

	}

	public List<Empleado> todoslosempleadosEmpleado()
			throws ClassNotFoundException, SQLException, DatosNoCorrectosException {
		stmt = con.createStatement();

		List<Empleado> lista = new ArrayList<Empleado>();

		rs = stmt.executeQuery("select * from Empleados");
		while (rs.next()) {
			char sexo = rs.getString(3).trim().charAt(0);
			lista.add(new Empleado(rs.getString(1), rs.getString(2), sexo, rs.getInt(4), rs.getInt(5)));
		}

		return lista;

	}

	public void cargarficherobackup() {

	}

	public boolean siexisteempleado(String dni) throws SQLException {
		boolean existe = false;

		stmt = con.createStatement();
		String consulta = "select count(dni) from Empleados where dni = '" + dni + "'";
		rs = stmt.executeQuery(consulta);

		while (rs.next()) {
			if (rs.getInt(1) > 0) {
				existe = true;
			}
		}
		return existe;
	}

	public void reemplazaempleado(Empleado emp) throws SQLException {
		stmt = con.createStatement();
		String consulta = "update Empleados set nombre = '" + emp.nombre + "', sexo = '" + emp.sexo + "', categoria = '"
				+ emp.getCategoria() + "', anyos = '" + emp.anyos + "' where dni = '" + emp.dni + "';";
		stmt.executeUpdate(consulta);
	}

	public int salarioempleado(String dni) throws SQLException {
		stmt = con.createStatement();
		String consulta = "select sueldo from Nominas where dni = '" + dni + "'";
		rs = stmt.executeQuery(consulta);

		int sueldo = 0;

		while (rs.next()) {
			sueldo = rs.getInt("Sueldo");
		}

		return sueldo;

	}

	public List<String> todoslossalariosydni() throws SQLException {
		List<String> lista = new ArrayList<String>();
		stmt = con.createStatement();
		String consulta = "select dni, sueldo from Nominas";
		rs = stmt.executeQuery(consulta);

		while (rs.next()) {
			lista.add(rs.getString("dni") + "," + rs.getInt("sueldo"));
		}
		return lista;
	}

	public Empleado sacaempleado(String dni) throws SQLException, DatosNoCorrectosException {
		Empleado empleado = null;
		String consulta = "select * from Empleados where dni like '" + dni + "'";
		stmt = con.createStatement();
		rs = stmt.executeQuery(consulta);

		while (rs.next()) {
			empleado = new Empleado(rs.getString("nombre"), rs.getString("dni"), rs.getString("sexo").charAt(0),
					rs.getInt("categoria"), rs.getInt("anyos"));
		}

		return empleado;

	}

	public void altaempleado(Empleado emp) throws SQLException, DatosNoCorrectosException {
		stmt = con.createStatement();
		String consulta = "Insert into Empleados values ('" + emp.nombre + "','" + emp.dni + "','" + emp.sexo + "',"
				+ emp.getCategoria() + "," + emp.anyos + ")";
		String consulta2 = "insert into Nominas values ('" + emp.dni + "', " + Nomina.sueldo(emp) + ")";

		if (!siexisteempleado(emp.dni)) {
			stmt.executeUpdate(consulta);
			stmt.executeUpdate(consulta2);
		}

	}

	public void recalculasueldo(Empleado emp) throws SQLException, DatosNoCorrectosException {
		stmt = con.createStatement();
		String consulta = "update Nominas set sueldo = " + Nomina.sueldo(emp) + " where dni = '" + emp.dni + "'";

		stmt.executeUpdate(consulta);

	}

	public void bajaempleado(String dni) throws SQLException, DatosNoCorrectosException {
		stmt = con.createStatement();

		String consulta = "delete from nominas where dni = '" + dni + "'";
		String consulta2 = "delete from empleados where dni = '" + dni + "'";

		if (siexisteempleado(dni)) {
			stmt.executeUpdate(consulta);
			stmt.executeUpdate(consulta2);
		} else {
			throw new DatosNoCorrectosException("Empleado inexistente");
		}

	}

	public void cerrarconexion() throws SQLException {
		con.close();
	}

}
