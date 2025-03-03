package cn.wfy.domain.kimi;

import cn.wfy.domain.kimi.model.res.RespData;

public interface IKimi {

    RespData doKimi(String question) throws Exception;
}
