package day7;

import day7.package1.A;

public class Exam2 {
    public static void main(String[] args) {
        // [1]접근제한자:클래스,맴버변수,메소드 등등 호출 제한
        // [2] 종류
            // public:공개 , 프로젝트내 어디서든 호출 가능
            // private: 비공개 , 현재 클래스에서만 호출 가능
            // default : 같은/하위 패키지 에서만 호출 가능, 접근제한자가 없을 경우 자동
            // protected : 같은/하위 패키지 에서만 호출 가능, 상속 관계 예외
        // [3] 사용법 :
            // 1) private/default class 클래스명{}          : 클래스 키워드 앞에서 작성
            // 2) 접근제한자 타입 맴버변수;                   : 맴버변수 타입 앞에서 작성
            // 3) 접근제한자 반환타입 메소드명(){}             : 반환 타입 앞에서 작성
            // 4) 접근제한자 생성자명(){}                    : 생성자명 앞에서 작성

        // [4] day7폴더 내 package1
        // ==== 다른 클래스 : 접근 제한자 의미 유 ====
        A a=new A();
        System.out.println("a.공개변수 = " + a.공개변수);
//        System.out.println("a.비공개변수 = " + a.비공개변수);//error
//        System.out.println(".일반변수 = " +a.일반변수);//error
        a.메소드();
//        a.비공개메소드(); error

        // [5] import : 다른 패키지의 클래스 호출
        // 자동완성시 자동으로 최상단에 import day7.package1.A;
        // ->day7폴더내 'A' 클래스를 가져온다
        // import java.util.Scanner;
        // ->java폴더내 util폴더내 Scanner를 가져온다
        // java.lang패키지는 import 생략

    }
}
