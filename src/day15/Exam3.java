package day15;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Exam3 {
    public static void main(String[] args) {
        // [2] Set 인터페이스, 순서(인데스) 없는 저장 -> 중복 불가능
        Set<String> set1=new HashSet<>();
        // Set 주요 메소드
        // 1) .add(새로운값) : 요소 추가
        set1.add("유재석");
        set1.add("유재석");    // 중복 불가능
        set1.add("강호동");
        System.out.println("set1 = " + set1);   // [유재석,강호동]
        // * 인덱스가 없으므로 .set(), .get(), .indexOf() 불가능
        // 2) .size() : 전체 요소 개수
        System.out.println("set1.size() = " + set1.size());
        // 3) .contains(찾을값) : 찾을 값이 존재하면 true
        boolean result1=set1.contains("유재석");
        // 4) .remove(삭제할 값) : 삭제
        set1.remove("유재석");
        // 5) .isEmpty : 요소가 한개도 없으면 true
        System.out.println("set1.isEmpty() = " + set1.isEmpty());
        // 6) .clear : 모든요소 삭제
        // set1.clear();
        // 7) .iterator() : 집합(SET)내 순서없는 요소들을 반복할 수 있도록 인터페이스 반환
        Iterator<String> iterator=set1.iterator();
        while (iterator.hasNext()) {  // .hasNext : 다음 요소가 존재하면 이동
            System.out.println(iterator.next());
        }

        // ======================================================== //
        // 집합(SET) 과 for문 관계
        // 1) 일반 for문 불가능
        // 2) 향상된 for문
        for(String str:set1) {System.out.println(str);}
        // 3) forEach
        set1.forEach((str)-> System.out.println(str));

        // 활용처 : JDBC(ResultSet)


        // ========================================================= //
        // Set 인터페이스
        Set<Integer> set2;
        set2=new HashSet<>();

        TreeSet<Integer> set=new TreeSet<>();
        set.add(50);set.add(30);set.add(45);
        System.out.println("set = " + set);
        // 이진트리 란? 각각의 노드(값)이 최대 2개의 노드(값) 연결 하는 구조
        // 작은값이 추가되면 왼쪽노드에 생성, 큰 값이 추가되면 오른쪽 노드에 추가 구조
        // 기본값은 오름차순, .descendingSet() 내림차순
        System.out.println(set.descendingSet());
        // 활용처 : 검색(검색 최적화)
    }
}
