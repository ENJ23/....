package ar.edu.unju.escmi.poo.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class FechaUtil {
	
	public static LocalDate convertirStringLocalDate(String fechaStr) {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		try {
            return LocalDate.parse(fechaStr, formatter);
        } catch (DateTimeParseException e) {
            throw new DateTimeParseException("Error al convertir la fecha: " + fechaStr, fechaStr, e.getErrorIndex(), e);
        }
	}
}
