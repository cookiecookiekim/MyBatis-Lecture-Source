package com.ohgiraffers.section01.xmlconfig.controller;

import com.ohgiraffers.section01.xmlconfig.model.dto.MenuDTO;
import com.ohgiraffers.section01.xmlconfig.model.service.MenuService;
import com.ohgiraffers.section01.xmlconfig.view.PrintResult;

import java.util.List;

public class MenuController { //24-10-07 (5교시) Controller 구성

    /* comment. Controller의 역할
    *   view에서 사용자가 입력한 정보를 파라미터 형태로 전달 받으면 전달받은 값을 검증하거나,
    *   [★★★ 추가적인 정보가 필요하면 가공한 뒤,
    *   service 쪽으로 전달하기 위한 인스턴스를 생성 및 담고,
    *   service의 비즈니스 로직을 담담하는 메서드를 호출한다. ★★★]
    *   또한 호출한 수행 결과를 반환받아 어떤 view를 보여줄지 결정하는 역할 수행. */

    private final MenuService menuService;
    private final PrintResult printResult;

    public MenuController () { // 이렇게 '생성자를 통한 초기화'를 하는 이유 → 안정성
        // MenuService menuService = new MenuService();로 하게되면 menuService를 만날때 마다 객체 생성
        // → 간극이 발생되어 불안정하다.
        this.menuService = new MenuService(); // 여기에 MenuService 생성 구문 추가
        this.printResult = new PrintResult();
    }

    public void selectAllMenu() {

        List<MenuDTO> menuList = menuService.selecAllMenu();
        if (menuList != null) { // 정상 조회가 됐다면,
            printResult.printMenuList(menuList);
        } else {
            System.out.println("조회 결과가 없습니다.");
        }
    }
}
