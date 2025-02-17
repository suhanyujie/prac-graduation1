package com.suhy.graduation1;

import lombok.Getter;
import lombok.Setter;

public class Response<T> {
    @Setter
    @Getter
    private T data;

    private boolean isOk;
    @Getter
    @Setter
    private String errMsg;

    public static <K> Response<K> success(K data) {
        Response<K> response = new Response<>();
        response.setData(data);
        response.setOk(true);
        return response;
    }

    public static Response<Void> fail(String msg) {
        Response<Void> response = new Response<>();
        response.setErrMsg(msg);
        response.setOk(false);
        return response;
    }

    public boolean isOk() {
        return isOk;
    }

    public void setOk(boolean ok) {
        this.isOk = ok;
    }
}
