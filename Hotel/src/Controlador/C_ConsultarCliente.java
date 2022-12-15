package Controlador;

import Modelo_DAO.M_ConsultarCliente;
import Modelo_DAO.M_RealizarReservacion;

public class C_ConsultarCliente {
	
	String  nombre, apellido;

	public C_ConsultarCliente(String nombre, String apellido) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
	}
	
	public boolean ConsultaCte() {
		
		M_ConsultarCliente c1 = new M_ConsultarCliente(nombre, apellido);
		return c1.ConsultaCte();
	}

}
