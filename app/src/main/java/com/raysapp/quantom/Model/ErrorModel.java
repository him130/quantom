package com.raysapp.quantom.Model;

public class ErrorModel {



    private Boolean result;

    private String message;

    private Object user;

    public ErrorModel(Boolean result, String message, Object user) {
        this.result = result;
        this.message = message;
        this.user = user;
    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getUser() {
        return user;
    }

    public void setUser(Object user) {
        this.user = user;
    }

}
