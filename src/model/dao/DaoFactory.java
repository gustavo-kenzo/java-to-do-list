package model.dao;

import db.DB;
import model.dao.impl.TarefaDaoJDBC;

public class DaoFactory {
	public static TarefaDao creatTarefa() {
		return new TarefaDaoJDBC(DB.getConnection());
	}
}
