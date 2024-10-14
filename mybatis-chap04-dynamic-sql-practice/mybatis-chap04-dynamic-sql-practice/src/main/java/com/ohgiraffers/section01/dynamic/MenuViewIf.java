package com.ohgiraffers.section01.dynamic;

import java.util.Scanner;

public class MenuViewIf {

    public void menuSelect(){

        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("=============mybatis 동적 확인 연습================");
            System.out.println("1. if 확인하기");
            System.out.println("2. choose(when , otherwise) 확인하기");
            System.out.println("3. foreach 확인하기");
            System.out.println("4. trim 확인하기");
            System.out.println("9. 종료하기");
            System.out.print("메뉴를 선택해 주세요 : ");
            int no = sc.nextInt();

            switch (no) {
                case 1 : selectIf(); break;
                case 2 : selectChoose(); break;
                case 3 : foreachSelect(); break;
                case 4 : trimSelect(); break;
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

    private static void foreachSelect() {
        Scanner sc = new Scanner(System.in);
        MenuController menuController = new MenuController();
        do {
            System.out.println("=================== foreach 서브 메뉴 ===================");
            System.out.println("1. 랜덤한 메뉴 5개 추출해서 조회하기");
            System.out.println("9. 이전 메뉴로 돌아가기");
            System.out.print("원하시는 메뉴를 선택해 주세요 : ");
            int no = sc.nextInt();

            switch (no) {
                case 1 : menuController.foreachSelect(); break;
            }
        } while(true);
    }

    private static void trimSelect () {
        Scanner sc = new Scanner(System.in);
        MenuController menuController = new MenuController();
        do {

            System.out.println("================ trim 서브 메뉴 ================");
            System.out.println("1. 검색 조건이 있는 경우 메뉴 코드로 조회, 단 없으면 전체 조회");
            System.out.println("2. 메뉴 혹은 카테고리 코드로 검색, 단 메뉴와 카테고리 둘 다 일치하는 경우도 검색, 검색 조건 없으면 전체 검색");
            System.out.println("3. 원하는 메뉴 정보만 수정하기");
            System.out.println("9. 이전 메뉴로 돌아가기");
            System.out.print("원하시는 메뉴를 선택해 주세요 : ");
            int no = sc.nextInt();

            switch (no) {
                case 1 : menuController.controllerSearchMenu(); break;
                case 2 : menuController.controllerSearchBoth(); break;
            }

        } while(true);

    }
}
