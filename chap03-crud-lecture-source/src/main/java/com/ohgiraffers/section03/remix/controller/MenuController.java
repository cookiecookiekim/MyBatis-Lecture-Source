package com.ohgiraffers.section03.remix.controller;

import com.ohgiraffers.section03.remix.model.dto.MenuDTO;
import com.ohgiraffers.section03.remix.model.service.MenuService;
import com.ohgiraffers.section03.remix.view.PrintResult;

import java.util.List;
import java.util.Map;

public class MenuController { //24-10-10 (3교시) section02 복사해옴

    /* comment. Controller의 역할
    *   view에서 사용자가 입력한 정보를 파라미터 형태로 전달 받으면 전달받은 값을 검증하거나,
    *   [★★★ 추가적인 정보가 필요하면 가공한 뒤,
    *   service 쪽으로 전달하기 위한 인스턴스를 생성 및 담고,
    *   service의 비즈니스 로직을 담담하는 메서드를 호출한다. ★★★]
    *   또한 호출한 수행 결과를 반환받아 어떤 view를 보여줄지 결정하는 역할 수행. */

    private final MenuService menuService;
    private final PrintResult printResult;

    public MenuController() { // 이렇게 '생성자를 통한 초기화'를 하는 이유 → 안정성
        // MenuService menuService = new MenuService();로 하게되면 menuService를 만날때 마다 객체 생성
        // → 간극이 발생되어 불안정하다.
        this.menuService = new MenuService(); // 여기에 MenuService 생성 구문 추가
        this.printResult = new PrintResult();
    }

    public void selectAllMenu() {

        List<MenuDTO> menuList = menuService.selecAllMenu();
        if (menuList != null) { // 정상 조회가 됐다면,
            printResult.printMenuList(menuList);
        } else { // 정상 조회가 안 됐다면 (menuList가 없다면) // 24-10-08 (화) 1교시
            printResult.printErrorMessage("selectList"); // "selectList" 이란 문자열 함께 전달
        }
    }

    public void selectMenuBycode(Map<String, String> parameter) { // 헷갈릴 수 있으니 매개변수명 parameter로 수정
        // 나중에 배울 개념이지만, 추후에 화면에서 입력받은 값을 컨트롤러가 전달받게 되면 String 타입으로 넘어온다!!!
        // 사용자가 입력한 String 타입의 값을 설계한 자료형(int)에 맞게 parsing(번역)
        int code = Integer.parseInt(parameter.get("menuCode")); // String → int 변경(String 값을 Int 자료형으로 파싱 - 오토 언박싱)
        // 전달받은 parameter에 값을 꺼낼 거다.

        MenuDTO menu = menuService.selectMenuByMenuCode(code); // 메뉴 코드로 검색할건데 조건(code)을 넣어 준다.

        if (menu != null) {
            printResult.printMenu(menu);
        } else {
            printResult.printErrorMessage("selectOne");
        }
    }

    public void insertNewMenu(Map<String, String> parameter) { // parameter를 db에 맞게 parsing 하기

        String menuName = parameter.get("name"); // key를 입력하여 값을 꺼내줌
        int menuPrice = Integer.parseInt(parameter.get("price")); // wrapper class로 형변환
        int categoryCode = Integer.parseInt(parameter.get("category")); // wrapper class로 형변환

        // 서로 다른 자료형을 가진 연관있는 값을 클래스로 뭉쳐서 전달해보기.
        // MenuDTO 클래스 사용
        MenuDTO newMenu = new MenuDTO();
        newMenu.setMenuName(menuName);
        newMenu.setMenuPrice(menuPrice);
        newMenu.setCategoryCode(categoryCode);

        // DTO 사용 목적 : 중간중간 필요에 따라 사용 (DTO 사용 안 할 시 3개를 보내야하고 형태를 유지해야 함)
        if (menuService.insertNewMenu(newMenu)) { // 기본값은 true
            // 되돌아와서 menuService.insertNewMenu(newMenu); 구문은 true 또는 false 형태이기 때문에 if 문에 담길 수 있음
            printResult.printSuccessMessage("insert");
        } else {
            printResult.printErrorMessage("insert");
        }
    }

    public void modifyMenu(Map<String, String> parameter) { // 나중에 파싱된 형태로 받는 방법 배울 예정
        int code = Integer.parseInt(parameter.get("code"));
        String name = parameter.get("name");
        int price = Integer.parseInt(parameter.get("price"));
        int categoryCode = Integer.parseInt(parameter.get("categoryCode"));

        MenuDTO modifyMenu = new MenuDTO();
        modifyMenu.setMenuCode(code);
        modifyMenu.setMenuName(name);
        modifyMenu.setMenuPrice(price);
        modifyMenu.setCategoryCode(categoryCode);

        if (menuService.modifyMenu(modifyMenu)) { // boolean type으로 받았으니 위와 동일하게 if문으로
            printResult.printSuccessMessage("update");
        } else {
            printResult.printErrorMessage("update");
        }
    }

    public void deleteMenu(Map<String, String> parameter) {
        int code = Integer.parseInt(parameter.get("code"));

        MenuDTO deleteMenu = new MenuDTO();
        deleteMenu.setMenuCode(code);

        if (menuService.deleteMenu(deleteMenu)) {
            printResult.printSuccessMessage("delete");
        } else {
            printResult.printErrorMessage("delete");
        }
    }
}
