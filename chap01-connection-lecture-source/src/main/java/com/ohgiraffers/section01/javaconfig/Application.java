package com.ohgiraffers.section01.javaconfig;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment; // build.gradle에서 다운 받았기 때문에 임포트 가능.
import org.apache.ibatis.session.Configuration; // import시 mybatis에서 제공하는 거로 선택해야 함.
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import java.util.Date;

public class Application { // 24-10-07 (월) 1~2교시 mybatis(프레임워크)

    private static String DRIVER = "com.mysql.cj.jdbc.Driver"; // 공식같은 것
    private static String URL = "jdbc:mysql://localhost/menudb"; // 공식같은 것
    private static String USER = "ohgiraffers";
    private static String PASSWORD = "ohgiraffers";

    public static void main(String[] args) {

        // mybatis 사용하기 위한 첫번째는 환경설정 필요

        /* index. 1. 환경 구성 */
        /* comment
        *   JdbcTransactionFactory() : 수동 커밋 (명령어를 보내야 반영하겠다는 의미)
        *   ManagedTransactionFactory() : 자동 커밋
        *   ------------------------------------
        *   PooledDataSource : ConnectionPool 사용 (미리 공간을 만들어 놓음과 동시에 값들을 넣어놓고 필요할때마다 꺼내 쓰는 용도)
        *   UnPooledDataSource : ConnectionPool 미사용 */

        Environment environment = new Environment(  // 기본 생성자 없음 , 반드시 3개의 전달인자를 넣어줘야함.
                "dev"                         // 환경 정보에 대한 이름(id)
                ,new JdbcTransactionFactory() // 수동 커밋 하겠다.
                ,new PooledDataSource(DRIVER,URL,USER,PASSWORD) // 전역변수로 드라이버에 대한 설정값들 기입
        );

        /* index. 2. 만들어둔 환경 정보를 바탕으로 MyBatis 설정 구성 */
        Configuration configuration = new Configuration(environment); // import시 mybatis에서 제공하는 거로 선택해야 함.

        /* index. 4. DataBase와 접속할 정보를 만들었으니, 이제 Session을 구성해보자 */
        configuration.addMapper(Mapper.class); // Mapper가 인터페이스이기 때문에 클래스처럼 만들어주기 .class

        /* index. 3. DataBase와 접속할 정보를 만들었고(index 1,2), 이제 Session 구성하기 */
        // JDBC에선 Connection, Mybatis에서는 Session (용어만 바뀌었다고 생각하기)
        /* Comment. SQLSession을 만들기 위한 준비 단계
        *   - SQLSessionFactory : SqlSession객체를 생성하기 위한 팩토리(공장)역할의 인터페이스
        *   - SQLSessionFactoryBuilder : SqlSessionFactory 인터페이스 타입의 하위 구현 객체를 생성하기 위한 빌드 역할 수행.
        *   → build() : 환경설정에 대한 정보를 담고있는 Configuration 타입의 객체 (메서드)
        *   혹은 외부 설정 파일과 연결된 Stream을 매개변수로 전달하면 SqlSessionFactory 인터페이스 타입의 객체 반환 */

        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(configuration);
        // 공장을 만들건데 빌더(인부)들에 의해서 만들어 진다. (build라는 명령어로)

        // 공장을 만들었으니 이제 Session을 만들 차례
        /* comment. openSession()
        *   SqlSession 인터페이스 타입의 객체를 반환하는 메서드이고, boolean 타입을 인자로 전달할 수 있다.
        *   false를 전달하게 되면 Connection 인터페이스 타입 객체로 DML 수행 후 autocommit 설정을 꺼주게 된다. (권장) */
        SqlSession sqlSession = factory.openSession(false);

        /* index. 5. 등록한 매퍼를 활용해서 내부에 작성한 기능을 수행 */
        Mapper mapper = sqlSession.getMapper(Mapper.class);

        Date date = mapper.selectSysDate(); // selectSysDate가 Date 타입
        System.out.println("date = " + date); // Mon Oct 07 00:00:00 KST 2024 → 실제 데이터베이스에서 조회한 값 출력

        sqlSession.close(); // jtbc와 달리, close가 예외처리도 없고 간편해졌다. (누군가 구현해놓고 있다라는 뜻)


        // XML 방식으로도 환경설정 할 수있다.
        // check point로는 xml방식으로 설정하는 게 편한지, 이게 편한지 체크해보자 (스스로..)
    }
}
