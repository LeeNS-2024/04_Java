package pkg3.dto;

// 인터페이스 상속 키워드 : implements (구현하다) 

public class LNSCalculator implements Calculator{

	@Override
	public int plus(int a, int b) {
		return a+b;
	}

	@Override
	public int minus(int a, int b) {
		return a-b;
	}

	@Override
	public int multi(int a, int b) {
		return a*b;
	}

	@Override
	public int div(int a, int b) {
		return a/b;
	}

	@Override
	public int mod(int a, int b) {
		return a%b;
	}

	@Override
	public int pow(int a, int x) {

		 int result = 1;
		 for(int i = 0; i<x; i++){
			 result*= a;
		 }
		 return result;
	}

	@Override
	public double areaOfCircle(double r) {
		double result = PI*r*r;
		return result;
	}

	@Override
	public String toBinary(int num) {
		return "이진수겠지 뭐,...";
	}

	@Override
	public String toHexadecimal(int num) {
		return "16진수 어쩌구겠지";
	}
	
	

}
