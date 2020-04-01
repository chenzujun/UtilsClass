package com.common;

public interface ResponseCodeConstants {

    /**
     * 标识：请求成功
     */
    String FLAG_SUCCESS = "success";

    /**
     * 标识：请求失败
     */
    String FLAG_FAILURE = "failure";

    /**
     * 响应代码：请求成功
     */
    String CODE_SUCCESS = "000001";

    /**
     * 响应代码：请求失败
     */
    String CODE_FAILURE = "000000";

    /**
     * 错误代码：请求参数为空
     */
    String ERROR_CODE_PARAM_NULL = "000002";

    /**
     * 错误代码：请求参数非法
     */
    String ERROR_CODE_PARAM_INVALID = "000003";

    /**
     * 错误代码：JSON转换失败
     */
    String ERROR_CODE_JSON_CONVERT_FAILURE = "000004";

    /**
     * 错误代码：重复提交
     */
    String ERROR_CODE_REQUEST_REPEAT = "000005";

    /**
     * 错误代码：数据库异常
     */
    String ERROR_CODE_DATABASE_ERROR = "000006";

    /**
     * 错误代码：登录失败
     */
    String ERROR_CODE_USER_LOGIN_FAILURE = "000007";

    /**
     * 错误代码：无记录被更新
     */
    String GLOBAL_KEY_NO_RECORDS_UPDATED = "000008";

    /**
     * 错误代码：无记录被更新异常信息
     */
    String ERROR_CODE_NO_RECORDS_UPDATED = "000009";

    /**
     * 错误代码：非法用户
     */
    String ERROR_CODE_USER_INVALID = "000010";

    /**
     * 错误代码：接口不存在
     */
    String ERROR_API_NOTEXIST = "000011";

    /**
     * 错误代码：签名验证错误
     */
    String SING_VALIDATE_ERROR = "000012";

    /**
     * 错误代码：app_key校验失败
     */
    String APP_KEY_VALIDATE_ERROR = "000013";

    /**
     * 错误代码：认证参数非法
     */
    String AUTH_PARAMETER_ERROR = "000014";

    /**
     * 错误代码：未知异常
     */
    String UNKNOWN_ERROR = "000099";

    /**
     * 错误代码：Http请求异常失败
     */
    String ERROR_CODE_HTTP_REQUEST_EXCEPTION = "000015";

    /**
     * 错误代码：记录已存在
     */
    String ERROR_CODE_RECORD_HASBEEN_EXISTS = "000016";

    /***
     * 邮件发送失败
     */
    String EMAIL_SEND_ERROR = "000018";

    /***
     * 短信发送失败
     */
    String SMS_SEND_ERROR = "000019";

    /***
     * Http请求短信服务商异常失败
     */
    String SMS_SEND_PRIVODER_ERROR = "000020";

    /***
     * 电话号码错误
     */
    String SMS_PHONE_ERROR = "000022";

    /***
     * 短信内容超过500字
     */
    String SMS_CONTENT_OVER_ERROR = "000023";

    /***
     * 短信内容解析异常
     */
    String SMS_CONTENT_ERROR = "000024";

    /***
     * 电话号码被设为黑名单
     */
    String SMS_PHONE_BLOCK = "000025";
    /***
     * 短信功能未开启
     */
    String SMS_ISNOT_OPEN = "000028";
}
