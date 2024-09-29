package ar.edu.unju.escmi.poo.dominio;

public class Alumno extends Usuario {

	private String curso;
	private String lu;
	

	public Alumno(int id, String nombre, String apellido, String email, String curso, String lu) {
		super(id, nombre, apellido, email);
		this.curso = curso;
		this.lu = lu;
	}


	public String getCurso() {
		return curso;
	}


	public void setCurso(String curso) {
		this.curso = curso;
	}


	public String getLu() {
		return lu;
	}


	public void setLu(String lu) {
		this.lu = lu;
	}
	
	
}
