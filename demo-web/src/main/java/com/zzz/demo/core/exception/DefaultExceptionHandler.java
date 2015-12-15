package com.zzz.demo.core.exception;

import com.zzz.demo.core.base.Logger;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by zyn on 2015/12/15.
 */
public class DefaultExceptionHandler extends Logger implements HandlerExceptionResolver {
    @ResponseBody
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
                                         Exception ex) {
        logger.debug("----------unhandle exception-----------");

        ex.printStackTrace();

        logger.error(ex.getMessage());

        PrintWriter writer;
        try {
            writer = response.getWriter();
            String s = "{\"Code:500\",\"msg\":\"unhandler exception\"}";
            writer.write(s);
            writer.flush();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }
}
