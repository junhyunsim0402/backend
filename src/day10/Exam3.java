package day10;

public class Exam3 {
    public static void main(String[] args) {
        // [1] 구현체
        Buy buy=new Customer();
        buy.method1();
        //  buy.method6();  //형제끼리는 불가능
        Customer customer=(Customer)buy;
        Sell sell1=customer;
        sell1.method6();

        // [2] 디폴트 메소드 실행 가능
        buy.method2(2);

        // [3] static(정적)메소드 실행 가능
        Buy.method3();

        // [4] private 메소드 호출 불가능
        //Buy.method4(); // error
        // Buy.method5(); // error
    }
}
interface Buy{
    // 1)추상메소드:선언부만 있고 구현부{}가 없는 메소드,*구현체가 구현할 대상*
    public abstract void method1();
    // 2) 디폴트메소드:인터페이스가 구현한 메소드
    public default int method2(int x){return x;}
    // 3) 정적메소드:인터페이스내 정적 구현 메소드,구현체없이 실행 가능
    public static void method3(){System.out.println("정적구현메소드");}
    // 4) private 메소드:현재 인터페이스 내에서만 사용하는 메소드(오버라이딩 못함)
    private void method4(){}
    private static void method5(){}
}
interface Sell{void method6();}

class Customer extends Object implements Buy,Sell{  //상속은 1번,구현은 여러개인터페이스
    // extends은 오버라이딩(선택!), implements는 오버라이딩 (필수!)
    // 오른쪽클릭 -> 생성 -> 메소드 재정의
    @Override public void method6() {System.out.println("[판매]");}
    @Override public void method1() {System.out.println("[구매]");}
}
