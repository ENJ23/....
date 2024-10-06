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
	
	public static int aumentarIdIncremental() {
		return idIncremental++;
	}
	
	public static void registrarUsuario(Usuario usuarioNuevo) {

	try {
		usuarios.add(usuarioNuevo);
		System.out.println("Usuario añadido con éxito");
	}catch(Exception e) {
		System.out.println("Algo salió mal...");
	}
		
}
	
	public static Alumno buscarUsuario(String lu, Class<Alumno> tipo) throws UsuarioNoRegistradoException {
		for (Usuario alumno : usuarios) {
			if (tipo.isInstance(alumno)) {
			Alumno alumnoBuscado = (Alumno) alumno;
				if (alumnoBuscado.getLu().equalsIgnoreCase(lu)) {
				return alumnoBuscado;
				}
			}
				
		}			
		throw new UsuarioNoRegistradoException("El usuario no está registrado");
	}
	
	public static Bibliotecario buscarBibliotecario(String legajo, Class<Bibliotecario> tipo) throws UsuarioNoRegistradoException {
		for (Usuario bib : usuarios) {
			if (tipo.isInstance(bib)) {
			Bibliotecario bibBuscado = (Bibliotecario) bib;
			if (bibBuscado.getLegajo().equals(legajo)) {
				return bibBuscado;
			}
			}
				
		}			
		throw new UsuarioNoRegistradoException("El usuario no está registrado");
	}
	
}
