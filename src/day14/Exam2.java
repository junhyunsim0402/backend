package day14;
import java.time.LocalTime;
import java.util.Scanner;

public class Exam2 {
    public static void main(String[] args) {
        // [시계 만들기]
        시계스래드 시계스래드=new 시계스래드();
        Thread thread=new Thread(시계스래드);
        thread.start();
        // [타이머 Thread 만들기]
        타이머스레드 타이머스레드=new 타이머스레드();
        타이머스레드.start();
        // [Main Thread 입력]
        for(;;){
            System.out.println("타이머: 1) ON 2)OFF");
            Scanner sc=new Scanner(System.in);
            int ch=sc.nextInt();
            if(ch==1){
                타이머스레드=new 타이머스레드();
                타이머스레드.state=true;
                타이머스레드.start();
            }
            else if(ch==2){}
        }
    }
}
class 시계스래드 implements Runnable{
    @Override
    public void run() {
        for(;;){
            System.out.println(LocalTime.now());
            // main스레드가 아닌 현재 작업스레드 1초 일시정지
            try{Thread.sleep(1000);}
            catch (Exception e){}
        }
    }
}
class 타이머스레드 extends Thread{
    boolean state=false;
    @Override
    public void run() {
        int second=0;   // 타이머가 계산하는 초
        for(;;){
            if(state==false){break;}
            second+=1;
            System.out.printf("[타이머] : %d 초 \n",second);
            try{Thread.sleep(1000);}
            catch (Exception e){}
        }
    }
}