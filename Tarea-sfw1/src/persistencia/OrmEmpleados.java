package persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entidades.Empleado;

/**
 * clase que permite la implementacion de la persistencia en la base de datos por medio de ORM
 * @author JUANDIEGO
 * @version 1.5 19/08/2020
 */



public class OrmEmpleados implements Persistencia {
	
	private EntityManager gestorBD;
	
	public OrmEmpleados() {
		EntityManagerFactory fabrica= 
				Persistence.createEntityManagerFactory("EmpleadosBD");
		gestorBD= fabrica.createEntityManager();
	}

	@Override
	public boolean añadirEmpleado(Empleado empleado) {
		
		if(empleado!=null) {
			try {
				gestorBD.getTransaction().begin();
				gestorBD.persist(empleado);
				gestorBD.getTransaction().commit();
				return true;
			}catch(Exception er) {
				return false;
			}			
		}
		return false;

		
	}

	@Override
	public boolean eliminarEmpleado(Empleado empleado) {
		
		Empleado empleadoBuscado=obtenerEmpleado(empleado.getIdentificador());
		if(empleadoBuscado!=null) {
			try {
				gestorBD.remove(empleado);
				gestorBD.getTransaction().commit();
				return true;
			}catch(Exception er) {
				return false;
			}
		}
		return false;
		
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

	@Override
	public int obtenerTotalEmpleados() {
		try{
            Query result = gestorBD.createQuery("Select identificador from empleados");
            return result.getMaxResults();
        }finally{
            gestorBD.close();
        }
	}

}
