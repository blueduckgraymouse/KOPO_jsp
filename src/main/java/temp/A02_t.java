package temp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


// 객체 지향을 적극 반영한 풀이법
public class A02_t {	// public 클래스는 하나만 있어야하지만 default는 여러 개 가능

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int R = sc.nextInt();
		int N = sc.nextInt();
		
		Gongsa gongsa = new Gongsa(a, b, R);
		
		List<Tree> trees = new ArrayList<Tree>();
		
		for (int i = 0 ; i < N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			Tree tree = new Tree(x, y);
			trees.add(tree);
		}
		
		Park park = new Park(gongsa, trees);
		for (boolean result : park.isSilents()) {
			System.out.println(result ? "silent" : "noisy");
		}
	}
}

class Gongsa {
	int x;
	int y;
	int radius;
	
	Gongsa(int x, int y, int radius) {
		this.x = x;
		this.y = y;
		this.radius = radius;
	}
	
	boolean isSilent(Tree tree) {
		return Math.pow(tree.x - x, 2) + Math.pow(tree.y - y, 2) >= Math.pow(radius, 2);
	}
}

class Tree {
	int x;
	int y;
	
	Tree(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	boolean isSilent(Gongsa gongsa) {
		return Math.pow(gongsa.x - x, 2) + Math.pow(gongsa.y - y, 2) <= Math.pow(gongsa.radius, 2);
	}
}

class Park {
	Gongsa gongsa;
	List<Tree> trees;
	
	Park(Gongsa gongsa, List<Tree> trees) {
		this.gongsa = gongsa;
		this.trees = trees;
	}
	
	List<Boolean> isSilents() {
		List<Boolean> results = new ArrayList<>();
		
		for (Tree tree : trees) {
			//boolean result = Math.pow(0, 0)
			results.add(gongsa.isSilent(tree));
		}
		return results;
	}
}
