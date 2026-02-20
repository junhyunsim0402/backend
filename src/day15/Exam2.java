package day15;

import java.util.*;

public class Exam2 {
    public static void main(String[] args) {
        // [1] 컬렉션(수집) 프레임(틀) 워크(일)
        // 1. 정의 : 자료들을 수집/저장 하는 방법들을 미리 만들어둔 인터페이스/클래스
        // 2. 목적 : 복잡한 자료구조를 제공받아 편리한 데이터 관리
            // 자료구조란? 컴퓨터가 자료들을 효율적으로 저장하는 방법/구조
        // 3. 종류 : 인터페이스란? 서로다른 클래스/타입 들을 기능 통합
        /*  인터페이스           구현체
        *   List        ->      ArrayList, Vector, LinkedList, Stack 등
        *   Set         ->      HashSet, TreeSet등
        *   Map         ->      HashMap, HashTable, TreeMap 등
        * */

        // [2] List 타입
        ArrayList<String> list1=new ArrayList<>();
        List<String> list2=new ArrayList<>();

        // List 주요 메소드
        // 1) .add() : 추가
        list2.add("유재석");
        list2.add("유재석");   // 중복허용
        list2.add(0,"강호동"); // 특정 인덱스에다가 추가 가능
        System.out.println("list2 = " + list2);
        // 2) .set  : 수정
        list2.set(0,"강호동2");
        System.out.println("list2 = " + list2);
        // 3) .get : 호출
        System.out.println("list2.get(1) = " + list2.get(1));
        // 4) .size : 개수
        System.out.println("list2.size() = " + list2.size());
        // 5) .contains
        boolean result1=list2.contains("강호동2");
        int result2=list2.indexOf("강호동2");
        // 6) .remove
        list2.remove("강호동2");
        System.out.println("result2 = " + list2);
        // 7) .isEmpty() : 비어있는지 확인
        System.out.println("list2.isEmpty() = " + list2.isEmpty()); //false
        // 8) .clear() : 삭제
        // list2.clear();

        // List 타입과 반복문
        // 1) 일반 for문
        for(int i=0;i<list2.size();i++){
            System.out.println(list2.get(i));
        }
        // 2) 향상된 for문 : 인덱스활용은 못함
        for(String str:list2){
            System.out.println(str);
        }
        // 3) ** forEach 문 (실무) **
        // 변수명.forEach((반복변수명)->{실행문;});
        list2.forEach((str)->{
            System.out.println("str = " + str);
        });
        // List 구현체들, 구현체란?인터페이스의 추상메소드를 구현(오버라이딩)한 클래스/객체
        List<Integer> list; // 인터페이스 타입
        // 공통 : 여러 요소(값)들을 순서대로(인덱스) 저장하는 구조
        list=new ArrayList<>();     // + 싱글스레드 사용, 비동기화 메소드
        list.add(0,50);
        // ArrayList는 중간 삽입/삭제 시 다른 데이터들의 이동 발생
            // 중간 삽입/삭제 느리다, 뒤에 추가 빠르다
                        // VS
        // LinkedList는 중간 삽입/삭제 시 다른 데이터들의 이동 발생X
            // 중간 삽입/삭제 빠르다, 뒤에 추가 느리다
        list=new LinkedList<>();    // + 싱글스레드 사용, +<링크>구조
        list.add(0,100);    // 0번 인덱스에 100 대입

        list=new Vector<>();        // + 멀티스레드 사용, 동기화 메소드

        list=new Stack<>();
        Stack<String> stack=new Stack<>();
        stack.push("유재석");stack.push("강호동");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        // Stack 스택 자료 구조란?LIFO(Last in First Out)
    }
}
