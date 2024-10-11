package com.ohgiraffers.section03.remix.view;

import com.ohgiraffers.section03.remix.model.dto.MenuDTO;

import java.util.List;

public class PrintResult {

    // 1번 전체 조회를 누르고 실행 결과 값을 보는 메서드
    public void printMenuList(List<MenuDTO> menuList) {
        System.out.println("요청하신 전체 메뉴 조회 결과입니다.");
        for (MenuDTO menu : menuList) {
            System.out.println(menu);
        }
        System.out.println("==========================================");
    }

    public void printErrorMessage(String errorCode) { // 매개변수를 errorCode로 짓고

        String errorMessage = ""; // 초기화 한 것

        switch (errorCode) {
            case "selectList" : // 매개변수가 "selectList"라면(실패했다면)
                errorMessage = "메뉴 전체 조회에 실패하셨습니다..";
                break;
            case "selectOne" :
                errorMessage = "메뉴 코드로 메뉴 조회에 실패하였습니다.."; // 없는 코드를 넣었을 때 실행
                break;
            case "insert":
                errorMessage = "신규 메뉴 등록에 실패하였습니다..";
                break;
            case "update" :
                errorMessage = "메뉴 수정에 실패하였습니다..";
                break;
            case "delete" :
                errorMessage = "메뉴 삭제에 실패하였습니다..";
                break;
        }
        System.out.println(errorMessage); // 실패 메시지 출력
    }

    public void printMenu(MenuDTO menu) {

        System.out.println(menu.getMenuCode() + "번 메뉴 조회 결과입니다."); // getter 메서드 사용해보기.
        System.out.println(menu);
        System.out.println("============================================");
    }

    public void printSuccessMessage(String successCode) {

        String successMessage = "";
        switch (successCode) {
            case "insert" :
                successMessage = "신규 메뉴 등록 성공!";
                break;
            case "update" :
                successMessage = "메뉴 수정 성공!";
                break;
            case "delete" :
                successMessage = "메뉴 삭제 성공!";
        }
        System.out.println(successMessage);
    }
}
