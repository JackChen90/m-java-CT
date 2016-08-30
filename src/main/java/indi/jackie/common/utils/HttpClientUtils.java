package indi.jackie.common.utils;

//import org.apache.commons.httpclient.*;
//import org.apache.commons.httpclient.Header;
//import org.apache.commons.httpclient.HttpException;
//import org.apache.commons.httpclient.HttpStatus;
//import org.apache.commons.httpclient.methods.GetMethod;
//import org.apache.commons.httpclient.params.HttpMethodParams;

import indi.jackie.common.constants.WechatConstants;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * <类描述>
 * <功能详细描述>
 *
 * @author 贾秀亚
 * @version [版本号, 2015/11/4 9:34]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class HttpClientUtils {

    /**
     * get请求
     *
     * @param url 请求路径（路径中包含参数）
     * @return 请求结果
     */
    public static String doGet(String url) {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet get = new HttpGet(url);
        String result = null;
        try {
            HttpResponse httpResponse = client.execute(get);
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            if (statusCode == HttpStatus.SC_OK) {
                HttpEntity entity = httpResponse.getEntity();
                // 获得返回数据
                result = EntityUtils.toString(entity, "UTF-8");
            } else {
                // 请求失败
                RunLog.getInstance().error("Http return code error", "statusCode=" + statusCode, WechatConstants.SYSTEM_NAME);
            }
        } catch (UnsupportedEncodingException e) {
            RunLog.getInstance().error("Not supported by encoding", "InnerErrorDesc=" + e.getMessage(), WechatConstants.SYSTEM_NAME);
        } catch (ClientProtocolException e) {
            RunLog.getInstance().error("Abnormal connection", "InnerErrorDesc=" + e.getMessage(), WechatConstants.SYSTEM_NAME);
        } catch (IOException e) {
            RunLog.getInstance().error("request failed", "InnerErrorDesc=" + e.getMessage(), WechatConstants.SYSTEM_NAME);
        }
        return result;
    }

    /**
     * post请求
     *
     * @param url 请求路径
     * @param reqContent 请求内容
     * @param contentType 请求内容编码类型
     * @return 请求结果
     */
    public static String doPost(String url, String reqContent, String contentType) {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost post = new HttpPost(url);
        String result = null;
        StringEntity s;
        try {
            s = new StringEntity(reqContent);

            s.setContentEncoding("UTF-8");
            //发送json数据需要设置contentType
            s.setContentType("application/json");
            if (StringUtils.isNotBlank(contentType)) {
                s.setContentType(contentType);
            }
            post.setEntity(s);
            HttpResponse httpResponse = client.execute(post);
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            if (statusCode == HttpStatus.SC_OK) {
                HttpEntity entity = httpResponse.getEntity();
                // 获得返回数据
                result = EntityUtils.toString(entity, "UTF-8");
            } else {
                // 请求失败
                RunLog.getInstance().error("Http return code error", "statusCode=" + statusCode, "gulu-web");
            }
        } catch (UnsupportedEncodingException e) {
            RunLog.getInstance().error("Not supported by encoding", "InnerErrorDesc=" + e.getMessage(), "gulu-web");
        } catch (ClientProtocolException e) {
            RunLog.getInstance().error("Abnormal connection", "InnerErrorDesc=" + e.getMessage(), "gulu-web");
        } catch (IOException e) {
            RunLog.getInstance().error("request failed", "InnerErrorDesc=" + e.getMessage(), "gulu-web");
        }
        return result;
    }

    /**
     * 发送HTTPS请求
     *
     * @param url
     * @return
     */
    public static String doGetWithSSL(String url, String charset) {

        String content = null;
        try {
            SSLContext sslcontext = SSLContext.getInstance("TLS");

            X509TrustManager tm = new X509TrustManager() {
                public void checkClientTrusted(
                        java.security.cert.X509Certificate[] chain,
                        String authType)
                        throws java.security.cert.CertificateException {
                }
                public void checkServerTrusted(
                        java.security.cert.X509Certificate[] chain,
                        String authType)
                        throws java.security.cert.CertificateException {
                }
                public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
            };

            sslcontext.init(null, new TrustManager[]{tm}, null);

            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext, NoopHostnameVerifier.INSTANCE);

            CloseableHttpClient httpclient = HttpClients.custom().setSSLSocketFactory(sslsf).build();

            HttpGet httpGet = new HttpGet(url);
            CloseableHttpResponse closeableHttpResponse = httpclient.execute(httpGet);
            HttpEntity entity = closeableHttpResponse.getEntity();

            if (StringUtils.isEmpty(charset)) {
                charset = "UTF-8";
            }
            content = EntityUtils.toString(entity, charset);
        } catch (Exception e) {
            RunLog.getInstance().error("Send HTTPS request", "InnerErrorDesc=" + e.getMessage(), "gulu-web");
        }

        return content;
    }
}
