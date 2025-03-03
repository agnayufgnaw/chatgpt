/**
 * Copyright 2025 bejson.com
 */
package cn.wfy.domain.kimi.model.vo;

/**
 * Auto-generated: 2025-03-03 19:25:11
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Choices {

    private int index;
    private Message message;
    private String finish_reason;
    public void setIndex(int index) {
        this.index = index;
    }
    public int getIndex() {
        return index;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
    public Message getMessage() {
        return message;
    }

    public void setFinish_reason(String finish_reason) {
        this.finish_reason = finish_reason;
    }
    public String getFinish_reason() {
        return finish_reason;
    }

}