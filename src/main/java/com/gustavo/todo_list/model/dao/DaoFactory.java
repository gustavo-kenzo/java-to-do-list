package com.gustavo.todo_list.model.dao;

import com.gustavo.todo_list.model.dao.impl.TarefaDaoJPA;
import com.gustavo.todo_list.util.JPAUtil;

public class DaoFactory {
    public static TarefaDao creatTarefa() {
        return new TarefaDaoJPA(JPAUtil.getEntityManager());
    }
}
