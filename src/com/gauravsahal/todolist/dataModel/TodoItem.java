package com.gauravsahal.todolist.dataModel;

import java.time.LocalDate;

/**
 * Created By GauravSahal on 03-06-2020
 */

public class TodoItem {
    private String shortDescription;
    private String details;
    private LocalDate deadLine;

    public TodoItem(String shortDescription, String details, LocalDate deadLine) {
        this.shortDescription = shortDescription;
        this.details = details;
        this.deadLine = deadLine;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public LocalDate getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(LocalDate deadLine) {
        this.deadLine = deadLine;
    }
}
