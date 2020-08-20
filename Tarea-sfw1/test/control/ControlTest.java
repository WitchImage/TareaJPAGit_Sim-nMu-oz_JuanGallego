package control;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * 
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
	 * Crea una empleado de cada tipo y verifica que se haya creado con éxito por medio
	 * de una consulta a la BD
	 */
	@Test
	void crearEmpleadoCadaTipo() {
		Control control = new Control();
		control.añadirEmpleado("a1", "Simón", 10000, 'a');
		control.añadirEmpleado("a2", "Diego", 5000, 'c');
		control.añadirEmpleado("a3", "Sandra", 100, 'h');
		
		//control.buscarEmpleado("")
	}

}
