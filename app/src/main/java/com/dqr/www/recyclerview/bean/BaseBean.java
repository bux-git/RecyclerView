package com.dqr.www.recyclerview.bean;

/**
 * Description：
 * Author：LiuYM
 * Date： 2017-03-28 14:52
 */

public class BaseBean<T> {

    private boolean error;
    private T results;
    private String message;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public T getResults() {
        return results;
    }

    public void setResults(T results) {
        this.results = results;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
