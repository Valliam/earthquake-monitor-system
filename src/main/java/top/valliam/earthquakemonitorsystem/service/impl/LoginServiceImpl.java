package top.valliam.earthquakemonitorsystem.service.impl;

import com.alibaba.fastjson.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.valliam.earthquakemonitorsystem.dao.LoginDao;
import top.valliam.earthquakemonitorsystem.service.LoginService;
import top.valliam.earthquakemonitorsystem.service.PermissionService;
import top.valliam.earthquakemonitorsystem.util.CommonUtil;
import top.valliam.earthquakemonitorsystem.util.constants.Constants;


/**
 * @Classname LoginServiceImpl
 * @Description 登陆Service的实现类
 * @Date 2019/12/2 3:50 下午
 * @Created by valliam
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginDao loginDao;
    @Autowired
    private PermissionService permissionService;

    /**
     * 登录表单提交
     */
    @Override
    public JSONObject authLogin(JSONObject jsonObject) {
        String username = jsonObject.getString("username");
        String password = jsonObject.getString("password");
        JSONObject info = new JSONObject();
        Subject currentUser = SecurityUtils.getSubject();
        //生成一个token
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            currentUser.login(token);
            info.put("result","success");
        } catch (AuthenticationException e) {
            info.put("result","fail");
        }
        return info;
    }

    @Override
    public JSONObject getUser(String username, String password) {
        return loginDao.getUser(username, password);
    }

    @Override
    public JSONObject getInfo() {
        //从session获取用户信息
        Session session = SecurityUtils.getSubject().getSession();
        JSONObject userInfo = (JSONObject) session.getAttribute(Constants.SESSION_USER_INFO);
        String username = userInfo.getString("username");
        JSONObject info = new JSONObject();
        JSONObject userPermission = permissionService.getUserPermission(username);
        session.setAttribute(Constants.SESSION_USER_PERMISSION,userPermission);
        info.put("userPermission",userPermission);
        return CommonUtil.successJson(info);
    }

    @Override
    public JSONObject logout() {
        try {
            Subject currentUser = SecurityUtils.getSubject();
            currentUser.logout();
        } catch (Exception e) {

        }
        return CommonUtil.successJson();
    }
}
