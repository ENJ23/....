package ar.edu.unju.escmi.poo.collections;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.escmi.poo.dominio.Alumno;
import ar.edu.unju.escmi.poo.dominio.Libro;
import ar.edu.unju.escmi.poo.dominio.Prestamo;
import ar.edu.unju.escmi.poo.exceptions.LibroNoDisponibleException;
import ar.edu.unju.escmi.poo.exceptions.LibroNoEncontradoException;
import ar.edu.unju.escmi.poo.exceptions.UsuarioNoRegistradoException;
import ar.edu.unju.escmi.poo.util.FechaUtil;

public class CollectionPrestamo {
	
	public static List<Prestamo> prestamos = new ArrayList<>();
	
	static Scanner scanner = new Scanner(System.in);
	static int idIncremental = 0;
	
	public static void crearPrestamo() {

		idIncremental++;
		LocalDate fechaPeticion = LocalDate.now();
		System.out.println("Ingrese la fecha de devolucion del libro: (dd/MM/YYYY)");
		String fechaStr = scanner.nextLine();
		
		try {
            LocalDate fechaTransformada = FechaUtil.convertirStringLocalDate(fechaStr);
            System.out.println("La fecha de entrega es: " + fechaTransformada);
        
		
		System.out.println("Ingrse el id del Libro a prestar: ");
		int idLibroBuscado = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Ingrese la libreta universitaria del alumno: ");
		String luSolicitante= scanner.nextLine();

		Libro libroBuscado = CollectionLibro.buscarLibroDisponible(idLibroBuscado);
		Alumno alumnoBuscado = CollectionUsuario.buscarUsuario(luSolicitante);
		if (libroBuscado != null && CollectionLibro.isDisponible(libroBuscado)) {
			if (alumnoBuscado != null) {
				Prestamo nuevoPrestamo = new Prestamo(idIncremental,fechaPeticion,fechaTransformada,libroBuscado,alumnoBuscado);
				prestamos.add(nuevoPrestamo);
				nuevoPrestamo.getLibro().setEstado(false);
				System.out.println("Ya puede llevarse su libro...");
			}
//			else {
//				System.out.println("Alumno no encontrado...");
//			}
		}
//		else {
//			System.out.println("Libro no encontrado...");
//		}
//		
		
		}catch (DateTimeParseException e) {
            System.out.println(e.getMessage());
        }catch (InputMismatchException e) {
        	System.out.println("Dato ingresado incorrectamente.Intentelo de nuevo");
        } catch (UsuarioNoRegistradoException e) {
			// TODO Auto-generated catch block
        	System.out.println("Usuario no encontrado");
        	e.getMessage();
			e.printStackTrace();
		} catch (LibroNoEncontradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LibroNoDisponibleException e) {
			// TODO Auto-generated catch block
			System.out.println("Libro no disponible para el prestamo");
			e.getMessage();
			e.printStackTrace();
		}

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
				System.out.println("Ahora este libro vuelve a estar disponible!");
			}
	}
	
}
