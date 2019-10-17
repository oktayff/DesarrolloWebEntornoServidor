package controller;
import model.BBDD;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MostrarEmpleados
 */
public class MostrarEmpleados extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MostrarEmpleados() {
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
		
		model.BBDD bd;
		
		try {
			
			bd = new BBDD();
			
			RequestDispatcher rd;
			
			List<String> empleados = bd.todoslosempleados();
//			empleados.add("Paco,sss,eeee,rrr,ttt");
//			empleados.add("Luis,eee,rrrr,ttt,yyy");
			request.setAttribute("listaEmpleados", empleados);
			
			rd = request.getRequestDispatcher("/Empleados.jsp");
			rd.forward(request, response);
				
		}catch(Exception e){
			e.printStackTrace();
			
		}
	}

}
