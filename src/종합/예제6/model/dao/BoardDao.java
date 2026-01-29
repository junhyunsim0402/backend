package 종합.예제6.model.dao;

import 종합.예제6.model.dto.BoardDto;

import java.util.ArrayList;

public class BoardDao {
    private BoardDao(){}
    private static final BoardDao instance=new BoardDao();
    public static BoardDao getInstance(){
        return instance;
    }
    // 데이터베이스 역할을 하는 ArrayList<추후에 삭제 예정>
    private static final ArrayList<BoardDto> boards=new ArrayList<>();
    // 전역변수에 최신 게시물 번호 저장<식별키 생성 목적:추후에 삭제 예정>
    private static int currentNo=1; // 초기값 1
    // 1) 등록 처리
    public boolean doPost(String content,String writer){
        // 1. 매개변수에 따른 객체를 만든다 + 게시물 번호 자동 생성
        BoardDto boardDto = new BoardDto(currentNo, content, writer);
        // 2. .add(새로운값)
        boolean saveResult=boards.add(boardDto);
        currentNo++;
        // 3. 저장 공간 여부를 controller에게 반환한다
        return saveResult;
    }

    // 2) 전체 조회 철: controller가 dao에게 모든 게시물을 요청한다
    // 개별 조회 1개 반환 타입: BoardDto vs 전체 조회 N개 반환타입 ArrayList<BoardDto>
    public ArrayList<BoardDto> doGet(){
        return boards;
    }
}
