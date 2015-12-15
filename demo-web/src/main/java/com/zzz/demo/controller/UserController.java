package com.zzz.demo.controller;

import com.zzz.demo.core.base.BaseController;
import com.zzz.demo.service.UserService;
import com.zzz.demo.vo.request.UserQueryReq;
import com.zzz.demo.vo.response.JsonResult;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by zyn on 2015/12/15.
 */
@RestController
public class UserController  extends BaseController {

    private final static String Url = "/user";

    @Resource
    private UserService userService;

    @RequestMapping(value=Url,method= RequestMethod.POST ,consumes= MediaType.APPLICATION_JSON_VALUE)
    public JsonResult addson(@RequestBody UserQueryReq page){
        logger.debug("user add:"+page.getName());
        int code  = userService.add(page);
        JsonResult jsonResult  = new JsonResult();
        jsonResult.setCode(code);
        return jsonResult;
    }

    @RequestMapping(value=Url+"/{id}",method= RequestMethod.GET)
    public JsonResult get(@PathVariable String id){
        logger.debug("user get:"+id);
        JsonResult jsonResult  = new JsonResult();
        jsonResult.setCode(1);
        jsonResult.setMsg(id);
        return jsonResult;
    }
}
