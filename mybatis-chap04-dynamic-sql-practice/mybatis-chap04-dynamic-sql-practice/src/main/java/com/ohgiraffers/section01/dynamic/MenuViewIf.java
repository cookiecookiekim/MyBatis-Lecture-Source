package com.ohgiraffers.section01.dynamic;

import java.util.Scanner;

public class MenuViewIf {

    public void menuSelect(){

        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("=============mybatis 동적 확인 연습================");
            System.out.println("1. if 확인하기");
            System.out.println("2. choose(when , otherwise) 확인하기");
            System.out.println("9. 종료하기");
            System.out.print("메뉴를 선택해 주세요 : ");
            int no = sc.nextInt();

            switch (no) {
                case 1 : selectIf(); break;
                case 2 : selectChoose(); break;
                case 9 : return;
            }

        } while (true);
    }
    private static void selectIf () {
        MenuController menuController = new MenuController();

        Scanner sc = new Scanner(System.in);
        System.out.println("============ if 서브 메뉴 ============");
        System.out.println("1. 원하는 금액 대 적합한 추천 메뉴 목록 보여주기");
        System.out.println("2. 메뉴 이름 or 카테고리 명으로 검색해서 메뉴 목록 보여주기");
        System.out.println("9. 이전 메뉴로");
        System.out.print("원하는 메뉴를 선택해 주세요 : ");
        int no = sc.nextInt();

        switch (no) {
            case 1 : menuController.controllerIfPrice(); break;
            case 2 : menuController.controllerIfNameCategory(); break;
            case 9 : return;
        }
    }

    private static void selectChoose() {
        Scanner sc = new Scanner(System.in);

        MenuController menuController = new MenuController();

        System.out.println("============ choose 서브 메뉴 ============");
        System.out.println("1. 카테고리 상위 분류열 메뉴 보여주기 (식사, 음료 디저트)");
        System.out.println("9. 이전 메뉴로 돌아가기");
        System.out.print("메뉴 번호를 입력해 주세요 : ");
        int no = sc.nextInt();

        switch (no) {
            case 1 : menuController.chooseSupCategory(); break;
            case 9 : return;
        }

    }
}
