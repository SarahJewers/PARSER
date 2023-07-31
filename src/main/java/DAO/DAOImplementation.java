package DAO;


import entities.ResultsEntity;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 * The type Dao implementation.
 */
public  class DAOImplementation {

    private final DAOHsqldb hsqldb = DAOHsqldb.getHsqldb();

    /**
     * The Connection.
     */
    public Connection connection;

    /**
     * Gets connection.
     *
     * @return the connection
     * @throws SQLException the sql exception
     */
    public Connection getConnection() throws SQLException {

        connection = null;
        try {
            connection = DriverManager.getConnection(
                    hsqldb.getURL(), hsqldb.getUser(), hsqldb.getPassword());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * Clear table.
     *
     * @throws SQLException the sql exception
     */
    public void clearTable() throws SQLException {
        Statement statement = getConnection().createStatement();
        statement.execute("DELETE FROM PARSER");

    }

    /**
     * Add.
     *
     * @param object the object
     * @throws SQLException the sql exception
     */
    public void add(final ResultsEntity object) throws SQLException {
        try {
            PreparedStatement statement = getConnection()
                    .prepareStatement("INSERT INTO PARSER (WORDS, WORDS_QUANTITY) VALUES (?,?)");
                    statement.setString(1, object.getWords().toString());
                    statement.setInt(2, object.getWords_quantity());
            statement.execute();
            connection.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    /**
     * Get all list.
     *
     * @return the list
     */
    public List<ResultsEntity> getAll(){
        List<ResultsEntity> list = new ArrayList<>();
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM PARSER")) {
            while (resultSet.next()) {
                list.add(getObject(resultSet));
            }
            connection.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
        return list;
    }

    /**
     * Update.
     *
     * @param resultsEntity the results entity
     */

    /**
     * Gets object.
     *
     * @param resultSet the result set
     * @return the object
     * @throws SQLException the sql exception
     */
    protected static ResultsEntity getObject(final ResultSet resultSet) throws SQLException {
        return new ResultsEntity(resultSet.getLong("ID"),
                resultSet.getString("WORDS"),
                resultSet.getInt("WORDS_QUANTITY"));
    }

}