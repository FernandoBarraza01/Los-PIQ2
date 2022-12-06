package Modelo_DAO;

public class M_ModificarReservacion {
	
	String fechaLlegada, fechaSalida, tipoHab;
	double precio;
	int idRes;

	public M_ModificarReservacion(int idRes,String fechaLlegada, String fechaSalida,String tipoHab, double precio) {
		this.idRes = idRes;
		this.fechaLlegada = fechaLlegada;
		this.fechaSalida = fechaSalida;
		this.tipoHab = tipoHab;
		this.precio = precio;
		
	}	
	
	public void ModifReserva() {
		
		R3 r = new R3(idRes,fechaLlegada, fechaSalida, tipoHab, precio);
		DAO_ModRes daor1 = new DAO_ModRes();
		daor1.ModifReserva(r);
		
	}

}
