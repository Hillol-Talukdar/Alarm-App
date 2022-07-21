package com.example.alarmapp;

public class Alarm {
    private int hours;
    private int minutes;
    private String message;

    public Alarm(int hours, int minutes, String message) {
        this.hours = hours;
        this.minutes = minutes;
        this.message = message;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Alarm{" +
                "hours=" + hours +
                ", minutes=" + minutes +
                ", message='" + message + '\'' +
                '}';
    }
}
