package temp;

import java.util.Scanner;

public class A01_b {

	public static void main(String[] args) {
		// 입력
		Scanner sc = new Scanner(System.in);
		// System.out.print("입력 수:");
		int count = sc.nextInt();
		String[] inputs = new String[count];
		for (int i = 0; i < count; i++) {
			// System.out.println("문자열[" + (i+1) + "] 입력 : ");
			inputs[i] = sc.next();
		}

		// 실행
		String result = answer(inputs);

		// 출력
		System.out.println(result);
	}

	// 문자열 결합
	public static String answer(String[] inputs) {
		StringBuffer result = new StringBuffer("Hello ");
		for (int i = 0; i < inputs.length; i++) {
			result.append(inputs[i]);
			if (i == inputs.length - 1) {
				result.append(".");
			} else {
				result.append(",");
			}
		}
		return result.toString();
	}
}
