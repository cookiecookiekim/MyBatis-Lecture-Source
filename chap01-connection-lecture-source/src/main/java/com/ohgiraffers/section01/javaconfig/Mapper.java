package com.ohgiraffers.section01.javaconfig;

import org.apache.ibatis.annotations.Select;

import java.util.Date; // 24-10-07 (월) 1~2교시 mybatis(프레임워크)

public interface Mapper { // 데이터베이스와 소통하는 창구 역할, 그러나 등록이 필요하다 (index. 4.)

    @Select("SELECT CURRENT_DATE() FROM DUAL") // DUAL : 가상의 테이블
    Date selectSysDate(); // 메서드 명이 쿼리문을 실행시킬 수 있는 key

}
