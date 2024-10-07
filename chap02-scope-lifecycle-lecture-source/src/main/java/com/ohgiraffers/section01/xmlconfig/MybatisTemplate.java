package com.ohgiraffers.section01.xmlconfig;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisTemplate { // 24-10-07 (월) 4교시, MyBatis - Template 구성

    /* comment. SqlSessionFactory는 어플리케이션 스코프를 가진다.
    *   즉, Application이 run하면 생성하고 끝날때까지 유지한다라는 뜻이다.
    *   → Application이 실행되는 동안 여러차례 Factory 생성하는 것은 나쁜 냄새가 나는 코드를 만드는 것!
    *   그리하여 가장 좋은 방식은 싱글톤 패턴을 이용하는 것이다. (1개의 인스턴스를 공유) */

    private static SqlSessionFactory sqlSessionFactory;

    public static SqlSession getSqlSession() { // session 필요할 때 호출하는 메서드

        if (sqlSessionFactory == null) { // 만약 SqlSessionFactory이 존재하지 않는다면
            String resource = "mybatis-config.xml"; // 만들겠다.

            try {
                InputStream inputStream = Resources.getResourceAsStream(resource);
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream); // 빌더를 통해 팰토리를 만들었다.

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } SqlSession sqlSession = sqlSessionFactory.openSession(false); // 공장 존재 여부 판단 후, if 밖에서 Session을 만들어준다.
            // 호출할때마다 계속 만들 거다.
        System.out.println("SqlSessionFactory의 hashcode() : " + sqlSessionFactory.hashCode()); // 1개 유지 여부 확인
        System.out.println("SqlSession의 hashcode() : " + sqlSession.hashCode()); // 추가 생성 여부 확인
        return sqlSession;
    }
}
