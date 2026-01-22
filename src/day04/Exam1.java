package day04;

import java.util.Scanner;

public class Exam1 { // class start
    public static void main(String[] args) { // main start

        // [1] 1부터 5까지 출력하시오
        System.out.println( 1 );    System.out.println( 2 );
        System.out.println( 3 );    System.out.println( 4 );
        System.out.println( 5 );
        // vs 초기값: 1 , 조건문 : 5까지 , 증감식 : 1씩증가
        for( int 출력값 = 1 ; 출력값<=5; 출력값++ ){
            System.out.println( 출력값 );
        }// for end

        // [2] 구구단 / for 중첩
        // (1) 2단 ~ 9단 : 초기값 : 1 , 조건문 : 9까지 , 증감식 : 1씩증가
        for( int 단 = 2 ; 단 <= 9 ; 단++ ){ System.out.println( 단 ); }
        // (2) 1곱 ~ 9곱 : 초기값 : 1 , 조건문 : 9까지 , 증감식 : 1씩증가
        for( int 곱 = 1 ; 곱 <= 9 ; 곱++ ){ System.out.println( 곱 ); }
        // (3) 단 반복문이 1회 반복할때마다 곱 반복문은 9번 실행된다.
        for( int 단 = 2 ; 단 <= 9 ; 단++ ){
            for( int 곱 = 1 ; 곱 <= 9 ; 곱++ ){
                System.out.printf( "%d  X   %d  =  %d \n" , 단 , 곱 , 단*곱 );  // 8 * 9 = 72회 출력
            } // for end
        } // for end

        // [3] break : 가장 가까운 반복문/switch {} 탈출 / continue : 가장 가까운 반복문(증감식) 이동;
        for( int i = 1 ; i <= 5 ; i++ ){
            if( i == 3 ){ break; } // 코드 흐름이 break 만나면 반복문 탈출
            System.out.println( i );
        } // 1 2
        for( int i = 1 ; i <= 5 ; i++ ){
            if (i == 3) { continue; } // 코드 흐름이 continue 만나면 증감식(i++)으로 이동
            System.out.println( i );
        } // 1 2 4 5

        // [4] 무한루프 : 조건문이 true 상수로 계속 되는 반복문
        // for( ; ; ){ System.out.println("무한루프"); }
        while ( true ){ // 조건식에 true 상수를 넣으면 무한루프
            System.out.println("무한입력");
            Scanner scan = new Scanner( System.in);
            String data = scan.next();
            if( data.equals("q") ){ break; }
        }


    } // main end
} // class end
