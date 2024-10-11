package com.ohgiraffers.section02.xmlconfig;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

public class Application { // 24-10-07 (월) 3교시 mybatis(프레임워크) xml 파일로 설정 정보 가져오기
                            // xml 방식의 config 해보기
                            // mybatis 홈페이지에 내용이 다 나와있음.
    public static void main(String[] args) {

        String resource = "mybatis-config.xml"; // 파일명
        InputStream inputStream = null;

        try {

            inputStream = Resources.getResourceAsStream(resource); // 경로 읽었다는 뜻.
            // → 파일 위치가 resources에 있기 때문에
            //  프로퍼티 객체 생성 이후 prop.loadFromXML(new FileInputStream)로 읽는 게 아니라
            //  inputStream = Resources.getResourceAsStream(resource); 이런 식으로 읽는다.

            SqlSessionFactory sqlSessionFactory =
                    new SqlSessionFactoryBuilder().build(inputStream); // try 안으로 옮겨줌

            SqlSession session = sqlSessionFactory.openSession(false); // session 만들기

            Date date = session.selectOne("mapper.selectSysDate"); //mapper.xml파일

            System.out.println("date = " + date);

            session.close(); // 자원 닫아주기

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
