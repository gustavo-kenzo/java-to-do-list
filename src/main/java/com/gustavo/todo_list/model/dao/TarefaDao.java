package com.gustavo.todo_list.model.dao;

import com.gustavo.todo_list.model.entities.Tarefa;

import java.util.List;

public interface TarefaDao {
    void insert(Tarefa obj);

    void update(Tarefa obj);

    void delete(Tarefa obj);

    List<Tarefa> findAll();
}
