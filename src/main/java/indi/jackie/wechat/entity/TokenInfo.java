package indi.jackie.wechat.entity;

public class TokenInfo {
    private Integer id;

    private String appId;

    private String appSecret;

    private String accessToken;

    private String jsapiTicket;

    private String appName;

    private String qrcodeImageUrl;

    private String wechatCode;

    private byte[] qrcodeImage;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getWechatCode() {
        return wechatCode;
    }

    public void setWechatCode(String wechatCode) {
        this.wechatCode = wechatCode == null ? null : wechatCode.trim();
    }

    public byte[] getQrcodeImage() {
        return qrcodeImage;
    }

    public void setQrcodeImage(byte[] qrcodeImage) {
        this.qrcodeImage = qrcodeImage;
    }
}