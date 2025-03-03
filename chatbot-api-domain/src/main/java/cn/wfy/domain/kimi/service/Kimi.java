package cn.wfy.domain.kimi.service;

import cn.wfy.domain.kimi.IKimi;
import cn.wfy.domain.kimi.model.req.ReqData;
import cn.wfy.domain.kimi.model.res.RespData;
import cn.wfy.domain.kimi.model.vo.Message;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class Kimi implements IKimi {

    @Value("${kimi.client.api-key}")
    private String key;

    @Value("${kimi.client.model}")
    private String model;

    @Value("${kimi.client.temperature}")
    private float temperature;

    private Logger log = LoggerFactory.getLogger(Kimi.class);

    @Override
    public RespData doKimi(String question) throws Exception {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost("https://api.moonshot.cn/v1/chat/completions");
        post.addHeader("Content-Type", "application/json;charset=utf8");
        post.addHeader("Authorization", "Bearer " + key);
        post.setHeader("Accept", "application/json");
//        接口测试
        String paramJson = "{\"Messages\":[{\"content\":\"你是谁\",\"role\":\"user\"}],\"model\":\"moonshot-v1-8k\",\"temperature\":0.3}";
        /*
                接口测试
        String paramJson = "{\n" +
                "  \"model\": \"moonshot-v1-8k\",\n" +
                "  \"Messages\": [\n" +
                "    {\"role\": \"system\", \"content\": \"你是 Kimi，由 Moonshot AI 提供的人工智能助手，你更擅长中文和英文的对话。你会为用户提供安全，有帮助，准确的回答。同时，你会拒绝一切涉及恐怖主义，种族歧视，黄色暴力等问题的回答。Moonshot AI 为专有名词，不可翻译成其他语言。\"},\n" +
                "    {\"role\": \"user\", \"content\": \"你好，我叫李雷，1+1等于多少？\"}\n" +
                "  ],\n" +
                "  \"temperature\": 0.3\n" +
                "}";
      */
        ReqData reqData = new ReqData(model, temperature);
        Message ques = new Message("user", question);
        List<Message> messages = new ArrayList<>();
        messages.add(ques);
        reqData.setMessages(messages);
        String jsonString = JSONObject.toJSONString(reqData);

        StringEntity stringEntity = new StringEntity(jsonString, ContentType.create("application/json", "UTF-8"));
        post.setEntity(stringEntity);
        CloseableHttpResponse response = httpClient.execute(post);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String res = EntityUtils.toString(response.getEntity());
            log.info(res);
            RespData respData = JSON.parseObject(res, RespData.class);
            log.info(JSON.toJSONString(respData));
            return respData;
        } else {
            throw new RuntimeException(String.valueOf(response.getStatusLine().getStatusCode()));
        }
    }
}
