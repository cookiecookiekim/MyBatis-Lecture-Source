package com.ohgiraffers.section01.xmlconfig.model.dao;

import com.ohgiraffers.section01.xmlconfig.model.dto.MenuDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class MenuDAO {

    /* comment. DAO(Data Access Object)
    *   - 데이터베이스에 접근하는 계층
    *   - 쿼리문을 전달하고 수행한 쿼리문에 대한 결과를 받는 역할. */

    // 여기에 쿼리문을 작성하면 불편하므로 xml 파일에 작성하겠다.
    public List<MenuDTO> selectAllMenu (SqlSession sqlSession) {

        sqlSession.selectList("MenuMapper.selectAllMenu");
    // menu-mapper.xml파일 MenuMapper에 접근하여 selectAllMenu를 실행시키겠다.
        return sqlSession.selectList("MenuMapper.selectAllMenu");
    }

    public MenuDTO selectMenuByMenuCode(SqlSession sqlSession, int code) {

        // 쿼리문에 return sqlSession.selectOne("MenuMapper.selectMenuByMenuCode", code); 보내줌.
        return sqlSession.selectOne("MenuMapper.selectMenuByMenuCode", code); // (미리 아이디값 설정, ★code★)
        // 이후, menu-mapper.xml에 두 번째 쿼리문 작성
    }

    public int insertNewMenu(SqlSession sqlSession, MenuDTO newMenu) { // 제대로 insert 됐다면 정수값(1)을 반환하기 때문에 int로 변경
        return sqlSession.insert("MenuMapper.insertNewMenu", newMenu);
        // Mapper 파일에 insertNewMenu와 newMenu 전달.
    }

    public int updateMenu(SqlSession sqlSession, MenuDTO modifyMenu) {
        return sqlSession.update("MenuMapper.updateMenu", modifyMenu);
    }

    public int deleteMenu(SqlSession sqlSession, MenuDTO deleteMenu) {
        return  sqlSession.delete("MenuMapper.deleteMenu", deleteMenu);
    }
}
