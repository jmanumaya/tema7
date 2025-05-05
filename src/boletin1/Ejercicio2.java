package boletin1;

import java.util.*;
import java.sql.*;

public class Ejercicio2 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String url = "jdbc:mysql://localhost/InstitutoDB";
		String usuario = "root";
		
		String pass = "";
		
		System.out.print(usuario + " Introduce su Contraseña: ");
		pass = sc.next();
		
		try(Connection con = DriverManager.getConnection(url, usuario, pass)){
			System.out.println("Conexión Realizada Correctamente");
			
			Statement sent = con.createStatement();
			
			// 2. Realiza diversas actualizaciones en las distintas tablas de la base de datos institutodb.
			
		//	System.out.println(sent.executeUpdate("UPDATE Estudiantes Set apellido = 'Maya Hidalgo' where id_estudiante = 4"));
		//	System.out.println(sent.executeUpdate("UPDATE Profesores Set email = 'david.bermudez@gmail.com' where id_profesor = 3"));
		//	System.out.println(sent.executeUpdate("UPDATE Cursos Set nombre = 'DAM 1º' where id_curso = 3"));
		//	System.out.println(sent.executeUpdate("UPDATE Matriculas Set fecha_matricula = '2024-07-15' where id_matricula = 5"));
			
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		sc.close();
	}

}
