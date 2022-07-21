package online.uzdevjs.studentsinfosystem.dto;

/**
 * Project student-info-system2
 * Author: jimmy
 * Created: 7/21/2022 - 10:53 AM
 */

import org.springframework.http.HttpStatus;

public class Response {
    private boolean success;
    private String message;
    private Object data;
    private HttpStatus status;

    public Response(boolean success, String message, Object data, HttpStatus status) {
        this.success = success;
        this.message = message;
        this.data = data;
        this.status = status;
    }

    public Response(boolean success, String message, HttpStatus status) {
        this.success = success;
        this.message = message;
        this.status = status;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}
