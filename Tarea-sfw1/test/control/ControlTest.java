package control;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Pruebas especificadas en el documento pdf
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
	
	/**
	 * Agrega un empleado de cada tipo y comprueba su correcta inserci�n
	 */
	@Test
	void agregarEmpleadoCadaTipo() {
		Control control = new Control();
		control.a�adirEmpleado("abc", "Simon", 1000, 'a');
		control.a�adirEmpleado("qwe", "Diego", 700, 'c');
		control.a�adirEmpleado("zxc", "Sandra", 100, 'h');
		assertNotEquals(null, control.buscarEmpleado("abc"));
		assertNotEquals(null, control.buscarEmpleado("qwe"));
		assertNotEquals(null, control.buscarEmpleado("zxc"));
	}
	
	/**
	 * Calcula la nomina de los tres empleados a�adidos en el anterior test
	 */
	@Test
	void calcularNominaTresEmpleados() {
		Control control = new Control();
		assertEquals(1700.0, control.calcularNominaSemanal());
	}
}
