package indi.jackie.common.utils;

/**
 * @author jackie chen
 * @create 2016/7/17
 * @description String工具类
 */
public class StringUtils {

    /**
     * 判断字符串是否为空
     * @param target
     * @return true/false
     */
    public static boolean isEmpty(String target){
        if(null == target || "".equals(target)){
            return true;
        }
        return false;
    }
}
