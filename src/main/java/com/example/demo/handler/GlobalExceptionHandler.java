package com.example.demo.handler;

import com.example.demo.config.exception.AjaxResult;
import com.example.demo.config.exception.BusinessException;
import com.example.demo.config.exception.ErrorEnum;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Log4j
@ControllerAdvice
public class GlobalExceptionHandler {

    //private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 处理自定义异常
     *
     */
    @ExceptionHandler(value = BusinessException.class)
    public AjaxResult bizExceptionHandler(BusinessException e) {
        log.error(e.getMessage(), e);
        return AjaxResult.defineError(e);
    }

    /**
     *处理其他异常
     *
     */
    @ExceptionHandler(value = Exception.class)
    public AjaxResult exceptionHandler( Exception e) {
        log.error(e.getMessage(), e);
        return AjaxResult.otherError(ErrorEnum.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    private Map<String,Object> exceptionHandler(HttpServletRequest req, Exception e){
        log.error(e.getMessage(),e);
        Map<String,Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success",false);
        modelMap.put("error",e.getMessage());
        return modelMap;
    }
}
