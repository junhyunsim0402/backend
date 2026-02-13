package day13;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Exam1 {
    public static void main(String[] args) {
        // 미리 만들어진 라이브러리/클래스: Object,Class,래퍼클래스
        // [1] 날짜/시간 클래스
        // 1-1) (컴퓨터)현재 날짜 클래스
        LocalDate localDate=LocalDate.now();
        System.out.println(localDate);  // 2026-02-11
        // 1-2) (컴퓨터) 현재 시간 클래스
        LocalTime localTime=LocalTime.now();
        System.out.println(localTime);      //09:45:40.520186500
        // 1-3) 현재 날짜/시간 클래스
        LocalDateTime localDateTime=LocalDateTime.now();
        System.out.println(localDateTime);      // 2026-02-11T09:45:40.520186500
        // 1-4) 정해진 날짜/시간 생성 .of(연도,월,일,시,분,초)
        LocalDateTime dateTime=LocalDateTime.of(2025,7,25,11,35,11);
        System.out.println(dateTime);   // 2025-07-25T11:35:11
        // 1-5) 정해진 패턴(형식) 지정, 패턴: y M d h m s
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 hh시 mm분 ss초");
        String today=dateTime.format(formatter); // 날짜/시간객체.format(날짜/시간패턴)
        System.out.println(today);
        // 1-6) 날짜 계산, .plusXXX(증가할 값) or .minusXXX(감소할 값)
        LocalDateTime dateTime1=dateTime.plusDays(10);  // 10일 증가
        System.out.println(dateTime1);
        LocalDateTime dateTime2=dateTime1.minusDays(30);
        System.out.println("dateTime2 = " + dateTime2);
        // 1-7) 날짜 세부 정보
        int year=localDateTime.getYear();
        System.out.println("year = " + year);   // 2026
        int month=localDate.getMonthValue();
        System.out.println("month = " + month); // 2
        int day=localDateTime.getDayOfMonth();
        System.out.println("day = " + day); // 11
        int hour=localDateTime.getHour();
        System.out.println("hour = " + hour);   // 10
        int minute=localDateTime.getMinute();
        System.out.println("minute = " + minute);   // 1
        int second=localDateTime.getSecond();
        System.out.println("second = " + second);   // 21
    }
}
