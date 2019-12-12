package controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BBDD;
import model.Pelicula;
import model.User;

/**
 * Servlet implementation class PeliculaServlet
 */
//@WebServlet("/PeliculaServlet")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controller() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

		String action = request.getParameter("accion");

		switch (action) {

		case "peliculasdirector":

			this.obtenerpeliculasDirector(request, response);

			break;

		case "loginuser":

			this.loginUser(request, response);

			break;

		case "insertarpeli":

			this.crearPelicula(request, response);

			break;
			
		case "eliminarpeli":
			
			this.eliminarPeli(request, response);
		
			break;
			
		case "buscarpeli":
			
			this.encontrarPelicula(request, response);
			
			break;
			
		case "modificarpeli":
			
			this.modificarPelicula(request, response);
			
			break;

		case "nuevoadmin":
			
			this.crearAdmin(request, response);

			break;

		}
	}

	// Metodo para obtener las peliculas de un director - FUNCIONA
	protected void obtenerpeliculasDirector(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		BBDD bbdd;

		try {

			bbdd = new BBDD();

			RequestDispatcher rd;

			String director = request.getParameter("director");

			List<Pelicula> peliculas = bbdd.peliculasDirector(director);

			if (peliculas.isEmpty() == true) {

				rd = request.getRequestDispatcher("/directorInexistente.jsp");

			} else {

				rd = request.getRequestDispatcher("/peliculasDirector.jsp");
				request.setAttribute("lista", peliculas);
			}

			rd.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Metodo para el logueo de un admin - FUNCIONA
	protected void loginUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		BBDD bbdd;

		try {

			bbdd = new BBDD();

			RequestDispatcher rd;

			String username = request.getParameter("username");
			String password = request.getParameter("password");

			int numero = bbdd.usuariosBD(username, password);

			if (numero > 0) {

				rd = request.getRequestDispatcher("/successfulLogin.jsp");

			} else {

				rd = request.getRequestDispatcher("/loginError.jsp");

			}

			rd.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// Metodo para insertar una nueva pelicula en la BBDD - FUNCIONA
	protected void crearPelicula(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		BBDD bbdd;

		try {

			bbdd = new BBDD();

			String director = request.getParameter("director");
			String titulo = request.getParameter("titulo");
			String fecha = request.getParameter("fecha");

			bbdd.crearPelicula(director, titulo, fecha);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// Metodo para eliminar una pelicula - FUNCIONA
	protected void eliminarPeli(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		BBDD bbdd;

		try {

			bbdd = new BBDD();

			String titulo = request.getParameter("titulo");
			
			bbdd.eliminarPelicula(titulo);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// Metodo para insertar un admin nuevo en la BBDD - FUNCIONA
	protected void crearAdmin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		BBDD bbdd;

		try {

			bbdd = new BBDD();

			String username = request.getParameter("username");
			String password = request.getParameter("password");

			bbdd.registroAdmin(username, password);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Metodo para encontrar una pelicula por su titulo - FUNCIONA
	protected void encontrarPelicula(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BBDD bbdd;
		
		try {
			
			bbdd = new BBDD();
			
			RequestDispatcher rd;
			
			Pelicula pe = bbdd.sacaPelicula(request.getParameter("titulo"));
			
			request.setAttribute("pelicula", pe);
			
			rd = request.getRequestDispatcher("/formModificarPelicula.jsp");
			rd.forward(request, response);
			
		}catch(Exception e) {
			
		}
	}
	
	protected void modificarPelicula(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BBDD bbdd;
		
		try {
			
			bbdd = new BBDD();
			
			RequestDispatcher rd;
			
			String director = request.getParameter("director");
			String titulo = request.getParameter("titulo");
			
			Pelicula antesdeactualizar = bbdd.sacaPelicula(titulo);
			
			String fecha = request.getParameter("fecha");
			
			
			Pelicula pe = new Pelicula(director, titulo, fecha);
			
			bbdd.reemplazarPelicula(pe);
			
			Boolean resolucion = null;
			
			System.out.println("entrando");
			
			if(antesdeactualizar.director.equals(pe.director) && antesdeactualizar.titulo == pe.titulo && antesdeactualizar.fecha == pe.fecha) {
				resolucion = false;
			}else {
				resolucion = true;
			}
			
			System.out.println("fuera");
			
			request.setAttribute("resolucion", resolucion);
			
			rd = request.getRequestDispatcher("/modificacion.jsp");
			rd.forward(request, response);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
