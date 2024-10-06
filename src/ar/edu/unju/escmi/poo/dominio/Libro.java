package ar.edu.unju.escmi.poo.dominio;

public class Libro {
	
	private int id;
	private String titulo;
	private String autor;
	private String isbn;
	private boolean estado;
	
	
	
	public void mostrarDatos() {
		if (estado == false) {
			System.out.println("Libro no Disponible...");
		}else {
			System.out.println("Libro [id=" + id + ", titulo=" + titulo + ", autor=" + autor + ", isbn=" + isbn + ", estado=" + estado + "]");
		}
	}
	
	public Libro(int id, String titulo, String autor, String isbn, boolean estado) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.isbn = isbn;
		this.estado = estado;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	
}
