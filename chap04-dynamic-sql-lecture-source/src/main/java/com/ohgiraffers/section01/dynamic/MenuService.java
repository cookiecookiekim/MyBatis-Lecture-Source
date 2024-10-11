package com.ohgiraffers.section01.dynamic;

import com.ohgiraffers.common.MenuDTO;
import com.ohgiraffers.common.SearchCriteria;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.ohgiraffers.common.Template.getSqlSession;

public class MenuService {

    private DynamicSqlMapper mapper; // DAO 계층 호출하기 위함

    public void selectMenuByPrice(int price) {
        SqlSession sqlSession = getSqlSession();

        mapper = sqlSession.getMapper(DynamicSqlMapper.class);
        /* comment.
        *   지금 하려고 하는 것은 price를 query문에 전달하여 금액에 따라 적합한 메뉴를 추천해 줄 것이다.
        *   기본 자료형으로는 조건문의 값을 비교할 수 없으며(price는 int 자료형) 인스턴스화를 진행해야 한다.
        *   hashmap을 사용해서 key 값으로 접근하거나 dto를 사용해서 getter 메서드로 접근 해야 한다. */

        // int의 wrapper 클래스 (오토 박싱)
        Map<String, Integer> map = new HashMap<>();
        map.put("price", price);

        // 전달한 값에 해당하는 메뉴들이 조회
        List<MenuDTO> menuList = mapper.selectMenuByPrice(map);
        if (menuList != null && menuList.size() > 0) {
         for (MenuDTO menu : menuList) {
             System.out.println(menu);
            }
         } else {
            System.out.println("검색 결과가 없습니다.");
        }
        sqlSession.close();
    }

    public void searchMenu(SearchCriteria searchCriteria) {
        SqlSession sqlSession = getSqlSession();

        mapper = sqlSession.getMapper(DynamicSqlMapper.class);

        List<MenuDTO> menuList = mapper.searchMenu(searchCriteria); // 이번에는 1번과 다르게 class로 전달한 것
        if (menuList != null && menuList.size() > 0) {
            for (MenuDTO menu : menuList) {
                System.out.println(menu);
            }
        } else {
            System.out.println("검색 결과가 없습니다.");
        }
        sqlSession.close();
    }
}
