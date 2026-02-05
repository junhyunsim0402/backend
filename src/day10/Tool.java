package day10;

public class Tool implements TestInterface{
    // TestInterface을 구현(implements)함 <--- 오버라이딩한다
    @Override public void method1(){
        System.out.println("해당 메소드 구현");
    }
    @Override
    public void method2(int x) {
        System.out.println("해당 메소드 구현:"+x);
    }
}
