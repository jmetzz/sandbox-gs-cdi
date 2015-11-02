package com.github.jmetzz.service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Jean Metz on 12-Oct-15.
 */
@ApplicationScoped
public class DerbyPingService {

    @Inject
    private Connection conn;

    public void ping() throws SQLException {
        conn.createStatement().executeQuery("SELECT 1 FROM SYSIBM.SYSDUMMY1");
    }

}
