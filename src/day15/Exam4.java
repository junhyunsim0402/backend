package day15;

import java.util.*;

public class Exam4 {
    public static void main(String[] args) {
        // [3] Map인터페이스, 저장된 순서(인덱스) 없이 key와 value로 entry(한 쌍)을 저장하는 구조
        // Map<KeyType, ValueType>
        Map<String,Integer> map1=new HashMap<>();
        // 주요 메소드
        // 1) .put(key,value) : 엔트리(key : value) 추가, key 중복 불가능, value 중복 가능
        map1.put("유재석",95);map1.put("강호동",90);map1.put("강호동",45);
        System.out.println("map1 = " + map1);
        // 2) .get(key) : 특정한 key의 값을 반환
        System.out.println("map1.get(\"강호동\") = " + map1.get("강호동"));
        // 3) .size() : 전체 엔트리 개수 반환
        System.out.println("map1.size() = " + map1.size());
        // 4) .containsKey(찾을 키), .containsValue(찾을 값) 존재하면 true
        boolean re1= map1.containsKey("유재석");
        boolean re2= map1.containsValue("50");
        // 5) .remove(key) : 틀정한 키가 존재하면 삭제
        map1.remove("유재석");
        // 6) .clear() : 전체 엔트리 삭제
        // map1.clear();
        // 7) .isEmpty() : 엔트리가 하나도 없으면 true
        boolean re3=map1.isEmpty();
        // 8) .entrySet() : 모든 엔트리를 집합(SET)으로 반환,
                // .keySet() : 모든 키를 집합으로 반환, .values() : 모든 값 들을 컬렉션으로 반환
        Set<Map.Entry<String,Integer>> set=map1.entrySet();
        Set<String> keys=map1.keySet();
        Collection<Integer> values=map1.values();

        // ============================================ //
        // Map타입과 반복문 관계
        // 1. 일반 for문 불가능
        // 2. 향상된 for문
        for(String key:map1.keySet()){
            System.out.println(map1.get(key));
        }
        // 3. forEach 문
        map1.keySet().forEach((key)->{
            System.out.println(map1.get(key));
        });
        // 활용처 : JSON/XML 호환용, 비정형(규칙없는) 데이터, DTO 호환 등등

        // ============================================ //
        // MAP 구현체
        Map<String,Object> map;
        map=new HashMap<>();    // * 싱글스레드
        map=new Hashtable<>();  // * 멀티 스레드
        map=new TreeMap<>();    // * 이진 트리(정렬)
        Properties properties=new Properties(); // Map구현체는 아니지만 Map구조 + 프로젝트 설정값 파일


    }
}
