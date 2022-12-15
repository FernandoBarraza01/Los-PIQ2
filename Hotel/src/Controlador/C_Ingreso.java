package Controlador;

import Modelo_DAO.M_ConsultarDisponibilidad;
import Modelo_DAO.M_Ingreso;

public class C_Ingreso {
	String clave;
	
	public C_Ingreso(String clave) {
		this.clave=clave;	
	}
	
	public boolean Ingreso() {
		M_Ingreso ing = new M_Ingreso(clave);
		return ing.Ingreso();
	}

}
