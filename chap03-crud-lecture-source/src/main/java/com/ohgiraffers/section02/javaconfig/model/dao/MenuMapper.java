package com.ohgiraffers.section02.javaconfig.model.dao;

import com.ohgiraffers.section02.javaconfig.model.dto.MenuDTO;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MenuMapper { // 24-10-10 (목) 1교시, xml 파일 방식으로 하는 게 아니니,
                              // xml파일에 작성하던 쿼리문을 MenuMapper 인터페이스에 작성할 목적. (
                               // → 그러려면 mybatis에서 이 인터페이스 파일을 인식해야함 (등록 필요)
                              // Template 클래스에 configuration.addMapper(MenuMapper.class); 확인

    @Results(id = "menuResultMap", value = { // DTO파일과 매칭시키는 과정 → xml에 했던 resultmap 과정
            @Result(id = true, property = "menuCode", column = "MENU_CODE")
            ,@Result(property = "menuName", column = "MENU_NAME")
            ,@Result(property = "menuPrice", column = "MENU_PRICE")
            ,@Result(property = "categoryCode", column = "CATEGORY_CODE")
            ,@Result(property = "orderableStatus", column = "ORDERABLE_STATUS")
    })

    @Select("SELECT " + // 상당히 불편함.
            " MENU_CODE\n" +
            ", MENU_NAME\n" +
            ", MENU_PRICE\n" +
            ", CATEGORY_CODE\n" +
            ", ORDERABLE_STATUS\n" +
            "FROM TBL_MENU\n" +
            "WHERE ORDERABLE_STATUS = 'Y'\n" +
            "ORDER BY MENU_CODE")

//    @ResultMap("menuResultMap") // 위에있는 "menuResultMap"을 사용하겠다.

    // → 자바 방식은 위와 같은 방식으로 사용하는데 상당히 불편하므로 거의 안 쓴다.

    List<MenuDTO> selectAllMenu(); // [쿼리문만 아니라면] 훨씬 간단하긴 하다.
    // xml 방식이라면 이 한 줄이 DAO에 3줄이다.(return 포함)

    // → section03 remix 파일은 자바 형식과 xml 형식의 장점만 모아놓고 해볼 예정이다.
}
