package com.mps.todolist.dao;

/**
 * / Created by Mike Schwingenschloegl in Aug 2021
 */
public class DAOException extends RuntimeException {

    public DAOException() {

    }

    public DAOException(String message) {

        super(message);
    }

    public DAOException(String message, Throwable cause) {

        super(message, cause);
    }

    public DAOException(Throwable cause) {

        super(cause);
    }

    public DAOException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {

        super(message, cause, enableSuppression, writableStackTrace);
    }

}
