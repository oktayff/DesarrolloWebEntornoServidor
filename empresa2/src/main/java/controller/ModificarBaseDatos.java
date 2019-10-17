package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BBDD;
import model.DatosNoCorrectosException;
import model.Empleado;

/**
 * Servlet implementation class ModificarBaseDatos
 */
public class ModificarBaseDatos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarBaseDatos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		BBDD bd;
		
		try {
			bd = new BBDD();
			
			RequestDispatcher rd;
			
			String nombre = request.getParameter("nombre");
			String dni = request.getParameter("dni");
			
			Empleado e1 = bd.sacaempleado(dni);
			
			char sexo = request.getParameter("sexo").trim().charAt(0);
			int categoria = Integer.parseInt(request.getParameter("categoria"));
			int anyos = Integer.parseInt(request.getParameter("anyos"));
						
			Empleado empl = new Empleado(nombre, dni, sexo, categoria, anyos);
			
			bd.reemplazaempleado(empl);
			bd.recalculasueldo(empl);
						
			Boolean resolucion = null;
			
			if( e1.nombre.equals(empl.nombre) && e1.sexo == empl.sexo && e1.getCategoria() == empl.getCategoria() && e1.anyos == empl.anyos ) {
				resolucion = false;
			}else {
				resolucion = true;
			}
			
			request.setAttribute("resolucion", resolucion);
			
			rd = request.getRequestDispatcher("/modificarDatos.jsp");
			rd.forward(request, response);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DatosNoCorrectosException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	catch (SQLException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}		
	
}
