import com.jmper.Root;
import com.jmper.User;
import com.jmper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author 郑和明
 * @version 1.0 (createTime:2017-12-26 15:46:52)
 */
public class CURD implements Root {


    private SqlSession session = null;
    private UserMapper userMapper = null;

    @Before
    public void setUp() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        session = sqlSessionFactory.openSession();
        userMapper = session.getMapper(UserMapper.class);
    }

    @After
    public void tearDown() throws Exception {
        session.close();
    }

    @Test
    public void insert() throws Exception {

        User user = new User();
        user.setAddress("北京市海淀区");
        user.setCreateTime(new Date());
        user.setIncome(new BigDecimal(100.12));
        user.setNickName("root");
        user.setUserName("root");
        user.setPassword("111111");
        user.setTelephone("1049049944");
        int id = userMapper.insertOne(user);
        logger.debug("id={},user={}", id, user);
        session.commit();
    }

    @Test
    public void delete() throws Exception {
        int res = userMapper.deleteUserById(3);

        logger.debug("id={}", res);
        session.commit();
    }
}