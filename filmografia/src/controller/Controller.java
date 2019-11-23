package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BBDD;
import model.Pelicula;

/**
 * Servlet implementation class PeliculaServlet
 */
@WebServlet("/PeliculaServlet")
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
		
			case "peliculasdirector":
				
				this.obtenerpeliculasDirector(request, response);
				
			break;
			
		}
	}
	
	protected void obtenerpeliculasDirector(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BBDD bbdd;
		
		try {
			
			bbdd = new BBDD();
			
			RequestDispatcher rd;
			
			String director = request.getParameter("director");
			
			List<Pelicula> peliculas = bbdd.peliculasDirector(director);
			request.setAttribute("lista", peliculas);
			
			rd = request.getRequestDispatcher("/peliculasDirector.jsp");
			rd.forward(request, response);
				
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
