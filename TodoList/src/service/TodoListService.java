package service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import dto.Todo;

public interface TodoListService {

	/**
	 * 전체 TodoList 조회
	 * @return TodoList
	 */
	public abstract List<Todo> getTodoList();

	public abstract Map<String, Object> todoListFullView();

	public abstract String dateFormat(LocalDateTime regDate);


}
