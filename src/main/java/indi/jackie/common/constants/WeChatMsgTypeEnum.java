package indi.jackie.common.constants;

/**
 * @author jackie chen
 * @create 2016/09/17
 * @description 微信Post消息，消息类型（MsgType）枚举类型
 */
public enum WeChatMsgTypeEnum {

    /**
     * Enum对象序列
     * <p>
     * 如果要定义自己的方法，在对象序列后加“；”号；
     * Java要求先定义对象序列。
     * </p> 
     */
    TEXT("text", 0), IMAGE("image", 1), VOICE("voice", 2), VIDEO("video", 3),
    SHORT_VIDEO("shortvideo", 4);

    /**
     * 映射Key
     */
    private String name;

    /**
     * 映射Value
     */
    private Integer index;

    /**
     * 根据微信消息类型名称获取Index
     *
     * @param msgTypeValue 微信消息类型名称
     * @return 微信消息类型对应Integer值
     */
    public static Integer getIndex(String msgTypeValue){
        for (WeChatMsgTypeEnum temp:
             WeChatMsgTypeEnum.values()) {
            if(temp.getName().equals(msgTypeValue))
                return temp.index;
        }
        return null;
    }

    /**
     * 构造函数
     *
     * @param name  映射key
     * @param index 映射value
     */
    WeChatMsgTypeEnum(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }
}
