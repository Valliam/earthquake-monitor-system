package top.valliam.earthquakemonitorsystem.service;

import com.alibaba.fastjson.JSONObject;

/**
 * @Classname LoginService
 * @Description TODO
 * @Date 2019/12/2 3:50 下午
 * @Created by valliam
 */
public interface LoginService {

    /**
     * 登录表单提交
     */
    JSONObject authLogin(JSONObject jsonObject);

    /**
     * 根据用户名和密码查询对应的用户
     *
     * @param username 用户名
     * @param password 密码
     */
    JSONObject getUser(String username, String password);

    /**
     * 查询当前登录用户的权限信息
     */
    JSONObject getInfo();

    /**
     * 退出登录
     */
    JSONObject logout();
}
