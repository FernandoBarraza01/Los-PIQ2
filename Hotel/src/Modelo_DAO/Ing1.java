package Modelo_DAO;

public class Ing1 {
	private String claveing;
	private String clavebd;
	
	public Ing1(String clave) {
		claveing=clave;
	}
	
	public String getClave() {
		return claveing;
	}

	public void setClave(String clave) {
		clavebd = clave;
	}

	@Override
	public String toString() {
		return "Ing1 [claveing=" + claveing + ", clavebd=" + clavebd + "]";
	}

	
	
	

}
