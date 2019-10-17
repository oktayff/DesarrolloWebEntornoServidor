package model;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class CalculaNominas {

	public static void main(String[] args) throws SQLException, ClassNotFoundException, DatosNoCorrectosException, IOException {
		
		BBDD bbdd = new BBDD();;
		Ficheros ficheros = new Ficheros();
		
		boolean salir = false;		
		
		Scanner numeros = new Scanner(System.in);
		Scanner letras = new Scanner(System.in);
				
		while (!salir) {
		
			System.out.println("1. Ver todos los empleados \n"
					+ "2. Ver salario de un empleado especifico \n"
					+ "3. Submenu de edicion \n"
					+ "4. Recalcular y actualizar sueldo de un empleado \n"
					+ "5. Recalcular y actualizar sueldos de todos los empleados \n"
					+ "6. Realizar copia de seguridad de la BBDD en fichero \n"
					+ "7. Alta de nuevos empleados \n"
					+ "8. Dar de baja empleado \n"
					+ "9. Cargar backup.txt a la base de datos \n"
					+ "0. Guardar todos los salarios junto al empleado \n"
					+ "Introduce cualquier otra tecla para salir.");
			
			int menuprincipal = Integer.parseInt(letras.nextLine());
		
			switch (menuprincipal) {
			case 1: 
				for(String empleado : bbdd.todoslosempleados()) {
					System.out.println(empleado);
				}
				break;
			
			case 2:
				System.out.println("Introduce el DNI del empleado del que quieres ver el sueldo");
				String dnisueldo = letras.nextLine();
				
				if(bbdd.salarioempleado(dnisueldo) > 0) {
					System.out.println("El salario del empleado con DNI: "+dnisueldo+" es de "+bbdd.salarioempleado(dnisueldo)+"�.");
				}else{
					System.out.println("El empleado con ese DNI no existe");
				}
				break;
				
			case 3:
				System.out.println("Introduce el DNI del empleado a editar");
				String dniaeditar = letras.nextLine().toUpperCase();
				
				if(bbdd.siexisteempleado(dniaeditar)) {
					System.out.println("Que campos deseas editar? \n"
							+ "1. Nombre \n"
							+ "2. Sexo \n"
							+ "3. Categoria \n"
							+ "4. Anyos \n"
							+ "5. Todos los campos \n"
							+ "Introduce cualquier otra tecla para salir.");
					int opcionaeditar = Integer.parseInt(letras.nextLine());
					
					Empleado aeditar = bbdd.sacaempleado(dniaeditar);
					
					switch (opcionaeditar) {
					case 1:
						System.out.println("Introduce el nuevo nombre");
						String nombreaeditar1 = letras.nextLine();
						bbdd.reemplazaempleado(new Empleado(nombreaeditar1, aeditar.dni, aeditar.sexo));
						System.out.println("Consulta enviada");
						break;
					case 2:
						System.out.println("Introduce el nuevo sexo F/M");
						String sexoaeditar1 = letras.nextLine();
						try {
							bbdd.reemplazaempleado(new Empleado(aeditar.nombre, aeditar.dni, sexoaeditar1.trim().toUpperCase().charAt(0)));
							System.out.println("Consulta enviada");
						} catch (DatosNoCorrectosException e) {
							System.out.println(e);
						}
						
						break;
					case 3:
						System.out.println("Introduce la nueva categoria");
						int categoriaeditar1 = numeros.nextInt();
						try {
							bbdd.reemplazaempleado(new Empleado(aeditar.nombre, aeditar.dni, aeditar.sexo, categoriaeditar1, aeditar.anyos));
							System.out.println("Consulta enviada");
						} catch (DatosNoCorrectosException e) {
							System.out.println(e);
						}
						break;
					case 4:
						System.out.println("Introduce el nuevo anyo");
						int anyosaeditar1 = numeros.nextInt();
						try {
							bbdd.reemplazaempleado(new Empleado(aeditar.nombre, aeditar.dni, aeditar.sexo, aeditar.getCategoria(), anyosaeditar1));
							System.out.println("Consulta enviada");
						} catch (DatosNoCorrectosException e) {
							System.out.println(e);
						}
						break;
					case 5:
						System.out.println("Introduce el nuevo nombre");
						String nombreaeditar = letras.nextLine();
						System.out.println("Introduce el nuevo sexo F/M");
						String sexoaeditar = letras.nextLine();
						System.out.println("Introduce la nueva categoria");
						int categoriaeditar = numeros.nextInt();
						System.out.println("Introduce el nuevo anyo");
						int anyosaeditar = numeros.nextInt();

						try {
							bbdd.reemplazaempleado(new Empleado(nombreaeditar, aeditar.dni, sexoaeditar.trim().toUpperCase().charAt(0), categoriaeditar, anyosaeditar));
							System.out.println("Consulta enviada");
						} catch (DatosNoCorrectosException e) {
							System.out.println(e);
						}
						
						break;
					default:
						System.out.println("OK");
						break;
					}
					
				}
				
				break;
				
			case 4:
				
				System.out.println("Introduce el DNI del empleado a recalcular el sueldo");
				String dnirecalcular = letras.nextLine();
				
				if(bbdd.siexisteempleado(dnirecalcular)) {
					bbdd.recalculasueldo(bbdd.sacaempleado(dnirecalcular));
					System.out.println("Consulta enviada");
				}else {
					System.out.println("Empleado inexistente");
				}
								
				break;
				
			case 5:
				
				for(String linea : bbdd.todoslosempleados()) {
					String dni = linea.split(",")[1];
					bbdd.recalculasueldo(bbdd.sacaempleado(dni));
				}
				System.out.println("Consulta enviada");
				
				break;
				
			case 6:
				
				ficheros.backupbbddafichero();
				System.out.println("Hecho :)");
				
				break;
				
			case 7:
				System.out.println("Alta manual o mediante fichero empleadosNuevos.txt? \n"
						+ "1. Manual \n"
						+ "2. Fichero \n");
				int opcionesalta = Integer.parseInt(letras.nextLine());
				
				switch (opcionesalta) {
				case 1:
					System.out.println("Introduce el nombre del empleado");
					String altanombre = letras.nextLine();
					System.out.println("Introduce el DNI del empleado");
					String altadni = letras.nextLine().trim().toUpperCase();
					System.out.println("Introduce el Sexo del empelado F/M");
					String altasexo = letras.nextLine().trim().toUpperCase();
					if(altasexo.equals("F") || altasexo.equals("M")) {
						System.out.println("El empleado tiene categoria y anyos trabajados? \n"
								+ "1. Si \n"
								+ "2. No");
						String sinocategoria = letras.nextLine();
						if(sinocategoria.equals("1")) {
							System.out.println("Introduce la categoria del empleado");
							int altacategoria = numeros.nextInt();
							System.out.println("Introduce los anyos trabajados del empleado");
							int altaanyos = numeros.nextInt();
							bbdd.altaempleado(new Empleado(altanombre, altadni, altasexo.charAt(0), altacategoria, altaanyos));
							System.out.println("Consulta Enviada");
						}else {
							bbdd.altaempleado(new Empleado(altanombre, altadni, altasexo.charAt(0)));
							System.out.println("Consulta Enviada");
						}				
					}else {
						System.out.println("Sexo incorrecto");
					}
										
					break;
				
				case 2:
					ficheros.altaempleados();
					System.out.println("Consulta Enviada");
					break;

				default:
					System.out.println("Operaci�n cancelada");
					break;
				}
				
				break;
				
			case 8:
				
				System.out.println("Introduce el DNI del empleado a dar de baja");
				String aborrar = letras.nextLine();
				
				try {
					bbdd.bajaempleado(aborrar);
					System.out.println("Consulta enviada");
				} catch (DatosNoCorrectosException e) {
					System.out.println(e);
				}
				
				break;
				
			case 9:
				
				ficheros.altaempleados(new File("backup.txt"));
				System.out.println("Hecho :)");
				
				break;
				
			case 0:
				
				ficheros.backupbbddafichero(new File("salarios.dat"));
				System.out.println("Hecho :)");
				
				break;
				
			default:
				System.out.println("Hasta otra :)");
				bbdd.cerrarconexion();
				salir=true;
				break;
			}
		
		};
			
		letras.close();
		numeros.close();
	}

}
