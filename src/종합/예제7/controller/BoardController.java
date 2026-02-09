package 종합.예제7.controller;

import 종합.예제7.model.dao.BoardDao;
import 종합.예제7.model.dto.BoardDto;

import java.util.ArrayList;

public class BoardController {
    private BoardController(){}
    public static final BoardController instance=new BoardController();
    public static BoardController getInstance(){return instance;}
    private BoardDao bd=BoardDao.getInstance();
    // 게시물 등록 controller
    public boolean write(String bcontent,String bwriter){
        boolean result=bd.write(bcontent,bwriter);
        return result;
    }
    public boolean delete(int bno){
        boolean result=bd.delete(bno);
        return result;
    }
    public boolean update(int bno,String bcontent){
        boolean result=bd.update(bno,bcontent);
        return result;
    }
    // [4] 게시물 전체조회,여러개 레코드조회->ArrayList,한개 레코드 조회->dto
    public ArrayList<BoardDto> findAll(){
        ArrayList<BoardDto> result=bd.findAll();
        return result;
    }
}
