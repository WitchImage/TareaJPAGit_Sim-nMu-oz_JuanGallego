package persistencia;

import java.util.List;

import entidades.Empleado;

/**
 * clase que permite la abstracion de la persistencia de los empleados
 * @author JUANDIEGO
 * @version 1.0 17/08/2020
 */

public interface Persistencia {

	/**
	 * metodo que permite agregar un empleado a la persistencia
	 * @param empleado el empleado que se desea eliminar de la persistencia
	 * @version 1.0
	 */
	public boolean añadirEmpleado(Empleado empleado);
	
	/**
	 * metodo que permite eliminar un empleado de la persistencia
	 * @param empleado el empleado que se desea eliminar de la persistencia
	 * @version 1.0
	 */
	public boolean eliminarEmpleado(Empleado empleado);
	
	/**
	 * metodo que permite buscar un empleado en la persitencia
	 * @param identificadorEmpleado el identificador del empleado que se busca
	 * @return el empleado si se encuentra 
	 * @version 1.0
	 */
	public Empleado obtenerEmpleado(String identificadorEmpleado);
	
	/**
	 * metodo que permite obtener el total de empleados de la compañia
	 * @return el numero total de empleados
	 */
	public int obtenerTotalEmpleados();
	
	/**
	 * metodo que permite obtener a todos los trabajadores de la compañia
	 * @return  l lista de empleados que pertenece a la compañia
	 */
	public List<Empleado> obtenerEmpleados();
}
