package top.valliam.earthquakemonitorsystem.service;

import com.alibaba.fastjson.JSONObject;

/**
 * @Classname PermissionService
 * @Description 权限的service类
 * @Date 2019/12/2 4:03 下午
 * @Created by valliam
 */
public interface PermissionService {
    /**
     * 查询某用户的 角色  菜单列表   权限列表
     */
    JSONObject getUserPermission(String username);
}
