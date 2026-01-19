package day01;

public class Exam3 {
    public static void main(String[] args) {
        // System:클래스 이면서 시스템 관련 기능/함수 제공
        //out: 출력 관련된 기능/함수 갖는 객체 반환
        // print:출력함수
        //ln:줄넘김
        System.out.println();
        System.out.printf("%s","자바안녕");
        /*
        printf(fomat 형식)
        %s:문자열,%d:정수,%c:문자,%f:실수
            %자릿수d:자릿수 만큼 자리 차지,만일 비어있으면 공백,오른쪽 정렬
            %-자릿수d:자릿수 만큼 자리 차지,비어있으면 공백,왼쪽정렬
            %0자릿수d:자릿수 만틈 차지,비어있으면 0채음
            %전체자릿수.소수점자리수f
        */
        String name="유재석";
        int age=10;

        //문자열과 변수 연결할떄 %?로 대입하는걸로한다
        System.out.printf("저는 %s 이고 나이는: %d 입니다\n",name,age);
        System.out.printf("저는 %s이고 나이는 %-6d 입니다\n",name,age);
        System.out.printf("저는 %s이고 나이는 %06d 입니다\n",name,age);
        System.out.printf("저는 %s이고 나이는 %3.2f 입니다\n",name,166.6666);
        // 이스케이프/제어 문자
        // \n:줄 바꿈 처리    \t:들여쓰기[tab]    \":큰따음표 출력
        // \':작음 따음표 출력 \\:백슬레시 출력
        System.out.println("안녕\n안녕2");
        System.out.println("안녕\t안녕2");
        System.out.println("안녕\"안녕2");
        System.out.println("안녕\\안녕2");

    }
}
