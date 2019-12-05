package top.valliam.earthquakemonitorsystem.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.valliam.earthquakemonitorsystem.service.LoginService;
import top.valliam.earthquakemonitorsystem.util.CommonUtil;

/**
 * @Classname LoginController
 * @Description 登陆相关的Controller
 * @Date 2019/12/2 3:48 下午
 * @Created by valliam
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    /**
     * 登陆
     */
    @PostMapping("/auth")
    public JSONObject authLogin(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "username,password");
        return loginService.authLogin(requestJson);
    }

    /**
     * 查询当前登录用户的信息
     */
    @PostMapping("/getInfo")
    public JSONObject getInfo() {
        return loginService.getInfo();
    }

    /**
     * 登出
     */
    @PostMapping("/logout")
    public JSONObject logout() {
        return loginService.logout();
    }
}
