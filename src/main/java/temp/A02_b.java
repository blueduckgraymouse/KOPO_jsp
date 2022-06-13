package temp;

import java.util.Scanner;

public class A02_b {
	public static void main(String[] args) {
		// 입력
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		int R = sc.nextInt();
		int N = sc.nextInt();
		int[][] positionTrees = new int[N][2];		// 교수님은 array보다는 arraylist를 선호
		for (int i = 0; i < N; i++) {				//   왜냐하면 List는 값을 가져올 때 첨자를 사용하지 않으므로
			positionTrees[i][0] = sc.nextInt();		//   에러 발생비율이 적다.
			positionTrees[i][1] = sc.nextInt();		// 변수명은 1년 후에 봐도 알아볼 수 있게 하자
		}
		sc.close();

		// 실행
		String[] results = solution(x, y, R, positionTrees);

		// 출력
		for (String result : results) {
			System.out.println(result);
		}
	}

	private static String[] solution(int x, int y, int R, int[][] positionTrees) {
		String[] results = new String[positionTrees.length];
		for (int i = 0; i < positionTrees.length; i++) {
			double distanceSquared = Math.pow(positionTrees[i][0] - x, 2) + Math.pow(positionTrees[i][1] - y, 2);
			if (distanceSquared >= Math.pow(R, 2)) {
				results[i] = "silent";
			} else {
				results[i] = "noisy";
			}
		}
		return results;
	}
}
