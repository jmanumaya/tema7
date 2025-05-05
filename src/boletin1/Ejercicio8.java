package boletin1;

import java.sql.*;
import java.util.*;

public class Ejercicio8 {

public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String url = "jdbc:mysql://localhost/InstitutoDB";
		String usuario = "root";
		
		String pass = "";
		
		int idEstudiante;
		
		System.out.println(usuario + " Introduce su Contraseña: ");
		pass = sc.next();
		
		try(Connection con = DriverManager.getConnection(url, usuario, pass)){
			System.out.println("Conexión Realizada Correctamente");
			
			Statement sent = con.createStatement();
			
			/*8. Realiza una aplicación que solicite el id de un estudiante y lo elimine de la base de datos.*/
			
			System.out.println("Introduce el ID del Estudiante a eliminar: ");
			idEstudiante = sc.nextInt();
			
			System.out.println("Filas eliminadas: " + sent.executeUpdate("DELETE from Estudiantes where id_estudiante = " + idEstudiante));
			
		} catch (SQLException e) {
			System.out.println(e);
		}

		sc.close();
	}

}
