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
public class Usage {

    private int prompt_tokens;
    private int completion_tokens;
    private int total_tokens;

    public void setPrompt_tokens(int prompt_tokens) {
        this.prompt_tokens = prompt_tokens;
    }
    public int getPrompt_tokens() {
        return prompt_tokens;
    }

    public void setCompletion_tokens(int completion_tokens) {
        this.completion_tokens = completion_tokens;
    }
    public int getCompletion_tokens() {
        return completion_tokens;
    }

    public void setTotal_tokens(int total_tokens) {
        this.total_tokens = total_tokens;
    }
    public int getTotal_tokens() {
        return total_tokens;
    }

}