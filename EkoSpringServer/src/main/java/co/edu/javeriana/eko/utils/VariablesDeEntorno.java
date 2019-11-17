package co.edu.javeriana.eko.utils;

public final class VariablesDeEntorno {
	// Url base para todos los End Points del servidor
	public static final String urlDominio = "http://localhost:8080/eko/";
	
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";
	
	/* --- Se genera un Singleton de Variables de Entorno --- */
	private static final VariablesDeEntorno instance = new VariablesDeEntorno();
	
	public static VariablesDeEntorno getInstance() {
		return instance;
	}
}
