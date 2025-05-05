package boletin1;

import java.sql.*;
import java.util.*;

public class Ejercicio10 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String url = "jdbc:mysql://localhost/InstitutoDB";
		String usuario = "root";
		
		String pass = "";
		
		String nombre;
		String fechaNacimiento;
		int curso;
		
		System.out.println(usuario + " Introduce su Contraseña: ");
		pass = sc.next();
		
		try(Connection con = DriverManager.getConnection(url, usuario, pass)){
			System.out.println("Conexión Realizada Correctamente");
			
			Statement sent = con.createStatement();
			
			/*9. Mostrar el nombre y fecha de nacimiento de todos los alumnos.*/
			
			System.out.println("Introduce el ID del Curso de los Alumnos a Mostrar: ");
			curso = sc.nextInt();
			
			ResultSet rs = sent.executeQuery("Select e.nombre, e.fecha_nacimiento from Estudiantes as e "
					+ "inner join Matriculas as m "
					+ "on e.id_estudiante = m.id_estudiante "
					+ "inner join Cursos as c "
					+ "on m.id_curso = c.id_curso "
					+ "where c.id_curso = " + curso);
			
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
