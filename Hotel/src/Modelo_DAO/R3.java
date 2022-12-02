package Modelo_DAO;

public class R3 {
	
	private String fechaLlegada, fechaSalida, tipoHab;
	private double precio;
	private int idRes;
	
	
	public R3(int idRes,String fechaLlegada, String fechaSalida, String tipoHab, double precio) {
		super();
		this.fechaLlegada = fechaLlegada;
		this.fechaSalida = fechaSalida;
		this.tipoHab = tipoHab;
		this.precio = precio;
		this.idRes = idRes;
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
	public int getTipoHab() {
		if(tipoHab.equals("sencilla")) 
			return 1;
		else 
			return 2;
		
	}
	public void setTipoHab(String tipoHab) {
		this.tipoHab = tipoHab;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getIdRes() {
		return idRes;
	}
	public void setIdRes(int idRes) {
		this.idRes = idRes;
	}

	@Override
	public String toString() {
		return "R3 [fechaLlegada=" + fechaLlegada + ", fechaSalida=" + fechaSalida + ", tipoHab=" + tipoHab
				+ ", precio=" + precio + ", idRes=" + idRes + "]";
	}
	
	
}
	

	