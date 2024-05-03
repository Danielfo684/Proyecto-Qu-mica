
package Proyecto_Quimica;
import java.sql.*;
import java.util.Scanner;

public class Main {
public static Scanner leer = new Scanner(System.in);
    public static void main(String[] args) {
Conexion conexion = new Conexion();
int eleccion = 2;

switch (eleccion) {
    case 1: conexion.conectarAlumno();
    break;
    case 2:
        System.out.println("Escriba el nombre de usuario");
     String user =   leer.nextLine();
             System.out.println("Escriba la contraseña de usuario");
     String password =   leer.nextLine();
        conexion.conectarProfesor(user, password);
}


    }
    
}
