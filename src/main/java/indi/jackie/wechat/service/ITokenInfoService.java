package indi.jackie.wechat.service;

import indi.jackie.common.wechat.WeChatSQLException;
import indi.jackie.wechat.entity.TokenInfo;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;
import java.util.List;

/**
 * @author jackie chen
 * @create 2016/8/30
 * @description TokenInfoService
 */
public interface ITokenInfoService {

    /**
     * 更新微信TokenInfo相关信息
     *
     * @param tokenInfo token相关
     * @throws WeChatSQLException
     */
    void updateWechatTokenInfo(TokenInfo tokenInfo) throws WeChatSQLException;

    /**
     * 获取access token列表
     *
     * @return access token列表
     */
    List<TokenInfo> getTokenInfoList() throws WeChatSQLException;

    /**
     *  根据appID获取access token
     *
     * @param appID 微信公众号appID
     * @return 对应的TokenInfo
     * @throws WeChatSQLException
     */
    TokenInfo getTokenInfoByAppID(String appID) throws WeChatSQLException;
}
