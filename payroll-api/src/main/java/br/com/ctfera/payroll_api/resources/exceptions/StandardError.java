package br.com.ctfera.payroll_api.resources.exceptions;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Setter
public class StandardError {
    private LocalDateTime timestamp;
    private String error;
    private Integer status;
    private String path;

/*

    public StandardError(LocalDateTime timestamp, String error, Integer status, String path) {
        this.timestamp = timestamp;
        this.error = error;
        this.status = status;
        this.path = path;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

*/

}
