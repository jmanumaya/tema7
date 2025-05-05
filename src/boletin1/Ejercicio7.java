package boletin1;

import java.util.*;
import java.sql.*;

public class Ejercicio7 {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		
		String url = "jdbc:mysql://localhost/InstitutoDB";
		String usuario = "root";
		
		String pass = "";
		
		String nombre = "";
		String apellido = "";
		String fechaNacimiento = "";
		String email = "";
		int telefono;
		
		System.out.print(usuario + " Introduce su Contraseña: ");
		pass = sc.next();
		sc.nextLine();
		
		try(Connection con = DriverManager.getConnection(url, usuario, pass)){
			System.out.println("Connexión Establecida Correctamente.");
			
			Statement sent = con.createStatement();
			
			//7. Realiza una aplicación que solicite todos los datos de un alumno y lo inserte en la base de datos.
			
			System.out.print("Nombre del Nuevo Alumno: ");
			nombre = sc.nextLine();
			System.out.print("Apellido del Alumno: ");
			apellido = sc.nextLine();
			System.out.println("Fecha de Nacimiento del Alumno");
			fechaNacimiento = pideFecha();
			System.out.print("Email de Alumno: ");
			email = sc.nextLine();
			System.out.print("Telefono del Alumno: ");
			telefono = sc.nextInt();
			
			// Forma diría normal:
			
			// System.out.println("Filas insertadas: " + sent.executeUpdate("INSERT into Estudiantes (nombre, apellido, fecha_nacimiento, email, telefono) values ('" + nombre + "', '" + apellido + "', '" + fechaNacimiento + "', '" + email + "', " + telefono + ")"));
			
			// Mejor Forma (intentando evitar inyecciones):
			
			// Los ? son marcadores de posicion (indico que luego voy a insertar los valores con set (ps.set(tipo)))
			String sql = "INSERT INTO Estudiantes (nombre, apellido, fecha_nacimiento, email, telefono) VALUES (?, ?, ?, ?, ?)";
			
			// Le digo a la conexión que prepare la sentencia SQL.
			PreparedStatement ps = con.prepareStatement(sql);

			// Relleno cada ? (posicion) con sus respectivos valores.
			ps.setString(1, nombre);
			ps.setString(2, apellido);
			ps.setString(3, fechaNacimiento);
			ps.setString(4, email);
			ps.setInt(5, telefono);

			// Este método (ps.executeUpdate) ejecutaría la consulta preparada, es decir, hace el INSERT.
			System.out.println("Filas insertadas: " + ps.executeUpdate());
			
		} catch (SQLException e) {
			System.out.println(e);
		}

		sc.close();
	}
	
	// Funcion que he creado para cuando se pida las fechas al usuario.
	static String pideFecha() {
		// String de la fecha ya formada segun los datos que ha introducido el usuario.
		String fecha;
		
		// Variable que va a almacenar el dia indicado por el usuario.
		String dia;
		// Variable que va a almacenar el mes indicado por el usuario.
		String mes;
		// Variable que va a almacenar el año indicado por el usuario.
		String anno;
		
		// Pido los datos al usuario.
		System.out.println("Dia: ");
		dia = sc.next();
		// Esto es para por si el dia introducido es 1 en vez de 01 pues ponerle el 0 delante (lo mismo con el mes)
		if (dia.length() == 1) dia = "0" + dia;
		System.out.println("Mes: ");
		mes = sc.next();
		if (mes.length() == 1) mes = "0" + mes;
		System.out.println("Año: ");
		anno = sc.next();
		sc.nextLine();
		
		// Formo la fecha antes de devolverla con el formato correcto.
		fecha = anno + "-" + mes + "-" + dia;
		
		// Devuelvo el String de la fecha ya formada.
		return fecha;
	}

}
