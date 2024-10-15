package com.ohgiraffers.section01.xmlmapper;

import java.util.Scanner;

public class Application { // 24-10-15 (화) 1교시 - view, controller는 건너뛰고 진행
                            // mapper 파일에서 사용하는 element에 대해서
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ElementService elementService = new ElementService();

        do {
            System.out.println("================== Mapper Element 테스트 메뉴 ==================");
            System.out.println("1. <cache> 테스트");
            System.out.println("2. <resultMap> 서브 메뉴");
            System.out.println("3. <sql> 테스트");
            System.out.println("4. <insert> 서브 메뉴");
            System.out.print("원하시는 메뉴를 골라주세요 : ");
            int no = sc.nextInt();

            switch (no) {
                case 1 : elementService.selectCacheTest(); break;
//                case 2 : asdada(); break;
//                case 3 : asdada(); break;
//                case 4 : asdada(); break;
            }
        } while (true);

    }
}
