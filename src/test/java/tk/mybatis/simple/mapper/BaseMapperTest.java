package tk.mybatis.simple.mapper;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;

import java.io.IOException;
import java.io.Reader;

/**
 * @author peng.li
 * @Description: TODO
 * @date 2020/7/29 10:30
 */
public class BaseMapperTest {

    private static SqlSessionFactory sqlSessionFactory;

    @Before
    public void init(){
        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public SqlSession getSqlSession(){
        return sqlSessionFactory.openSession();
    }

}
