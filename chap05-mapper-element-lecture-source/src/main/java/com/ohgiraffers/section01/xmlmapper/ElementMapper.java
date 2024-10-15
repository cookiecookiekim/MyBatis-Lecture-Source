package com.ohgiraffers.section01.xmlmapper;

import java.util.List;

public interface ElementMapper {


    List<String> selectCacheTest(); // 반환값이 String인데 여러 행이기 때문에 List이다.
                                    // where 조건에 하나만 반환한다면 그냥 String도 가능하다. (이해)


}
