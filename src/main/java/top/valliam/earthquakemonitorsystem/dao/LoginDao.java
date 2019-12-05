package top.valliam.earthquakemonitorsystem.dao;

import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Param;

/**
 * @Classname LoginDao
 * @Description 登陆的相关Dao
 * @Date 2019/12/2 4:00 下午
 * @Created by valliam
 */
public interface LoginDao {
    /**
     * 根据用户名和密码查询对应的用户
     */
    JSONObject getUser(@Param("username")String username, @Param("password")String password);
}
