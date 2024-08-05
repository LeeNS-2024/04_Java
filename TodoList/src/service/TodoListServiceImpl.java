package service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

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

}
