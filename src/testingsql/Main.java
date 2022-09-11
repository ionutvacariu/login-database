package testingsql;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/exercitii";//?allowPublicKeyRetrieval=true
        String username = "root";
        String password = "pass4sas";


        String nr = "114"; // Simulez o citire de la tastatura

        // finally  -> nu il facem pentru ca avem try with resources --> De citit despre
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Database connected!");
            Statement statement = connection.createStatement();
            String sql_formatted = "select * from studenti s where nr_matricol  = " + nr;
            ResultSet resultSet = statement.executeQuery(sql_formatted);
            //                    statement.executeUpdate()

            while (resultSet.next()) {
                System.out.println(resultSet.getString("nume"));
                System.out.println(resultSet.getString(1));
            }

            //varianta II de a pune parametri in query
            String sql = "select * from studenti s where nr_matricol = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "114");
            ResultSet resultSet1 = preparedStatement.executeQuery();
            while (resultSet1.next()) {
                System.out.print (resultSet1.getString("nume") + "   ");
                System.out.println(resultSet1.getString(1));
            }


        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }

/*

        try{
            // cod care poate genera o exceptie cu un anumit tip
        }catch (  acel tip de exceptie "spatiu" identificator_exceptie  ){
            // cod de exceptie
        } finally {
            // cod care se executa oricand --> chiar daca e razboi
            fisier.close ()
        }

*/

    }
}
