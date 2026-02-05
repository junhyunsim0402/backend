package day11;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exam1 {
    public static void main(String[] args) {
        // [1] 예외 처리:개발자가 구현한 로직이나 사용자의 영향으로 문제
        // -> 시스템오류:시스템이 종료되는 심각한 문제
        // [2] 예외종류
            // 1) 일반예외:컴파일(실행전)될 때 예외 처리 코드 검사
                // 입출력,네트워크,파일,JDBC(DB연동) 등 주로 외부와 통신
            // 2) 실행예외:실행도중 발생하는 예외 처리 코드 검사(개발자 예측/경험 의존도 크다)
                // 연산문제,null,index 등 주로 코드적인 문제,데이터타입 문제
        // [3] 예외처리의 목적
            // 1) 예외 고치는게 아니라 예외가 발생하면 피해서 다른 코드로 이동
            // 즉]24시간 코드실행
        // [4] 사용법
            // try{예외가 발생하거나 발생할것같은 코드}
            // catch(발생한예외클래스명 변수명){만약에 예외 발생했을때 처리할 코드}
            // catch(발생한예외클래스명 변수명){만약에 예외 발생했을때 처리할 코드}
            // finally{예외 여부 상관없이 무조건 실행되는 코드}
        // [5] 주요 예외 클래스
            // 1. ClassNotFoundException:클래스를 못찾았을때 발생하는 예외 클래스
            // 2. InterruptedException : 흐름(스레드)가 중단 되었을때 발생하는 예외 클래스
            // 3. NullPointerException : null일때 (.)접근연산자 사용시 발생하는 예외 클래스
            // 4. NumberFormatException :
            // 5. ArrayIndexOutOfBoundsException :
            // 6. InputMismatchException :
            // 등등 모든 예외 클래스는 Exception 클래스로부터 상속받는다
        // 1) 일반예외 예시1, Class.forName("패키지명.클래스명"):현재 프로젝트내 클래스가 존재하는지 검사/동적할당
        try {
            Class.forName("java.lang.String");  // String 클래스가 존재하는지 확인하는 코드
        } catch (ClassNotFoundException e1) {
            System.out.println("예외발생1:String 클래스없음");
        }
        // 2) 일반예외 예시2,Thred.sleep(밀리초):현재의 흐름(스레드) 일시정지 메소드
        try {
            Thread.sleep(1); //현재 흐름(스레드)1초간 일시정지
        } catch (InterruptedException e2) {
            System.out.println("예외발생2:스레드 중단 발생");;
        }
        // 일반 예외 클래스들은 실행 전에 코드 밑줄에 빨강색으로 예외 발생 가이드라인 해준다
        // 3) 실행예외 예시3
        try {
            String name = null;
            System.out.println(name.length()); // .(접근.도트)연산자는 객체가 존재해야만 가능
        }catch (NullPointerException error){
            System.out.println("예외발생3:null은 메소드를 호출 불가능");
        }
        // 4) 실행예외 예시4
        String str1="100";
        String str2="1abc";
        Integer.parseInt(str1); //Integer.parseInt(문자열):문자열->정수형태로 변환
        try {
            int int2 = Integer.parseInt(str2);//NumberFormatException: "1abc"를 숫자로 표현 불가능
        }catch (NumberFormatException n){
            System.out.println("에외발생4:바꿀수없다");
        }
        // 5) 실행예외 예시5, ArrayIndexOutOfBoundsException
        int[] ary={1,2,3};
        try {
            System.out.println(ary[2]);
            System.out.println(ary[3]);
        }catch (ArrayIndexOutOfBoundsException a){
            System.out.println("예외발생5:존재하지않은 인덱스입니다.");
        }
        // 6) 실행예외 예시6
        try {
            Scanner sc = new Scanner(System.in);
            int value = sc.nextInt(); // 만약 비정상적인 입력값이면 예외 발생
        }catch (InputMismatchException input){
            System.out.println("예외발생6:입력할수없는 정보입니다."+input);
        }
        // 7) 예외는 다양한 이유로 발생한다.예외 중에 상위(부모)클래스가 존재한다 Exception 크래스
        try{

        }catch (NumberFormatException n2){
            System.out.println(n2);
        }catch (NullPointerException n1){
            System.out.println(n1);
        }catch (Exception e){   //모든 예외에 대해 처리해주는 상위 클래스,문제점:세부적인 예외처리 불가능,가장 마지막에 사용한다
            System.out.println(e);
        }finally {
            System.out.println("예외가 발생 여부 상관없이 무조건 싱행되는 구역");
        }
    }
}
