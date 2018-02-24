package app.model;

import app.entities.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ModelSingl {
    private Connection connection;

    private static ModelSingl instance = new ModelSingl();

//    private List<User> model;

    private ModelSingl(){
//        model = new ArrayList<>();
    }

    public static ModelSingl getInstance(){
        return instance;
    }



    public final Connection getConnection()
            throws ClassNotFoundException, SQLException {

        System.out.println("Connect to db");
        String databaseURL = "jdbc:h2:~/testTableUser";
        Class.forName("org.h2.Driver");
        Connection connection = DriverManager.getConnection(databaseURL,
                "sa", "");
        return connection;
    }

    /**
     * The method creates table app_user.
     *
     * @param connection connection to database
     * @throws SQLException some exception
     */
    public final void createUserTable(final Connection connection)
            throws SQLException {
        System.out.println("create app_user table");
        String createTable =
                "CREATE TABLE app_user("
                        + "user_id INT NOT NULL AUTO_INCREMENT,"
                        + "login VARCHAR (255) NOT NULL ,"
                        + "password VARCHAR (255) NOT NULL ,"
                        + "description VARCHAR (255) NULL,"
                        + "PRIMARY KEY (user_id))";

        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(createTable);
        } finally {
            if (connection != null) connection.close();
        }

    }

    /**
     * The method adds user to app_user.
     *
     * @param connection connection to database
     * @param user User
     * @throws SQLException some exception
     */
    public final void addUser(final User user)
            throws SQLException, ClassNotFoundException {
        connection = getConnection();
        String newUser = "INSERT INTO app_user (login, password, description)"
                + " VALUES(?,?,?)";

        try (PreparedStatement preparedStatement =
                     connection.prepareStatement(newUser)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(2 + 1, "dd");
            preparedStatement.executeUpdate();
        } finally {
            if (connection != null) connection.close();
        }


    }

    /**
     * The method displays all users from the app_user.
     *
     *
     * @throws SQLException some exception
     */
    public final List<String> getUsers()
            throws SQLException, ClassNotFoundException {
        connection = getConnection();
        List<String> model1 = new ArrayList<>();

        System.out.println("\nОтображаем список всех пользователей:");
        String getRecords =
                "SELECT user_id, login, description "
                        + "FROM app_user "
                        + "ORDER BY user_id";
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(getRecords);
            while (resultSet.next()) {
                model1.add(resultSet.getString("login"));
// System.out.println(String.format("User: %s, %s, %s",
//                        resultSet.getInt("user_id"),
//                        resultSet.getString("login"),
//                        resultSet.getString("description")));
            }
        } finally {
            if (connection != null) connection.close();
        }
        return model1;
    }

    /**
     * The method updates the table entries.
     *
     * @param connection connection to database
     * @param id user's id
     * @param login user's login
     * @param password user's password
     * @param description some description
     * @throws SQLException some exception
     */
    public final void updateUserById(final Connection connection,
                                     final int id,
                                     final String login,
                                     final String password,
                                     final String description)
            throws SQLException {

        System.out.println(String.format("Обновляем "
                + "данные пользователя с id = %s", id));
        String getById =
                "UPDATE app_user "
                        + "SET login=?, password=?, description=? "
                        + "WHERE user_id = ?";

        try (PreparedStatement preparedStatement =
                     connection.prepareStatement(getById)) {
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            preparedStatement.setString(2 + 1, description);
            preparedStatement.setInt(2 + 2, id);

            preparedStatement.executeUpdate();
        } finally {
            if (connection != null) connection.close();
        }

    }

    /**
     * The method removes user by id.
     *
     * @param connection connection to database
     * @param id user's id
     * @throws SQLException some exceptions
     */
    public final void removeUserById(final Connection connection, final int id)
            throws SQLException {
        System.out.println(String.format("Удаляем пользователя с id = %s", id));
        String delRecord = "DELETE FROM app_user WHERE user_id = ?";
        try (PreparedStatement preparedStatement =
                     connection.prepareStatement(delRecord)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } finally {
            if (connection != null) connection.close();
        }



    }

//    public void add(User user){
//        model.add(user);
//    }
//
//    public List<String> list(){
//        return model.stream()
//                .map(User::getName)
//                .collect(Collectors.toList());
//    }
}
