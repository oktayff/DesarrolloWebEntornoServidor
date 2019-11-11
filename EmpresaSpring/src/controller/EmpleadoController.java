package controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import laboral.DatosNoCorrectosException;
import laboral.Empleado;
import service.EmpleadoService;

@Controller
public class EmpleadoController {

	@Autowired
	EmpleadoService es;

	@RequestMapping("/empleados")
	public ModelAndView mostrarEmpleados() {
		List<Empleado> lista = null;
		try {
			lista = es.todoslosempleadosEmpleado();
		} catch (ClassNotFoundException | SQLException | DatosNoCorrectosException e) {
			e.printStackTrace();
		}
		return new ModelAndView("empleados", "lista", lista);
	}

	@RequestMapping("/salario")
	public ModelAndView salarioEmpleado(@RequestParam String dni) {
		int sueldo = 0;
		try {
			sueldo = es.salarioempleado(dni);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new ModelAndView("salario");
	}

	@RequestMapping("/modificacion")
	public ModelAndView sacarEmpleado(@RequestParam String dni) {
		Empleado empleado = null;
		try {
			empleado = es.sacaempleado(dni);
		} catch (SQLException | DatosNoCorrectosException e) {
			e.printStackTrace();
		}
		return new ModelAndView("modificacion");
	}

	@RequestMapping("/editarEmpleado")
	public void modificarEmpleado(@RequestParam String nombre, @RequestParam String dni, @RequestParam char sexo,
			@RequestParam int categoria, @RequestParam int anyos) {
		Empleado empleado = null;
		try {
			empleado = new Empleado(nombre, dni, sexo, categoria, anyos);
			es.reemplazaempleado(empleado);
			es.recalculasueldo(empleado);
		} catch (SQLException | DatosNoCorrectosException e) {
			e.printStackTrace();
		}
	}

}