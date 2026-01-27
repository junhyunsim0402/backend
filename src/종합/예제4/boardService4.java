package 종합.예제4;

import java.util.Scanner;

public class boardService4 {
    public static void main(String[] args) {
        BoardController bs=new BoardController();
        for(;;){
            System.out.println("========== My Community =========== ");
            System.out.println("1.게시물쓰기 2.게시물출력");
            System.out.println("=================================== ");
            System.out.print("선택>");
            Scanner scan = new Scanner( System.in );
            int ch= scan.nextInt();
            switch (ch){
                case 1:
                    scan.nextLine();
                    System.out.print("내용:");String content=scan.nextLine();
                    System.out.print("작성자:");String writer=scan.nextLine();
                    boolean result=bs.doPost(content,writer);
                    if(result){
                        System.out.println("등록성공");
                    }else{
                        System.out.println("등록실패");
                    }break;
                case 2:
                    Board[] allBoards = bs.doGet();
                    System.out.println("--- 게시물 목록 ---");
                    for (int i = 0; i < allBoards.length; i++) {
                        if (allBoards[i] != null) {
                            System.out.println("내용: " + allBoards[i].content + " | 작성자: " + allBoards[i].writer);
                        }
                    }break;
                default:break;
            }
        }
    }
}
