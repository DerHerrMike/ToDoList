package com.mps.todolist.model;

import java.util.Date;


/**
 * / Created by Mike Schwingenschloegl in Aug 2021
 */
public class Task {

    int idTask;
    String text;
    Date date;

    public Task(int idTask, String text, Date date) {

        this.idTask = idTask;
        this.text = text;
        this.date = date;
    }

    public int getIdTask() {

        return idTask;
    }
    public void setIdTask(int idTask) {

        this.idTask = idTask;
    }
    public String getText() {

        return text;
    }
    public void setText(String text) {

        this.text = text;
    }
    public Date getDate() {

        return date;
    }
    public void setDate(Date date) {

        this.date = date;
    }
}
