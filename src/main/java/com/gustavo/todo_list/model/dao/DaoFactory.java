package com.gustavo.todo_list.model.dao;

import com.gustavo.todo_list.db.DB;
import com.gustavo.todo_list.model.dao.impl.TarefaDaoJDBC;

public class DaoFactory {
    public static TarefaDao creatTarefa() {
        return new TarefaDaoJDBC(DB.getConnection());
    }
}
