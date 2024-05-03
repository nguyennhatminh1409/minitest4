package service;

import moduel.Present;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PresentDAO implements IPresentDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/minitest4";
    private String jdbcUsername = "root";
    private String jdbcPassword = "minh1409";
    private static final String INSERT_PRESENT_SQL = "INSERT INTO present (code, name, price, ship, img) VALUES (?, ?, ?, ?, ?);";
    private static final String SELECT_PRESENT_BY_ID = "select code, name, price, ship, img from present where id =?";
    private static final String SELECT_ALL_PRESENT = "select * from present";
    private static final String DELETE_PRESENT_SQL = "delete from present where id = ?;";
    private static final String UPDATE_PRESENT_SQL = "update present set code=?, name=?, price=?, ship=?, img=? where id = ?;";

    public PresentDAO() {
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    @Override
    public void insertPresent(Present present) throws SQLException {
        System.out.println(INSERT_PRESENT_SQL);
        PreparedStatement preparedStatement = getConnection().prepareStatement(INSERT_PRESENT_SQL);
        preparedStatement.setString(1, present.getCode());
        preparedStatement.setString(2, present.getName());
        preparedStatement.setDouble(3, present.getPrice());
        preparedStatement.setString(4, present.getShip());
        preparedStatement.setString(5, present.getImg());
        System.out.println(preparedStatement);
        preparedStatement.executeUpdate();

    }

    @Override
    public Present selectPresent(int id) {
        Present present = null;
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(SELECT_PRESENT_BY_ID);
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String code = rs.getString("code");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                String ship = rs.getString("ship");
                String img = rs.getString("img");
                present = new Present(id, code, name, price, ship, img);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return present;
    }

    @Override
    public List<Present> selectAllPresent() {
        List<Present> presents = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(SELECT_ALL_PRESENT);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String code = rs.getString("code");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                String ship = rs.getString("ship");
                String img = rs.getString("img");
                presents.add(new Present(id, code, name, price, ship, img));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return presents;
    }

    @Override
    public boolean deletePresent(int id) throws SQLException {
        boolean rowDelete;
        PreparedStatement preparedStatement = getConnection().prepareStatement(DELETE_PRESENT_SQL);
        preparedStatement.setInt(1, id);
        rowDelete = preparedStatement.executeUpdate() > 0;
        return rowDelete;
    }

    @Override
    public boolean updatePresent(Present present) throws SQLException {
        boolean rowUpdate;
        PreparedStatement preparedStatement = getConnection().prepareStatement(UPDATE_PRESENT_SQL);
        preparedStatement.setString(1, present.getCode());
        preparedStatement.setString(2, present.getName());
        preparedStatement.setDouble(3, present.getPrice());
        preparedStatement.setString(4, present.getShip());
        preparedStatement.setString(5, present.getImg());
        preparedStatement.setInt(6, present.getId());

        rowUpdate = preparedStatement.executeUpdate() > 0;
        return rowUpdate;
    }
    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
