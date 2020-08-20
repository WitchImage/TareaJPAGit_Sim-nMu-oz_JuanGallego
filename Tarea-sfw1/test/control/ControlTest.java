package control;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Pruebas especificadas en el documento pdf
 * @author Simón Felipe Muñoz Osorio
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
	 * Agrega un empleado de cada tipo y comprueba su correcta inserción
	 */
	@Test
	void agregarEmpleadoCadaTipo() {
		Control control = new Control();
		control.añadirEmpleado("abc", "Simon", 1000, 'a');
		control.añadirEmpleado("qwe", "Diego", 700, 'c');
		control.añadirEmpleado("zxc", "Sandra", 100, 'h');
		assertNotEquals(null, control.buscarEmpleado("abc"));
		assertNotEquals(null, control.buscarEmpleado("qwe"));
		assertNotEquals(null, control.buscarEmpleado("zxc"));
	}
	
	/**
	 * Calcula la nomina de los tres empleados añadidos en el anterior test
	 */
	@Test
	void calcularNominaTresEmpleados() {
		Control control = new Control();
		assertEquals(1700.0, control.calcularNominaSemanal());
	}
}
