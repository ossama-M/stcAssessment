package com.alzain.stcAssessment.entity;

public enum PermissionLevel {
    READ("read"), WRITE("write"), DELETE("delete"), ADD("add");
    private String operation;

    PermissionLevel(String operation) {
        this.operation = operation;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
}
