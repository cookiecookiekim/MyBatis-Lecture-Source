package com.ohgiraffers.section01.xmlmapper;

import org.apache.ibatis.session.SqlSession;

import static com.ohgiraffers.common.Template.getSqlSession;

public class ElementService { // 24-10-15 Service

    private ElementMapper mapper;

    public void selectCacheTest() {

        SqlSession sqlSession = getSqlSession();

        mapper = sqlSession.getMapper(ElementMapper.class);

        mapper.asdasd();

        sqlSession.close();
    }
}
