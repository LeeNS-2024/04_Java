package run;

import java.util.HashSet;
import java.util.Set;

// 문제점 1. 이론 지식이 너무 약함
// 문제점 2. 오류가 나면 원인을 찾아야 되는데 못찾는다
// 문제점 3. 답안 작성 방법

// 내일 시험범위 변수부터 컬렉션까지 
// 컬렉션 - (List / Set / Map)

public class TestRun {
	public static void main(String[] args) {
		
		// 컬렉션 : 자바 자료구조 모음
		
		// List : 
		//	- 인덱스가 존재해서 순서 유지
		//	- 중복 데이터 저장 가능
		
		// Set : (주머니, 집합)
		// - 순서 x
		// - 중복 저장 x
		
		// Map : 
		// - K:V 한쌍으로 데이터 저장 (key : value)
		// - 중복 K 불가
		// - 대신 K를 이용해서 V 구분 가능 -> V 중복 O
		
		// Set 객체 생성
		Set<String> MenuSet = new HashSet<String>();
		
		// Set에 객체 추가
		MenuSet.add("라면");
		MenuSet.add("김밥");
		MenuSet.add("우동");
		MenuSet.add("우동"); // 중복돼서 제거됨
		MenuSet.add("우동"); // 중복돼서 제거됨
		
		System.out.println(MenuSet); // [김밥, 우동, 라면]
		
		// MenuSet에 "라면"이 있는지 검사하기
		
		// 문제 원인
		// -> 일반 for 문을 이용해서 다루고 있는 i 값을 통해 
		// Set 의 i 번째 인덱스를 가져오려고함
		// 하지만 Set 은 인덱스가 없어서 오류가 발생함
		
		// + if 문에 문자열 비교 시 비교연산자(==)를 사용해서
		// 	 값이 아닌 주소를 비교하고 있음
		
		// + 메뉴가 존재할때도
		//	 있음 / 없음 모두 출력하는 문제발생
		//   왜? 같은 메뉴를 찾았을 경우
		//	 없음을 출력하지 못하게하는 처리가 되어있지 않아서
		
		/*
		for(int i =0; i<MenuSet.size(); i++) {
			if(MenuSet.get(i) == "라면") {
				System.out.println("라면 있음");				
			}
		}
		*/
		
		// 해결 방법
		// - 일반 for 문 -> 향상된 for 문
		// - get() 구문 -> 하나씩 꺼내 저장한 변수명으로 변경
		// - if 문 비교 연산자를 equals()로 변경
		// - 메뉴가 있을 경우 if 문에
		// 	 1) return 을 추가해서 프로그램 종료
		// 	 2) flag 를 이용해 없음 구문 실행 여부를 처리
		
		boolean flag = true;
		
		for( String menu : MenuSet ) {
			if(menu.equals("라면")) {
				System.out.println("라면 있음");
				flag = false;
			}
		}
		
		// for 문이 끝났을 때
		// 라면이 있었으면 flag == false;
		// 라면이 없었을 때 flag == true;

		if(flag) System.out.println("라면 없음");
	}
}
