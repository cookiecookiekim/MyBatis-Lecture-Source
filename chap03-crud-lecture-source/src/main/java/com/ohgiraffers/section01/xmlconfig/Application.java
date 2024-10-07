package com.ohgiraffers.section01.xmlconfig;

import com.ohgiraffers.section01.xmlconfig.view.MenuView;

public class Application { // 24-10-07 5교시 mybatis - crud

    public static void main(String[] args) { // 1. xml방식으로 crud 해보기
// view : 사용자가 보는 화면 및 입력(등록)
// controller : 입력 받음 (데이터(날짜) 검증)
// model[service , dao] : 검증이 완료되었고, 실행을 하겠다
        /* controller → service(데이터 베이스에 넣을 준비) → dao (데이터 베이스와 연관된 클래스에 넘겨줌) → db (이후 반대로 돌아가며 리턴) →
         1 반환 (등록성공 시) → dao → service → controller(1을 사용자가 알아보기 슆게 '등록 완료'와 같은 페이지가 보이게 바꿔줌) → view */

        MenuView view = new MenuView();
        view.display();

    }

}
