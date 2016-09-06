package indi.jackie.wechat.service.impl;

import com.google.gson.Gson;
import indi.jackie.common.constants.WeChatConstants;
import indi.jackie.common.utils.HttpClientUtils;
import indi.jackie.common.utils.PropertiesUtil;
import indi.jackie.common.utils.RunLog;
import indi.jackie.common.utils.StringUtils;
import indi.jackie.common.wechat.WeChatSQLException;
import indi.jackie.wechat.dto.TokenInfoDTO;
import indi.jackie.wechat.entity.TokenInfo;
import indi.jackie.wechat.service.ITokenInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

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

    @Autowired
    private ITokenInfoService tokenInfoService;

    public static void getAccessToken() {

    }

    @Scheduled(cron = "0 0 0/1 * * ?")
    public void updateAllAccessToken() throws WeChatSQLException {
        List<TokenInfo> tokenInfoList = tokenInfoService.getTokenInfoList();
        if (null != tokenInfoList && !tokenInfoList.isEmpty()) {
            for (TokenInfo tokenInfo : tokenInfoList) {
                updateAccessToken(tokenInfo);
            }
        }
    }

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
}
