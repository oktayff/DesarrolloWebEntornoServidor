package laboral;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import laboral.DatosNoCorrectosException;
import laboral.Empleado;

public class Ficheros {
	
	BBDD bbdd;
	
	public Ficheros() throws ClassNotFoundException, SQLException {
		bbdd = new BBDD();
	}
	
	protected List<String> leerficheroempleados() throws FileNotFoundException {
		File empleados = new File("empleados.txt");
		List<String> listaempleados = new ArrayList<String>();
		
        Scanner sc=new Scanner(empleados);
        while(sc.hasNextLine()){
            listaempleados.add(sc.nextLine());
        }
        
        sc.close();
        
        return listaempleados;

	}
	
	public void backupbbddafichero() throws ClassNotFoundException, SQLException, IOException {
		File backup = new File("backup.txt");
		BufferedWriter wr = new BufferedWriter(new FileWriter(backup,false));
		
		for(String empleado : bbdd.todoslosempleados()) {
			wr.write(empleado+"\n");
		}
		wr.close();
	}
	
	public void backupbbddafichero(File backup) throws ClassNotFoundException, SQLException, IOException {
		BufferedWriter wr = new BufferedWriter(new FileWriter(backup,false));
		
		for(String empleado : bbdd.todoslossalariosydni()) {
			wr.write(empleado+"\n");
		}
		wr.close();
	}
	
	public void altaempleados() throws FileNotFoundException, DatosNoCorrectosException, SQLException {
		File altas = new File("empleadosNuevos.txt");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(altas);
				
		while(sc.hasNext()) {
			Empleado nuevoempl;
			
			String linea = sc.nextLine();
			String [] campos = linea.split(",");
			if(campos.length == 3) {
				nuevoempl = new Empleado(campos[0].trim(), campos[1].trim().toUpperCase(), campos[2].trim().toUpperCase().charAt(0));
				bbdd.altaempleado(nuevoempl);
			}else if (campos.length == 5) {
				nuevoempl = new Empleado(campos[0].trim(), campos[1].trim().toUpperCase(), campos[2].trim().toUpperCase().charAt(0), Integer.parseInt(campos[3].trim()), Integer.parseInt(campos[4].trim()));
				bbdd.altaempleado(nuevoempl);
			}else {
				continue;
				
			}
			
		}
		
	}
	
	
	public void altaempleados(File altas) throws FileNotFoundException, DatosNoCorrectosException, SQLException {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(altas);
				
		while(sc.hasNext()) {
			Empleado nuevoempl;
			
			String linea = sc.nextLine();
			String [] campos = linea.split(",");
			if(bbdd.siexisteempleado(campos[1].trim().toUpperCase())) {
				if(campos.length == 3) {
					bbdd.reemplazaempleado(new Empleado(campos[0].trim(), campos[1].trim().toUpperCase(), campos[2].trim().toUpperCase().charAt(0)));
				}else if (campos.length == 5) {
					bbdd.reemplazaempleado(new Empleado(campos[0].trim(), campos[1].trim().toUpperCase(), campos[2].trim().toUpperCase().charAt(0), Integer.parseInt(campos[3].trim()), Integer.parseInt(campos[4].trim())));
				}else {
					throw new DatosNoCorrectosException("Algo va mal a la hora de leer el fichero especificado");
				}
			}else {
				if(campos.length == 3) {
					nuevoempl = new Empleado(campos[0].trim(), campos[1].trim().toUpperCase(), campos[2].trim().toUpperCase().charAt(0));
					bbdd.altaempleado(nuevoempl);
				}else if (campos.length == 5) {
					System.out.println(campos[4]);
					nuevoempl = new Empleado(campos[0].trim(), campos[1].trim().toUpperCase(), campos[2].trim().toUpperCase().charAt(0), Integer.parseInt(campos[3].trim()), Integer.parseInt(campos[4].trim()));
					bbdd.altaempleado(nuevoempl);
				}else {
					throw new DatosNoCorrectosException("Algo va mal a la hora de leer el fichero especificado");
				}
			}
		}
	}
	
	
}