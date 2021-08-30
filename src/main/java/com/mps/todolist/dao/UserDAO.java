package com.mps.todolist.dao;

import java.sql.*;


/**
 * / Created by Mike Schwingenschloegl in Aug 2021
 */
public class UserDAO {

    public static int createUser(String email, String password) {

        try (Connection connection = DbConnection.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("" +
                    "INSERT INTO user " +
                    "(email, password) " +
                    "VALUES " +
                    "(?, ?) ", Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, email);
            ps.setString(2, password);

            int rowCount = ps.executeUpdate();
            if (rowCount < 1) {
                throw new DAOException("Create user: es wurden keine Zeilen bearbeitet");
            }
            //ID des generierten Datensatzes auslesen
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                //PK auslesen und returnen
                return generatedKeys.getInt(1);
            }
            throw new DAOException("Create user: Es wurde kein Key generiert!");
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }
}


