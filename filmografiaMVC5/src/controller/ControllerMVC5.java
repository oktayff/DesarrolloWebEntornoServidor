package controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import model.BBDD;
import model.Pelicula;

@Controller
public class ControllerMVC5 {

	BBDD bbdd;
	String next = null;

	@RequestMapping("/info")
	public ModelAndView info() {
		return new ModelAndView("info");
	}

	@RequestMapping("/formDirectores")
	public ModelAndView formDirectores() {
		return new ModelAndView("formDirectores");
	}

	@RequestMapping("/formAdmin")
	public ModelAndView formAdmin() {
		return new ModelAndView("formAdmin");
	}

	@PostMapping("/peliculasDirector")
	public ModelAndView peliculasDirector(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ClassNotFoundException {

		bbdd = new BBDD();

		String director = request.getParameter("director");

		List<Pelicula> peliculas = bbdd.peliculasDirector(director);

		if (peliculas.size() != 0) {

			request.setAttribute("lista", peliculas);

			next = "peliculasDirector";

		} else {

			next = "directorInexistente";
		}

		return new ModelAndView(next, "lista", peliculas);
	}

	@PostMapping("/successfulLogin")
	public ModelAndView loginUser(HttpServletRequest request) throws SQLException, ClassNotFoundException {

		bbdd = new BBDD();

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		int numero = bbdd.usuariosBD(username, password);

		if (numero > 0) {

			next = "successfulLogin";

		} else {

			next = "loginError";
		}

		return new ModelAndView(next);
	}

	@GetMapping("/registroAdmin")
	public ModelAndView registroAdmin() {

		return new ModelAndView("registrarAdmin");

	}

	@PostMapping("/registrarAdmin")
	public ModelAndView registroAdmin(HttpServletRequest request) throws SQLException, ClassNotFoundException {

		bbdd = new BBDD();

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		try {
			
			int registro = bbdd.registroAdmin(username, password);

			if (registro > 0) {

				request.setAttribute("msg", "El usuario ha sido registrado");
				next = "successfulLogin";
			}
			
		}catch(Exception e) {
			
			request.setAttribute("msg", "El usuario no ha sido registrado");
			next = "successfulLogin";
			
		}

		return new ModelAndView(next);
	}

	@GetMapping("/mantPeliculas")
	public ModelAndView mantPeli() {

		return new ModelAndView("mantPeliculas");
	}

	@GetMapping("/formCrearPelicula")
	public ModelAndView formCrear() {

		return new ModelAndView("formCrearPelicula");
	}

	@PostMapping("/formCrearPelicula")
	public ModelAndView crearPeli(HttpServletRequest request) throws SQLException, ClassNotFoundException {

		bbdd = new BBDD();

		String director = request.getParameter("director");
		String titulo = request.getParameter("titulo");
		String fecha = request.getParameter("fecha");
		
		try {
			
			int registro = bbdd.crearPelicula(director, titulo, fecha);
			
			if(registro > 0) {
				
				request.setAttribute("msg", "La pelicula ha sido creada");
				next = "formCrearPelicula";
			
			}
			
		}catch(Exception e) {
			
			request.setAttribute("msg", "La pelicula no ha sido creada");
			next = "formCrearPelicula";
		}
		
		return new ModelAndView(next);
	}

	@GetMapping("formEliminarPelicula")
	public ModelAndView formEliminar() {

		return new ModelAndView("formEliminarPelicula");
	}
	
	@PostMapping("/formEliminarPelicula")
	public ModelAndView eliminarPeli(HttpServletRequest request) throws SQLException, ClassNotFoundException {
		
		bbdd = new BBDD();
		
		String titulo = request.getParameter("titulo");
		
		try {
			
			int registro = bbdd.eliminarPelicula(titulo);
			
			if(registro > 0) {
				
				request.setAttribute("msg", "La pelicula ha sido eliminada");
				next = "formEliminarPelicula";
				
			}

		} catch (Exception e) {
			
			request.setAttribute("msg", "La pelicula no ha sido eliminada");
			next = "formEliminarPelicula";
		}
		
		return new ModelAndView(next);
	}
	
	@PostMapping("/formModificarPelicula")
	public ModelAndView modificarPeli(HttpServletRequest request) throws SQLException, ClassNotFoundException {
		
		bbdd = new BBDD();
		Pelicula pe = null;
		
		try {
			
			pe = bbdd.sacaPelicula(request.getParameter("titulo"));
			
			next = "formModificarPelicula";
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return new ModelAndView(next, "pelicula", pe);
	}
	
	@PostMapping("/actualizacionPeli")
	public ModelAndView actualizacionPeli(HttpServletRequest request) throws SQLException, ClassNotFoundException {
		
		String director = request.getParameter("director");
		String titulo = request.getParameter("titulo");
		String fecha = request.getParameter("fecha");

		Pelicula pe = new Pelicula(director, titulo, fecha);
		
		try {
			
			bbdd.reemplazarPelicula(pe);
			
			int registro = bbdd.reemplazarPelicula(pe);
			
			if(registro < 0) {
				request.setAttribute("msg", "La pelicula no se ha actualizado");
				next = "formModificarPelicula";
			}
			
		}catch(Exception e) {
			
			request.setAttribute("msg", "La pelicula no ha sido eliminada");
			next = "formModificarPelicula";	
		}
		return new ModelAndView(next);
	}

}
