package day04;

import java.util.Scanner;

public class practice5 {
    public static void main(String[] args) {
////        문제1
//        for(int i=1;i<=10;i++){
//            System.out.println(i);
//        }
////        문제2
//        for(int i=10;i>0;i--){
//            System.out.println(i);
//        }
////        문제3
//        int sum=0;
//        for (int i=1;i<=50;i++){
//            sum+=i;
//        }
//        System.out.printf("1부터 50까지의 합계:%d",sum);
////        문제4
//        for(int i=1;i<=20;i++){
//            if(i%2==0){
//                System.out.println(i);
//            }
//        }
////        문제5
//        for(int i=1;i<=30;i++){
//            if(i%3==0){
//                continue;
//            }
//            System.out.println(i);
//        }
////        문제6
//        int i=1;
//        int sum=0;
//        while(true){
//            if(sum<=100){
//                sum+=i;
//                i++;
//            }else{
//                System.out.printf("%d까지 더했을때 합계가 %d로 100을 넘습니다.",i-1,sum);
//                break;
//            }
//        }
////        문제7
//        for (int i=1;i<=5;i++){
//            String star="*";
//            System.out.println(star.repeat(i));
//        }
////        문제8
//        for(int i=5;i>=1;i--){
//            String Star="*";
//            System.out.println(Star.repeat(i));
//        }
////        문제9
//        Scanner scan=new Scanner(System.in);
//        String user="";
//        int count=1;
//        while(true){
//            System.out.printf("%d회 입력:",count);
//            user= scan.next();
//            if(user.equals("end")) {
//                System.out.printf("[안내]프로그램을 종료합니다.[총 %d회 입력]", count-1);
//                break;
//            }
//            count++;
//        }
////        문제10
        int july1=3532100;
        int july2=9123700;
        int july3=5183400;
        int july4=11738700;
        int indexJuly=0;
        System.out.println("-------7월 매출액-------");
        for (int i=1;i<=4;i++){
            if(i==1){indexJuly=july1;}
            else if (i==2) {indexJuly=july2;}
            else if (i==3) {indexJuly=july3;}
            else{indexJuly=july4;}
            System.out.printf("%d주차:%s%d만원\n",i,"■ ".repeat((int)indexJuly/1000000),(int)indexJuly/10000);
        }
////        문제11
//        int result=0;
//        for(;;){
//            System.out.println("1:입금|2:출금|3:잔고|4:종료");
//            Scanner sc=new Scanner(System.in);
//            int user=sc.nextInt();
//            switch (user){
//                case 1:System.out.print("입금액:");int input= sc.nextInt();result+=input;break;
//                case 2:System.out.print("출금액:");input= sc.nextInt();result-=input;break;
//                case 3:System.out.printf("현재 잔고:%d원\n",result);break;
//                case 4:System.out.println("프로그램을 종료합니다");break;
//            }
//            if(user==4){
//                break;
//            }
//        }
    }
}
