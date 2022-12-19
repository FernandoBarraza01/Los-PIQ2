package PruebasUnitarias;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Modelo_DAO.Ing2;
import Modelo_DAO.M_CambioContr;
/*
 * @author Juan Pablo Trejo
 * Prueba unitaria HU-9
 */
class CambioContrTest {
	private Ing2 i2 =new Ing2(null,null);
	private M_CambioContr cc=new M_CambioContr(i2.getClaveOld(),i2.getClaveNew(),null);

	@BeforeEach
	void setUp() throws Exception {
		i2.setClaveNew("clave123");
		
	}

	@Test
	void test() {
		//Caso de prueba 1: corroborar que la nueva clave coincide con la confirmación de dicha clave
		boolean resultado= cc.CompararClaves(i2.getClaveNew(), "clave123");
		
		assertEquals(true,resultado);
		
	}

}
