package com.github.jmetzz.persistence;

import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Jean Metz on 12-Oct-15.
 */
public class JDBCConnectionProducer {

    @Produces
    private Connection createConnection() {
        Connection conn = null;

        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
            conn = DriverManager.getConnection("jdbc:derby:memory:gs-cdi", "APP", "APP");
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }


    private void closeConnection(@Disposes Connection conn) throws SQLException {
        conn.close();
    }

}
