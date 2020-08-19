package control;

import entidades.Empleado;
import entidades.Fabrica;
import persistencia.ListaEmpleados;
import persistencia.Persistencia;

/**
 * clase encargada del control del programa
 * @author Simón Felipe Muñoz Osorio
 * @author Juan Diego Gallego Giraldo
 * @version 2.0
 *
 */
public class Control {

	private Persistencia empleados;
	
	public Control() {
		empleados=new ListaEmpleados();
	}
	
	/***
	 * metodo que permite agregar un nuevo empleado a la persistencia 
	 * @param nombre el nombre del empleado a ingresar
	 * @param salario el salario que ganara el empleado en la compañia
	 * @param tipo el tipo de contrato que tiene el empleado
	 * @return si se logro o no ingresar el empleado
	 */
	public boolean añadirEmpleado(String nombre,double salario,char tipo) {
		if(salario<1) {
			return false;
		}
		int nuevoIdentificador=generaNuevoIdentificador();
		if (nuevoIdentificador>0) {
			String identificadorBusqueda=Integer.toString(nuevoIdentificador);
			Empleado empleadoBuscado=empleados.obtenerEmpleado(identificadorBusqueda);
			if(empleadoBuscado==null) {
				Empleado nuevoEmpleado=Fabrica.construirEmpleado(identificadorBusqueda,nombre,salario, tipo);
				empleados.añadirEmpleado(nuevoEmpleado);
			}else
			{
				return false;
			}
				
			
		}
		
	}
	
	/**
	 * metodo que permite buscar un empleado en la persistencia
	 * @param identificador el numero de identificacion del empleado
	 * @return el empleado si lo encuentra o null si no lo encuentra
	 */
	public Empleado buscarEmpleado(String identificador) {
		return empleados.obtenerEmpleado(identificador);
	}
	
	
	public int generaNuevoIdentificador() {
		int numeroBuscado;
		numeroBuscado=this.empleados.obtenerTotalEmpleados();
		if (numeroBuscado>0) {
			return numeroBuscado+1;
		}else {
			return 0;
		}
		
	}
	
	
	
	
	
}
