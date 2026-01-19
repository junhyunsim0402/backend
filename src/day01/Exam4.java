package day01;

import java.util.Scanner;

public class Exam4 {
    public static void main(String[] args) {
        //[1]입력객체
        //Scanner 클래스:입력받은 자료들을 특정한 타입으로 변환
        // new:새로운 객체 생성할떄 사용되는 키워드
        // new Scanner:스캐너 객체 만들겠다
        // (System.in):시스템 입력 객체를 Scanner에 전달
        // Scanner 변수명=new Scanner(System.in);
        Scanner scan=new Scanner(System.in);

        //[2]입력함수
        // .next(); : 입력받은 자료들을 문자열로 반환,띄어쓰기 X
        String str1=scan.next();
        System.out.println(str1);

        // .nextLine(): 입력받은 자료를 문자열로 반환,띄어쓰기 포함
        // 주의할점:띄어쓰기를 포함하다 보니 앞전에 next가 충돌하여 하나의 next가 인식됨
        // 해결방법:nextLine()사용할떄 앞정에 next()가 존재하면 nextLine()하나 더 작성
        scan.nextLine();    // 앞전의 next()해결
        System.out.println("nextLine():");
        String str2=scan.nextLine();
        System.out.println(str2);

        // .nextByte()
        // 주의할점:+-128까지
        System.out.println("nextByte():");
        byte b1=scan.nextByte();
        System.out.println(b1);

        //.nextShort:입력받은 자료를 short로 반환
        System.out.println("nextShort");
        short s1=scan.nextShort();
        System.out.println(s1);

        // .nextInt:입력받은 자료를 int로 반환
        System.out.println("nextInt():");
        int i1=scan.nextInt();
        System.out.println(i1);

        // .nextLong:입력받은 자료를 long로 반환
        long l1=scan.nextLong();
        System.out.println(l1);

        // .nextFloat(),    .nextDouble: float이나 double로도 반환가능
        System.out.println(".nextFloat");
        float f1=scan.nextFloat();
        System.out.println(".nextDouble");
        double d1=scan.nextDouble();
        System.out.println(f1);
        System.out.println(d1);

        // .nextBoolean:입력받은 자료를 불리언으로 반환
        boolean b2=scan.nextBoolean();
        System.out.println(b2);

        // .next().charAt(0):입력받은 자료에서 첫번쨰 글짜 변환
        System.out.println("next().charAt(0)");
        char c1=scan.next().charAt(0);
    }
}
