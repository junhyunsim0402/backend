package 종합.과제2.controller;

import 종합.과제2.model.dao.WaitingDao;
import 종합.과제2.model.dto.WaitingDto;

import java.util.ArrayList;

public class WaitingController {
    private WaitingController(){}
    private static final WaitingController instance=new WaitingController();
    public static WaitingController getInstance(){return instance;}
    private WaitingDao wd=WaitingDao.getInstance();
    public boolean add(String phone,int count){
        boolean result=wd.add(phone, count);
        return result;
    }
    public  ArrayList<WaitingDto> doGet(){
        return wd.doGet();
    }
}
