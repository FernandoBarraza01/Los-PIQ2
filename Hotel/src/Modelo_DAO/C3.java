package Modelo_DAO;

public class C3 {
	
	private String nombre, apellidos, fechaLlegada, fechaSalida;
	private int numHab;
	
	public C3(String nombre, String apellidos, String fechaLlegada, String fechaSalida, int numHab) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaLlegada = fechaLlegada;
		this.fechaSalida = fechaSalida;
		this.numHab = numHab;
	}
	
	public C3(String nombre, String apellidos) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getFechaLlegada() {
		return fechaLlegada;
	}

	public void setFechaLlegada(String fechaLlegada) {
		this.fechaLlegada = fechaLlegada;
	}

	public String getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(String fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public int getNumHab() {
		return numHab;
	}

	public void setNumHab(int numHab) {
		this.numHab = numHab;
	}

	@Override
	public String toString() {
		return "C3 [nombre=" + nombre + ", apellidos=" + apellidos + ", fechaLlegada=" + fechaLlegada + ", fechaSalida="
				+ fechaSalida + ", numHab=" + numHab + "]";
	}
	
	
	
	
	

}
