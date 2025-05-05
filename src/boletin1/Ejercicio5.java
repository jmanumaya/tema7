package boletin1;

import java.sql.*;
import java.util.*;

public class Ejercicio5 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String url = "jdbc:mysql://localhost/InstitutoDB";
		String usuario = "root";
		
		String pass = "";
		
		System.out.print(usuario + " Introduce su Contraseña: ");
		pass = sc.next();
		
		try(Connection con = DriverManager.getConnection(url, usuario, pass)){
			System.out.println("Conexión Realizada Correctamente.");
			
			Statement sent = con.createStatement();
			
			// Prueba de añadir notas a los distintos alumnos en las distintas asignaturas (las añadidas en el ejericio 4)
			
			System.out.println(sent.executeUpdate("INSERT into Calificaciones (id_estudiante, id_curso, id_profesor, tipo_evaluacion, nota, fecha_evaluacion)"
					+ " values (1, 4, 1, 'Examen', 8.5, '2025-04-12')"));
			System.out.println(sent.executeUpdate("INSERT into Calificaciones (id_estudiante, id_curso, id_profesor, tipo_evaluacion, nota, fecha_evaluacion)"
					+ " values (1, 5, 2, 'Examen', 9, '2025-05-12')"));
			System.out.println(sent.executeUpdate("INSERT into Calificaciones (id_estudiante, id_curso, id_profesor, tipo_evaluacion, nota, fecha_evaluacion)"
					+ " values (2, 6, 1, 'Trabajo', 10, '2025-04-20')"));
			System.out.println(sent.executeUpdate("INSERT into Calificaciones (id_estudiante, id_curso, id_profesor, tipo_evaluacion, nota, fecha_evaluacion)"
					+ " values (2, 7, 2, 'Trabajo', 7, '2025-06-01')"));
			System.out.println(sent.executeUpdate("INSERT into Calificaciones (id_estudiante, id_curso, id_profesor, tipo_evaluacion, nota, fecha_evaluacion)"
					+ " values (3, 8, 1, 'Proyecto', 5, '2025-05-19')"));
			
		} catch (SQLException e) {
			System.out.println(e);
		}
		

	}

}
