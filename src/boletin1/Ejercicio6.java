package boletin1;

import java.sql.*;
import java.util.*;

public class Ejercicio6 {

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
			
			// 6. Súmale un punto a Ana González en Matemáticas 1º.
			
		//	System.out.println("Filas actualizadas: " + sent.executeUpdate("UPDATE Calificaciones set nota = (nota + 1) where id_estudiante = 1 and id_curso = 1"));
			
		} catch (SQLException e) {
			System.out.println(e);
		}

		sc.close();
	}

}
