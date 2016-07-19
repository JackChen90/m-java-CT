package indi.jackie.wechat.entity;

/**
 * @author jackie chen
 * @create 2016/7/19
 * @description 错误实体类
 */
public class ErrorModel {
    /**
     * 错误码
     */
    Integer code;
    /**
     * 错误消息
     */
    String errMessage;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getErrMessage() {
        return errMessage;
    }

    public void setErrMessage(String errMessage) {
        this.errMessage = errMessage;
    }
}
