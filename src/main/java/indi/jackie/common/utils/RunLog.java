package indi.jackie.common.utils;

import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Date;

/**
 * <运行日志记录>
 * <功能详细描述>
 *
 * @author zyw
 * @version [版本号, 2015/11/18 11:12]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class RunLog
{
    
    private static final Log loggerInfo = LogFactory.getLog("RUN");
    
    private RunLog()
    {
    }
    
    private static RunLog runLog = null;
    
    //静态工厂方法   
    public static RunLog getInstance()
    {
        synchronized (RunLog.class)
        {
            if (runLog == null)
            {
                runLog = new RunLog();
            }
        }
        return runLog;
    }
    
    /**
     * 
     * <记录系统运行info级别日志>
     * <功能详细描述>
     * @param staticInfo 静态信息 表达日志记录静态内容的字符串
     * @param additionalInfo 附加信息: 表达日志记录的动态内容，
     * 采用“Name=Value”形式，多个“Name=Value”
     * 之间采用“,”分隔（如Name或Value中包含“,”则用转义符“\,”表示），
     * Value内容只能是英文、数字、特殊符号或三者的组合。必须记录的附加信息：
     * 业务流程处理异常时使用InnerErrorCode=XXXX,
     * InnerErrorDesc=XXXX记录内部错误码及错误描述；如果涉及外部接口交互异常，
     * 使用ReturnCode=XXXX,ReturnCodeDesc=XXXX记录外部接口返回码及描述；
     * @see [类、类#方法、类#成员]
     */
    public void info(String staticInfo, String additionalInfo, String systemModuleName)
    {
        StringBuilder logInfo = new StringBuilder();
        logInfo.append(DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss SSS"))
            .append("|INFO")
            .append("|")
            .append(systemModuleName)
            .append("|")
            .append(staticInfo)
            .append("|")
            .append(additionalInfo);
        loggerInfo.info(logInfo.toString());
    }
    
    /**
     * 
     * <记录系统运行warning级别日志>
     * <功能详细描述>
     * @param staticInfo 静态信息 表达日志记录静态内容的字符串
     * @param additionalInfo 附加信息: 表达日志记录的动态内容，
     * 采用“Name=Value”形式，多个“Name=Value”
     * 之间采用“,”分隔（如Name或Value中包含“,”则用转义符“\,”表示），
     * Value内容只能是英文、数字、特殊符号或三者的组合。必须记录的附加信息：
     * 业务流程处理异常时使用InnerErrorCode=XXXX,
     * InnerErrorDesc=XXXX记录内部错误码及错误描述；如果涉及外部接口交互异常，
     * 使用ReturnCode=XXXX,ReturnCodeDesc=XXXX记录外部接口返回码及描述；
     * @see [类、类#方法、类#成员]
     */
    public void warn(String staticInfo, String additionalInfo, String systemModuleName)
    {
        StringBuilder logInfo = new StringBuilder();
        logInfo.append(DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss SSS"))
            .append("|WARN")
            .append("|")
            .append(systemModuleName)
            .append("|")
            .append(staticInfo)
            .append("|")
            .append(additionalInfo);
        loggerInfo.warn(logInfo.toString());
    }
    
    /**
     * 
     * <记录系统运行error级别日志>
     * <功能详细描述>
     * @param staticInfo 静态信息 表达日志记录静态内容的字符串
     * @param additionalInfo 附加信息: 表达日志记录的动态内容，
     * 采用“Name=Value”形式，多个“Name=Value”
     * 之间采用“,”分隔（如Name或Value中包含“,”则用转义符“\,”表示），
     * Value内容只能是英文、数字、特殊符号或三者的组合。必须记录的附加信息：
     * 业务流程处理异常时使用InnerErrorCode=XXXX,
     * InnerErrorDesc=XXXX记录内部错误码及错误描述；如果涉及外部接口交互异常，
     * 使用ReturnCode=XXXX,ReturnCodeDesc=XXXX记录外部接口返回码及描述；
     * @see [类、类#方法、类#成员]
     */
    public void error(String staticInfo, String additionalInfo, String systemModuleName)
    {
        StringBuilder logInfo = new StringBuilder();
        logInfo.append(DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss SSS"))
            .append("|ERROR")
            .append("|")
            .append(systemModuleName)
            .append("|")
            .append(staticInfo)
            .append("|")
            .append(additionalInfo);
        loggerInfo.error(logInfo.toString());
    }
    
    
    /**
     * 
     * <记录系统运行info级别日志>
     * <功能详细描述>
     * @param paramLog 自定义Log
     * @param staticInfo 静态信息 表达日志记录静态内容的字符串
     * @param additionalInfo 附加信息: 表达日志记录的动态内容，
     * 采用“Name=Value”形式，多个“Name=Value”
     * 之间采用“,”分隔（如Name或Value中包含“,”则用转义符“\,”表示），
     * Value内容只能是英文、数字、特殊符号或三者的组合。必须记录的附加信息：
     * 业务流程处理异常时使用InnerErrorCode=XXXX,
     * InnerErrorDesc=XXXX记录内部错误码及错误描述；如果涉及外部接口交互异常，
     * 使用ReturnCode=XXXX,ReturnCodeDesc=XXXX记录外部接口返回码及描述；
     * @see [类、类#方法、类#成员]
     */
    public void info(Log paramLog, String staticInfo, String additionalInfo, String systemModuleName)
    {
        StringBuilder logInfo = new StringBuilder();
        logInfo.append(DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss SSS"))
            .append("|INFO")
            .append("|")
            .append(systemModuleName)
            .append("|")
            .append(staticInfo)
            .append("|")
            .append(additionalInfo);
        if(null != paramLog) {
            paramLog.info(logInfo.toString());
        } else {
            loggerInfo.info(logInfo.toString());
        }
    }
    
    /**
     * 
     * <记录系统运行warning级别日志>
     * <功能详细描述>
     * @param staticInfo 静态信息 表达日志记录静态内容的字符串
     * @param additionalInfo 附加信息: 表达日志记录的动态内容，
     * 采用“Name=Value”形式，多个“Name=Value”
     * 之间采用“,”分隔（如Name或Value中包含“,”则用转义符“\,”表示），
     * Value内容只能是英文、数字、特殊符号或三者的组合。必须记录的附加信息：
     * 业务流程处理异常时使用InnerErrorCode=XXXX,
     * InnerErrorDesc=XXXX记录内部错误码及错误描述；如果涉及外部接口交互异常，
     * 使用ReturnCode=XXXX,ReturnCodeDesc=XXXX记录外部接口返回码及描述；
     * @see [类、类#方法、类#成员]
     */
    public void warn(Log paramLog, String staticInfo, String additionalInfo, String systemModuleName)
    {
        StringBuilder logInfo = new StringBuilder();
        logInfo.append(DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss SSS"))
            .append("|WARN")
            .append("|")
            .append(systemModuleName)
            .append("|")
            .append(staticInfo)
            .append("|")
            .append(additionalInfo);
        if(null != paramLog) {
            paramLog.warn(logInfo.toString());
        } else {
            loggerInfo.warn(logInfo.toString());
        }
    }
    
    /**
     * 
     * <记录系统运行error级别日志>
     * <功能详细描述>
     * @param paramLog 自定义Log
     * @param staticInfo 静态信息 表达日志记录静态内容的字符串
     * @param additionalInfo 附加信息: 表达日志记录的动态内容，
     * 采用“Name=Value”形式，多个“Name=Value”
     * 之间采用“,”分隔（如Name或Value中包含“,”则用转义符“\,”表示），
     * Value内容只能是英文、数字、特殊符号或三者的组合。必须记录的附加信息：
     * 业务流程处理异常时使用InnerErrorCode=XXXX,
     * InnerErrorDesc=XXXX记录内部错误码及错误描述；如果涉及外部接口交互异常，
     * 使用ReturnCode=XXXX,ReturnCodeDesc=XXXX记录外部接口返回码及描述；
     * @see [类、类#方法、类#成员]
     */
    public void error(Log paramLog, String staticInfo, String additionalInfo, String systemModuleName)
    {
        StringBuilder logInfo = new StringBuilder();
        logInfo.append(DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss SSS"))
            .append("|ERROR")
            .append("|")
            .append(systemModuleName)
            .append("|")
            .append(staticInfo)
            .append("|")
            .append(additionalInfo);
        if(null != paramLog) {
            paramLog.error(logInfo.toString());
        } else {
            loggerInfo.error(logInfo.toString());
        }
    }
}
