package day03;

import java.util.Scanner;

public class practice4 {
    public static void main(String[] args) {
//        문제1
        Scanner scan=new Scanner(System.in);
        System.out.print("첫 번째 점수:");
        int num1=scan.nextInt();
        System.out.print("두 번째 점수:");
        int num2= scan.nextInt();
        if(num1+num2>=90){
            System.out.println("성공");
        }else{
            System.out.println("실패");
        }
//        문제2
        System.out.print("첫 번째 정수:");
        int n1= scan.nextInt();
        System.out.print("두 번째 정수:");
        int n2= scan.nextInt();
        if(n1>n2){
            System.out.printf("더 큰수:%d",n1);
        } else if (n1<n2) {
            System.out.printf("더 큰수:%d",n2);
        }else{
            System.out.println("똑같다");
        }
//        문제3
        System.out.print("아이디:");
        String id= scan.next();
        System.out.print("비밀번호:");
        int password= scan.nextInt();
        if(id.equals("admin")&&password==1234){
            System.out.println("로그인 성공");
        }else {
            System.out.println("로그인 실패");
        }
//        문제4
        System.out.print("비밀번호를 입력하세요:");
        String pwd= scan.next();
        if(pwd.length()>=12){
            System.out.println("보안 등급:강함");
        } else if (pwd.length()>=8) {
            System.out.println("보안 등급:보통");
        }else{
            System.out.println("보안 등급:약함(8자 이상으로 설정해주세요.");
        }
//        문제5
        System.out.print("주민등록번호(-포함) 13자리 입력하세요:");
        String adminnum= scan.next();
        if(adminnum.charAt(7)=='1'||adminnum.charAt(7)=='3') {
            System.out.println("남자");
        } else if (adminnum.charAt(7)=='2'||adminnum.charAt(7)=='4') {
            System.out.println("여자");
        }else {
            System.out.println("다시 입력하세요.");
        }
//        문제6
        System.out.print("점수를 입력하세요:");
        int score= scan.nextInt();
        if(score>=900){
            System.out.println("A급 경품");
        } else if (score>=700) {
            System.out.println("B급 경품");
        }else if(score>=500){
            System.out.println("C급 경품");
        }else {
            System.out.println("참가상");
        }
//        문제7
        System.out.print("역할을 입력하세요:");
        String role=scan.next();
        if(role.equals("admin")) {
            System.out.println("모든 기능에 접근할수 있습니다");
        } else if (role.equals("editor")) {
            System.out.println("콘텐츠 수정 및 생성 기능에 접근할 수 있습니다.");
        } else if (role.equals("viewer")) {
            System.out.println("콘텐츠 조회만 가능합니다");
        }else{
            System.out.println("정의되지 않은 역할입니다");
        }
//        문제8
        System.out.print("나이를 입력하세요:");
        int age= scan.nextInt();
        if(age>=65){
            System.out.println("3,000원");
        } else if (age>=20) {
            System.out.println("10,000원");
        } else if (age>=8) {
            System.out.println("5,000원");
        }else{
            System.out.println("무료");
        }
//        문제9
        System.out.print("점수를 입력하세요:");
        int score1= scan.nextInt();
        if(score1>=90){
            System.out.println("A급 등급");
        } else if (score1>=80) {
            System.out.println("B급 등급");
        }else if(score1>=70){
            System.out.println("C급 등급");
        }else {
            System.out.println("재시험");
        }
//        문제10
        System.out.print("총 구매 금액:");
        int buymoney= scan.nextInt();
        if(buymoney>=50000){
            buymoney*=0.9;
        } else if (buymoney>=30000) {
            buymoney*=0.95;
        } else if (buymoney>=10000) {
            buymoney*=0.99;
        }else{
            buymoney*=1;
        }
        System.out.printf("최종 결제 금액:%d원\n",buymoney);
//        문제11
        System.out.print("월(1~12)을 입력하세요:");
        int month= scan.nextInt();
        if(month>=3&&month<=5){
            System.out.println("봄");
        }else if(month>=6&&month<=8){
            System.out.println("여름");
        } else if (month>=9&&month<=11) {
            System.out.println("가을");
        } else if (month<=2&&month>=0||month==12) {
            System.out.println("겨울");
        }else{
            System.out.println("다시 입력하세요.");
        }
//        문제12
        System.out.print("첫 번째 정수:");
        int first= scan.nextInt();
        System.out.print("두 번째 정수:");
        int two= scan.nextInt();
        System.out.print("세 번째 정수:");
        int three= scan.nextInt();
        if(first>=two){
            if(first>=three){
                System.out.printf("가장 큰 수:%d\n",first);
            }else {
                System.out.printf("가장 큰 수:%d\n",three);
            }
        } else{
            if(two>=three){
                System.out.printf("가장 큰 수:%d\n",two);
            }else{
                System.out.printf("가장 큰 수:%d\n",three);
            }
        }
//        문제 13
        System.out.print("연도를 입력하세요:");
        int year= scan.nextInt();
        if(year%4==0&&year%100!=0||year%400==0){
            System.out.printf("%d년은 윤년입니다\n",year);
        }else {
            System.out.printf("%d년은 평년입니다\n",year);
        }
//        문제14
        System.out.print("첫 번째 정수:");
        int nm1= scan.nextInt();
        System.out.print("두 번째 정수:");
        int nm2= scan.nextInt();
        System.out.print("세 번째 정수:");
        int nm3= scan.nextInt();
        if(nm1>=nm2&&nm1>=nm3){
            if(nm2>=nm3){
                System.out.printf("%d,%d,%d",nm3,nm2,nm1);
            }else{
                System.out.printf("%d,%d,%d",nm2,nm3,nm1);
            }
        } else if (nm2>=nm1&&nm2>=nm3) {
            if(nm1>=nm3){
                System.out.printf("%d,%d,%d",nm3,nm1,nm2);
            }else{
                System.out.printf("%d,%d,%d",nm1,nm3,nm2);
            }
        }else{
            if(nm1>=nm2){
                System.out.printf("%d,%d,%d",nm2,nm1,nm3);
            }else{
                System.out.printf("%d,%d,%d",nm1,nm2,nm3);
            }
        }
//        문제15
        System.out.print("player1님 0(가위),1(바위),2(보)중 하나를 입력하세요:");
        int p1= scan.nextInt();
        System.out.print("player2님 0(가위),1(바위),2(보)중 하나를 입력하세요:");
        int p2= scan.nextInt();
//        if(p1==0&&p2==2||p1==1&&p2==0||p1==2&&p2==1){
//            System.out.println("플레이어1 승리");
//        } else if (p2==0&&p1==2||p2==1&&p1==0||p2==2&&p1==1) {
//            System.out.println("플레이어2 승리");
//        } else if (p1==p2) {
//            System.out.println("비겼습니다");
//        }else{
//            System.out.println("다시 입력해주세요");
//        }
        switch (p1){
            case 0:
                switch (p2){
                    case 0: System.out.println("무승부");break;
                    case 1:System.out.println("player2승리");break;
                    case 2: System.out.println("player1승리");break;
                    default:System.out.println("다시 입력하세요");break;
                }break;
            case 1:
                switch (p2){
                    case 0:System.out.println("player1승리");break;
                    case 1:System.out.println("무승부");break;
                    case 2:System.out.println("player2승리");break;
                    default:System.out.println("다시 입력하세요");break;
                }break;
            case 2:
                switch (p2){
                    case 0:System.out.println("player2승리");break;
                    case 1:System.out.println("player1승리");break;
                    case 2:System.out.println("무승부");break;
                    default:System.out.println("다시 입력하세요");break;
                }break;
            default:System.out.println("다시 입력하세요");break;
        }
    }
}
