package temp;

import java.util.Scanner;

public class A01 {

	public static void main(String[] args) {
		// 입력
		Scanner sc = new Scanner(System.in);
		//System.out.print("입력 수:");
		int count = sc.nextInt();
		String[] inputs = new String[count];
		for (int i = 0 ; i < count ; i++) {
			//System.out.println("문자열[" + (i+1) + "] 입력 : ");
			inputs[i] = sc.next();
		}
		
		// 실행
		String result = answer(inputs);
		
		// 출력
		System.out.println(result);
		
	}

	public static String answer(String[] inputs) {
		String result = "Hello ";
		for (int i = 0; i < inputs.length; i++) {			// for문, 즉 문자열 결합의 횟수가 매우 크다면
			result += inputs[i];
			if (i == inputs.length - 1) {					//   조건문도 그 횟수만큼 실행되므로
				result += ".";								//   속도를 생각한다면 ,를 무조건 찍고
			} else {										//   마지막 , 를 지워 주는 것이 성능 향상
				result += ",";
			}
		}
		return result;
	}
}
