package com.ohgiraffers.section03.remix.model.dao;

import com.ohgiraffers.section03.remix.model.dto.MenuDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public interface MenuMapper { // → section03 xml파일의 장점 + 자바 파일의 장점 합쳐서 사용

    List<MenuDTO> selectAllMenu(); // → 이 메서드가 곧, 쿼리문의 id이다.

    MenuDTO selectCodeMenu(int code);

    int insertNewMenu(MenuDTO menu);

    int updateMenu(MenuDTO modifyMenu);

    int deleteMenu(MenuDTO deleteMenu);

}
