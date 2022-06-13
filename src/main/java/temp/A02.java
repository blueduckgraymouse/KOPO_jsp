package temp;

import java.util.Scanner;

public class A02 {
	public static void main(String[] args) {
		// 입력
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int R = sc.nextInt();
		int N = sc.nextInt();
		int[][] inputs = new int[N][2];
		for (int i = 0; i < N; i++) {
			inputs[i][0] = sc.nextInt();
			inputs[i][1] = sc.nextInt();
		}
		sc.close();

		// 실행
		solution(a, b, R, inputs);
	}

	private static void solution(int a, int b, int R, int[][] inputs) {
		for (int i = 0; i < inputs.length; i++) {
			double distance = Math.pow(inputs[i][0] - a, 2) + Math.pow(inputs[i][1] - b, 2);
			if (distance >= Math.pow(R, 2)) {
				System.out.println("silent");
			} else {
				System.out.println("noisy");
			}
		}

	}

}
