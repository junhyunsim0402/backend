package day02;

import java.util.Scanner;

public class Practice3 {
    public static void main(String[] args) {
//        문제1
        Scanner sc=new Scanner(System.in);
        System.out.print("국어 점수:");
        int num1=sc.nextInt();
        System.out.print("영어 점수:");
        int num2=sc.nextInt();
        System.out.print("수학 점수:");
        int num3=sc.nextInt();
        System.out.printf("총점:%d\n평균:%.1f\n",num1+num2+num3,(float)(num1+num2+num3)/3);
//        문제2
        System.out.print("반지름을 입력하세요:");
        double radius=sc.nextDouble();
        System.out.printf("원의 넓이%1.3f\n",radius*radius*3.14);
//        문제3
        System.out.print("첫 번째 실수:");
        double n1=sc.nextDouble();
        System.out.print("두 번째 실수:");
        double n2=sc.nextDouble();
        System.out.printf("비율:%.1f%%\n",n1/n2*100);
//        문제4
        System.out.print("정수를 입력하세요:");
        int holsu=sc.nextInt();
        boolean result2=holsu%2==1?true:false;
        System.out.println(result2);
//        문제5
        System.out.print("정수를 입력하세요:");
        int q=sc.nextInt();
        boolean result=q%7==0?true:false;
        System.out.println(result);
//        문제6
        sc.nextLine();
        System.out.print("아이디:");
        String id=sc.nextLine();
        System.out.print("비밀번호:");
        int password=sc.nextInt();
        boolean result1=id.equals("admin")&&password==1234?true:false;
        System.out.println(result1);
//        문제7
        System.out.print("정수를 입력하세요:");
        int holsu1=sc.nextInt();
        boolean result3=holsu1%2==1&&holsu1%7==0?true:false;
        System.out.printf("결과:%b\n",result3);
//        문제8
        System.out.print("1차 점수:");
        int one=sc.nextInt();
        System.out.print("2차 점수:");
        int two= sc.nextInt();
        boolean result4=one+two>=150?true:false;
        String output=result4==true?"합격":"불합격";
        System.out.println(output);
//        문제9
        System.out.print("이름을 입력하세요:");
        String name1=sc.next();
        String result5= name1.equals("유재석")?name1+"(방장)":name1;
        System.out.println(result5);
//        문제10
        System.out.print("밑변:");
        double line=sc.nextDouble();
        System.out.print("높이:");
        double height1=sc.nextDouble();
        System.out.printf("삼각형의 넓이:%.1f\n",line*height1/2);
//        문제11
        System.out.print("섭씨 온도:");
        double subsi=sc.nextDouble();
        System.out.printf("화씨 온도%.1f\n",subsi*9/5+32);
//        문제12
        System.out.print("태어난 년도:");
        int year=sc.nextInt();
        System.out.printf("2025년 기준 나이:%d세\n",2025-year);
//        문제 13
        System.out.print("키(cm):");
        double cm=sc.nextDouble();
        System.out.print("몸무게(kg):");
        double kg=sc.nextDouble();
        System.out.printf("BMI 지수:%.2f...\n",kg/((cm/100)*(cm/100)));
//        문제 14
        sc.nextLine();
        System.out.print("아이디:");
        String id1=sc.nextLine();
        System.out.print("이메일:");
        String email=sc.nextLine();
        String result7= id1.equals("admin")||email.equals("admin@test.com")?"관리자":"일반 사용자";
        System.out.println(result7);
//        문제15
        System.out.print("점수를 입력하세요:");
        int scores=sc.nextInt();
        char result8=scores>=90?'A':scores>=80?'B':'C';
        System.out.println(result8);
//        문제16
        System.out.print("나이를 입력하세요:");
        int age=sc.nextInt();
        String event=20<=age&&age<=29?"이벤트 대상입니다.":"이벤트 대상이 아닙니다.";
        System.out.println(event);
    }
}
