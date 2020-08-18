package persistencia;

import java.util.List;

import entidades.Empleado;
/**
 * clase lista que permite implementar la persistencia en memoria 
 * @author JUANDIEGO
 * @version 1.0 17/08/2020
 */
public class ListaEmpleados implements Persistencia {
	
	private List<Empleado> empleados;

	@Override
	public void añadirEmpleado(Empleado empleado) {
		if (empleado!=null) {
			this.empleados.add(empleado);
		}
		
	}

	@Override
	public void eliminarEmpleado(Empleado empleado) {
		Empleado empleadoBuscado=obtenerEmpleado(empleado.getIdentificador());
		if(empleadoBuscado!=null) {
			this.empleados.remove(empleadoBuscado);
		}
	}

	@Override
	public Empleado obtenerEmpleado(String identificadorEmpleado) {
		if(!identificadorEmpleado.isBlank()) {
			for(Empleado e: this.empleados) {
				if(identificadorEmpleado.equalsIgnoreCase(e.getIdentificador())) {
					return e;
				}
			}
		}
		return null;
	}
	
	

}
