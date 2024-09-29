package ar.edu.unju.escmi.poo.main;

import java.util.InputMismatchException;
import java.util.Scanner;

import ar.edu.unju.escmi.poo.collections.CollectionLibro;
import ar.edu.unju.escmi.poo.collections.CollectionPrestamo;
import ar.edu.unju.escmi.poo.collections.CollectionUsuario;
import ar.edu.unju.escmi.poo.exceptions.LibroNoEncontradoException;
import ar.edu.unju.escmi.poo.exceptions.UsuarioNoRegistradoException;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		CollectionLibro.precargarLibros();
		CollectionUsuario.precargarUsuarios();
		int opcion = 0;
		
		do {
			try {
			System.out.println("Menú de Opciones");
			System.out.println("----------------");
			System.out.println
			("1 - Registrar libro.\n" + 
			 "2 - Registrar usuario.\n" +
			 "3 - Préstamo de libro.\n" +
			 "4 - Devolución de libro.\n" +
			 "5 - Listar libros. \n" + 
			 "6 - Salir");
			System.out.println("Ingrese una opción");
			
			
			opcion = scanner.nextInt();
			scanner.nextLine();
			
			}catch(InputMismatchException e) {
				System.out.println("Opcion Inválida. Intente de nuevo ");
				scanner.nextLine();
				opcion = 999;
			}
						
			switch(opcion) {
			
			case 1:	
				try {
					CollectionLibro.registrarLibro();
				} catch (UsuarioNoRegistradoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					break;
			case 2:
				try {
					System.out.println("¿Desea ingresar un bibliotecario o un alumno?");
					String tipo = scanner.nextLine();
					if (tipo.equalsIgnoreCase("alumno") || tipo.equalsIgnoreCase("bibliotecario")) {
					CollectionUsuario.registrarUsuario(tipo);
					}else {
						System.out.println("Algo falló en la ejecución. Intentelo de nuevo.");
					}
				}catch(Exception e) {
					System.out.println("Algo falló en la ejecucion. Intentelo de nuevo: " + e.getMessage());
				}
					break;
					
			case 3: 
					CollectionPrestamo.crearPrestamo();
					break;
					
			case 4: 
				try {
					System.out.println("Ingrese el id del libro devuelto: ");
					int idDevuelto = scanner.nextInt();
					scanner.nextLine();
					CollectionPrestamo.devolverPrestamo(idDevuelto);
				}catch(LibroNoEncontradoException e) {
					e.printStackTrace();
				}catch(Exception e) {
					System.out.println("Algo salió mal. Intentelo de nuevo");
					
				}
					break;
			
			case 5:
					CollectionLibro.listarLibros();
					break;
			case 6: 
					System.out.println("Saliendo del programa...");
					break;
					

			default:
				
				System.out.println("*Numero fuera de rango [1-5]*");
				break;
				
			}
				
		}while (opcion != 6);
		scanner.close();
	}


}
