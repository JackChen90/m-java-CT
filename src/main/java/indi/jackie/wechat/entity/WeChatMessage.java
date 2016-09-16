package indi.jackie.wechat.entity;

/**
 * @author jackie chen
 * @create 2016/09/17
 * @description 微信消息实体类
 */
public class WeChatMessage {

    /**
     * 接收方微信号
     */
    private String ToUserName;

    /**
     * 发送方微信号，若为普通用户，则是一个OpenID
     */
    private String FromUserName;

    /**
     * 消息创建时间
     */
    private String CreateTime;

    /**
     * 消息类型，取值如下：
     * <p>
     * 文本消息：text 0
     * 图片消息：image 1
     * 语音消息：voice 2
     * 视频消息：video 3
     * 小视频消息：shortvideo 4
     * 地理位置消息：location 5
     * 链接消息：link 6
     * </p>
     */
    private String MsgType;

    /**
     * 消息id，64位整型
     */
    private String MsgId;

    /**
     * 文本消息内容
     */
    private String Content;

    /**
     * 图片消息图片链接
     */
    private String PicUrl;

    /**
     * 图片/语音/视频消息媒体id，可以调用多媒体文件下载接口拉取数据
     */
    private String MediaId;

    /**
     * 语音格式，如amr，speex等
     */
    private String Format;

    /**
     * 视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据
     */
    private String ThumbMediaId;

    /**
     * 地理位置纬度
     */
    private String Location_X;

    /**
     * 地理位置经度
     */
    private String Location_Y;

    /**
     * 地图缩放大小
     */
    private String Scale;

    /**
     * 地理位置信息
     */
    private String Label;

    /**
     * 链接消息标题
     */
    private String Title;

    /**
     * 链接消息描述
     */
    private String Description;

    /**
     * 链接消息链接
     */
    private String Url;

    public String getToUserName() {
        return ToUserName;
    }

    public void setToUserName(String toUserName) {
        ToUserName = toUserName;
    }

    public String getFromUserName() {
        return FromUserName;
    }

    public void setFromUserName(String fromUserName) {
        FromUserName = fromUserName;
    }

    public String getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(String createTime) {
        CreateTime = createTime;
    }

    public String getMsgType() {
        return MsgType;
    }

    public void setMsgType(String msgType) {
        MsgType = msgType;
    }

    public String getMsgId() {
        return MsgId;
    }

    public void setMsgId(String msgId) {
        MsgId = msgId;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getPicUrl() {
        return PicUrl;
    }

    public void setPicUrl(String picUrl) {
        PicUrl = picUrl;
    }

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }

    public String getFormat() {
        return Format;
    }

    public void setFormat(String format) {
        Format = format;
    }

    public String getThumbMediaId() {
        return ThumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        ThumbMediaId = thumbMediaId;
    }

    public String getLocation_X() {
        return Location_X;
    }

    public void setLocation_X(String location_X) {
        Location_X = location_X;
    }

    public String getLocation_Y() {
        return Location_Y;
    }

    public void setLocation_Y(String location_Y) {
        Location_Y = location_Y;
    }

    public String getScale() {
        return Scale;
    }

    public void setScale(String scale) {
        Scale = scale;
    }

    public String getLabel() {
        return Label;
    }

    public void setLabel(String label) {
        Label = label;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }
}
