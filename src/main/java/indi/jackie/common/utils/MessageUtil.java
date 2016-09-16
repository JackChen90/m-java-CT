package indi.jackie.common.utils;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import static oracle.net.aso.C01.t;

/**
 * @author jackie chen
 * @create 2016/09/17
 * @description xml工具类
 */
public class MessageUtil {

    public static <T> T toBean(String xmlStr, Class<T> cls){
        XStream xStream=new XStream(new DomDriver("UTF-8"));
        xStream.processAnnotations(cls);
        T t= (T) xStream.fromXML(xmlStr);
        return t;
    }
}
