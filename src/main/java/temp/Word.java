package temp;

public class Word {
	private String letters;

	public static void main(String[] args) {
		Word word = new Word("hello world~");

		for (int i = 0; i < word.letters.length(); i++) {
			System.out.println(i + "번쨰 : " + word.isVowel(i));
		}
		
		System.out.println("--");
		
		for (int i = 0; i < word.letters.length(); i++) {
			System.out.println(i + "번쨰 : " + word.isConsonant(i));
		}
	}

	public Word(String letters) {
		this.letters = letters.toLowerCase();
	}

	// i번째 글자가 모음인지 확인,  a,i,u,e,o
	public boolean isVowel(int i) {
		boolean result = false;
		String[] vowels = { "a", "i", "u", "e", "o" };
		// char[] vowels = {'a', 'i', 'u', 'e', 'o'};
		// -> charsquence를 인터페이스를 상속받은 클래스는 CharBuffer, Segment, String, StringBuffer,
		// StringBuilder이므로
		// equals ()메서드에서는 false.
		for (int j = 0; j < vowels.length; j++) {
			if (letters.substring(i, i + 1).equals(vowels[j])) {
				result = true; // 중간에 return을 하게 되면 코드가 길어졌을 때
				break; // 코드 이해가 어려워지므로 명시적을 변수로 만들어 마지막에 return하는 것을 추천.
			}
		}
		return result;
	}
	
	// i번쨰 글자가 자음인지 확인,  b,c,d,f,g,h,j,k,l,m,n,p,q,r,s,t,v,w,x,z
	public boolean isConsonant(int i) {
		return "bcdfghjklmnpqrstvwxyz".contains(letters.substring(i, i + 1));
	}
}
