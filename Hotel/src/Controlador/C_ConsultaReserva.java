package Controlador;

import Modelo_DAO.M_ConsultarCliente;
import Modelo_DAO.M_ConsultarReservacion;

public class C_ConsultaReserva {
	
	int numRes;

	public C_ConsultaReserva(int numRes) {
		this.numRes = numRes;
	}
	
public void ConsultaReserva() {
		
		M_ConsultarReservacion c2 = new M_ConsultarReservacion(numRes);
		c2.ConsultaReserva();
	}

}
