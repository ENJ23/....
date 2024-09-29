package ar.edu.unju.escmi.poo.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.escmi.poo.dominio.Bibliotecario;
import ar.edu.unju.escmi.poo.dominio.Libro;
import ar.edu.unju.escmi.poo.exceptions.LibroNoDisponibleException;
import ar.edu.unju.escmi.poo.exceptions.LibroNoEncontradoException;
import ar.edu.unju.escmi.poo.exceptions.UsuarioNoRegistradoException;

public class CollectionLibro {
	
	public static List<Libro> libros = new ArrayList<>();
	static Scanner scanner = new Scanner(System.in);
	static int idIncremental = 5;
	
	public static void precargarLibros() {
		libros.add(new Libro(1, "Cien años de soledad", "Gabriel García Márquez", "978-3-16-148410-0", true));
		libros.add(new Libro(2, "Don Quijote de la Mancha", "Miguel de Cervantes", "978-3-16-148410-1", true));
		libros.add(new Libro(3, "El amor en los tiempos del cólera", "Gabriel García Márquez", "978-3-16-148410-2", false));
		libros.add(new Libro(4, "1984", "George Orwell", "978-3-16-148410-3", true));
		libros.add(new Libro(5, "La casa de los espíritus", "Isabel Allende", "978-3-16-148410-4", true));

	}
	
	public static void registrarLibro() throws UsuarioNoRegistradoException {

		System.out.println("Ingresa tu legajo, para verificar que eres un bibliotecario: ");
		String legajoBib = scanner.nextLine();
		Bibliotecario bibBuscado = CollectionUsuario.buscarBibliotecario(legajoBib);
		if (bibBuscado != null) {
			System.out.println("Legajo Confirmado. Tiene permiso para registrar el libro");
			idIncremental++;
			System.out.println("Ingrese el titulo: ");
			String tituloLibro = scanner.nextLine();
			System.out.println("Ingrse el nombre del autor: ");
			String autorLibro = scanner.nextLine();
			System.out.println("Ingrese el isbn: ");
			String isbnLibro = scanner.nextLine();
			boolean estadoLibro = true;
			
			Libro nuevoLibro = new Libro(idIncremental,tituloLibro,autorLibro,isbnLibro,estadoLibro);
			libros.add(nuevoLibro);
		}
		
	}
	
	public static void listarLibros() {
		
		System.out.println("Claro, aquí tienes la lista de libros");
		System.out.println("Para tomar prestados los 'No disponibles' debes esperar a que sean devueltos. Ten cuidado con eso.");
		for (Libro libro : libros) {
			if (libro.isEstado()) {
				System.out.println(libro);
			}else {
				System.out.println(libro + "Libro No Disponible");
			}
		}
	}
	
	public static Libro buscarLibros(int id) throws LibroNoEncontradoException {
		for (Libro libro : libros) {
			if (libro.getId() == id) {
				return libro;
			}
		}
		throw new LibroNoEncontradoException("Libro no encontrado");
	}
	
	public static Libro buscarLibroDisponible(int id) throws LibroNoEncontradoException {
		for (Libro libro : libros) {
			if (libro.isEstado()) {
				if (libro.getId() == id) {
					return libro;
				}
			}	
		}
		throw new LibroNoEncontradoException("Libro no encontrado");
	}
	
	public static boolean isDisponible(Libro libro) throws LibroNoDisponibleException {
		if (libro.isEstado()) {
			return true;
		}else {
			throw new LibroNoDisponibleException("Libro no Disponible para prestamo");
		}
	}
}
