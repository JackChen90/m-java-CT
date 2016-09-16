package indi.jackie.wechat.dao;

import indi.jackie.boot.Dao;
import indi.jackie.common.wechat.WeChatSQLException;
import indi.jackie.wechat.entity.TokenInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Dao
public interface TokenInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TokenInfo record);

    int insertSelective(TokenInfo record);

    TokenInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TokenInfo record);

    int updateByPrimaryKeyWithBLOBs(TokenInfo record);

    int updateByPrimaryKey(TokenInfo record);

    /**
     * 获取access token列表
     *
     * @return access token列表
     */
    List<TokenInfo> getTokenInfoList();

    /**
     * 根据微信号更新access token
     *
     * @param tokenInfo
     * @return
     */
    Integer updateByAppCode(TokenInfo tokenInfo);

    /**
     * 根据appID获取 access token
     *
     * @param appID
     * @return
     */
    public TokenInfo getTokenInfoByAppID(String appID);
}