package helpers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Fecha {

	private static final DateTimeFormatter FORMATO_FECHA_HORA = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	public static String get() {
		return LocalDateTime.now().format(FORMATO_FECHA_HORA);
	}

	public static final String getTiempo = get();
}