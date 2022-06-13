package temp;

public class Study01 {

	/* equals와 == 비교 확인 */
	public static void main(String[] args) {
//		String a = "apple";
//		//String b = "b";
//		String b = new String("apple");
//		String c = new String("apple");
//		String d = "apple";
//		String e = b;
//		
//		System.out.println(a==b);			// false , 같은 데이터(주소)를 참조하는가?
//		System.out.println(a==c);		 	// false , 같은 데이터(주소)를 참조하는가?
//		System.out.println(b==c);		 	// false , 같은 데이터(주소)를 참조하는가?
//		System.out.println(b==e); 			// true , 같은 데이터(주소)를 참조하는가?
//		System.out.println(a.equals(b));	// true	, 참조하는 데이터의 내용이 같은가?
//		System.out.println(a.equals(c));	// true , 참조하는 데이터의 내용이 같은가?
//		
//		System.out.println(System.identityHashCode(a));
//		System.out.println(System.identityHashCode(b));
//		System.out.println(System.identityHashCode(c));
//		
//		System.out.println(a.hashCode());	// String객체에서 오버라이딩 한 hashcode()는 
//		System.out.println(b.hashCode());
//		System.out.println(c.hashCode());
//		
//		System.out.println(a == b);			
//		System.out.println(a == c);			
//		System.out.println(b == c);		
//		System.out.println(a == d);
//		
//		System.out.println("---------");
//		Dto_temp temp11 = new Dto_temp(1, "홍길동");
//		Dto_temp temp22 = new Dto_temp(1, "홍길동");
//		System.out.println(System.identityHashCode(temp11));
//		System.out.println(System.identityHashCode(temp22));
//		System.out.println(temp11.toString());
//		System.out.println(temp11.hashCode());
//		System.out.println(temp22.hashCode());
//		System.out.println(temp11 == temp22);
//		System.out.println(temp11.equals(temp22));
//		System.out.println(temp11.hashCode() == temp22.hashCode());
//		
//		System.out.println("---------");
//		Dto_temp_hashcode temp1 = new Dto_temp_hashcode(1, "홍길동");
//		Dto_temp_hashcode temp2 = new Dto_temp_hashcode(1, "홍길동");
//		Dto_temp_hashcode temp3 = new Dto_temp_hashcode(1, new String("홍길동"));
//		System.out.println(temp1.hashCode());
//		System.out.println(temp2.hashCode());
//		System.out.println(temp3.hashCode());
//		System.out.println(temp1 == temp2);
//		System.out.println(temp1 == temp3);
//		System.out.println(temp1.equals(temp2));
//		System.out.println(temp1.equals(temp3));
//		System.out.println(temp1.hashCode() == temp2.hashCode());
//		System.out.println(temp1.hashCode() == temp3.hashCode());
//		
//		String m ="m";
//		System.out.println(m.hashCode());
//		System.out.println(System.identityHashCode(m));
		
//		String a = "a";
//		String aa = a;
//		String aaa = "a";
//		String aaaa = new String("a");
////		System.out.println(a == aa);	// true
////		System.out.println(a == aaa);	// true - string pool에 변수 a가 참조하고 있는 문자열 "a"가 존재하므로 변수 aaa는 변수a가 참조하고 있는 문자열 "a"동일하게 참조한다.
////		System.out.println(a == aaaa);	// false - aaaa는 리터럴 방식으로 기존 string pool의 "a"가 아닌 힙 영역에 "a"를 새로 할당하고 이를 참조하고 있다.
//		System.out.println(a.equals(aa));	// true
//		System.out.println(a.equals(aaa));	// true
//		System.out.println(a.equals(aaaa));	// true
//		
//		Object obj1 = new Object();
//		Object obj2 = new Object();
//		System.out.println(obj1.hashCode());	// 1023487453
//		System.out.println(obj2.hashCode());	// 1651191114
//		
//		
//		String a = "a";
//		String aa = a;
//		String aaa = "a";
//		String aaaa = new String("a");
//		System.out.println(a.hashCode());		// 97
//		System.out.println(aa.hashCode());		// 97
//		System.out.println(aaa.hashCode());		// 97
//		System.out.println(aaaa.hashCode());	// 97
//		
		
//		Machine machine = new Machine("car");
//		System.out.println(machine.toString());
//		
//		Car car = new Car("car", "kia");
//		System.out.println(car.toString());
//		
//		Car car2 = new Car("car");
//		System.out.println(car2.toString());
		
		Dto_temp temp1 = new Dto_temp(1);
		System.out.println(temp1.hashCode());	// 1865127310
		System.out.println(System.identityHashCode(temp1));	// 1865127310
		
//		Dto_temp temp1 = new Dto_temp(1);
//		Dto_temp temp2 = new Dto_temp(1);
//		
//		System.out.println(temp1.hashCode());	// 32
//		System.out.println(temp2.hashCode());	// 32
	}

}
