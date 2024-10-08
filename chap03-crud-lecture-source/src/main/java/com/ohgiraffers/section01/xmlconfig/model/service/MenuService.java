package com.ohgiraffers.section01.xmlconfig.model.service;

import com.ohgiraffers.section01.xmlconfig.model.dao.MenuDAO;
import com.ohgiraffers.section01.xmlconfig.model.dto.MenuDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.ohgiraffers.section01.xmlconfig.common.Template.getSqlSession;

public class MenuService {

    /* comment. Service 계층의 역할
     *   - 비즈니스 로직(하나의 일련과정), 쿠팡에서 메뉴 주문
     *   → 우리는 뭘 해야 할까?
     *   1. SqlSession 생성 → DB 접속 준비
     *   - .DAO (데이터베이스 접근 객체)의 메서드 호출
     *    트렌잭션(commit, rollback) 제어
     *   - SqlSecssion 닫기 */

    private final MenuDAO menuDAO;

    public MenuService () {
        this.menuDAO = new MenuDAO();
    }

    public List<MenuDTO> selecAllMenu() {

        SqlSession sqlSession = getSqlSession();

        // DAO는 데이터베이스와 직접 소통하는 클래스이다.
        // 소통하기 위해서는 통로 == Connection == SqlSession이 필요하다.
        List<MenuDTO> menuList =  menuDAO.selectAllMenu(sqlSession); // 호출함과 동시에 sqlSession 전달

        sqlSession.close(); // 마지막으로 통로 닫기.

        return menuList;
    }

    public MenuDTO selectMenuByMenuCode(int code) {
        // 여기서 할 일 1. SqlSession 생성
        SqlSession sqlSession = getSqlSession();
        // 2. DAO 계층에 메서드 호출하기 - session과 추가적인 전달값이 있다면 같이 전달
        MenuDTO menu = menuDAO.selectMenuByMenuCode(sqlSession, code); // Controller에 DTO(menu) 타입과 맞춰주기.
        //  menuDAO.selectMenuByMenuCode(sqlSession, code);는 한 행의 메뉴(데이터)를 뜻함.

        // 3. 사용한 통로 닫아주기
        sqlSession.close();

        return menu; // 한 행의 메뉴를 controller로 가져감.
    }

    public boolean insertNewMenu(MenuDTO newMenu) { // 등록이 잘 됐는지 보려고 반환타입을 boolean으로 변경
        // 1. SqlSession 생성
        SqlSession sqlSession = getSqlSession();
        // 2. DAO 계층에 SqlSession과 전달할 값 있으면 전달
        int result = menuDAO.insertNewMenu(sqlSession,newMenu); // class형 자료형(newMenu) 전달
        // int result에 담는 이유는 insert가 정상적으로 등록 됐다면 정수(1)형으로 반환하기 때문에 int형으로 받아줘야 한다.

        // 3. dml(insert, update , delete) 구문은 트랜젝션 제어를 해줘야 한다.
        // → 트랜잭션 제어 : 저장을 할 거인지, 롤백을 할 것인지
        if (result > 0) { // 제대로 수행이 되었다면
            sqlSession.commit(); // commit → 수행할 결과를 저장하겠다.
        } else { // 수행이 제대로 안 되었다면
            sqlSession.rollback(); // 마치 하지 않은 것 처럼 되돌려 놓겠다.
        }
        // 4. SqlSession 닫기
        sqlSession.close();

        return (result > 0 ? true : false);
    }

    public boolean modifyMenu(MenuDTO modifyMenu) {
        SqlSession sqlSession = getSqlSession();

        int result = menuDAO.updateMenu(sqlSession, modifyMenu);
        if (result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        sqlSession.close();
        return (result > 0 ? true : false);
    }

    public boolean deleteMenu(MenuDTO deleteMenu) {
        SqlSession sqlSession = getSqlSession();
        int result = menuDAO.deleteMenu(sqlSession,deleteMenu);
        if (result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        sqlSession.close();
        return (result > 0 ? true : false);
    }
}
