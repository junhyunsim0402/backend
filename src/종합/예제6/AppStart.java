package 종합.예제6;

import 종합.예제6.view.BoardView;

public class AppStart {
    public static void main(String[] args) {
        // 최초로 실행할 화면 view 요청
        BoardView.getInstance().indexView();
    }
}
