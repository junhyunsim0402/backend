package 종합.과제3.controller;

import 종합.과제3.dao.UserDao;

public class UserController {
    private UserController(){}
    private static final UserController instance=new UserController();
    public static UserController getInstance(){return instance;}
    UserDao ud=UserDao.getInstance();
    public boolean userAdd(String id,int pwd,String nickname){
        boolean userResult=ud.userAdd(id,pwd,nickname);
        return userResult;
    }
    public String userOutput(String id,int pwd){
        String nicknameResult=ud.login(id,pwd);
        return nicknameResult;
    }
}
