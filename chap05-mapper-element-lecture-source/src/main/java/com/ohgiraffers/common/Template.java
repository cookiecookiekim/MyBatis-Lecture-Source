package com.ohgiraffers.common;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Template { // 24-10-15 (화) 1교시 chap04 복붙

    private static SqlSessionFactory sqlSessionFactory;

    public static SqlSession getSqlSession () {
        if (sqlSessionFactory == null) {
            String resource = "config/mybatis-config.xml"; // 경로 입력

            try {
                InputStream inputStream = Resources.getResourceAsStream(resource);

                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return sqlSessionFactory.openSession(false);
    }

}
