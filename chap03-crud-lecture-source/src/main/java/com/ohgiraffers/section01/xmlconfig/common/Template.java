package com.ohgiraffers.section01.xmlconfig.common;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Template { // SqlSession 객체 만드는 클래스

    private static SqlSessionFactory sqlSessionFactory; // 싱글톤

    public static SqlSession getSqlSession() {  // 부를때마다
        if (sqlSessionFactory == null) { // 만약 팩토리가 없다면
            String resource = "com/ohgiraffers/section01/xmlconfig/mybatis-config.xml";
            try {
                InputStream inputStream =
                        Resources.getResourceAsStream(resource);

                sqlSessionFactory =
                        new SqlSessionFactoryBuilder().build(inputStream); // 팩토리를 하나만 만들겠다.

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        SqlSession sqlSession = sqlSessionFactory.openSession(false); // 세션을 만들겠다.
        return sqlSession;
    }


}
