package com.mps.todolist.dao;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;


/**
 * / Created by Mike Schwingenschloegl in Aug 2021
 */
public class DbConnection {

    private static HikariConfig config = new HikariConfig();
    private static HikariDataSource ds;

    static {
        config.setJdbcUrl("jdbc:mysql://localhost:3306/todolist");
        config.setUsername("root");
        config.setPassword("Bier4tot");
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        config.setMaximumPoolSize(5);
        ds = new HikariDataSource(config);
    }

    private DbConnection() {

    }

    public static Connection getConnection() throws SQLException {

        return ds.getConnection();
    }


}
