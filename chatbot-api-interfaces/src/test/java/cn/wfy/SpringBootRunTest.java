package cn.wfy;

import cn.wfy.domain.kimi.model.res.RespData;
import cn.wfy.domain.kimi.model.vo.Choices;
import cn.wfy.domain.kimi.service.Kimi;
import cn.wfy.domain.zsxq.IZsxqApi;
import cn.wfy.domain.zsxq.model.aggregates.UnAnsweredQuestionsAggregates;
import cn.wfy.domain.zsxq.model.vo.Topics;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

@SpringBootTest
public class SpringBootRunTest {

    @Value("${chatgpt-api.groupId}")
    private String groupId;

    @Value("${chatgpt-api.cookie}")
    private String cookie;

    @Resource
    private IZsxqApi zsxqApi;

    @Resource
    private Kimi kimi;

    private Logger log = LoggerFactory.getLogger(SpringBootRunTest.class);
    @Test
    public void test_zsxqApi() throws IOException {
        UnAnsweredQuestionsAggregates unAnsweredQuestionsAggregates = zsxqApi.queryUnAnsweredQuestionTopicId(groupId, cookie);
        List<Topics> topics = unAnsweredQuestionsAggregates.getResp_data().getTopics();
        for(Topics topic : topics){

            String topicId = topic.getTopic_id();
            String text = topic.getQuestion().getText();
            log.info("{},{}", topicId, text);
        }
    }


    @Test
    public void test_kimi() throws Exception {
        RespData respData = kimi.doKimi("你是谁");
        List<Choices> choices = respData.getChoices();
        for (Choices choice : choices) {
            log.info(choice.getMessage().getContent());
        }
    }
}