package PruebasUnitarias;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Modelo_DAO.Ing1;
import Modelo_DAO.M_Ingreso;
/*
 * @author Luis Fernando Lopez
 * Prueba unitaria HU-8
 */

class IngresoTest {
	private Ing1 i1=new Ing1(null);
	private M_Ingreso ing=new M_Ingreso(i1.getClave());
	

	@BeforeEach
	void setUp() throws Exception {
		i1.setClave("user123");
		
	}
	

	@Test
	void test() {
		//caso de prueba 1: corrobora que la clave ingresada es correcta
		boolean resultado = ing.ValidarClaves(i1.getClavebd(), "user123");
		assertEquals(true,resultado);
	}

}
