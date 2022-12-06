package Modelo_DAO;

public class M_ConsultarReservacion {
	
	int numRes;

	public M_ConsultarReservacion(int numRes) {
		super();
		this.numRes = numRes;
	}
	
public void ConsultaReserva() {
		
		C2 c = new C2 (numRes);
		DAO_ConsRes daoc2 = new DAO_ConsRes();
		daoc2.ConsultaReserva(c);
	}

}
