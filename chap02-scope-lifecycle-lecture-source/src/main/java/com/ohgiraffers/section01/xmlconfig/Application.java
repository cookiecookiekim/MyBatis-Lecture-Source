package com.ohgiraffers.section01.xmlconfig;

import static com.ohgiraffers.section01.xmlconfig.MybatisTemplate.getSqlSession;

public class Application { // 24-10-07 (월) 4교시, MyBatis - lifecycle
                            // 이번 프로젝트의 핵심 : Factory는 1개만 생성, Session은 호출할때마다 새롭게 생성

    public static void main(String[] args) {

        System.out.println(getSqlSession());
        System.out.println(getSqlSession());
        System.out.println(getSqlSession());
        System.out.println(getSqlSession());
        System.out.println(getSqlSession()); // → Factory 해쉬코드 동일 , Session 해쉬코드는 모두 상이
                                            // ★ Factory는 최초 1회 생성 Session은 부를때마다 새로 생성★
    }
}
