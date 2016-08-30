package indi.jackie.wechat.entity;

public class TokenInfo {
    private Integer id;

    private String appCode;

    private String appId;

    private String appSecret;

    private String accessToken;

    private String jsapiTicket;

    private String appName;

    private String qrcodeImageUrl;

    private String wechatOriginId;

    private byte[] qrcodeImage;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode == null ? null : appCode.trim();
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret == null ? null : appSecret.trim();
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken == null ? null : accessToken.trim();
    }

    public String getJsapiTicket() {
        return jsapiTicket;
    }

    public void setJsapiTicket(String jsapiTicket) {
        this.jsapiTicket = jsapiTicket == null ? null : jsapiTicket.trim();
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName == null ? null : appName.trim();
    }

    public String getQrcodeImageUrl() {
        return qrcodeImageUrl;
    }

    public void setQrcodeImageUrl(String qrcodeImageUrl) {
        this.qrcodeImageUrl = qrcodeImageUrl == null ? null : qrcodeImageUrl.trim();
    }

    public String getWechatOriginId() {
        return wechatOriginId;
    }

    public void setWechatOriginId(String wechatOriginId) {
        this.wechatOriginId = wechatOriginId == null ? null : wechatOriginId.trim();
    }

    public byte[] getQrcodeImage() {
        return qrcodeImage;
    }

    public void setQrcodeImage(byte[] qrcodeImage) {
        this.qrcodeImage = qrcodeImage;
    }
}