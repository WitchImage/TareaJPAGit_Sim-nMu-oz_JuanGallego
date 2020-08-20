package entidades;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("hora")
/**
 * Empleado cuyo salario se paga por horas trabajadas a la semana
 * @author Simón Felipe Muñoz Osorio
 * @author Juan Diego Gallego Giraldo
 * @version 1.0
 */
public class EmpleadoHora extends Empleado {
	private int horasTrabajadasSemana;
	private int horasTrabajadasTotales;
	
	public EmpleadoHora(String identificador, String nombre, double salario) {
		super(identificador, nombre, salario);
		horasTrabajadasSemana = 0;
		horasTrabajadasTotales = 0;
	}
	
	/**
	 * Añade horas de trabajo
	 * @param horas las horas a añadir
	 */
	public void añadirHorasTrabajadas(int horas) {
		horasTrabajadasSemana += horas;
		horasTrabajadasTotales += horas;
	}
	
	/**
	 * Reinicia en 0 las horas trabajadas en la semana
	 */
	public void reiniciarSemana() {
		horasTrabajadasSemana = 0;
	}
	
	@Override
	public double calcularNomina() {
		return getSalario()*horasTrabajadasSemana;
	}

	public int getHorasTrabajadasSemana() {
		return horasTrabajadasSemana;
	}

	public void setHorasTrabajadasSemana(int horasTrabajadasSemana) {
		this.horasTrabajadasSemana = horasTrabajadasSemana;
	}

	public int getHorasTrabajadasTotales() {
		return horasTrabajadasTotales;
	}

	public void setHorasTrabajadasTotales(int horasTrabajadasTotales) {
		this.horasTrabajadasTotales = horasTrabajadasTotales;
	}
	
}
