package model;

import java.io.Serializable;

public class ResponseApi<E> implements Serializable {
    private String message;
    private Integer statusCode;
    private E body;

    public ResponseApi() {
    }

    public ResponseApi(String message, Integer statusCode, E body) {
        this.message = message;
        this.statusCode = statusCode;
        this.body = body;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public E getBody() {
        return body;
    }

    public void setBody(E body) {
        this.body = body;
    }
}
