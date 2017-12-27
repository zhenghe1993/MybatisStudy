package com.jmper;

import org.apache.ibatis.annotations.Select;

/**
 * @author 郑和明
 * @version 1.0 (createTime:2017-12-23 20:14:09)
 */
public interface UserMapper {
    /**
     * 根据id 返回 用户类
     *
     * @param id 用户id
     * @return user类
     */
    User selectOne(Integer id);

    /**
     * 插入数据
     *
     * @param user 用户对象
     * @return id
     */
    int insertOne(User user);

    int deleteUserById(int id);
}
