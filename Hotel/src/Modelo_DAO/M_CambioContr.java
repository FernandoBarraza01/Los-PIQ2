package Modelo_DAO;
/*
 * @author Juan Pablo Trejo
 */

public class M_CambioContr {
	String claveOld;
	String claveNew;
	String claveConf;
	String clavebd;
	
	
	public M_CambioContr(String claveOld, String claveNew, String claveConf) {
		super();
		this.claveOld = claveOld;
		this.claveNew = claveNew;
		this.claveConf = claveConf;
	}

	public Integer CambioContr() {
		Ing2 i=new Ing2(claveOld,claveNew);
		DAO_CambioContr daoing= new DAO_CambioContr();
		clavebd=daoing.ObtenerContr(i);
		if(ValidarClaves(claveOld,clavebd)) {
			if(CompararClaves(claveNew,claveConf)) {
				i=new Ing2(claveOld,claveNew);
				daoing.CambioContr(i);
				return 3;
			}
			else
				return 2;
		}
		else
			return 1;
		
	}
	
	public boolean ValidarClaves(String clave,String clavebd) {
		if(clave.equals(clavebd))
			return true;
		else
				return false;
	}
	
	public boolean CompararClaves(String claveNew,String claveConf) {
		if(claveNew.equals(claveConf))
			return true;
		else
				return false;
	}
	
}
