package preAndroid;

import com.kitri.dto.Test;
import com.kitri.dto.TestImpl;

public class LambdaTest {
	public static void test(Test t) {
		t.m(10);
	}
	
	public static void main(String[] args) {
//		TestImpl impl = new TestImpl();
//		test(impl);
		
		
//		i->System.out.println(i);
		test(i->System.out.println(i));	//Test라는 interface를 implements한 하위class 객체가 알아서 생성되고
										//Test의 method도 알아서 Overriding 됨
										//그 Overriding된 method에 i를 넣는 것.
										//>>따라서 TestImpl class 안만들어도 됨!!
										//method가 하나일 때만 됨으로 event를 만들때 주로 사용한다. (Lambda 표현식을 씀으로서 코딩양 줄임)
		
	}
}
