package Modelo_DAO;
/*
 * @author Luis Fernando Lopez
 */

public class M_Ingreso {
	String clave;
	String clavebd;
	
	public M_Ingreso(String clave) {
		this.clave=clave;
		
	}
	
	public boolean Ingreso() {
		Ing1 i=new Ing1(clave);
		DAO_Ingreso daoing = new DAO_Ingreso();
		clavebd=daoing.Ingreso(i);
		return ValidarClaves(clave,clavebd);
	}
	
	public boolean ValidarClaves(String clave,String clavebd) {
		if(clave.equals(clavebd))
			return true;
		else
				return false;
	}
}
