package com.ohgiraffers.section03.remix.common;

import com.ohgiraffers.section03.remix.model.dao.MenuMapper;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

public class Template { // 24-10-10(목) 2교시, mybatis 관련 템플릿 생성
    // → 수업 목표 : xml파일 말고, 자바로 사용해보기.
    // xml파일(mybatis-config.xml)에 필드값을 이곳에 작성
    private static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static String URL = "jdbc:mysql://localhost/menudb";
    private static String USER = "ohgiraffers";
    private static String PASSWORD = "ohgiraffers";

    private static SqlSessionFactory sqlSessionFactory;

    public static SqlSession getSqlSession() { // 메서드 생성
        if (sqlSessionFactory == null) {
            Environment environment = new Environment(
            "dev"
            ,new JdbcTransactionFactory()
            ,new PooledDataSource(DRIVER,URL, USER, PASSWORD));
            Configuration configuration = new Configuration(environment);// 환경 구성
            // 여기까지 작성 후에 xml 방식(파일)과 비교해보기

            /* comment. 작성한 MenuMapper 인터페이스 mapper로 등록 */
            configuration.addMapper(MenuMapper.class);

            sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration); // 환경 구성한 걸 가지고 공장을 만든다.
        }
        return sqlSessionFactory.openSession(false);
    } // Template은 자바 방식으로 하는 경우가 많다.
    // 추후에는 노출이 돼있으니까 Properties 파일로 넘기면 어떨까? 라는 생각 가지면 좋음. 일단은 그냥 넘어감.
}
