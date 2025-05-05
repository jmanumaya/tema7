package boletin1;

import java.sql.*;
import java.util.*;

public class Ejercicio4 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String url = "jdbc:mysql://localhost/InstitutoDB";
		String usuario = "root";
		
		String pass = "";
		
		System.out.println(usuario + " Introduce su Contraseña: ");
		pass = sc.next();
		
		try(Connection con = DriverManager.getConnection(url, usuario, pass)){
			System.out.println("Conexión Realizada Correctamente");
			
			Statement sent = con.createStatement();

		//	System.out.println(sent.executeUpdate("INSERT into Cursos (nombre, descripcion, año_escolar) values ('Historia 1º', 'Curso de Historia para el primer año', 2025)"));
		//	System.out.println(sent.executeUpdate("INSERT into Cursos (nombre, descripcion, año_escolar) values ('Biología 1º', 'Curso de Biología para el primer año', 2025)"));
		//	System.out.println(sent.executeUpdate("INSERT into Cursos (nombre, descripcion, año_escolar) values ('Educación Física 1º', 'Curso de Educación Física para el primer año', 2025)"));
		//	System.out.println(sent.executeUpdate("INSERT into Cursos (nombre, descripcion, año_escolar) values ('Música 1º', 'Curso de Música para el primer año', 2025)"));
		//	System.out.println(sent.executeUpdate("INSERT into Cursos (nombre, descripcion, año_escolar) values ('Tecnología 1º', 'Curso de Tecnología para el primer año', 2025)"));
			
		} catch (SQLException e) {
			System.out.println(e);
		}

		sc.close();
	}

}
