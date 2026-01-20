package day02;

import java.util.Scanner;

public class Practice2 {
    public static void main(String[] args) {
//        문제1
        byte a=10;
        int b=200;
        long a_b=a+b;
        System.out.println(a_b);
//        문제2
        double z=3.141592;
        System.out.printf("원본 double 값:%f\n",z);
//        문제3
        Scanner scan=new Scanner(System.in);
        System.out.print("키를 입력해주세요:");
        double doubleValue=scan.nextDouble();
        System.out.printf("당신의 키는 약%dcm 이군요\n",(int)doubleValue);
//        문제4
        System.out.printf("첫 번째 정수 입력:");
        int num1=scan.nextInt();
        System.out.printf("두 번째 정수 입력:");
        int num2=scan.nextInt();
        System.out.printf("세 번째 정수 입력:");
        int num3=scan.nextInt();
        double result1=(double)(num1+num2+num3)/3;
        System.out.printf("평균 결과:%.10f",result1);
    }
}
