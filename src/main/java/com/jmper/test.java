package com.jmper;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author 郑和明
 * @version 1.0 (createTime:2017-12-23 19:32:12)
 */
public class test {

    public static void main(String[] args) throws IOException {

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession session=sqlSessionFactory.openSession();


        UserMapper userMapper = session.getMapper(UserMapper.class);
        try {
//            User user =session.selectOne("com.jmper.UserMapper.selectOne", 1);
//              User user=userMapper.selectOne(1);
              User user=userMapper.selectUserByNickName("Jmper");
            System.out.println(user);
        } finally {
            session.close();
        }


    }
}
