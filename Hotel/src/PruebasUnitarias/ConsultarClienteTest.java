package PruebasUnitarias;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Modelo_DAO.C3;
import Modelo_DAO.M_ConsultarCliente;
/*
 * @author Fernando Barraza 
 * Prueba unitaria de HU-5
 */
class ConsultarClienteTest {
	
	private C3 c3= new C3(null,null);
	private M_ConsultarCliente cc= new M_ConsultarCliente(c3.getNombre(),c3.getApellidos());
	
	@BeforeEach
	void setUp() throws Exception {
		c3.setNombre("Juan");
		c3.setApellidos("");
	}

	@Test
	void test() {
		//Caso de prueba 1: Corroborar que para Consultar un cliente, los campos nombres y apellidos no pueden ser nulos
		boolean resultado= cc.ValidarNombreApellido(c3.getNombre(), c3.getApellidos());
		
		assertEquals(false,resultado);
	}

}
