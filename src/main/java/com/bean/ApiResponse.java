package com.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author chenjun
 * @date 2018/7/25
 * @since V1.0.0
 */
public class ApiResponse implements Serializable {
    private static final long serialVersionUID = -8507190486969470959L;

    public static final String RESULT_SUCCESS = "1";
    public static final String RESULT_FAIL = "0";
    public static final String RESULT_PART_FAIL = "2";
    public static final String UN_KNOW_EXCEPTION = "系统处理失败";
    public static final String NOT_FIND_RESOURCE = "访问的资源不存在";
    public static final String MISS_PARAM_RESOURCE = "请求参数异常";
    public static final String SUCCESS_MSG = "系统处理成功";
    public static final String LOGGER_TEMPLATE = "error:{},params:{}。";

    private String result;
    private String msg;
    private List<Error> errors;
    private Object data;

    @Override
    public String toString() {
        return "ApiResponse [result=" + this.result + ", msg=" + this.msg + ", errors=" + this.errors + ", data=" + this.data + "]";
    }

    public Object getData() {
        return this.data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public ApiResponse() {
    }

    public ApiResponse(String result) {
        this.result = result;
    }

    public ApiResponse(String result, String msg) {
        this.result = result;
        this.msg = msg;
    }

    public void setDefFailMsg() {
        this.setResult("0");
        this.setMsg("系统处理失败");
    }

    public void setFailMsg(String msg) {
        this.setResult("0");
        this.setMsg(msg);
    }

    public void setExceptionMsg(Exception e) {
        this.setResult("0");
        this.setMsg(this.buildErrorMessage(e));
    }

    public void setDefSucMsg() {
        this.setResult("1");
        this.setMsg("系统处理成功");
    }

    public static ApiResponse buildSuccessResult() {
        ApiResponse result = new ApiResponse();
        result.setDefSucMsg();
        return result;
    }

    public static ApiResponse buildSuccessResult(Object data) {
        ApiResponse result = new ApiResponse();
        result.setDefSucMsg();
        result.setData(data);
        return result;
    }

    public static ApiResponse buildFailResult() {
        ApiResponse result = new ApiResponse();
        result.setDefFailMsg();
        return result;
    }

    public static ApiResponse buildFailResult(String code, String msg, Error... error) {
        ApiResponse result = new ApiResponse();
        result.setResult(code);
        result.setMsg(msg);
        if (error != null && error.length > 0) {
            List<Error> errors = new ArrayList(error.length);
            result.setErrors(errors);
            Error[] arr$ = error;
            int len$ = error.length;

            for (int i$ = 0; i$ < len$; ++i$) {
                Error e = arr$[i$];
                errors.add(e);
            }
        }

        return result;
    }

    public static ApiResponse buildFailResult(String code, String msg) {
        ApiResponse result = new ApiResponse();
        result.setResult(code);
        result.setMsg(msg);
        return result;
    }

    public static ApiResponse buildFailResult(String msg) {
        ApiResponse result = new ApiResponse();
        result.setFailMsg(msg);
        return result;
    }

    public void addError(Error error) {
        if (this.errors == null) {
            this.errors = new ArrayList();
        }

        this.errors.add(error);
    }

    public void addError(String errorCode, Throwable errorMsg) {
        Error error = new Error(errorCode, errorMsg);
        this.addError(error);
    }

    public static ApiResponse buildFailResult(Exception e) {
        ApiResponse result = new ApiResponse();
        result.setExceptionMsg(e);
        return result;
    }

    public String buildErrorMessage(Exception e) {
        String errorMessage = null;
        String exceptionName = e.getClass().getSimpleName();
        if ("DoErrorException".equals(exceptionName)) {
            errorMessage = e.getMessage();
        } else if ("DataAccessException".equals(exceptionName)) {
            errorMessage = "数据库操作失败！";
        } else if ("NullPointerException".equals(exceptionName)) {
            errorMessage = "调用了未经初始化的对象或者是不存在的对象！";
        } else if ("IOException".equals(exceptionName)) {
            errorMessage = "IO异常！";
        } else if ("ClassNotFoundException".equals(exceptionName)) {
            errorMessage = "指定的类不存在！";
        } else if ("ArithmeticException".equals(exceptionName)) {
            errorMessage = "数学运算异常！";
        } else if ("ArrayIndexOutOfBoundsException".equals(exceptionName)) {
            errorMessage = "数组下标越界!";
        } else if ("IllegalArgumentException".equals(exceptionName)) {
            errorMessage = "方法的参数错误！";
        } else if ("ClassCastException".equals(exceptionName)) {
            errorMessage = "类型强制转换错误！";
        } else if ("SecurityException".equals(exceptionName)) {
            errorMessage = "违背安全原则异常！";
        } else if ("SQLException".equals(exceptionName)) {
            errorMessage = "操作数据库异常！";
        } else if ("NoSuchMethodError".equals(exceptionName)) {
            errorMessage = "方法末找到异常！";
        } else if ("InternalError".equals(exceptionName)) {
            errorMessage = "Java虚拟机发生了内部错误！";
        } else if ("SchedulerException".equals(exceptionName)) {
            errorMessage = "JOB任务调度出现异常！";
        } else if ("DataIntegrityViolationException".equals(exceptionName)) {
            errorMessage = "数据完整性冲突异常！";
        } else if ("HttpClientErrorException".equals(exceptionName)) {
            errorMessage = "请求发生错误！";
        } else {
            errorMessage = "程序内部错误，操作失败！";
        }

        return errorMessage;
    }

    public String getResult() {
        return this.result;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public List<Error> getErrors() {
        return this.errors;
    }

    public void setErrors(List<Error> errors) {
        this.errors = errors;
    }
}
