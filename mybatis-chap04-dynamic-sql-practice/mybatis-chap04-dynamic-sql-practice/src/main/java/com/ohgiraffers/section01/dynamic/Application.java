package com.ohgiraffers.section01.dynamic;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

        do {
            System.out.println("===== 마이바티스 동적 SQL 학습 메뉴 =====");
            System.out.println("1. if 확인하기 ");
            System.out.println("2. choose(when, otherwise) 확인하기 ");
            System.out.println("3. foreach 확인하기 ");
            System.out.println("4. trim(where, set) 확인하기 ");
            System.out.println("9. 종료하기 ");
            System.out.print("메뉴를 선택해 주세요 :  ");
            int no = sc.nextInt();

            switch (no) {
                case 1 : selectIf(); break;
            }

        } while (true);
    }
    private static void selectIf () {
        MenuService menuService = new MenuService();
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("============ if 서브 메뉴 ============");
            System.out.println("1. 원하는 금액 대 적합한 추천 메뉴 목록 보여주기");
            System.out.println("2. 메뉴 이름 or 카테고리 명으로 검색해서 메뉴 목록 보여주기");
            System.out.println("9. 이전 메뉴로");
            System.out.print("원하는 메뉴를 선택해 주세요 : ");
            int no = sc.nextInt();

            switch (no) {
                case 1 :
                    menuService.selectMenuByPrice(inputPrice()); break;
                case 9 :
                    System.out.println("if 서브메뉴 종료"); return; // 자신을 호출한 app로 돌아감.
            }
        } while (true);
    }
    private static int inputPrice() {
        Scanner sc = new Scanner(System.in);
        System.out.print("검색하실 가격의 최대 금액을 입력해 주세요 : ");
        int price = sc.nextInt();

        return price;
    }
}
