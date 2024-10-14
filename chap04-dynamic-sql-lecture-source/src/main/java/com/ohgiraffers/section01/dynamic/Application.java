package com.ohgiraffers.section01.dynamic;

import com.ohgiraffers.common.SearchCriteria;

import java.util.*;

public class Application { // 24-10-11 (화) 2교시 // 동적 SQL 학습 // 24-10-14 (월) 1교시 foreach

    public static void main(String[] args) {

        /* title. MyBatis Dynamic SQL 확인하기 */
        // 이번에는 DAO, DTO 딱히 구분하지 않겠다. (시간 오래 걸리므로)

        Scanner sc = new Scanner(System.in);

        do {

            System.out.println("===== 마이바티스 동적 SQL 학습 메뉴 =====");
            System.out.println("1. if 확인하기 ");
            System.out.println("2. choose(when, otherwise) 확인하기 ");
            System.out.println("3. foreach 확인하기 ");
            System.out.println("4. trim(where, set) 확인하기 ");
            System.out.println("9. 종료하기 ");
            System.out.print("메뉴를 선택해 주세요 :  ");
            int no = sc.nextInt();

            switch (no) {
                case 1 :
                    ifsubMenu(); break;
                case 2 :
                    chooseSubMenu(); break;
                case 3 :
                    foreachSubMenu(); break;  // 24-10-14 (월) 1교시
                case 4 :
                    trimSubMenu(); break;
                case 9 :
                    System.out.println("프로그램 종료"); break;
            }

        } while (true);
    }


    private static void ifsubMenu() {
        Scanner sc = new Scanner(System.in);
        MenuService menuService = new MenuService();
        do {
            System.out.println("============ if 서브 메뉴 ============");
            System.out.println("1. 원하는 금액 대 적합한 추천 메뉴 목록 보여주기");
            System.out.println("2. 메뉴 이름 or 카테고리 명으로 검색해서 메뉴 목록 보여주기");
            System.out.println("9. 이전 메뉴로");
            System.out.print("원하는 메뉴를 선택해 주세요 : ");
            int no = sc.nextInt();

            switch (no) {
                case 1 :
                    menuService.selectMenuByPrice(inputPrice()); break;
                case 2 :
                    menuService.searchMenu(inputSearchCriteria()); break;
                case 9 :
                    System.out.println("if 서브메뉴 종료"); return; // 자신을 호출한 app로 돌아감.
            }
        } while (true);
    }

    private static int inputPrice () {
        Scanner sc = new Scanner(System.in);
        System.out.print("검색하실 가격의 최대 금액을 입력해 주세요 : ");
        int price = sc.nextInt();

        return price;
    }

    private static SearchCriteria inputSearchCriteria () { // class(DTO) 형태로 넘겨 줘보자.
        Scanner sc = new Scanner(System.in);
        System.out.print("검색 기준을 선택해 주세요 (menuName or category) : ");
        String condition = sc.nextLine();
        System.out.print("검색어를 임력해 주세요 : ");
        String value = sc.nextLine();

        return new SearchCriteria(condition , value); // 매개변수가 있는 생성자를 통한 초기화.
    }

    private static void chooseSubMenu () {
        Scanner sc = new Scanner(System.in);
        MenuService menuService = new MenuService();

        do {
            System.out.println("============ choose 서브 메뉴 ============");
            System.out.println("1. 카테고리 상위 분류열 메뉴 보여주기 (식사, 음료 디저트)");
            System.out.println("9. 이전 메뉴로 돌아가기");
            System.out.print("메뉴 번호를 입력해 주세요 : ");
            int no = sc.nextInt();

            switch (no) {
                case 1 : menuService.searchMenuBySupCategory(inputSupCategory()); break; // 상위니까 super
                case 9 : return;
            }
        } while (true);

    }

    public static SearchCriteria inputSupCategory () {
        Scanner sc = new Scanner(System.in);
        System.out.print("상위 분류를 입력해 주세요(식사, 음료, 디저트) : ");
        String value = sc.nextLine();

        return new SearchCriteria("category" , value); // 검색조건을 category로 고정
    }

    private static void foreachSubMenu () {
        Scanner sc = new Scanner(System.in);
        MenuService menuService = new MenuService();

        do {
            System.out.println("=================== foreach 서브 메뉴 ===================");
            System.out.println("1. 랜덤한 메뉴 5개 추출해서 조회하기");
            System.out.println("9. 이전 메뉴로 돌아가기");
            System.out.print("원하시는 메뉴를 선택해 주세요 : ");
            int no = sc.nextInt();

            switch (no) {
                case 1 : menuService.searchMenuByRandomCode(createRandomCodeList()); break;
                case 9 : return;
            }
        } while (true);

    }

    private static List<Integer> createRandomCodeList() {
        // 5개의 중복되지 않는 메뉴코드 생성 (내 DB에 행이 총 몇개 있는지 확인) (범위 지정해야 하므로)
        Set<Integer> set = new HashSet<>(); // 중복 허용하지 않는 컬렉션 Set 사용
        while (set.size() < 5) { // 반복문으로 set에 값을 넣어주기
            int temp = ((int)(Math.random() * 31)) + 1; // 총 행의 개수 31개와 시작값 1 지정
            set.add(temp); // 한 번의 반복문 종료 시에 set에 temp를 집어 넣겠다.
            System.out.println(temp); // 확인용
        }

        List<Integer> menuCodeList = new ArrayList<>(set);
        Collections.sort(menuCodeList); // 복습 차원에서 정렬 진행

        return menuCodeList;
    }

    private static void trimSubMenu () {
        Scanner sc = new Scanner(System.in);
        MenuService menuService = new MenuService();

        do {
            System.out.println("================ trim 서브 메뉴 ================");
            System.out.println("1. 검색 조건이 있는 경우 메뉴 코드로 조회, 단 없으면 전체 조회");
            System.out.println("2. 메뉴 혹은 카테고리 코드로 검색, 단 메뉴와 카테고리 둘 다 일치하는 경우도 검색, 검색 조거 없으면 전체 검색");
            System.out.println("3. 원하는 메뉴 정보만 수정하기");
            System.out.println("9. 이전 메뉴로 돌아가기");
            System.out.print("원하시는 메뉴를 선택해 주세요 : ");
            int no = sc.nextInt();

            switch (no) {
                case 1 : menuService.searchMenuByCodeOrSearchAll(inputAllOrOne()); break;
                case 2 : break;
                case 3 : break;
                case 9 : return;
            }
        } while (true);
    }

    private static SearchCriteria inputAllOrOne () {
        // condition → 검색 조건 // value → 값
        Scanner sc = new Scanner(System.in);
        System.out.print("검색 조건을 입력하시겠습니까? (예 or 아니오) : ");
        boolean hasSearchValue = "예".equals(sc.nextLine()) ? true : false; // 예, 아니오 두가지니까 boolean으로 활용해보기

        SearchCriteria searchCriteria = new SearchCriteria();
        // "예"라고 입력 했을 때 동작할 구문
        if (hasSearchValue) {
            System.out.print("검색할 메뉴 코드를 입력해 주세요 : ");
            String code = sc.nextLine();
            searchCriteria.setCondition("menuCode");
            searchCriteria.setValue(code);
        }
        return searchCriteria;
    }
}







