package indi.jackie.wechat.service;

import indi.jackie.wechat.entity.TokenInfo;

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
     */
    void updateWechatTokenInfo(TokenInfo tokenInfo);

    /**
     * 获取access token列表
     *
     * @return access token列表
     */
    List<TokenInfo> getTokenInfoList();
}
