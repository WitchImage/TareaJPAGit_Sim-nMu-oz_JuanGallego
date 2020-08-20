package persistencia;

import java.util.List;

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
				Persistence.createEntityManagerFactory("empleadosBD");
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
		if(!identificadorEmpleado.isEmpty()) {
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
            Query result = gestorBD.createQuery("select e from Empleado e");
            return result.getMaxResults();
        }catch(Exception e) {
        	return -1;
        }
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Empleado> obtenerEmpleados() {
		Query query = gestorBD.createQuery("select e from Empleado e");
		List<Empleado> empleados = query.getResultList();
		return empleados;
	}
	
	
	
	/**
	 * Cierra el EntitiyManager cuando se vaya a destruir este objeto
	 */
	@Override
	protected void finalize() {
		gestorBD.close();
	}

}
