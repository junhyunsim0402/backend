package 종합.과제2.model.dao;

import 종합.과제2.model.dto.WaitingDto;

import java.util.ArrayList;
public class WaitingDao {
    private WaitingDao(){}
    private ArrayList<WaitingDto> waitingList=new ArrayList<>();
    private static final WaitingDao instance=new WaitingDao();
    public static WaitingDao getInstance(){return instance;}
    int no=0;
    public boolean add(String phone,int count){
        no+=1;
        WaitingDto waitingDto=new WaitingDto(no,phone,count);
        boolean result=waitingList.add(waitingDto);
        return result;
    }
    public ArrayList<WaitingDto> doGet(){
        return waitingList;
    }
}