package io.pax.cryptos.dao;

import io.pax.cryptos.domain.SimpleUser;
import io.pax.cryptos.domain.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by AELION on 07/02/2018.
 */
public class UserDao
{

    JdbcConnector connector = new JdbcConnector();

    public List<User> listUsers() throws SQLException {
        List<User> users = new ArrayList<>();
        Connection conn = this.connector.getConnection();
        Statement stmt = conn.createStatement();   //Qui va représenter la requête SQL
        ResultSet rs = stmt.executeQuery("SELECT*FROM user");

        while (rs.next()) {
            String name = rs.getString("name");
            int id = rs.getInt("id");

            users.add(new SimpleUser(id, name));

            // System.out.println(name+ ":" +id);
        }


        rs.close();
        stmt.close();
        conn.close();

        return users;
    }


    public int createUser(String name) throws SQLException {
        //MOST important stuff of your life : NEVER EVER String concatenation in JDBC
        String query = "INSERT INTO user(name) VALUES (?)";

        //query = "INSERT INTO wallet (name, user_id) VALUES('test', 2)"
        System.out.println(query);

        Connection conn = this.connector.getConnection();
        PreparedStatement statement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, name);

        statement.executeUpdate();

        ResultSet keys = statement.getGeneratedKeys();
        keys.next();

        int id = keys.getInt(1);

        statement.close();
        conn.close();

        return id;
    }


    public void deleteUser(int userId) throws SQLException {


        String query = "DELETE FROM user WHERE id = ?";

        Connection conn = this.connector.getConnection();
        PreparedStatement statement = conn.prepareStatement(query);

        statement.setInt(1, userId);
        new WalletDao().deleteAll(userId);
        statement.executeUpdate();



        statement.close();
        conn.close();
    }



    public List<User> findByName(String extract) throws SQLException {
        List<User> users = new ArrayList<>();
        Connection conn = this.connector.getConnection();
        Statement stmt = conn.createStatement();   //Qui va représenter la requête SQL
        ResultSet rs = stmt.executeQuery("SELECT * FROM user WHERE name LIKE '"+extract+"%'");
        while (rs.next()) {
            extract = rs.getString("name");
            int id = rs.getInt("id");

            users.add(new SimpleUser(id, extract));

            // System.out.println(name+ ":" +id);
        }

        rs.close();
        stmt.close();
        conn.close();

        return users;

    }

    /*public void deleteByName(String exactName) throws SQLException {
        String query = "DELETE FROM user WHERE name = ?";

        Connection conn = this.connector.getConnection();
        PreparedStatement statement = conn.prepareStatement(query);

        statement.setString(1, exactName);

        User user = findByName(exactName);
        new WalletDao().deleteAll(userId);

        statement.executeUpdate();

        statement.close();
        conn.close();
    }

*/

    /**
     *
     * @param userId the id of the wallet
     * @param newName the new name
     */
    public void updateUser(int userId, String newName) throws SQLException {
        String query = "UPDATE user SET name = ? WHERE id = ?";

        //query = "INSERT INTO wallet (name, user_id) VALUES('test', 2)"
        System.out.println(query);

        Connection conn = this.connector.getConnection();
        PreparedStatement statement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, newName);
        statement.setInt(2, userId);

        statement.executeUpdate();

        ResultSet keys = statement.getGeneratedKeys();
        keys.next();


        statement.close();
        conn.close();

    }



    public static void main(String[] args) throws SQLException {
       UserDao dao = new UserDao();
       // System.out.println(dao.listUsers());
        //dao.createUser("christian");
          dao.deleteUser(2);
        //int id = dao.createWallet(2, "Bidon");
        // dao.deleteWallet(id);
        //dao.deleteAll(6);
       // System.out.println(dao.findByName("W"));
       // dao.updateUser(3, "Woodson");
    }

}
