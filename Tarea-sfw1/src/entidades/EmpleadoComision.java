package entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("comision")
/**
 * Empleado por comisi�n que gana su salario semanal m�s un 5% por las ventas realizadas
 * @author Sim�n Felipe Mu�oz Osorio
 * @author Juan Diego Gallego Giraldo
 * @version 1.0
 */
public class EmpleadoComision extends Empleado {
	private List<Double> ventasSemana;
	private List<Double> ventasTotales;
	
	public EmpleadoComision(String identificador, String nombre, double salario) {
		super(identificador, nombre, salario);
		ventasSemana = new ArrayList<Double>();
		ventasTotales = new ArrayList<Double>();
	}
	
	/**
	 * A�ade una nueva venta a la lista de ventas del empleado
	 * @param valorVenta el valor de la venta a a�adir
	 */
	public void a�adirVenta(double valorVenta) {
		ventasSemana.add(valorVenta);
		ventasTotales.add(valorVenta);
	}
	
	/**
	 * @return el total de ventas en la semana actual
	 */
	public double obtenerVentasSemana() {
		double ventas = 0;
		for(Double venta: ventasSemana) {
			ventas += venta;
		}
		return ventas;
	}
	
	/**
	 * La reinicia a 0 las ventas realizadas en la semana
	 */
	public void reiniciarSemana() {
		ventasSemana.clear();
	}
	
	@Override
	public double calcularNomina() {
		return getSalario()+(obtenerVentasSemana()*0.05);
	}
	
	
}
