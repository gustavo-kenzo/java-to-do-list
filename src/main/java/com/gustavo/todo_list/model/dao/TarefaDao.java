package com.gustavo.todo_list.model.dao;

import java.util.List;

import com.gustavo.todo_list.model.entities.Tarefa;

public interface TarefaDao {
	void insert(Tarefa obj);

	void update(Tarefa obj);

	void deleteById(Integer id);

	List<Tarefa> findAll();

	Integer findIdByRowNumber(int rowNumber);

}
