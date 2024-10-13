package com.ohgiraffers.section01.dynamic;

import com.ohgiraffers.common.MenuDTO;
import com.ohgiraffers.common.SearchCriteria;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MenuController {

    MenuService menuService = new MenuService();
    PrintResult printResult = new PrintResult();

    public void controllerIfPrice() {

        Scanner sc = new Scanner(System.in);
        System.out.print("검색하실 가격의 최대 금액을 입력해 주세요 : ");
        int price = sc.nextInt();

        Map<String, Integer> map = new HashMap<>();
        map.put("price", price);
        menuService.ifMaxPrice(map);

    }

    public void controllerIfNameCategory() {
        Scanner sc = new Scanner(System.in);
        System.out.print("검색 기준을 선택해 주세요 (menuName or category) : ");
        String condition = sc.nextLine();
        System.out.print("검색어를 임력해 주세요 : ");
        String value = sc.nextLine();

        SearchCriteria searchCriteria = new SearchCriteria(condition,value);
        menuService.serviceIfNameCategory(searchCriteria);

    }

    public void chooseSupCategory() {
        Scanner sc = new Scanner(System.in);
        System.out.print("상위 분류를 입력해 주세요(식사, 음료, 디저트) : ");
        String value = sc.nextLine();

        SearchCriteria searchCriteria = new SearchCriteria("category", value);
        List<MenuDTO> menuList = menuService.chooseSupMenu(searchCriteria);

        if (menuList != null && menuList.size() > 0) {
            printResult.choseCategorySelect(menuList);
        } else {
            printResult.errorCode("errorChooseCategory");
        }

    }
}












