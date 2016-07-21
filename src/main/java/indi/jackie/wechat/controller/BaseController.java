package indi.jackie.wechat.controller;


import com.google.gson.Gson;
import indi.jackie.common.utils.PropertiesUtil;
import indi.jackie.common.wechat.AesException;
import indi.jackie.common.wechat.SHA1;
import indi.jackie.wechat.entity.ErrorModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author jackie chen
 * @create 2016/7/15
 * @description 基础Controller
 */

@Controller
public class BaseController {

    /**
     * 服务器配置的TOKEN
     */
    private final String OFFICIAL_ACCOUNT_TOKEN = PropertiesUtil.CONFIG.get("officialAccountToken");

    /**
     * 用于创建JSON的Gson实例
     */
    private static final Gson gson = new Gson();

    /**
     * 基础Exception处理方法
     *
     * @param e 异常
     * @return 错误报文
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public String exceptionHandler(Exception e) {
        int code = -12345;
        String errMessage = "系统错误";
        if (e instanceof AesException) {
            code = ((AesException) e).getCode();
            errMessage = e.getMessage();
        }
        return createFailJson(code, errMessage);
    }

    /**
     * 创建错误报文
     *
     * @param code       错误码
     * @param errMessage 错误消息
     * @return 错误信息
     */
    private String createFailJson(int code, String errMessage) {
        ErrorModel errorModel = new ErrorModel();
        errorModel.setCode(code);
        errorModel.setErrMessage(errMessage);
        return gson.toJson(errorModel);
    }

    /**
     * 校验服务器地址有效性
     * <p>
     * <p>校验流程如下</p>
     * 1. 将token、timestamp、nonce三个参数进行字典序排序
     * 2. 将三个参数字符串拼接成一个字符串进行sha1加密
     * 3. 将加密后的字符串与signature对比，标识该请求来源于微信
     * 4. 若校验成功，原样返回echostr
     *
     * @param signature 签名
     * @param timestamp 时间戳
     * @param nonce     随机数
     * @param echostr   随机字符串
     * @return echostr 回应报文
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public String verifyWeChatAPI(HttpServletResponse response, String signature, String timestamp, String nonce, String echostr) throws AesException, IOException {
        //校验signature
        if (null != signature && signature.equals(SHA1.getSHA1(OFFICIAL_ACCOUNT_TOKEN, timestamp, nonce))) {
            return echostr;
        }
        //校验失败则返回error
        return "error";
    }

}
