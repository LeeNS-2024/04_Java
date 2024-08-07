package run;

import java.util.HashSet;
import java.util.Scanner;


public class Exam {
	public static void main(String[] args) {
		HashSet<String> set = new HashSet<String>(); // set을 문자열로 받게 선언
		set.add("문미미");
		set.add("박보배");
		set.add("송성실");
		set.add("윤예의");
		set.add("정재주"); // set 주머니에 다섯개 이름 넣음
		
		Scanner sc = new Scanner(System.in);
		System.out.print("검색할 이름을 입력하세요 : ");
		String input = sc.next(); // nextInt는 정수형을 입력받음. next로 바꿔서 문자형을 입력받아야됨
		boolean isExist = false; // isExist 변수선언 false로
		for(String name : set) {
			if(name.equals(input)) {
				isExist = true;
				break;
			}
		}
		if(isExist) {
			System.out.println("존재하는 회원입니다.");
		} else {
			System.out.println("존재하지 않는 회원입니다.");
		}
	}
}
