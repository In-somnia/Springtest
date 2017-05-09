package com.yet.spring.core.beans;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Event {
    private int id;
    private String msg;
    private LocalDateTime date;
    private DateTimeFormatter dateTimeFormatter;

    public Event(LocalDateTime date, DateTimeFormatter dateTimeFormatter) {
        this.id = generateId();
        this.date = date;
        this.dateTimeFormatter = dateTimeFormatter;
    }

    public int generateId() {
        Random random = new Random();
        return random.nextInt(100);
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    @Override
    public String toString() {
        return "id: " + id + ", date: " + DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(date) + ", message: " + this.getMsg();
    }
}
