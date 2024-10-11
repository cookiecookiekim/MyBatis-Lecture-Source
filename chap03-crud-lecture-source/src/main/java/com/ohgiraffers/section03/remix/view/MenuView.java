package com.ohgiraffers.section03.remix.view;

import com.ohgiraffers.section03.remix.controller.MenuController;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MenuView {  //24-10-10 (3교시) section02 복사해옴

    /* comment.
     *   나는 아직 Server에 대한 개념과 프론트엔드에 대한 개념을 배우지 않았다.
     *   따라서 실질적으로 사용자들이 볼 수 있는 화면을 만들 수 없지만, 콘솔창을 사용자들이
     *   볼 수 있는 화면이라고 생각하고 연습해보자. */

    /* comment. 시스템 요구사항
     *   1. 메뉴 전체 조회
     *   2. 메뉴 코드로 메뉴 조회
     *   3. 신규 메뉴 등록
     *   4. 메뉴 수정
     *   5. 메뉴 삭제 */

    public void display() {

        Scanner sc = new Scanner(System.in);
        MenuController menuController = new MenuController();
        // menuController 선언과 동시에 MenuController 기본 생성자로 이동하여 this로 초기화 한다.
        do {
            // 사용자가 보는 화면이라고 생각하자.
            System.out.println("=================== HiMedia 메뉴 관리 시스템 ===================");
            System.out.println("1. 메뉴 전체 조회하기");
            System.out.println("2. 메뉴 코드로 메뉴 조회하기");
            System.out.println("3. 신규 메뉴 등록하기");
            System.out.println("4. 메뉴 수정하기");
            System.out.println("5. 메뉴 삭제하기");
            System.out.println("==============================================================");
            System.out.print("실행할 메뉴를 선택해 주세요 : ");
            int no = sc.nextInt();

            switch (no) {
                case 1:
                    menuController.selectAllMenu();
                    break;
                case 2: // parameter(return값)를 가지고 감.
                    menuController.selectMenuBycode(inputMenuCode()); // inputMenuCode()라는 메서드를 만들어서 동작 시키겠다.
                    break;
                case 3:
                    menuController.insertNewMenu(inputMenu());
                    break;
                case 4 :
                    menuController.modifyMenu(inputModifyMenu());
                    break;
                case 5 :
                    menuController.deleteMenu(deleteMenu());
                    break;
            }
        } while (true);
    }

    private static Map<String, String> deleteMenu () {
        Scanner sc = new Scanner(System.in);
        System.out.print("삭제할 메뉴 코드를 입력해 주세요 : ");
        String code = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("code" , code);
        return parameter;
    }
    private static Map<String,String> inputModifyMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.print("수정할 메뉴 코드를 입력해 주세요 : ");
        String code = sc.nextLine();
        System.out.print("수정할 메뉴 이름을 입력해 주세요 : ");
        String name = sc.nextLine();
        System.out.print("수정할 메뉴 가격을 입력해 주세요 : ");
        String price = sc.nextLine();
        System.out.print("수정할 카테고리 코드를 입력해 주세요 : ");
        String categoryCode = sc.nextLine();

        Map<String,String> parameter = new HashMap<>();
        parameter.put("code" , code);
        parameter.put("name" , name);
        parameter.put("price", price);
        parameter.put("categoryCode", categoryCode);
        return parameter;
    }

    private static Map<String, String> inputMenu() { // 역할 : 메뉴 이름, 가격, 카테고리 코드 입렫 받아 넘겨주기
        Scanner sc = new Scanner(System.in);
        System.out.print("신규 메뉴 이름을 입력해 주세요 : ");
        String name = sc.nextLine();
        System.out.print("신규 메뉴의 판매 가격을 입력해 주세요 : ");
        String price = sc.nextLine();
        System.out.print("신규 메뉴의 카테고리 코드를 입력하세요 : ");
        String category = sc.nextLine();

        Map<String, String> parameter = new HashMap<>(); // 맵 만들고, parameter에 값 담아주기.
        parameter.put("name", name);
        parameter.put("price", price);
        parameter.put("category", category);

        return parameter;
    }

    private static Map<String, String> inputMenuCode() { // class명을 생략하기 위해 일부러 static으로 만듦
        // 복습 차원에서 Map 형식으로 만들기, <String 타입으로 key와 value 설정>
        Scanner sc = new Scanner(System.in);
        System.out.print("검색하실 메뉴 코드를 입력해 주세요 : ");
        String menuCode = sc.nextLine();

        Map<String, String> parameter = new HashMap<>(); // return을 위한 map 객체 생성
        parameter.put("menuCode", menuCode); // map은 put으로 값을 집어 넣을 수 있다.
        // put("menuCode", menuCode) 를 통해, 위에 코드인 parameter에 들어감

        return parameter;
    }

}
