package day01;

public class Exam2 {
    //public class:공개용 클래스 선언하는 뜻을 갖는 키워드
    //Exam2:임의의 클래스명 정의한다:첫글자 대문자

    //[1]m+enter:main함수
    //자바에서 최초로 실행 흐름(스레드)를 갖는 (미리 만들어진 함수)
    public static void main(String[] args) {
        System.out.println(3);//JS의 출력과 같은 것
        System.out.print("유");
        System.out.print("재");
        System.out.println("석");
        String a="유재석";
        for (int i=0;i<a.length();i++){
            System.out.print(i);
        }
        //[3]자료형/타입(분류):자료들을 효율적으로 사용하기 위한 분류방법
        //바이트란?bit(0혹은 1) --->01010101(8bit/bit 8개)1바이트->1024byte
        //정수:byte(1b,-128~127),short(2b,+-3만),int(4b,+-21억) long(8b,+-21억이상)
        //실수:float(4b,소수점8자리),double(8b,소수점17자리)
        //문자:char(2b,`작은따음표 감싼)
        //논리:boolean(1b,true/false)
        //문자열:String(문자열클래스)
        boolean bool1=false;
        boolean bool2=true;
        System.out.println(bool1);

        //2.char
        char ch1='a';

        // 3. String
        String str1="abc";
        System.out.println(str1);

        //4. byte:
        byte b1=100;
        //오류 byte b2=300;

        //5.short
        short s1=10000;
        //오류 short s2=40000;

        //6.int:정수의 리터럴 기본타입, 즉]키보드로부터 입력받은 값들은 int타입
        int i1=1000000000;

        //7.long:리터럴 뒤에 L/l를 붙임
        long l1=30000000L;//입력받은 값이 int라 오류가 30억의 단위를 받아들일수 없음

        //8. double:실수의 기본타입
        double d1=0.123214412;

        //9.float:리터럴 뒤에 F/f 붙임
        float f1=0.12345678F;
        System.out.println(f1);
        //소수점 오차가 생기거나 표현 한계로 실무에서는 String or DigDecial사용


    }
}
/*
---코드 작성---         ---코드 실행---
 JS:console.log()       브라우저
 JAVA:print()           main
 */