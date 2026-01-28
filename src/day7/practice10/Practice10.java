package day7.practice10;

import day7.package1.B;

import java.util.Scanner;

public class Practice10 {
    public static void main(String[] args) {
//        //문제1
//        Member member=new Member();
//        member.setId("admin");
//        System.out.println(member.getId());
//        //문제2
//        Score score=new Score();
//        score.setScore(85);
//        System.out.println(score.getScore());
//        score.setScore(120);
//        System.out.println(score.getScore());
//        //문제3
//        BankAccount bankAccount=new BankAccount("123-456");
//        System.out.println(bankAccount.getAccountNumber());
//        //문제4
//        CircleCalculator circleCalculator=new CircleCalculator();
//        Scanner sc=new Scanner(System.in);
//        int num=sc.nextInt();
//        System.out.println(circleCalculator.getPi(num));
//        //문제5
//        TicketMachine ticketMachine1=new TicketMachine();
//        TicketMachine ticketMachine2=new TicketMachine();
//        TicketMachine ticketMachine3=new TicketMachine();
//        ticketMachine1.issueTicket();
//        ticketMachine1.issueTicket();
//        ticketMachine2.issueTicket();
//        TicketMachine.printTotalTickets();
        //문제6
        System.out.println("게임이름:"+GameConfig.게임이름);
        System.out.println("최대레벨:"+GameConfig.최대레벨);
        System.out.println("최대체력:"+GameConfig.최대체력);

    }
}
//문제1
class Member {
    private String id;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
}
//문제2
class Score{
    private int score;
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        if(score>=0&&score<=100) {
            this.score = score;
        }else{
            System.out.println("유효하지 않은 점수입니다.");
        }
    }
}
//문제3
class BankAccount{
    private String accountNumber;
    public BankAccount(String accountNumber){
        this.accountNumber=accountNumber;
    }
    public String getAccountNumber() {
        return accountNumber;
    }
}
//문제4
class CircleCalculator{
    final double Pi=3.14159;

    public double getPi(int num) {
        return num*num*Pi;
    }
}
//문제5
class TicketMachine{
    static int totalTickets=0;
    public void issueTicket(){
        totalTickets+=1;
        System.out.println("티켓 1장을 발권했습니다.");
    }
    static void printTotalTickets(){
        System.out.println("지금까지의 총 티켓 수:"+totalTickets);
    }
}
//문제6
class GameConfig{
    public static final int 최대레벨=99;
    public static final int 최대체력=10000;
    public static final String 게임이름="MY RPG";
}