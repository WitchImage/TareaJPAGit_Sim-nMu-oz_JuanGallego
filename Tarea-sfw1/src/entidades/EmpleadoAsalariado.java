package entidades;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("asalariado")
/**
 * Empleado que gana un sueldo fijo semanal
 * @author Sim�n Felipe Mu�oz Osorio
 * @author Juan Diego Gallego Giraldo
 * @version 1.0
 */
public class EmpleadoAsalariado extends Empleado {
	
	public EmpleadoAsalariado() {}
	
	public EmpleadoAsalariado(String identificador, String nombre, double salario) {
		super(identificador, nombre, salario);
	}
	
	@Override
	public double calcularNomina() {
		return getSalario();
	}
}
