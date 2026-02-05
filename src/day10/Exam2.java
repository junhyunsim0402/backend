package day10;

public class Exam2 {
    public static void main(String[] args) {
        // [1] 인터페이스 객체 생성 불가능
        // new 키보드() //인터페이스타입은 생성자가 없다
        // [2] 인터페이스 타입의 변수 선언
        키보드 myKeyBoard;
            // myKeyBoard.aKey(); //추상메소드는 실행안됨(구현 안해서)
        // [3] 추상메소드 구현=클래스에서 오버라이딩
        // [4] 구현(객)체 만들기:해당 인터페이스 구현한 클래스로 객체 생성
        myKeyBoard=new 격투게임(); // <--키보드에 격투게임 연결
        myKeyBoard.aKey();
        myKeyBoard.bKey(10,5);

        // [5] 다형성 - 게임 교체
        System.out.println("=======게임교체========");
        myKeyBoard=new 축구게임();
        myKeyBoard.aKey();
        myKeyBoard.bKey(3,2);

        //구현체없이 자체적으로 구현 == 인명 구현체
        // new 인터페이스명(){오버라이딩}
        myKeyBoard=new 키보드() {
            @Override
            public void aKey() {System.out.println("[밥먹기]");}
            @Override
            public int bKey(int x, int y) {System.out.println("[공부]");return 0;}
        };
        myKeyBoard.aKey();
        myKeyBoard.bKey(3,4);
    }
}
class 격투게임 implements 키보드{
    // implements이란?해당 인터페이스내 추상 메소드 구현
    @Override
    public void aKey() {System.out.println("[공격]");}

    @Override
    public int bKey(int x, int y) {System.out.println("[방어]");return x+y;}
}
class 축구게임 implements 키보드{
    // 구현체는 오버라이딩 필수
    @Override
    public void aKey() {System.out.println("[슈팅]");}
    @Override
    public int bKey(int x, int y) {System.out.println("[태클]");return x+y;}
}