package boletin1;

import java.sql.*;
import java.util.*;

public class Ejercicio9 {

	public static void main(String[] args) {
			
		Scanner sc = new Scanner(System.in);
		
		String url = "jdbc:mysql://localhost/InstitutoDB";
		String usuario = "root";
		
		String pass = "";
		
		String nombre;
		String fechaNacimiento;
		
		System.out.println(usuario + " Introduce su Contraseña: ");
		pass = sc.next();
		
		try(Connection con = DriverManager.getConnection(url, usuario, pass)){
			System.out.println("Conexión Realizada Correctamente");
			
			Statement sent = con.createStatement();
			
			/*9. Mostrar el nombre y fecha de nacimiento de todos los alumnos.*/
			
			ResultSet rs = sent.executeQuery("Select nombre, fecha_nacimiento from Estudiantes");
			
			System.out.println("Nombre\t| Fecha Nacimiento"
					+ "\n--------------------------");
			
			while(rs.next()) {
				nombre = rs.getString("nombre");
				fechaNacimiento = rs.getString("fecha_nacimiento");
				System.out.println(nombre + "\t| " + fechaNacimiento);
			}
			
		} catch (SQLException e) {
			System.out.println(e);
		}

		sc.close();
	}

}
