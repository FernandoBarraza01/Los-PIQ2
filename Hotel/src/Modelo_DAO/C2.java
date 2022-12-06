package Modelo_DAO;

public class C2 {
	
	private int idRes ;
	private String fechaLlegada, fechaSalida, nombre, apellidos, tel, tipoHab, status;
	private double precio;
	
	public C2(int idRes, String fechaLlegada, String fechaSalida, String nombre, String apellidos, String tel,
			String tipoHab, String status, double precio) {
		super();
		this.idRes = idRes;
		this.fechaLlegada = fechaLlegada;
		this.fechaSalida = fechaSalida;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.tel = tel;
		this.tipoHab = tipoHab;
		this.status = status;
		this.precio = precio;
	}
	public C2(int idRes) {
		
		this.idRes = idRes;
		
	}
	public int getIdRes() {
		return idRes;
	}
	public void setIdRes(int idRes) {
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
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getTipoHab() {
		return tipoHab;
	}
	public void setTipoHab(String tipoHab) {
		this.tipoHab = tipoHab;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	@Override
	public String toString() {
		return "C2 [idRes=" + idRes + ", fechaLlegada=" + fechaLlegada + ", fechaSalida=" + fechaSalida + ", nombre="
				+ nombre + ", apellidos=" + apellidos + ", tel=" + tel + ", tipoHab=" + tipoHab + ", status=" + status
				+ ", precio=" + precio + "]";
	}
	
	
	

}
