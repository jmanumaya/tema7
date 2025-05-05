package boletin1;

import java.sql.*;
import java.util.*;

public class Ejercicio1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String url = "jdbc:mysql://localhost/InstitutoDB";
		String usuario = "root";
		String password = "";
		
		System.out.print(usuario + " Introduce su contraseña: ");
		password = sc.next();
		
		/* Realizo la coneccion con el metodo estatico getConnection de DriveManager y guardo ese objeto de tipo Connection en la variable con
		   para luego poder hacer una serie de acciones gracias en la base de datos. */
		try (Connection con = DriverManager.getConnection(url, usuario, password)){
			System.out.println("Conexión exitosa");
			
			/* Uso el objeto de tipo Connection para creame un objeto Statement gracias al metodo createStatement
			Este Objeto me permite ejecutar instrucciones SQL como SELECT, INSERT, UPDATE, DETELE...*/
			Statement sent = con.createStatement();
			
			// Uso el metodo executeUpdate para poder realizar los insert solicitados. (con este metodo tambien puedo usar UPDATE y DELETE)
			
			// 1. Realiza diversas inserciones en las distintas tablas de la base de datos institutodb.
			
		//	System.out.println(sent.executeUpdate("INSERT into Estudiantes (nombre, apellido, fecha_nacimiento, email, telefono) values ('Jose Manuel', 'Maya', '2005-09-15', 'jmayahidal@gmail.com', 629263572)"));
		//	System.out.println(sent.executeUpdate("INSERT into Profesores (nombre, apellido, especialidad, email) values ('David', 'Bermúdez', 'Bootstrap', 'david.bermudez@iesnervion.es')"));
		//	System.out.println(sent.executeUpdate("INSERT into Cursos (nombre, descripcion, año_escolar) values ('Primero DAM', 'Primero año del curso de Desarrollo de Aplicaciones Multiplataformas', 2024)"));
		//	System.out.println(sent.executeUpdate("INSERT into Matriculas (id_estudiante, id_curso, fecha_matricula) values (4, 2, '2024-07-12')"));
			
		} catch (SQLException e) {
			System.err.println(e);
		}
		
		sc.close();
	}

}
