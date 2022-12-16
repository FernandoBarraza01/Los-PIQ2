package Controlador;

import Modelo_DAO.M_CambioContr;

public class C_CambioContr {
	String claveOld;
	String claveNew;
	String claveConf;
	
	public C_CambioContr(String claveOld, String claveNew, String claveConf) {
		super();
		this.claveOld = claveOld;
		this.claveNew = claveNew;
		this.claveConf = claveConf;
	}

	public Integer CambioContr() {
		M_CambioContr ing = new M_CambioContr(claveOld,claveNew,claveConf);
		return ing.CambioContr();
	}
}
