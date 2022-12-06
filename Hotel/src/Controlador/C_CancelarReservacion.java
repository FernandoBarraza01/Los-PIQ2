package Controlador;

import Modelo_DAO.M_CancelarReservacion;

public class C_CancelarReservacion {
	
	int numRes;
	String status;

	public C_CancelarReservacion(int numRes,String status) {
		this.numRes = numRes;
		this.status = status;
	}
	
public void CancelarReservacion() {
		
		M_CancelarReservacion c2 = new M_CancelarReservacion(numRes, status);
		c2.CancelarReserva();
	}

}
