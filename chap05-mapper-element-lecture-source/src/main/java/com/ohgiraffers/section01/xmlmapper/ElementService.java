package com.ohgiraffers.section01.xmlmapper;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.ohgiraffers.common.Template.getSqlSession;

public class ElementService { // 24-10-15 Service

    private ElementMapper mapper;

    public void selectCacheTest() {

        SqlSession sqlSession = getSqlSession();

        mapper = sqlSession.getMapper(ElementMapper.class);
        // 동일한 쿼리문을 여러번 실행하여 테스트하기 (cache 적용 했을 때 시간 감소 효율 확인)

        for (int i = 0; i < 10; i++) {
            Long startTime = System.currentTimeMillis(); // 조회 시간 확인용 시작 시간 체크

            List<String> menuNameList = mapper.selectCacheTest();
            System.out.println(menuNameList);

            Long endTime = System.currentTimeMillis(); // 조회 시간 확인용 종료 시간 체크

            Long interval = endTime - startTime; // 총 걸린 시간 체크
            System.out.println("수행 시간 : " + interval + "(ms)");
        }

        sqlSession.close();
    }

    public void selectResultMapTest() {
        SqlSession sqlSession = getSqlSession();

        mapper = sqlSession.getMapper(ElementMapper.class);
        List<String> list = mapper.asdadadasdasd();

        sqlSession.close();
    }
}
