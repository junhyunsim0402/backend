package day10;

public interface 키보드 {
    // 상수
    public static final String 제조사="인텔";
    String 제조일="2026-02-04";    //public static final 생략가능

    // 추상메소드,public abstract 생략가능
    public abstract void aKey();
    int bKey(int x,int y);
}