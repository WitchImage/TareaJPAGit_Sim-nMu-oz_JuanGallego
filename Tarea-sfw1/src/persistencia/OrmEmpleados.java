package persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entidades.Empleado;

/**
 * clase que permite la implementacion de la persistencia en la base de datos por medio de ORM
 * @author JUANDIEGO
 * @version 1.0 17/08/2020
 */

public class OrmEmpleados implements Persistencia {
	
	private EntityManager gestorBD;
	
	public OrmEmpleados() {
		EntityManagerFactory fabrica= 
				Persistence.createEntityManagerFactory("EmpleadosBD");
		gestorBD= fabrica.createEntityManager();
	}

	@Override
	public void añadirEmpleado(Empleado empleado) {
		
		if(empleado!=null) {
			try {
				gestorBD.getTransaction().begin();
				gestorBD.persist(empleado);
				gestorBD.getTransaction().commit();
				
			}catch(Exception er) {
				
			}			
		}

		
	}

	@Override
	public void eliminarEmpleado(Empleado empleado) {
		
		Empleado empleadoBuscado=obtenerEmpleado(empleado.getIdentificador());
		if(empleadoBuscado!=null) {
			try {
				gestorBD.remove(empleado);
				gestorBD.getTransaction().commit();
				
			}catch(Exception er) {
				
			}
		}
		
	}

	@Override
	public Empleado obtenerEmpleado(String identificadorEmpleado) {
		if(!identificadorEmpleado.isBlank()) {
			Empleado empleadoBuscado = gestorBD.find(Empleado.class, identificadorEmpleado);
			if (empleadoBuscado!=null) {
				return empleadoBuscado;
			}
		}
		return null;
	}

}
