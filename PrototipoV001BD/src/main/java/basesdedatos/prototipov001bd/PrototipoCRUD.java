/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package basesdedatos.prototipov001bd;

/**
 *
 * @author renat
 */
import java.sql.*;

public class PrototipoCRUD {
    public static void main(String[] args) {
        // Configuración de la conexión
        String url = "jdbc:mysql://localhost:3306/Northwind";
        String user = "root";
        String password = "Contraseña";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);

            System.out.println("Elige la tabla que deseas presentar:");
            System.out.print("1. Categories\n" +
                    "2. Customers\n" +
                    "3. Employees\n" +
                    "4. OrderDetails\n" +
                    "5. Orders\n" +
                    "6. Products\n" +
                    "7. Shippers\n" +
                    "8. Suppliers\n" +
                    "> ");
            int entrada = Integer.parseInt(System.console().readLine());

            switch (entrada) {
                case 1:
                    printCategories(connection);
                    break;
                                case 2:
                    printCustomers(connection);
                    break;
                case 3:
                    printEmployees(connection);
                    break;
                case 4:
                    printOrderDetails(connection);
                    break;
                case 5:
                    printOrders(connection);
                    break;
                case 6:
                    printProducts(connection);
                    break;
                case 7:
                    printShippers(connection);
                    break;
                case 8:
                    printSuppliers(connection);
                    break;

                default:
                    System.out.println("Opcion incorrecta");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cerrar la conexión al finalizar
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void printCategories(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Categories");

        System.out.printf("|%-15s| %-30s| %-75s|\n", "CategoryID", "CategoryName", "Description");
        while (resultSet.next()) {
            int categoryID = resultSet.getInt("CategoryID");
            String categoryName = resultSet.getString("CategoryName");
            String description = resultSet.getString("Description");

            System.out.printf("|%-15d| %-30s| %-75s|\n", categoryID, categoryName, description);
        }
    }
    
}

