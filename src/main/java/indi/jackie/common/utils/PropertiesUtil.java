package indi.jackie.common.utils;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 
 * 〈一句话功能简述〉PropertiesUtil.java<br>
 * 〈功能详细描述〉
 *
 * @author 贾秀亚
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class PropertiesUtil {

    /** 系统的默认自定义properties */
    public static final Map<String, String> CONFIG = PropertiesUtil.getInstance().getProperties(
            "/sysConfig.properties");

    public static final String DIR_SEPARATE = "/";

    /** 类实例变量 */
    private static PropertiesUtil instance = null;

    /** 私有构造函数 */
    private PropertiesUtil() {
    }

    /**
     * 获取实例变量
     * 
     * @return PropertieUtil实例
     */
    public static PropertiesUtil getInstance() {
        if (instance == null) {
            instance = new PropertiesUtil();
        }
        return instance;
    }

    /**
     * 根据<code>Properties</code>文件名取得所有的键值
     * 
     * @param filename 类路径下的<code>Properties</code>文件名
     * @return
     */
    public Map<String, String> getProperties(String filename) {
        Map<String, String> map = new HashMap<String, String>();
        InputStream is = null;
        try {
            is = getClass().getResourceAsStream(filename);
            if (is == null) {
                return map;
            }
            Properties pro = new Properties();
            pro.load(is);
            Enumeration<?> e = pro.propertyNames();
            String key = null;
            String value = null;
            while (e.hasMoreElements()) {
                key = (String) e.nextElement();
                value = pro.getProperty(key);
                map.put(key, value == null ? "" : value.trim());
            }
        } catch (IOException ie) {
            RunLogDemo.getInstance().error("Failed to read the configuration file","InnerErrorDesc=" + ie.getMessage(),"gulu-web");
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException ie) {
                    RunLogDemo.getInstance().error("Failed to read the configuration file", "InnerErrorDesc=" + ie.getMessage(),"gulu-web");
                }
            }
        }
        return map;
    }

    /**
     * 根据<code>Properties</code>文件名取得所有的键值
     * 
     * @param filename 文件绝对路径<code>Properties</code>文件名
     * @return
     */
    public Map<String, String> getPropertiesByFilePath(String filename) {
        Map<String, String> map = new HashMap<String, String>();
        InputStream is = null;
        try {
            is = new FileInputStream(filename);
            Properties pro = new Properties();
            pro.load(is);
            Enumeration<?> e = pro.propertyNames();
            String key = null;
            String value = null;
            while (e.hasMoreElements()) {
                key = (String) e.nextElement();
                value = pro.getProperty(key);
                map.put(key, value == null ? "" : value.trim());
            }
        } catch (IOException ie) {
            RunLogDemo.getInstance().error("Failed to read the configuration file", "InnerErrorDesc=" + ie.getMessage(),"gulu-web");
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException ie) {
                    RunLogDemo.getInstance().error("Failed to read the configuration file","InnerErrorDesc=" +  ie.getMessage(),"gulu-web");
                }
            }
        }
        return map;
    }

    public static String getPicServerSystemImage(String sysHeadPicNum) {
        StringBuilder str = new StringBuilder();
        str.append(CONFIG.get("picServerUrl")).append(DIR_SEPARATE).append(CONFIG.get("picServerAppCode"))
                .append(DIR_SEPARATE).append(CONFIG.get("picServerImgType")).append(DIR_SEPARATE).append("0000000000")
                .append("_").append(sysHeadPicNum).append("_").append(CONFIG.get("picServerWidth")).append("x")
                .append(CONFIG.get("picServerLength")).append(".").append(CONFIG.get("picServerSuffix"));
        return str.toString();
    }

    public static String getPicServerUserImage(String userId) {
        StringBuilder str = new StringBuilder();
        str.append(CONFIG.get("picServerUrl")).append(DIR_SEPARATE).append(CONFIG.get("picServerAppCode"))
                .append(DIR_SEPARATE).append(CONFIG.get("picServerImgType")).append(DIR_SEPARATE).append(userId)
                .append("_").append(CONFIG.get("picServerDefault")).append("_").append(CONFIG.get("picServerWidth"))
                .append("x").append(CONFIG.get("picServerLength")).append(".").append(CONFIG.get("picServerSuffix"));
        return str.toString();
    }
}
