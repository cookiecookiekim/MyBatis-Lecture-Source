package com.ohgiraffers.section01.dynamic;

import com.ohgiraffers.common.MenuDTO;

import java.util.List;

public interface DynamicSqlMapper {


    List<MenuDTO> daoIfSelect(int result);

}
