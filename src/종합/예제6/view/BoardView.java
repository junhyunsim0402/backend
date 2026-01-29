package 종합.예제6.view;

import 종합.예제4.Board;
import 종합.예제6.controller.BoardController;
import 종합.예제6.model.dao.BoardDao;
import 종합.예제6.model.dto.BoardDto;

import java.util.ArrayList;
import java.util.Scanner;

public class BoardView {
    private Scanner sc=new Scanner(System.in);
    // [1] 싱글톤 생성
    private BoardView(){}
    private static final BoardView instance=new BoardView();
    public static final BoardView getInstance(){
        return instance;
    }

    // [2] MVC패턴 흐름의 controller호출
    private BoardController bc=BoardController.getInstance();

    // 1) 등록 입출력 화면
    public void writeView(){
        System.out.println("내용:");String content=sc.nextLine();
        System.out.println("작성자:");String writer=sc.next();
        boolean result=bc.doPost(content,writer);  // 컨트롤러에게 입력받은 content,writer 전달하여 결과 받아오기
        // 받은 결과에 따른 화면 출력
        if(result){
            System.out.println("[안내]성공");
        }else{
            System.out.println("[경고]실패");
        }
    }

    // 메인 입출력 화면
    public void indexView() {
        for(;;) {
            System.out.println("========== My Community =========== ");
            System.out.println("1.게시물쓰기 2.게시물출력");
            System.out.println("=================================== ");
            System.out.print("선택>");
            Scanner scan = new Scanner(System.in);
            int ch = scan.nextInt();
            if(ch==1){writeView();}
            else if(ch==2){printView();}
        }
    }

    // 등록 입출력 화면
    public void printView( ){
        // 1. 컨트롤러에게 모든 게시물 요청 하고 결과를 받는다.
        ArrayList<BoardDto> boards = bc.doGet(); // vs BoardDto[] boards = bc.doGet();
        // 2. 받은 결과를 모두 출력한다. // ArrayList는 가변(저장된요소만)길이 라서 null 체크 안한다.
        for( BoardDto board : boards ){
            System.out.printf("번호 : %d , 작성자 : %s , 내용 : %s \n" ,
                    board.getNo() , board.getWriter() , board.getContent() );
        }
    }
}
