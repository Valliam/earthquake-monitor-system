package top.valliam.earthquakemonitorsystem.config.exception;

import com.alibaba.fastjson.JSONObject;

/**
 * @Classname CommonJsonException
 * @Description 错误类
 * 比如校验参数的时候，如果不符合要求，则抛出此错误类
 * 拦截器可以统一拦截此错误,将其中json返回给前端
 * @Date 2019/11/15 5:43 下午
 * @Created by valliam
 */
public class CommonJsonException extends RuntimeException {
    private JSONObject resultJson;

    public CommonJsonException(JSONObject resultJson){
        this.resultJson = resultJson;
    }

    public JSONObject getResultJson() {
        return resultJson;
    }
}
