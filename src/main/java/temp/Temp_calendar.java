package temp;

import java.util.Calendar;
import java.util.Collections;
import java.util.Date;

public class Temp_calendar {

	public static void main(String[] args) {
		//Calendar calendar = new Calendar();
		Calendar calendar =Calendar.getInstance();
		
		System.out.println(calendar.get(calendar.YEAR));		// 연도
		System.out.println(calendar.get(calendar.MONTH) + 1);	// 월, 0부터 시작
		System.out.println(calendar.get(calendar.DAY_OF_MONTH));// 일
		
		System.out.println(calendar.get(calendar.DATE));		// 일
		System.out.println(calendar.get(calendar.DAY_OF_WEEK));	// 요일, 일요일이 1
		System.out.println(calendar.get(calendar.DAY_OF_WEEK_IN_MONTH));	// 해당 달의 주차
		System.out.println(calendar.get(calendar.HOUR_OF_DAY));	// 시
		System.out.println(calendar.get(calendar.HOUR));		// 시, am/pm구분
		System.out.println(calendar.get(calendar.MINUTE));		// 분

		System.out.println(calendar.get(calendar.JANUARY));
		System.out.println(calendar.get(calendar.MONDAY));
		
		// add 메서드
		calendar.add(Calendar.DAY_OF_MONTH, 10);
		Date date = calendar.getTime();
		System.out.println(date.toString());

		// 내년 내 생일 요일
		calendar.set(2023, 2, 9);
		System.out.println(calendar.get(calendar.DAY_OF_WEEK));	
	}

}
