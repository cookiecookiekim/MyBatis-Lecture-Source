package com.ohgiraffers.section01.dynamic;

import com.ohgiraffers.common.MenuDTO;
import com.ohgiraffers.common.SearchCriteria;

import java.util.List;
import java.util.Map;

public interface DynamicSqlMapper {

    List<MenuDTO> ifSelectMaxPrice(Map<String, Integer> map);

    List<MenuDTO> ifSelectNameCategory(SearchCriteria searchCriteria);

    List<MenuDTO> chooseSupCategory(SearchCriteria searchCriteria);

}
