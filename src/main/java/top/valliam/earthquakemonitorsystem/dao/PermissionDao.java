package top.valliam.earthquakemonitorsystem.dao;

import com.alibaba.fastjson.JSONObject;

import java.util.Set;

/**
 * @Classname PermissionDao
 * @Description TODO
 * @Date 2019/12/2 4:05 下午
 * @Created by valliam
 */
public interface PermissionDao {
    /**
     * 查询用户的角色 菜单 权限
     */
    JSONObject getUserPermission(String username);

    /**
     * 查询所有的菜单
     */
    Set<String> getAllMenu();

    /**
     * 查询所有的权限
     */
    Set<String> getAllPermission();
}
