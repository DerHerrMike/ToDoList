package com.mps.todolist.dao;

import java.sql.*;
import java.util.Date;


/**
 * / Created by Mike Schwingenschloegl in Aug 2021
 */
public class TaskDAO {

    public static int createTask(String text, Date endDate) {

        try(Connection connection = DbConnection.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("" +
                    "INSERT INTO task " +
                    "(text) " +
                    "(endDate) "+
                    "VALUES " +
                    "(?,?)", Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, text);
            ps.setDate(2, (java.sql.Date) endDate);
            int rowCount = ps.executeUpdate();
            if (rowCount == 0) {
                throw new DAOException("Create Task: keine Zeile verändert!");
            }
            // ID des erzeugten Datensatzes herausholen und zurückgeben
            ResultSet rs = ps.getGeneratedKeys();
            // Innerhalb vom ResultSet ist der Key
            if (rs.next()) {
                // Key aus ResultSet herausholen und zurückgeben
                return rs.getInt(1);
            }
            throw new DAOException("Create Task: Es wurde kein Key generiert");


        } catch (SQLException e) {
            throw new DAOException(e);
        }


    }


}
