package Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entidades.Empleado;
import entidades.EmpleadoAsalariado;

public class main {

	public static void main(String[] args) {
		 EntityManagerFactory fabrica=	
				 Persistence.createEntityManagerFactory("empleadosBD");
		 EntityManager gestorbd = fabrica.createEntityManager();
		 
	}

}
