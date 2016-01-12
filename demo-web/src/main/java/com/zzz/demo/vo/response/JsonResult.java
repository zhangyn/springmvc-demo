package com.zzz.demo.vo.response;

/**
 * Created by zyn on 2015/12/15.
 */
public class JsonResult {

    public JsonResult(){}

    public JsonResult(int code,String msg){
        this.code = code;
        this.msg = msg;
    }
    private int code;

    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
