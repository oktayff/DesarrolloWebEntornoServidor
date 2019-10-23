package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BBDD;
import model.Empleado;

/**
 * Servlet implementation class ModificarEnBD
 */
public class ModificarBD extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarBD() {
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
