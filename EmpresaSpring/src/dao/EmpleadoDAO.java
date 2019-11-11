package dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import laboral.Empleado;
import service.EmpleadoService;

public class EmpleadoDAO implements DAO {
	
	EmpleadoService es;

	@Override
	public List<Empleado> mostrarEmpleados() throws Exception {
		List<Empleado> empleados;
		empleados = es.todoslosempleadosEmpleado();
		return empleados;
	}

	@Override
	public int salarioEmpleado(String dni) throws Exception {
		int sueldo;
		sueldo = es.salarioempleado(dni);
		return sueldo;
	}

	@Override
	public Empleado encontrarEmpleadoDNI(String dni) throws Exception {
		Empleado empleado = null;
		empleado = es.sacaempleado(dni);
		return empleado;
	}
	
	@Override
	public void modificarEmpleadoDB(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Empleado empleado;
		String nombre = request.getParameter("nombre");
		String dni = request.getParameter("dni");
		char sexo = request.getParameter("sexo").trim().charAt(0);
		int categoria = Integer.parseInt(request.getParameter("categoria"));
		int anyos = Integer.parseInt(request.getParameter("anyos"));
		empleado = new Empleado(nombre, dni, sexo, categoria, anyos);
		
		es.reemplazaempleado(empleado);
		es.recalculasueldo(empleado);
		
	}

}
