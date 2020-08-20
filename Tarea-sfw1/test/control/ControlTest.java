package control;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * 
 * @author Sim�n Felipe Mu�oz Osorio
 *
 */
class ControlTest {

	/**
	 * Calcula la nomina de la empresa cuando no tiene empleados
	 */
	@Test
	void calcularNominaSinEmpleados() {
		Control control = new Control();
		assertEquals(0.0, control.calcularNominaSemanal());
	}
	
	

}
