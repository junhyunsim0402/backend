package day01;

import java.util.Scanner;

public class Practice1 {
    public static void main(String[] args) {
//        문제1
        System.out.println(25);
        System.out.println("홍길동");
//        문제2
        Scanner value=new Scanner(System.in);
        int age= value.nextInt();
        System.out.println(age);
//        문제3
        String name="홍길동";
        age=25;
        double height=175.5;
        String motto;
//        문제4
        System.out.println("제 이름은 "+name+", 나이는 "+age+"세, 키는 "+height+"cm입니다.");
//        문제5
        System.out.printf("제 이름은 %s, 나이는 %d세, 키는 %3.1fcm입니다.\n",name,age,height);
//        문제6
        System.out.println("|\\_/|");
        System.out.println("|q p|\t/}");
        System.out.println("( 0 )\"\"\"\\");
        System.out.println("|\"^\"'\t|");
        System.out.println("||_/=\\\\__|");
//        문제7
        int num=1;
        String writer="유재석";
        String content="안녕하세요!";
        System.out.printf("번호\t작성자\t방문록\n");
        System.out.printf("%d\t%s\t%s\n",num,writer,content);
//        문제8
        Scanner scan=new Scanner(System.in);
        name=scan.nextLine();
        age=scan.nextInt();
        System.out.printf("%s님의 나이는 %d세 입니다.\n",name,age);
//        문제9
        System.out.print("게시물 번호:");
        int number=value.nextInt();
        value.nextLine();
        System.out.print("제목:");
        String title=value.nextLine();
        System.out.print("내용:");
        content=value.nextLine();
        System.out.printf("[%d번 게시물]\n제목:%s\n내용:%s\n",number,title,content);
//        문제10
        System.out.print("성별을 입력하세요(남/여):");
        char gender=value.next().charAt(0);
        System.out.printf("입력하신 성별은 %c입니다\n",gender);
//        문제11
        Scanner sc=new Scanner(System.in);
        System.out.print("이름:");
        name=sc.nextLine();
        System.out.print("나이:");
        age=sc.nextInt();
        System.out.print("키:");
        height=sc.nextFloat();
        System.out.print("프로그래머입니까?(ture/false):");
        boolean result=sc.nextBoolean();
        System.out.printf("이름%s\n나이:%d\n키:%3.1fcm\n프로그래머 여부:%b",name,age,height,result);
    }
}
