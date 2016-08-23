package indi.jackie.wechat.dao;

import indi.jackie.boot.Dao;
import indi.jackie.wechat.entity.TokenInfo;

@Dao
public interface TokenInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TokenInfo record);

    int insertSelective(TokenInfo record);

    TokenInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TokenInfo record);

    int updateByPrimaryKeyWithBLOBs(TokenInfo record);

    int updateByPrimaryKey(TokenInfo record);
}