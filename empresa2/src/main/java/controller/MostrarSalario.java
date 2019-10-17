package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BBDD;

/**
 * Servlet implementation class MostrarSalario
 */
public class MostrarSalario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MostrarSalario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
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
			
			String info = "";
			
			if(bd.salarioempleado(request.getParameter("dni")) > 0) {
				info = "El salario es de " +bd.salarioempleado(request.getParameter("dni"))+" euros";
			}else {
				info = "No existe el empleado";
			}
			
			request.setAttribute("info", info);
			
			rd = request.getRequestDispatcher("/mostrarSalario.jsp");
			rd.forward(request, response);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
