package com.mycompany.bancounipar.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DatabaseUtils {
    
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:postgresql://3.142.131.90:5435/uniparcentral",
                "aluno",
                "aluno"
        );
    }

    public Connection getException() {
        throw new UnsupportedOperationException("Formato não Suportado ainda!");
    }
}
