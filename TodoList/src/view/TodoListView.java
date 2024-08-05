package view;

import service.TodoListService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

import dto.Todo;
import service.TodoListService;
import service.TodoListServiceImpl;

// View : 사용자에게 보여지는 역할을 하는 클래스/객체
// - 보여줄 화면을 출력 / 필요한 데이터를 입력

public class TodoListView {
	
	private TodoListService service = null;
	private BufferedReader br = null;
	
	public TodoListView() {
		
		try {
			service = new TodoListServiceImpl();
			br = new BufferedReader(new InputStreamReader(System.in));
			
		} catch(Exception e) {
			System.out.println("*** 프로그램 실행 중 오류 발생 ***");
			e.printStackTrace();
			System.exit(0); // 프로그램 종료
		}
	}
	
	// ----------------------------------------------------------------------------------------
	// [메인 메뉴]
//	====== Todo List =====
//			
//			1. Todo List Full View
//			2. Todo Detail View
//			3. Todo Add
//			4. Todo Complete
//			5. Todo Update
//			6. Todo Delete
//			0. EXIT
//			select menu number >>>
	
	public void mainMenu() {
		int selectNumber = 0;
		do {
			try {
				selectNumber = selectMenu();
				
				switch(selectNumber){
				case 1: todoListFullView();		break;
				case 2: todoDetailView(); 		break;
				case 3: todoAdd(); 				break;
				case 4: todoComplete(); 		break;
				case 5: todoUpdate(); 			break;
				case 6: todoDelete(); 			break;
					
				case 0: 
					System.out.println("*** 프로그램 종료 ***"); 
					br.close();
				break;
					
				default : System.out.println("### 메뉴에 작성된 번호만 입력해주세요 ###");
				}
				
				System.out.println("==================================================================");
				
			} catch(NumberFormatException e) {
				System.out.println("\n### 숫자만 입력해주세요 ###\n");
				selectNumber = -1; // 첫 반복에서 종료되지 않게 값 변경
			} catch(IOException e) {
				System.out.println("\n### 입출력 관련 예외 발생 ###\n");
				e.printStackTrace();
			} catch(Exception e) {
				e.printStackTrace();
			}
			
		} while(selectNumber !=0);
		
		try {
			if(br != null) br.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	// ---------------------------------------------------------------------------------------
	// [메뉴 출력/선택하는 메서드]
	
	private int selectMenu() throws NumberFormatException, IOException {
		System.out.println("\n====== Todo List ======\n");
		
		System.out.println("1. To do List Full View");
		System.out.println("2. To do Detail View");
		System.out.println("3. To do Add");
		System.out.println("4. To do Complete");
		System.out.println("5. To do Update");
		System.out.println("6. To do Delete");
		System.out.println("0. EXIT");
		
		System.out.print("select menu number >>>");
		int input = Integer.parseInt(br.readLine());
		System.out.println();
		
		return input;
	}
	
	// --------------------------------------------------------------------------------------------

	/**
	 * 할 일 목록 모두 보기
	 */
	private void todoListFullView() {
		
		System.out.println("\n===============[1. Todo List Full View]===============\n");
		
		// 할 일 목록, 완료 개수
		Map<String, Object> map = service.todoListFullView();
		
		List<Todo> todoList = (List<Todo>)map.get("todoList");
		int completeCount = (int)map.get("completeCount");
		
		System.out.printf("[ 완료된 Todo 개수 / 전체 Todo 수 : %d / %d ]\n",
							completeCount, todoList.size());
		
		System.out.println("-----------------------------------------------------------------");
		System.out.printf("%-3s %10s   %10s     %s\n", "인덱스","등록일", "완료여부", "할 일 제목");
		System.out.println("-----------------------------------------------------------------");
		
		if(todoList.isEmpty()) {
			System.out.println("\n### Todolist가 비어있습니다. ###\n");
			return;
		}
		for(int i = 0, len = todoList.size(); i < len; i++) {
			String title 		= todoList.get(i).getTitle();
			String completeYN 	= todoList.get(i).isComplete() ? "O" : "X";
			String regDate 		= service.dateFormat(todoList.get(i).getRegDate());
			System.out.printf("[%3d] %20d      (%s)      %s\n",i, regDate, completeYN, title);
		}
	}
	
	// -----------------------------------------------------------------------------------------------------
	
	
	
	
}























































