package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BBDD;
import model.Empleado;

/**
 * Servlet implementation class Controller
 */

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		String action = request.getParameter("accion");
		
		switch(action) {
		
			case "mostrarempleados":
				
				this.mostrarEmpleados(request, response);
			
			break;
			
			case "versalario":
				
				this.salarioEmpleado(request, response);
				
			break;
			
			case "buscardni":
				
				this.encontrarEmpleadoDNI(request, response);
				
			break;
			
			case "modificarempleado":
				
				this.modificarEmpleadoBD(request, response);
			
			break;
		}
		
	}
	
	//Método que sirve para mostrar los empleados de la base de datos
	protected void mostrarEmpleados(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BBDD bbdd;
		
		try {
			
			bbdd = new BBDD();
			
			RequestDispatcher rd;
			
			List<Empleado> empleados = bbdd.todoslosempleadosEmpleado();
			request.setAttribute("lista", empleados);
			
			rd = request.getRequestDispatcher("/empleados.jsp");
			rd.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Método que sirve para mostrar el salario de un empleado que buscamos por su DNI
	protected void salarioEmpleado(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BBDD bbdd;
		
		try {
			
			bbdd = new BBDD();
			
			RequestDispatcher rd;
			
			String respuesta = "";
			
			if(bbdd.salarioempleado(request.getParameter("dni")) > 0) { 
				respuesta = "El salario del empleado es de: "+bbdd.salarioempleado(request.getParameter("dni")) + " euros";
			}else{ 
				respuesta = "No existe el empleado, introduzca otro DNI";
			} 
			
			request.setAttribute("respuesta", respuesta);
			
			rd = request.getRequestDispatcher("/salario.jsp");
			rd.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();;
		}
		
	}
	
	//Método al que le proporcionamos el DNI para elegir el empleado que queremos modificar
	protected void encontrarEmpleadoDNI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		
		BBDD bbdd;
		
		try {
			
			bbdd = new BBDD();
			
			RequestDispatcher rd;
						
			Empleado empl = bbdd.sacaempleado(request.getParameter("dni"));
			
			request.setAttribute("empleado", empl);
			
			rd = request.getRequestDispatcher("/editarEmpleado.jsp");
			rd.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//Método que modifica el empleado en la base de datos
	protected void modificarEmpleadoBD(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BBDD bbdd;
		
		try {
			bbdd = new BBDD();
			
			RequestDispatcher rd;
			
			String nombre = request.getParameter("nombre");
			String dni = request.getParameter("dni");
			
			Empleado antesdeactualizar = bbdd.sacaempleado(dni);
			
			char sexo = request.getParameter("sexo").trim().charAt(0);
			int categoria = Integer.parseInt(request.getParameter("categoria"));
			int anyos = Integer.parseInt(request.getParameter("anyos"));
						
			Empleado empl = new Empleado(nombre, dni, sexo, categoria, anyos);
			
			bbdd.reemplazaempleado(empl);
			bbdd.recalculasueldo(empl);
						
			Boolean resolucion = null;
			
			if( antesdeactualizar.nombre.equals(empl.nombre) && antesdeactualizar.sexo == empl.sexo && antesdeactualizar.getCategoria() == empl.getCategoria() && antesdeactualizar.anyos == empl.anyos ) {
				resolucion = false;
			}else {
				resolucion = true;
			}
			
			request.setAttribute("resolucion", resolucion);
			
			rd = request.getRequestDispatcher("/modificacion.jsp");
			rd.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}			
		
	}

}
