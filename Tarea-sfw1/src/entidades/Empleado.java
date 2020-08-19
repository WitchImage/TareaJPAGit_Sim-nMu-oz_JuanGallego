package entidades;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;


@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo")
/**
 * Empleado que puede ser asalario, por comisión o por hora
 * @author Simón Felipe Muñoz Osorio
 * @author Juan Diego Gallego Giraldo
 * @version 1.0
 */
public abstract class Empleado {
	private String identificador;
	private String nombre;
	private double salario;
	
	public Empleado(String identificador, String nombre, double salario) {
		this.identificador = identificador;
		this.nombre = nombre;
		this.salario = salario;
	}
	
	/**
	 * Calcula la nomina del empleado. Si el empleado es asalario, la nomina es su salario semanal;
	 * si el empleado es por comisión, la nomina es su salario semanal más un 5% de las ventas realizadas
	 * en la semana, y si es empleado por hora, su salario es el pago por horas trabajadas en la semana
	 * @return la nomina del empleado
	 */
	public abstract double calcularNomina();
	
	public String getIdentificador() {
		return identificador;
	}
	
	public double getSalario() {
		return salario;
	}
}
