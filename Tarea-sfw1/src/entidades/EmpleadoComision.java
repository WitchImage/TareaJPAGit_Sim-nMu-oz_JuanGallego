package entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("comision")
/**
 * Empleado por comisión que gana su salario semanal más un 5% por las ventas realizadas
 * @author Simón Felipe Muñoz Osorio
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
	 * Añade una nueva venta a la lista de ventas del empleado
	 * @param valorVenta el valor de la venta a añadir
	 */
	public void añadirVenta(double valorVenta) {
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
