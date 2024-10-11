package com.ohgiraffers.section03.remix.model.service;

import com.ohgiraffers.section03.remix.model.dao.MenuMapper;
import com.ohgiraffers.section03.remix.model.dto.MenuDTO;
import org.apache.ibatis.session.SqlSession;

import java.awt.*;
import java.util.List;

import static com.ohgiraffers.section03.remix.common.Template.getSqlSession;

public class MenuService {  // 24-10-10 (목) 3교시 Service 구성

    private MenuMapper menuMapper;

    public List<MenuDTO> selecAllMenu() {
        // 1. SqlSession 생성
        SqlSession sqlSession = getSqlSession();
        // 2. dao 클래스 메서드 호출 (xml 파일 방식이라면 dao에서 xml로 보냈음)
        // 인터페이스이므로 new로 인스턴스 생성 불가능
        // → 집어 넣은 MenuMapper.class를 get으로 꺼내기
        menuMapper = sqlSession.getMapper(MenuMapper.class);

        List<MenuDTO> menuList = menuMapper.selectAllMenu(); // 여러개 꺼낼 거니까 List<MenuDTO>로

        // 3. 사용한 SqlSession 닫기
        sqlSession.close();
        return menuList;
    }


    public MenuDTO selectMenuByMenuCode(int code) {
        SqlSession sqlSession = getSqlSession();
        menuMapper = sqlSession.getMapper(MenuMapper.class);

        MenuDTO menuList = menuMapper.selectCodeMenu(code);

        sqlSession.close();
        return menuList;
    }

    public boolean insertNewMenu(MenuDTO newMenu) {
        SqlSession sqlSession = getSqlSession();
        menuMapper = sqlSession.getMapper(MenuMapper.class);

        // sqlSession은 안 보내도 되는 이유 재확인하기.
        int result = menuMapper.insertNewMenu(newMenu);

        if (result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

     return (result > 0 ? true : false);
    }

    public boolean modifyMenu(MenuDTO modifyMenu) {
        SqlSession sqlSession = getSqlSession();

        menuMapper = sqlSession.getMapper(MenuMapper.class);

        int result = menuMapper.updateMenu(modifyMenu);

        if (result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        return (result > 0 ? true : false);
    }

    public boolean deleteMenu(MenuDTO deleteMenu) {
        SqlSession sqlSession = getSqlSession();

        menuMapper = sqlSession.getMapper(MenuMapper.class);

        int result = menuMapper.deleteMenu(deleteMenu);

        if (result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        return (result > 0 ? true : false);
    }
}














