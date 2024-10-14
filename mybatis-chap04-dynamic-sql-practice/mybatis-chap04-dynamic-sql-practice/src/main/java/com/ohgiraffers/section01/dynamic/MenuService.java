package com.ohgiraffers.section01.dynamic;

import com.ohgiraffers.common.MenuDTO;
import com.ohgiraffers.common.SearchCriteria;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static com.ohgiraffers.common.Template.getSqlSession;

public class MenuService {

    private DynamicSqlMapper mapper;
    PrintResult printResult = new PrintResult();

    public void ifMaxPrice(Map<String , Integer> map) {
        SqlSession sqlSession = getSqlSession();

        mapper = sqlSession.getMapper(DynamicSqlMapper.class);
        List<MenuDTO> menuList = mapper.ifSelectMaxPrice(map);
        if (menuList != null && menuList.size() > 0) {
            printResult.ifMaxPriceSelect(menuList);
        } else {
            printResult.errorCode("errorMaxPriceSelect");
        }

        sqlSession.close();
    }

    public void serviceIfNameCategory(SearchCriteria searchCriteria) {
        SqlSession sqlSession = getSqlSession();

        mapper = sqlSession.getMapper(DynamicSqlMapper.class);

        List<MenuDTO> menuList = mapper.ifSelectNameCategory(searchCriteria);

        if (menuList != null && menuList.size() > 0) {
            printResult.ifNameCategorySelect(menuList);
        } else {
            printResult.errorCode("errorNameCategorySelect");
        }

        sqlSession.close();
    }

    public List<MenuDTO> chooseSupMenu(SearchCriteria searchCriteria) {
        SqlSession sqlSession = getSqlSession();

        mapper = sqlSession.getMapper(DynamicSqlMapper.class);

        List<MenuDTO> menuList = mapper.chooseSupCategory(searchCriteria);

        sqlSession.close();
        return menuList;
    }

    public void foreachSelect(Map<String, List<Integer>> map) {
        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(DynamicSqlMapper.class);
        List<MenuDTO> menuList = mapper.foreachSelectMapper(map);
        if (menuList != null && menuList.size() > 0) {
            printResult.foreachShowResult(menuList);
        } else {
            printResult.errorCode("errorForeachSelect");
        }
        sqlSession.close();
    }

    public void searchMenuCode(SearchCriteria searchCriteria) {
        SqlSession sqlSession = getSqlSession();

        mapper = sqlSession.getMapper(DynamicSqlMapper.class);
        System.out.println("확인 1");
        List<MenuDTO> menuList = mapper.searchMenuCode(searchCriteria);
        System.out.println("확인 2");
        if (menuList != null && menuList.size() > 0) {
            printResult.searchMenuCode(menuList);
        } else {
            printResult.errorCode("errorSearchMenuCode");
        }

        sqlSession.close();
    }

    public void searchNameCategoryBoth(Map<String, Object> map) {
        SqlSession sqlSession = getSqlSession();

        mapper = sqlSession.getMapper(DynamicSqlMapper.class);

        List<MenuDTO> menuList = mapper.searchNameCategoryBoth(map);

        if (menuList != null && menuList.size() > 0) {
            printResult.showSearchNameCategoryBoth(menuList);
        } else {
            printResult.errorCode("errorSearchBoth");
        }

        sqlSession.close();
    }
}














