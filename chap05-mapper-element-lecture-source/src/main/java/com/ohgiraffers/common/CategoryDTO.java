package com.ohgiraffers.common;

public class CategoryDTO {
    private int code;
    private String name;
    private Integer refCategoryCode; // DB상에 refCategoryCode가 null 허용이므로 Integer로 지정
    // int(기본 자료형)의 초기값은 0이고 Integer(참조 자료형)의 초기값은 null임을 기억하기.

    public CategoryDTO() {}

    public CategoryDTO(int code, String name, Integer refCategoryCode) {
        this.code = code;
        this.name = name;
        this.refCategoryCode = refCategoryCode;
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

    @Override
    public String toString() {
        return "CategoryDTO{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", refCategoryCode=" + refCategoryCode +
                '}';
    }
}
