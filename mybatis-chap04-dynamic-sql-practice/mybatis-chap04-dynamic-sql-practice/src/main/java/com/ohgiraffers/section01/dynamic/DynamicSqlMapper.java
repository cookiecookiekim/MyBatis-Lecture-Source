package com.ohgiraffers.section01.dynamic;

import com.ohgiraffers.common.MenuDTO;
import com.ohgiraffers.common.SearchCriteria;

import java.util.List;
import java.util.Map;

public interface DynamicSqlMapper {

    List<MenuDTO> ifSelectMaxPrice(Map<String, Integer> map);

    List<MenuDTO> ifSelectNameCategory(SearchCriteria searchCriteria);

    List<MenuDTO> chooseSupCategory(SearchCriteria searchCriteria);

    List<MenuDTO> foreachSelectMapper(Map<String, List<Integer>> map);

    List<MenuDTO> searchMenuCode(SearchCriteria searchCriteria);

    List<MenuDTO> searchNameCategoryBoth(Map<String, Object> map);

    int modifiWantChangeInfo(Map<String, Object> map);
}
