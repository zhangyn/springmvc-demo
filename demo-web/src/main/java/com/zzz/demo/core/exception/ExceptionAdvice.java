package com.zzz.demo.core.exception;

import com.zzz.demo.core.base.Logger;
import com.zzz.demo.vo.response.JsonResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException;


@ControllerAdvice
@ResponseBody
public class ExceptionAdvice  extends Logger{
 
    /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public JsonResult handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        logger.error("参数解析失败", e);
        return new JsonResult(400,"could_not_read_json");
    }

    /**
     * 404 - Method Not Allowed
     */
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchRequestHandlingMethodException.class)
    public JsonResult handleNoSuchRequestHandlingMethodException(NoSuchRequestHandlingMethodException e) {
        logger.error("找不到资源", e);
        return new JsonResult(404,"not_found");
    }

    /**
     * 405 - Method Not Allowed
     */
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public JsonResult handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        logger.error("不支持当前请求方法", e);
        return new JsonResult(405,"request_method_not_supported");
    }

    /**
     * 406 - MediaType Not Acceptable
     */
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    @ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
    public JsonResult handleHttpMediaTypeNotAcceptableException(HttpMediaTypeNotAcceptableException e) {
        logger.error("不支持当前请求方法", e);
        return new JsonResult(406,"mediatype_not_acceptable");
    }
    /**
     * 415 - Unsupported Media Type
     */
    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public JsonResult handleHttpMediaTypeNotSupportedException(Exception e) {
        logger.error("不支持当前媒体类型", e);
        return new JsonResult(415,"content_type_not_supported");
    }

    /**
     * 500 - Internal Server Error
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public JsonResult handleException(Exception e) {
        logger.error("服务运行异常", e);
        return new JsonResult(500,"unhandler exception");
    }
}
