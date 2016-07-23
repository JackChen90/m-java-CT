package indi.jackie.common.utils;

import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Date;

/**
 * @author jackie chen
 * @create 2016/7/21
 * @description RunLog类
 */
public class RunLog {

    /**
     * 获取log4j.properties中，AppenderName为Run的Log
     */
    private final Log log = LogFactory.getLog("Run");

    /**
     * 单例对象的索引名
     */
    private static RunLog runLog = null;


    /**
     * 私有构造方法
     */
    private RunLog() {
    }

    /**
     * 静态工厂方法
     * @return 单例对象
     */
    public static RunLog getInstance() {
        synchronized (RunLog.class) {
            if (null == runLog) {
                runLog = new RunLog();
            }
        }
        return runLog;
    }

    /**
     * 记录Debug级别日志的方法
     *
     * @param staticInfo 静态信息 表达日志记录静态内容的字符串
     * @param additionalInfo 附加信息: 表达日志记录的动态内容
     *                       采用“Name=Value”形式，多个“Name=Value”之间
     *                       采用“,”分隔（如Name或Value中包含“,”则用转义符“\,”表示）
     * @param systemModuleName 系统模块名称
     */
    public void debug(String staticInfo, String additionalInfo, String systemModuleName) {
        StringBuilder logInfo = new StringBuilder();
        logInfo.append(DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss SSS"))
                .append("|DEBUG")
                .append("|")
                .append(staticInfo)
                .append("|")
                .append(additionalInfo)
                .append("|")
                .append(systemModuleName);
        log.debug(logInfo);
    }

    /**
     * 记录Info级别日志的方法
     *
     * @param staticInfo 静态信息 表达日志记录静态内容的字符串
     * @param additionalInfo 附加信息: 表达日志记录的动态内容
     *                       采用“Name=Value”形式，多个“Name=Value”之间
     *                       采用“,”分隔（如Name或Value中包含“,”则用转义符“\,”表示）
     * @param systemModuleName 系统模块名称
     */
    public void info(String staticInfo, String additionalInfo, String systemModuleName) {
        StringBuilder logInfo = new StringBuilder();
        logInfo.append(DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss SSS"))
                .append("|INFO")
                .append("|")
                .append(staticInfo)
                .append("|")
                .append(additionalInfo)
                .append("|")
                .append(systemModuleName);
        log.info(logInfo);
    }

    /**
     * 记录Warn级别日志的方法
     *
     * @param staticInfo 静态信息 表达日志记录静态内容的字符串
     * @param additionalInfo 附加信息: 表达日志记录的动态内容
     *                       采用“Name=Value”形式，多个“Name=Value”之间
     *                       采用“,”分隔（如Name或Value中包含“,”则用转义符“\,”表示）
     * @param systemModuleName 系统模块名称
     */
    public void warn(String staticInfo, String additionalInfo, String systemModuleName) {
        StringBuilder logInfo = new StringBuilder();
        logInfo.append(DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss SSS"))
                .append("|WARN")
                .append("|")
                .append(staticInfo)
                .append("|")
                .append(additionalInfo)
                .append("|")
                .append(systemModuleName);
        log.warn(logInfo);
    }

    /**
     * 记录Error级别日志的方法
     *
     * @param staticInfo 静态信息 表达日志记录静态内容的字符串
     * @param additionalInfo 附加信息: 表达日志记录的动态内容
     *                       采用“Name=Value”形式，多个“Name=Value”之间
     *                       采用“,”分隔（如Name或Value中包含“,”则用转义符“\,”表示）
     * @param systemModuleName 系统模块名称
     */
    public void error(String staticInfo, String additionalInfo, String systemModuleName) {
        StringBuilder logInfo = new StringBuilder();
        logInfo.append(DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss SSS"))
                .append("|ERROR")
                .append("|")
                .append(staticInfo)
                .append("|")
                .append(additionalInfo)
                .append("|")
                .append(systemModuleName);
        log.error(logInfo);
    }
}
