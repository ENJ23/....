package ar.edu.unju.escmi.poo.dominio;

import java.time.LocalDate;

public class Prestamo {
	
	private int id;
	private LocalDate fechaPrestamo;
	private LocalDate fechaDevolucion;
	private Libro libro;
	private Usuario usuario;
	
	
	public Prestamo(int id, LocalDate fechaPrestamo, LocalDate fechaDevolucion, Libro libro, Usuario usuario) {
		super();
		this.id = id;
		this.fechaPrestamo = fechaPrestamo;
		this.fechaDevolucion = fechaDevolucion;
		this.libro = libro;
		this.usuario = usuario;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public LocalDate getFechaPrestamo() {
		return fechaPrestamo;
	}


	public void setFechaPrestamo(LocalDate fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}


	public LocalDate getFechaDevolucion() {
		return fechaDevolucion;
	}


	public void setFechaDevolucion(LocalDate fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}


	public Libro getLibro() {
		return libro;
	}


	public void setLibro(Libro libro) {
		this.libro = libro;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
		
}
