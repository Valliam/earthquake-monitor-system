package top.valliam.earthquakemonitorsystem.service.impl;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.valliam.earthquakemonitorsystem.dao.PermissionDao;
import top.valliam.earthquakemonitorsystem.service.PermissionService;

import java.util.Set;

/**
 * @Classname PermissionServiceImpl
 * @Description 权限Service的相关实现
 * @Date 2019/12/2 4:03 下午
 * @Created by valliam
 */
@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionDao permissionDao;
    @Override
    public JSONObject getUserPermission(String username) {
        JSONObject userPermission = getUserPermissionFromDB(username);
        return userPermission;
    }

    private JSONObject getUserPermissionFromDB(String username) {
        JSONObject userPermission = permissionDao.getUserPermission(username);
        //管理员角色ID为1
        int adminRoleId = 1;
        //如果是管理员
        String roleIdKey = "roleId";
        if (adminRoleId == userPermission.getIntValue(roleIdKey)) {
            //查询所有菜单  所有权限
            Set<String> menuList = permissionDao.getAllMenu();
            Set<String> permissionList = permissionDao.getAllPermission();
            userPermission.put("menuList", menuList);
            userPermission.put("permissionList", permissionList);
        }
        return userPermission;
    }
}
