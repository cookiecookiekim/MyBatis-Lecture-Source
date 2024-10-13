package com.ohgiraffers.section01.dynamic;

import com.ohgiraffers.common.MenuDTO;

import java.util.List;

public class PrintResult {


    public void ifMaxPriceSelect(List<MenuDTO> menuList) {
        System.out.println("최고 금액 입력에 따른 메뉴 조회 결과입니다.");
        for (MenuDTO result : menuList) {
            System.out.println(result);
        }
    }
    public void ifNameCategorySelect(List<MenuDTO> menuList) {
        System.out.println("메뉴 이름 및 카테고리로 조회한 결과입니다.");
        for (MenuDTO result : menuList) {
            System.out.println(result);
        }
    }

    public void errorCode(String errorMessage) {
        String errorCode = "";
        switch (errorMessage) {
            case "errorMaxPriceSelect" :
                errorCode = "입력한 최고금액 입력 조회에 실패하였습니다."; break;
            case "errorNameCategorySelect" :
                errorCode = "메뉴 이름 및 카테고리에 의한 조회에 실패하였습니다."; break;
            case "errorChooseCategory" :
                errorCode = "상위 카테고리 코드 조회에 실패하였습니다.";
        }
        System.out.println(errorCode);
    }

    public void choseCategorySelect(List<MenuDTO> menuList) {
        System.out.println("상위 카테고리 코드 조회 결과입니다.");
        for (MenuDTO result : menuList) {
            System.out.println(result);
        }
    }
}
