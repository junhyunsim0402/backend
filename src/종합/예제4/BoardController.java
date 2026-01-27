package 종합.예제4;

import java.util.Scanner;

public class BoardController {
    Board[] boards=new Board[100];
    public boolean doPost(String content,String writer){
        for(int i=0;i<boards.length;i++){
            if(boards[i]==null){
                Board board=new Board();
                board.content=content;
                board.writer=writer;
                boards[i]=board;
                return true;
            }
        }
        return false;
    }
    public Board[] doGet(){
        return boards;
    }
}
