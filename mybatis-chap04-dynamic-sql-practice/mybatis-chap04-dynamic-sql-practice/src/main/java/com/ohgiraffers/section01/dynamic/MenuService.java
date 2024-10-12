package com.ohgiraffers.section01.dynamic;

import com.ohgiraffers.common.MenuDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.ohgiraffers.common.Template.getSqlSession;

public class MenuService {

    private DynamicSqlMapper mapper;

    public void selectMenuByPrice (int price) {
        SqlSession sqlSession = getSqlSession();

        mapper = sqlSession.getMapper(DynamicSqlMapper.class);

        Map<String, Integer> result = new HashMap<>();
        result.put("price", price);

        List<MenuDTO> menuList = mapper.ifSelect(result);
        if (menuList != null && menuList.size() > 0) {
            for (MenuDTO list : menuList) {
                System.out.println(list);
            }
        }

        sqlSession.close();
    }

}







