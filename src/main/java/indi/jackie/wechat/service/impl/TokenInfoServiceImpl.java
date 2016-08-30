package indi.jackie.wechat.service.impl;

import indi.jackie.common.utils.StringUtils;
import indi.jackie.wechat.dao.TokenInfoMapper;
import indi.jackie.wechat.entity.TokenInfo;
import indi.jackie.wechat.service.ITokenInfoService;
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
    @Autowired
    private TokenInfoMapper tokenInfoMapper;

    /**
     * 更新微信TokenInfo相关信息
     *
     * @param tokenInfo token相关
     */
    public void updateWechatTokenInfo(TokenInfo tokenInfo) {
        //tokenInfo为null直接return
        if (tokenInfo == null) {
            return;
        }
        //appCode为空直接return
        if (StringUtils.isEmpty(tokenInfo.getAppCode())) {
            return;
        }

    }

    public List<TokenInfo> getTokenInfoList() {
        return tokenInfoMapper.getTokenInfoList();
    }
}
