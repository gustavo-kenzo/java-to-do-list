package com.gustavo.todo_list.model.dao.impl;

import com.gustavo.todo_list.model.dao.TarefaDao;
import com.gustavo.todo_list.model.entities.Tarefa;
import jakarta.persistence.EntityManager;

import java.util.List;

public class TarefaDaoJPA implements TarefaDao {
    EntityManager em;

    public TarefaDaoJPA(EntityManager em) {
        this.em = em;
    }

    @Override
    public void insert(Tarefa obj) {

    }

    @Override
    public void update(Tarefa obj) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public List<Tarefa> findAll() {
        return List.of();
    }

    @Override
    public Integer findIdByRowNumber(int rowNumber) {
        return 0;
    }
}
