package basesdedatos.prototipov001bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Ejecutor {
    public static void main(String[] args) {
        try {
            // Crear la conexión a la base de datos
            Connection cnx = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/Northwind", "root", "Contraseña"
            );

            // Crear un statement
            Statement stmt = cnx.createStatement();

            // Ejecutar una consulta
            ResultSet rs = stmt.executeQuery("SELECT * FROM Customers");

            // Imprimir los resultados
            while (rs.next()) {
                System.out.println(rs.getString("Address"));
            }
            
            // Consulta para obtener todos los clientes
            rs = stmt.executeQuery("SELECT * FROM Customers");
            while (rs.next()) {
            System.out.println(rs.getString("Address"));
            }

// Consulta para obtener todos los pedidos de un cliente específico
rs = stmt.executeQuery("SELECT * FROM Orders WHERE CustomerID = 'ALFKI'");
while (rs.next()) {
    System.out.println(rs.getString("OrderID"));
}

// Consulta para obtener todos los productos de una categoría específica
rs = stmt.executeQuery("SELECT * FROM Products WHERE CategoryID = 1");
while (rs.next()) {
    System.out.println(rs.getString("ProductName"));
}

            // Ejecutar una consulta para insertar datos
            //stmt.executeUpdate("INSERT INTO nombretabla (columna1, columna2) VALUES (valor1, valor2)");

            // Ejecutar una consulta para actualizar datos
            //stmt.executeUpdate("UPDATE nombretabla SET columna1 = valor1 WHERE condicion");

            // Ejecutar una consulta para eliminar datos
            //stmt.executeUpdate("DELETE FROM nombretabla WHERE condicion");

            // Cerrar la conexión
            cnx.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}