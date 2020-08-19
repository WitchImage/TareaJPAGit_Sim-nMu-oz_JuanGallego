package entidades;

public class Fabrica {
	/**
	 * Crea un nuevo Empleado
	 * @param identificador el identificador del empleado
	 * @param nombre el nombre del empleado
	 * @param salario el salario del empleado
	 * @param tipo el tipo de empleado (a: asalariado, c: comisión, h: hora)
	 * @return el empleado o null si no se ingreso un tipo de empelado correcto
	 */
	public static Empleado construirEmpleado(String identificador, String nombre,
											double salario, char tipo) {
		switch (tipo) {
		case 'a': 	return new EmpleadoAsalariado(identificador, nombre, salario);
		case 'c': 	return new EmpleadoComision(identificador, nombre, salario);
		case 'h':	return new EmpleadoHora(identificador, nombre, salario);
		}
		return null;
	}
}
