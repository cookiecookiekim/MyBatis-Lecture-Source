package com.ohgiraffers.section01.dynamic;

import com.ohgiraffers.common.MenuDTO;
import com.ohgiraffers.common.SearchCriteria;

import java.util.*;

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

    public void foreachSelect() {

        Set<Integer> set = new HashSet<>();
        while (set.size() < 5) {
            int result = ((int)(Math.random()* 30 + 1));
            set.add(result);
            System.out.println(set);
        }
        List<Integer> list = new ArrayList<>(set);

        Map<String , List<Integer>> map = new HashMap<>();
        map.put("key", list);
        menuService.foreachSelect(map);
    }

    public void controllerSearchMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.print("검색 조건을 입력하시겠습니까? (예 or 아니오) : ");

        boolean yesOrNo = "예".equals(sc.nextLine()) ? true : false;

        SearchCriteria searchCriteria = new SearchCriteria();

        if (yesOrNo) {
            System.out.print("검색할 메뉴 코드를 입력해 주세요 : ");
            String menuCode = sc.nextLine();
            searchCriteria.setCondition("menuCode");
            searchCriteria.setValue(menuCode);
        }

        System.out.println("확인 0");
        menuService.searchMenuCode(searchCriteria);

    }

    public void controllerSearchBoth() {
        Scanner sc = new Scanner(System.in);
        System.out.print("검색 조건(category or name or both or null) : "); // 여러 상황 연습
        String value = sc.nextLine();

        Map<String , Object> map = new HashMap<>();

        if ("category".equals(value)) {
            System.out.print("검색할 카테고리 코드를 입력해 주세요 : ");
            int categoryCode = sc.nextInt();
            map.put("categoryCode", categoryCode);

        } else if ("name".equals(value)) {
            System.out.print("검색할 메뉴 이름을 입력해 주세요 : ");
            String menuName = sc.nextLine();
            map.put("menuName", menuName);

        } else if ("both".equals(value)) {
            System.out.print("검색할 카테고리 코드를 입력해 주세요 : ");
            int categoryCode = sc.nextInt();
            System.out.print("검색할 메뉴 이름을 입력해 주세요 : ");
            String menuName = sc.nextLine();

            map.put("categoryCode", categoryCode);
            map.put("menuName", menuName);

            menuService.searchNameCategoryBoth(map);
        }
    }
}












