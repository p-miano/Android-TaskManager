package com.example.taskmanager;

public class Task {
    private String taskName;
    private String taskDescription;
    private boolean isCompleted;

    public Task(String taskName, String taskDescription) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.isCompleted = false;
    }
    public String getTaskName(){
        return taskName;
    }
    public  String getTaskDescription(){
        return taskDescription;
    }

    // Getter and Setter for isCompleted
    public boolean isCompleted() {
        return isCompleted;
    }
    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

}

