package boletin1;

import java.sql.*;
import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String url = "jdbc:mysql://localhost/InstitutoDB";
		String usuario = "root";
		
		String pass = "";
		
		System.out.print(usuario + " Introduce su Contraseña: ");
		pass = sc.next();

		try (Connection con = DriverManager.getConnection(url, usuario, pass)){
			System.out.println("Conexión Realizada con Éxito");
			
			Statement sent = con.createStatement();
			
			// 3. Realiza una eliminación de registro en las distintas tablas de la base de datos institutodb.
			
		//	System.out.println("Filas eliminadas: " + sent.executeUpdate("DELETE from Matriculas where id_matricula = 5"));
		//	System.out.println("Filas eliminadas: " + sent.executeUpdate("DELETE from Estudiantes where id_estudiante = 4"));
		//	System.out.println("Filas eliminadas: " + sent.executeUpdate("DELETE from Profesores where id_profesor = 3"));
		//	System.out.println("Filas eliminadas: " + sent.executeUpdate("DELETE from Cursos where id_curso = 3"));
				
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		sc.close();
	}

}
