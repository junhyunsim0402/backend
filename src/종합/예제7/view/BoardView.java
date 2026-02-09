package 종합.예제7.view;

import 종합.예제7.controller.BoardController;
import 종합.예제7.model.dto.BoardDto;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BoardView {
    private BoardView(){}
    private static final BoardView instance=new BoardView();
    public static BoardView getInstance(){return instance;}
    private BoardController bc=BoardController.getInstance();
    private Scanner sc=new Scanner(System.in);
    public void index(){
        for(;;){
            try {
                System.out.println("========== My Community =========== ");
                System.out.println("1.게시물쓰기 2.게시물출력 3.게시물 수정 4.게시물 삭제");
                System.out.println("=================================== ");
                System.out.print("선택>");
                int ch = sc.nextInt();
                if (ch == 1) {writeView();}
                else if (ch == 2) {findAll();}
                else if (ch == 3) {update();}
                else if (ch == 4) {delete();}
                else {System.out.println("[경고]없는 기능 번호입니다.");}
            }catch (InputMismatchException i){
                System.out.println("[경고]잘못된 입력 방식입니다.[재입력]");
                sc=new Scanner(System.in);  // 입력객체 초기화
            }catch (Exception e){
                System.out.println("[시스템오류]관리자에게 문의");
            }
        }
    }
    public void writeView(){
        sc.nextLine();
        System.out.print("내용:");String content=sc.nextLine();
        System.out.print("작성자:");String writer=sc.next();
        boolean result=bc.write(content,writer);  // 컨트롤러에게 입력받은 content,writer 전달하여 결과 받아오기
        // 받은 결과에 따른 화면 출력
        if(result){
            System.out.println("[안내]성공");
        }else{
            System.out.println("[경고]실패");
        }
    }
    // 게시물 삭제
    public void delete(){
        System.out.print("삭제할 게시물 번호:"); int bno=sc.nextInt();
        boolean result=bc.delete(bno);
        if(result){
            System.out.println("[안내]삭제 성공");
        }else{
            System.out.println("[경고]삭제 실패");
        }
    }
    // [2] 게시물 전체 조회
    public void findAll(){
        ArrayList<BoardDto> boards=bc.findAll();
        for(BoardDto board:boards){
            System.out.printf("번호:%d, 작성일:%s, 작성자:%s, 내용:%s\n",
                    board.getBno(),board.getBwriter(),board.getBwriter(),board.getBcontent());
        }
    }
    // [3] 게시물 수정
    public void update(){
        System.out.print("수정할 게시물번호:");int bno=sc.nextInt();sc.nextLine();
        System.out.print("수정할 내용:"); String bcontent=sc.nextLine();
        boolean result=bc.update(bno,bcontent);
        if(result){
            System.out.println("[안내]수정 성공");
        }else{
            System.out.println("[경고]수정 실패");
        }
    }
}
