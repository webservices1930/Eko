package co.edu.javeriana.eko.model;

public class Disponibilidad {
	private String fecha;
	private int cuposDisponibles;
	
	// Constructores
	public Disponibilidad() {}
	
	public Disponibilidad(String fecha, int cuposDisponibles) {
		this.fecha = fecha;
		this.cuposDisponibles = cuposDisponibles;
	}

	// Getters y setters
	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getCuposDisponibles() {
		return cuposDisponibles;
	}

	public void setCuposDisponibles(int cuposDisponibles) {
		this.cuposDisponibles = cuposDisponibles;
	}
}
