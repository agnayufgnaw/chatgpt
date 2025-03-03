package cn.wfy.domain.kimi.model.req;


import cn.wfy.domain.kimi.model.vo.Message;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

//        接口测试
//        String paramJson = "{\n" +
//                "  \"model\": \"moonshot-v1-8k\",\n" +
//                "  \"Messages\": [\n" +
//                "    {\"role\": \"system\", \"content\": \"你是 Kimi，由 Moonshot AI 提供的人工智能助手，你更擅长中文和英文的对话。你会为用户提供安全，有帮助，准确的回答。同时，你会拒绝一切涉及恐怖主义，种族歧视，黄色暴力等问题的回答。Moonshot AI 为专有名词，不可翻译成其他语言。\"},\n" +
//                "    {\"role\": \"user\", \"content\": \"你好，我叫李雷，1+1等于多少？\"}\n" +
//                "  ],\n" +
//                "  \"temperature\": 0.3\n" +
//                "}";
public class ReqData {

    private String model;

    @JsonProperty("Messages")
    private List<Message> Messages;

    public float temperature;

    public ReqData(String model, List<Message> Messages, float temperature) {
        this.model = model;
        this.Messages = Messages;
        this.temperature = temperature;
    }

    public ReqData(String model, float temperature) {
        this.model = model;
        this.temperature = temperature;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<Message> getMessages() {
        return Messages;
    }

    public void setMessages(List<Message> Messages) {
        this.Messages = Messages;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }
}
