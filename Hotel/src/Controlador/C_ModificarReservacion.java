package Controlador;

import Modelo_DAO.M_CancelarReservacion;
import Modelo_DAO.M_ModificarReservacion;
import Modelo_DAO.M_RealizarReservacion;

public class C_ModificarReservacion {
	
	String fechaLlegada, fechaSalida, tipoHab;
	double precio;
	int idRes;

	public C_ModificarReservacion(int idRes,String fechaLlegada, String fechaSalida,String tipoHab, double precio) {
		this.idRes = idRes;
		this.fechaLlegada = fechaLlegada;
		this.fechaSalida = fechaSalida;
		this.tipoHab = tipoHab;
		this.precio = precio;
		
	}	
	
	public void Reservacion() {
		M_ModificarReservacion r1 = new M_ModificarReservacion(idRes,fechaLlegada, fechaSalida, tipoHab, precio);
		r1.ModifReserva();
		
	}
	

}
