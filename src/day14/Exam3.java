package day14;

public class Exam3 {
    public static void main(String[] args) {
        // [동기화 VS 비동기화]
        /*
        * [동기화]
        * 1.정의 : 메소드/기능 사용하여 메소드를 점령하는 상태
        * 2.목적 : 서로 다른 여러 스레드가 동시에 하나의 메소드에 사용한다면 충돌이 발생할 수 있음
        * 3.비교
        *   동기화                                      비동기화
        *   처리순서 보장                                처리순서 보장 안됨
        *   주문 순서대로 음료 제조후 손님에게 준다          제조가 먼저 완성된 음료를 손님에게 준다
        * 4.사용법
        * */
        // 1) 계산기 객체 생성
        계산기 계산기=new 계산기();
        // 2) 스레드A
        작업스레드A threadA=new 작업스레드A();
        threadA.계산기=계산기;
        // 3) 스레드B
        작업스레드B threadB=new 작업스레드B();
        threadB.계산기=계산기;
        // 2개의 스레드가 동일한 계산기 객체를 맴버변수로 갖는 예제
        threadA.start();
        threadB.start();
    }
}
class 계산기{
    int memory; // 맴버변수
    public void setMemory(int memory){
        // this란? 현재메소드를 실행한 객체라는 뜻
        // 맴버변수명 와 매개변수명이 같을때 식별용
        this.memory=memory;
        try{
            Thread.sleep(1000);
        }catch (Exception e){}
        System.out.println(Thread.currentThread());
    }
}
class 작업스레드A extends Thread{
    계산기 계산기;
    @Override
    public void run() {
        계산기.setMemory(100);
    }
}
class 작업스레드B extends  Thread{
    계산기 계산기;
    @Override
    public void run() {
        계산기.setMemory(200);
    }
}