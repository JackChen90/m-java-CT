package indi.jackie.wechat.service.impl;

import com.google.gson.Gson;
import indi.jackie.common.constants.WeChatConstants;
import indi.jackie.common.constants.WeChatMsgTypeEnum;
import indi.jackie.common.utils.*;
import indi.jackie.common.wechat.WeChatSQLException;
import indi.jackie.wechat.dto.TokenInfoDTO;
import indi.jackie.wechat.entity.TokenInfo;
import indi.jackie.wechat.entity.WeChatMessage;
import indi.jackie.wechat.service.ITokenInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author jackie chen
 * @create 2016/7/23
 * @description 基础Service
 */
@Service
public class BaseService {

    private static final String TOKEN = "token?";
    private static final String GRANT_TYPE = "grant_type=client_credential";
    private static final String APP_ID = "&appid=";
    private static final String APP_SECRET = "&secret=";

    /**
     * 微信返回json中错误码标识
     */
    private static final String ERR_CODE = "errcode";

    /**
     * 用于解析JSON的Gson
     */
    private static final Gson gson = new Gson();

    /**
     * 公众号token前缀
     */
    private static final String ACCESS_TOKEN = "accessToken_";

    @Autowired
    private ITokenInfoService tokenInfoService;

    public String getAccessToken(HttpServletRequest request, String appID) throws WeChatSQLException {
        String key = ACCESS_TOKEN + appID;
        if (null == request.getSession().getAttribute(key)) {
            return tokenInfoService.getTokenInfoByAppID(appID).getAccessToken();
        } else {
            return request.getSession().getAttribute(key).toString();
        }
    }

    /**
     * 更新所有公众号access token
     *
     * @throws WeChatSQLException
     */
    @Scheduled(cron = "0 0 0/1 * * ?")
    public void updateAllAccessToken() throws WeChatSQLException {
        List<TokenInfo> tokenInfoList = tokenInfoService.getTokenInfoList();
        if (null != tokenInfoList && !tokenInfoList.isEmpty()) {
            for (TokenInfo tokenInfo : tokenInfoList) {
                updateAccessToken(tokenInfo);
            }
        }
    }

    /**
     * 更新Tokeninfo
     *
     * @param tokenInfo
     * @throws WeChatSQLException
     */
    private void updateAccessToken(TokenInfo tokenInfo) throws WeChatSQLException {
        //应用ID
        String appID = tokenInfo.getAppId();
        //应用密钥
        String appSecret = tokenInfo.getAppSecret();
        //微信获取access token url
        String wechatTokenServerUrl = PropertiesUtil.CONFIG.get("wechatServerUrl") +
                TOKEN + GRANT_TYPE + APP_ID + appID + APP_SECRET + appSecret;
        String tokenMessage = HttpClientUtils.doGet(wechatTokenServerUrl);
        if (!StringUtils.isEmpty(tokenMessage)) {
            if (tokenMessage.contains(ERR_CODE)) {
                RunLog.getInstance().error("get access token from wechat server fail ", tokenMessage, WeChatConstants.SYSTEM_NAME);
            } else {
                TokenInfoDTO dto = gson.fromJson(tokenMessage, TokenInfoDTO.class);
                String accessToken = dto.getAccess_token();
                if (!StringUtils.isEmpty(accessToken)) {
                    tokenInfo.setAccessToken(accessToken);
                    tokenInfoService.updateWechatTokenInfo(tokenInfo);
                }
            }
        }
    }

    /**
     * 处理WeChat以Post方式发来的请求
     *
     * @param request HttpServletRequest
     * @return Xml形式的String
     */
    public static String processWeChatRequest(HttpServletRequest request) {
        String respMessage = null;
        try {
            InputStream inputStream = request.getInputStream();
            // xml请求解析
            WeChatMessage msg = MessageUtil.toBean(inputStream.toString(), WeChatMessage.class);

            if (null != msg && null != msg.getMsgType()) {
                switch (WeChatMsgTypeEnum.getIndex(msg.getMsgType())) {
                    //文本消息
                    case 0:
                    default:
                        respMessage = createTextMsg();
                        break;
                    //图片消息
                    case 1:
                        respMessage = createImgMsg();
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return respMessage;
    }

    private static String createImgMsg() {
        return "IMG";
    }

    private static String createTextMsg() {
        return "Hello, welcom to CT!";
    }
}
