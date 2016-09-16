package indi.jackie.wechat.service.impl;

import com.google.gson.Gson;
import indi.jackie.common.constants.WeChatConstants;
import indi.jackie.common.utils.RunLog;
import indi.jackie.common.utils.StringUtils;
import indi.jackie.common.wechat.WeChatSQLException;
import indi.jackie.wechat.dao.TokenInfoMapper;
import indi.jackie.wechat.entity.TokenInfo;
import indi.jackie.wechat.service.ITokenInfoService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jackie chen
 * @create 2016/8/30
 * @description TokenInfoServiceImpl
 */
@Service
public class TokenInfoServiceImpl implements ITokenInfoService {

    /**
     * Gson对象，用于转Gson
     */
    private static Gson gson = new Gson();

    @Autowired
    private TokenInfoMapper tokenInfoMapper;

    /**
     * 更新微信TokenInfo相关信息
     *
     * @param tokenInfo token相关
     */
    public void updateWechatTokenInfo(TokenInfo tokenInfo) throws WeChatSQLException {
        //tokenInfo为null直接return
        if (tokenInfo == null) {
            return;
        }
        //appCode为空直接return
        if (StringUtils.isEmpty(tokenInfo.getAppCode())) {
            return;
        }
        try{
            tokenInfoMapper.updateByAppCode(tokenInfo);
            RunLog.getInstance().info("update access token success ", gson.toJson(tokenInfo), WeChatConstants.SYSTEM_NAME);
        }catch (Exception e){
            RunLog.getInstance().error("update access token fail ", e.getMessage(), WeChatConstants.SYSTEM_NAME);
            throw new WeChatSQLException(WeChatSQLException.UPDATE_ERROR);
        }
    }

    public List<TokenInfo> getTokenInfoList() throws WeChatSQLException {
        try {
            RunLog.getInstance().info("get access token information list success ", null, WeChatConstants.SYSTEM_NAME);
            return tokenInfoMapper.getTokenInfoList();
        }catch (Exception e){
            RunLog.getInstance().error("get access token information list fail ", e.getMessage(), WeChatConstants.SYSTEM_NAME);
            throw new WeChatSQLException(WeChatSQLException.SELECT_ERROR);
        }
    }

    /**
     *  根据appID获取access token
     *
     * @param appID 微信公众号appID
     * @return 对应的TokenInfo
     * @throws WeChatSQLException
     */
    @Override
    public TokenInfo getTokenInfoByAppID(@Param("appID") String appID) throws WeChatSQLException {
        return null;
    }
}
