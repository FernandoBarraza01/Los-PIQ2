package Vista;

public class Principal {
	

	public static void main(String[] args) {

		VentanaPrincipal vp = null;
		
		//Ingreso IN=new Ingreso();
		if(vp!=null) {
			vp.dispose();		
		}
		else {
			vp= new VentanaPrincipal("Hotel Las Gaviotas");
		}
	}
}

