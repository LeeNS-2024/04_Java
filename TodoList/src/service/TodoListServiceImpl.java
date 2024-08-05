package service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import dao.TodoListDao;
import dao.TodoListDaoImpl;
import dto.Todo;

public class TodoListServiceImpl implements TodoListService{

	private TodoListDaoImpl dao = null;


	public TodoListServiceImpl() throws FileNotFoundException,
										ClassNotFoundException,
										IOException	{
		dao  = new TodoListDaoImpl();
	}
	
	
	@Override
	public List<Todo> getTodoList() {
		return dao.getTodoList();
	}


	@Override
	public Map<String, Object> todoListFullView() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String dateFormat(LocalDateTime regDate) {
		// TODO Auto-generated method stub
		return null;
	}

}
