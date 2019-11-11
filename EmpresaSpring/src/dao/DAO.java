package dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import laboral.Empleado;

public interface DAO {
	
	public List<Empleado> mostrarEmpleados() throws Exception;
	
	public int salarioEmpleado(String dni) throws Exception;
	
	public Empleado encontrarEmpleadoDNI(String dni) throws Exception;

	void modificarEmpleadoDB(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
}
