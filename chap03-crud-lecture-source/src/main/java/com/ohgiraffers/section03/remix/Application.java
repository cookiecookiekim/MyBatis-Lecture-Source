package com.ohgiraffers.section03.remix;

import com.ohgiraffers.section03.remix.view.MenuView;

public class Application {  //24-10-10 (3교시) xml.config와 java.config의 장점만 사용하는 remix

    public static void main(String[] args) {

       MenuView view = new MenuView();

       view.display();
    }
}
