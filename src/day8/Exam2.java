package day8;

public class Exam2 {
    public static void main(String[] args) {
        // [1] 싱글톤:프로그램 내 단 하나의 인스턴스(객체) 갖는 설계 구조
        // [2] 싱글톤 생성
        // [3] 다른 클래스에서 싱글톤 호출, 클래스명.getInstance();
        Controller.getInstance();
    }
}
class Controller{   //해당 클래스의 싱글톤 패턴 적용
    private Controller(){}  // 1. 생성자를 private로 다른 클래스에서 호출 못함
    // 2. 단 하나의 객체를 생성하여 상수(staic final)에 저장한다
    private static final Controller singleTon=new Controller();    //
    // 3. 해당 싱글톤(객체)를 다른 클래스에서 간접 사용 (공규)하도록 getter한다
    public static Controller getInstance(){
        return singleTon;   // 2번에서 생성한 싱글톤(객체)를 반환한다.
    }
}