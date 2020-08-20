package persistencia;

import java.util.List;

import entidades.Empleado;
/**
 * clase lista que permite implementar la persistencia en memoria 
 * @author JUANDIEGO
 * @version 1.5 19/08/2020
 */
public class ListaEmpleados implements Persistencia {
	
	private List<Empleado> empleados;

	@Override
	public boolean añadirEmpleado(Empleado empleado) {
		if (empleado!=null) {
			this.empleados.add(empleado);
			return true;
		}
		return false;
	}

	@Override
	public boolean eliminarEmpleado(Empleado empleado) {
		Empleado empleadoBuscado=obtenerEmpleado(empleado.getIdentificador());
		if(empleadoBuscado!=null) {
			this.empleados.remove(empleadoBuscado);
			return true;
		}
		return false;
	}

	@Override
	public Empleado obtenerEmpleado(String identificadorEmpleado) {
		if(!identificadorEmpleado.isEmpty()) {
			for(Empleado e: this.empleados) {
				if(identificadorEmpleado.equalsIgnoreCase(e.getIdentificador())) {
					return e;
				}
			}
		}
		return null;
	}

	@Override
	public int obtenerTotalEmpleados() {
		return this.empleados.size();
	}

	@Override
	public List<Empleado> obtenerEmpleados() {
		return this.empleados;
	}
	
	

}
