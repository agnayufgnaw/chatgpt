package cn.wfy;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;

import javax.swing.text.html.parser.Entity;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.commons.lang3.StringEscapeUtils;

/**
 * Unit test for simple App.
 */

public class ApiApplicationTest
        extends TestCase {
    @Test
    public void query_unanswered_questions() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet get = new HttpGet("https://api.zsxq.com/v2/groups/28882558215811/topics?scope=unanswered_questions&count=20");

        get.addHeader("cookie", "zsxq_access_token=B8C8A0E6-FD11-D374-1C88-6A2E60509104_A86AD39B0EEFCE77; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22812218818125242%22%2C%22first_id%22%3A%221952b47ff34e72-021c29dbe66f63c-4c657b58-2359296-1952b47ff351220%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E5%BC%95%E8%8D%90%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC%22%2C%22%24latest_referrer%22%3A%22https%3A%2F%2Fbugstack.cn%2F%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTk1MmI0N2ZmMzRlNzItMDIxYzI5ZGJlNjZmNjNjLTRjNjU3YjU4LTIzNTkyOTYtMTk1MmI0N2ZmMzUxMjIwIiwiJGlkZW50aXR5X2xvZ2luX2lkIjoiODEyMjE4ODE4MTI1MjQyIn0%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22812218818125242%22%7D%2C%22%24device_id%22%3A%221952b47ff34e72-021c29dbe66f63c-4c657b58-2359296-1952b47ff351220%22%7D; zsxqsessionid=edfffc4d1bd03703124d2c0a67b0dffb; abtest_env=product");

        get.addHeader("Content-Type", "application/json;charset=utf8");

        CloseableHttpResponse response = httpClient.execute(get);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        } else {
            System.out.println(response.getStatusLine().getStatusCode());
        }

    }

    @Test
    public void answer() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost("https://api.zsxq.com/v2/topics/4848122484845448/answer");

        post.addHeader("cookie", "zsxq_access_token=B8C8A0E6-FD11-D374-1C88-6A2E60509104_A86AD39B0EEFCE77; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22812218818125242%22%2C%22first_id%22%3A%221952b47ff34e72-021c29dbe66f63c-4c657b58-2359296-1952b47ff351220%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E5%BC%95%E8%8D%90%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC%22%2C%22%24latest_referrer%22%3A%22https%3A%2F%2Fbugstack.cn%2F%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTk1MmI0N2ZmMzRlNzItMDIxYzI5ZGJlNjZmNjNjLTRjNjU3YjU4LTIzNTkyOTYtMTk1MmI0N2ZmMzUxMjIwIiwiJGlkZW50aXR5X2xvZ2luX2lkIjoiODEyMjE4ODE4MTI1MjQyIn0%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22812218818125242%22%7D%2C%22%24device_id%22%3A%221952b47ff34e72-021c29dbe66f63c-4c657b58-2359296-1952b47ff351220%22%7D; zsxqsessionid=edfffc4d1bd03703124d2c0a67b0dffb; abtest_env=product");
        post.addHeader("Content-Type", "application/json;charset=utf8");

        String paramJson = "{\n" +
                "  \"req_data\": {\n" +
                "    \"text\": \"自己去百度！\\n\",\n" +
                "    \"image_ids\": [],\n" +
                "    \"silenced\": false\n" +
                "  }\n" +
                "}";

        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "UTF-8"));
        post.setEntity(stringEntity);

        CloseableHttpResponse response = httpClient.execute(post);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        } else {
            System.out.println(response.getStatusLine().getStatusCode());
        }


    }

    @Test
    public void getKimi() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost("http://localhost:5000/send-message");
        post.addHeader("Content-Type", "application/json;charset=utf8");
        String paramJson = "{" +
                " \"Message\": \"我特别喜欢使用kimi\" " +
                "}";
        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "UTF-8"));
        post.setEntity(stringEntity);
        CloseableHttpResponse response = httpClient.execute(post);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(unicodeToStr(res));
        } else {
            System.out.println(response.getStatusLine().getStatusCode());
        }

    }

    @Test
    public void Kimi() throws IOException{
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost("https://api.moonshot.cn/v1/chat/completions");
        post.addHeader("Content-Type", "application/json;charset=utf8");
        post.addHeader("Authorization","Bearer sk-awQcFURGe3aXSV35whIqpoPsOmtDt02aT5Oj8kvHePMP0UDn");

        String paramJson = "{\n" +
                "  \"model\": \"moonshot-v1-8k\",\n" +
                "  \"messages\": [\n" +
                "    {\"role\": \"user\", \"content\": \"你好，我叫李雷，1+1等于多少？\"}\n" +
                "  ],\n" +
                "  \"temperature\": 0.3\n" +
                "}";

        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("application/json", "UTF-8"));
        post.setEntity(stringEntity);
        CloseableHttpResponse response = httpClient.execute(post);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(unicodeToStr(res));
        } else {
            System.out.println(response.getStatusLine().getStatusCode());
        }

    }


    public String unicodeToStr(String res) {
        return StringEscapeUtils.unescapeJava(res);
    }

}
