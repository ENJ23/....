package ar.edu.unju.escmi.poo.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.escmi.poo.dominio.Libro;
import ar.edu.unju.escmi.poo.dominio.Prestamo;
import ar.edu.unju.escmi.poo.exceptions.LibroNoEncontradoException;

public class CollectionPrestamo {
	
	public static List<Prestamo> prestamos = new ArrayList<>();
	
	static Scanner scanner = new Scanner(System.in);
	static int idIncremental = 0;
	
	public static int aumentarIdIncremental () {
		return idIncremental++;
	}
	
	public static void crearPrestamo(Prestamo nuevoPrestamo) {
				prestamos.add(nuevoPrestamo);
				nuevoPrestamo.getLibro().setEstado(false);
				System.out.println("Ya puede llevarse su libro...");
		}	
	

	
	
	
/*	public static void devolverPrestamo(int id) throws LibroNoEncontradoException {
		Libro libroBuscado = CollectionLibro.buscarLibros(id);
		if (libroBuscado != null) {
			libroBuscado.setEstado(true);
			System.out.println("Muchas gracias por devolver el libro a tiempo ");
		}*/	
	//}
	
	public static void devolverPrestamo(int id) throws LibroNoEncontradoException {
		Libro libroBuscado = CollectionLibro.buscarLibros(id);
		Prestamo prestamo = null;
			if(libroBuscado.isEstado()) {
				System.out.println("Este libro ya ha sido devuelto...");
			}
		
		
			for (Prestamo p : prestamos) {
				if(p.getLibro().getId() == id) {
					prestamo = p;
					break;
				}
			}
			
			if (prestamo != null) {
				System.out.println("Gracias " + prestamo.getUsuario().getNombre() + " " + prestamo.getUsuario().getApellido() + " por devolver el libro: " + prestamo.getLibro().getTitulo());
				libroBuscado.setEstado(true);
				prestamo.setFechaDevolucion(prestamo.registrarDevolucion());
				System.out.println("Ahora este libro vuelve a estar disponible!");
				System.out.println("Fecha de devolucion del libro: " + prestamo.getFechaDevolucion());
			}
	}
	
}
