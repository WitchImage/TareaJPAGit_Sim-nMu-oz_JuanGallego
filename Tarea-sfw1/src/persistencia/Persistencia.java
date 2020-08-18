package persistencia;

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
	public void añadirEmpleado(Empleado empleado);
	
	/**
	 * metodo que permite eliminar un empleado de la persistencia
	 * @param empleado el empleado que se desea eliminar de la persistencia
	 * @version 1.0
	 */
	public void eliminarEmpleado(Empleado empleado);
	
	/**
	 * metodo que permite buscar un empleado en la persitencia
	 * @param identificadorEmpleado el identificador del empleado que se busca
	 * @return el empleado si se encuentra 
	 * @version 1.0
	 */
	public Empleado obtenerEmpleado(String identificadorEmpleado);
	
}
