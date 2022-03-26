package mxz.commons.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisUtils {
    private static SqlSessionFactory factory = null;

    //  单例SqlSessionFactory
    static {
        String config = "mybatis.xml";
        try {
            InputStream in = Resources.getResourceAsStream(config);
            factory = new SqlSessionFactoryBuilder().build(in);
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    //  获取SqlSession
    public static SqlSession getSqlSession() {
        return factory.openSession(true);//自动提交事务
    }


}
