package Modelo_DAO;

public class M_CancelarReservacion {
	
	int numRes;
	String status;

	public M_CancelarReservacion(int numRes,String status) {
		this.numRes = numRes;
		this.status = status;
	}
	
public void CancelarReserva() {
		
		R4 r = new R4 (numRes,status);
		DAO_CancRes daoc2 = new DAO_CancRes();
		daoc2.CancelarReserva(r);
		
	}

}
