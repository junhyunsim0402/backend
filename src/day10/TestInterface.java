package day10;

public interface TestInterface {
    // 맴버변수 불가능
    //int a;
    public static final int b=10;   //상수는 가능
    // 생성자 불가능
    // 추상메소드:메소드 선언만 존재,{}구현부 없는
    public abstract void method1();
    void method2(int x);    //public abstract 생략가능
}