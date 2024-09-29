package ar.edu.unju.escmi.poo.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.escmi.poo.dominio.Alumno;
import ar.edu.unju.escmi.poo.dominio.Bibliotecario;
import ar.edu.unju.escmi.poo.dominio.Usuario;
import ar.edu.unju.escmi.poo.exceptions.UsuarioNoRegistradoException;

public class CollectionUsuario {
	
	public static List<Usuario> usuarios = new ArrayList<>();
	
	
	static Scanner scanner = new Scanner(System.in);
	static int idIncremental = 3;
	
	public static void precargarUsuarios() {
		usuarios.add(new Bibliotecario(1, "Juan", "Pérez", "juan.perez@example.com","legajo1"));
		usuarios.add(new Alumno(2, "María", "González", "maria.gonzalez@example.com","3RO Informática","4000"));
		usuarios.add(new Alumno(3, "Carlos", "López", "carlos.lopez@example.com","2DO Informatica", "2000"));
	}
	
	public static void registrarUsuario(String tipo) {

		idIncremental++;
		System.out.println("Ingrese el nombre: ");
		String nombreUser = scanner.nextLine();
		System.out.println("Ingrse el apellido: ");
		String apellidoUser = scanner.nextLine();
		System.out.println("Ingrese el email: ");
		String emailUser = scanner.nextLine();
			if (tipo.toLowerCase().equals("bibliotecario")) {
				System.out.println("Ingrese el legajo: ");
				String legajoBib = scanner.nextLine();
				Bibliotecario nuevoBibliotecario = new Bibliotecario(idIncremental,nombreUser,apellidoUser,emailUser,legajoBib);
				usuarios.add(nuevoBibliotecario);
				System.out.println("Bibliotecario añadido con éxito");
			}else if (tipo.toLowerCase().equals("alumno")){
				System.out.println("Ingrese el curso: ");
				String cursoAlumn = scanner.nextLine();
				System.out.println("Ingrse el Nº de libreta universitaria");
				String luAlumn = scanner.nextLine();
				Alumno nuevoAlumno = new Alumno(idIncremental,nombreUser,apellidoUser,emailUser,cursoAlumn,luAlumn);
				usuarios.add(nuevoAlumno);
				System.out.println("Alumno añadido con éxito");
			}else {
				System.out.println("Algo falló en la ejecucion. Intentelo de nuevo");
			}
		
	}
	
	public static Alumno buscarUsuario(String lu) throws UsuarioNoRegistradoException {
		for (Usuario alumno : usuarios) {
			Alumno alumnoBuscado = (Alumno) alumno;
			if (alumnoBuscado.getLu().equalsIgnoreCase(lu)) {
				return alumnoBuscado;
			}
				
		}			
		throw new UsuarioNoRegistradoException("El usuario no está registrado");
	}
	
	public static Bibliotecario buscarBibliotecario(String legajo) throws UsuarioNoRegistradoException {
		for (Usuario bib : usuarios) {
			Bibliotecario bibBuscado = (Bibliotecario) bib;
			if (bibBuscado.getLegajo().equals(legajo)) {
				return bibBuscado;
			}
				
		}			
		throw new UsuarioNoRegistradoException("El usuario no está registrado");
	}
	
}
