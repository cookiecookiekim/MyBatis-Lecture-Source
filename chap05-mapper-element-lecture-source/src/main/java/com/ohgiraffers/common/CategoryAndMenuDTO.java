package com.ohgiraffers.common;

import java.util.List;

public class CategoryAndMenuDTO { // 24-10-15 (화) 5교시 카테고리 기준 DTO

    private int code;
    private String name;
    private Integer refCategoryCode;
    private List<MenuDTO> menuList;
    // ex 카테고리 번호가 1번인 경우, 메뉴가 여러가지 담김. → 1:N 이므로 List로 담아야 한다.

    public CategoryAndMenuDTO() {}

    public CategoryAndMenuDTO(int code, String name, Integer refCategoryCode, List<MenuDTO> menuList) {
        this.code = code;
        this.name = name;
        this.refCategoryCode = refCategoryCode;
        this.menuList = menuList;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRefCategoryCode() {
        return refCategoryCode;
    }

    public void setRefCategoryCode(Integer refCategoryCode) {
        this.refCategoryCode = refCategoryCode;
    }

    public List<MenuDTO> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<MenuDTO> menuList) {
        this.menuList = menuList;
    }

    @Override
    public String toString() {
        return "CategoryAndMenuDTO{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", refCategoryCode=" + refCategoryCode +
                ", menuList=" + menuList +
                '}';
    }
}
