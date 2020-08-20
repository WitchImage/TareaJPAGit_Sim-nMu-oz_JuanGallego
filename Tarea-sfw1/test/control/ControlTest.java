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
	
	/**
	 * Crea una empleado de cada tipo y verifica que se haya creado con �xito por medio
	 * de una consulta a la BD
	 */
	@Test
	void crearEmpleadoCadaTipo() {
		Control control = new Control();
		control.a�adirEmpleado("a1", "Sim�n", 10000, 'a');
		control.a�adirEmpleado("a2", "Diego", 5000, 'c');
		control.a�adirEmpleado("a3", "Sandra", 100, 'h');
		
		//control.buscarEmpleado("")
	}

}
