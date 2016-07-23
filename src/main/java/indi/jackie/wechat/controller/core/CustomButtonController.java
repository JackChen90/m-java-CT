package indi.jackie.wechat.controller.core;

import com.google.gson.Gson;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author jackie chen
 * @create 2016/7/22
 * @description 自定义Button Controller
 */
public class CustomButtonController {
    /**
     * 用于创建JSON的Gson实例
     */
    private static final Gson gson = new Gson();

    @RequestMapping(value = "setCunstomButton")
    @ResponseBody
    public String setCustomButton(){
        return "";
    }
}
