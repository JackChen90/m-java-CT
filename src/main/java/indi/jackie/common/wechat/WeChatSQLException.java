package indi.jackie.common.wechat;

/**
 * @author jackie chen
 * @create 2016/09/07
 * @description
 */
public class WeChatSQLException extends Exception {

    /**
     * 更新SQL语句错误码
     */
    public static final int UPDATE_ERROR = -10001;
    /**
     * 插入SQL语句错误码
     */
    public static final int INSERT_ERROR = -10002;
    /**
     * 查询SQL语句错误码
     */
    public static final int SELECT_ERROR = -10003;
    /**
     * 删除SQL语句错误码
     */
    public static final int DELETE_ERROR = -10004;

    /**
     * 更新SQL语句错误Message
     */
    private static final String UPDATE_ERROR_MESSAGE = "更新SQL语句出错";
    /**
     * 插入SQL语句错误Message
     */
    private static final String INSERT_ERROR_MESSAGE = "插入SQL语句出错";
    /**
     * 查询SQL语句错误Message
     */
    private static final String SELECT_ERROR_MESSAGE = "查询SQL语句出错";
    /**
     * 删除SQL语句错误Message
     */
    private static final String DELETE_ERROR_MESSAGE = "删除SQL语句出错";

    /**
     * 根据错误码获取错误Message
     *
     * @param code 错误码
     * @return 错误Message
     */
    private static String getMessage(int code) {
        switch (code) {
            case UPDATE_ERROR:
                return UPDATE_ERROR_MESSAGE;
            case INSERT_ERROR:
                return INSERT_ERROR_MESSAGE;
            case SELECT_ERROR:
                return SELECT_ERROR_MESSAGE;
            case DELETE_ERROR:
                return DELETE_ERROR_MESSAGE;
            default:
                return null;
        }
    }

    /**
     * 构造函数
     *
     * @param code 错误码
     */
    public WeChatSQLException(int code) {
        super(getMessage(code));
    }
}
