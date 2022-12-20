package Modelo_DAO;

import Vista.ResultadosCliente;
/*
 * @author Fernando Barraza 
 */

public class M_ConsultarCliente {
	
	String  nombre, apellido;

	public M_ConsultarCliente(String nombre, String apellido) {
	
		this.nombre = nombre;
		this.apellido = apellido;
	}
	
	public boolean ConsultaCte() {
		if(ValidarNombreApellido(nombre,apellido)) {
			C3 c = new C3(nombre, apellido);
			DAO_ConsCte daoc1 = new DAO_ConsCte();
			daoc1.ConsultaCte(c);
			return true;
		}
		else
			return false;
	}
	
	//No permite que el nombre o apellidos sean nulos
	public boolean ValidarNombreApellido(String nombre, String apellido) {
		if(nombre.equals("") || apellido.equals(""))
			return false;
		else 
			return true;
	}

}
