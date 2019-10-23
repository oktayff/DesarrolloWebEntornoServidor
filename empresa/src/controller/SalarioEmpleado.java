package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BBDD;

/**
 * Servlet implementation class SalarioEspecifico
 */
public class SalarioEmpleado extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SalarioEmpleado() {
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

}
