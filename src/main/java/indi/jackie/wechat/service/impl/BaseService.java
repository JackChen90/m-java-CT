package indi.jackie.wechat.service.impl;

import indi.jackie.wechat.dao.TokenInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @author jackie chen
 * @create 2016/7/23
 * @description 基础Service
 */
@Service
public class BaseService {
    @Autowired
    private TokenInfoMapper tokenInfoMapper;

    public static void getAccessToken() {

    }

    @Scheduled(cron = "0 0 0/1 * * ?")
    public void updateAccessToken() {

    }
}
