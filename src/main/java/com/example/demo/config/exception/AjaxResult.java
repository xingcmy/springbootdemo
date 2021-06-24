package com.example.demo.config.exception;

import lombok.Getter;
import lombok.Setter;

public class AjaxResult {
    //是否成功
    @Getter
    @Setter
    private Boolean success;
    //状态码
    @Getter
    @Setter
    private Integer code;
    //提示信息
    @Getter
    @Setter
    private String msg;
    //数据
    @Getter
    @Setter
    private Object data;

    public AjaxResult() {}

    public AjaxResult(Boolean success,Integer code, String msg,Object data) {
        this.success = success;
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     *
     * @param de
     * @return
     */
    public static AjaxResult defineError(BusinessException de){
        AjaxResult result = new AjaxResult();
        result.setSuccess(false);
        result.setCode(de.getErrorCode());
        result.setMsg(de.getErrorMsg());
        result.setData(null);
        return result;
    }

    /**
     *
     * @param errorEnum
     * @return
     */
    public static AjaxResult otherError(ErrorEnum errorEnum){
        AjaxResult result = new AjaxResult();
        result.setMsg(errorEnum.getErrorMsg());
        result.setCode(errorEnum.getErrorCode());
        result.setSuccess(false);
        result.setData(null);
        return result;
    }

}
