package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.TarefaDao;
import model.entities.Tarefa;

public class TarefaDaoJDBC implements TarefaDao {
	Connection conn = null;

	public TarefaDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Tarefa obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("INSERT INTO tasks (taskName, taskDescription, taskStatus) VALUES (?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			st.setString(1, obj.getNomeTarefa());
			st.setString(2, obj.getDescricao());
			st.setBoolean(3, obj.isStatus());
			int rows = st.executeUpdate();
			if (rows > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					obj.setId(id);
				}
			} else {
				throw new DbException("Erro ao inserir nova tarefa!");
			}

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}

	}

	@Override
	public void update(Tarefa obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("UPDATE tasks SET taskStatus = ? WHERE id = ?");
			st.setBoolean(1, obj.isStatus());
			st.setInt(2, obj.getId());
			int rows = st.executeUpdate();
			if (rows == 0) {
				throw new DbException("Erro ao atualizar! Id não encontrado!");
			}

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}

	}

	@Override
	public void deleteById(Integer id) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("DELETE FROM tasks WHERE id = ?");
			st.setInt(1, id);
			int rows = st.executeUpdate();
			if (rows == 0) {
				throw new DbException("Tarefa nao deletada! Id nao existe!");
			}
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}

	}

	@Override
	public List<Tarefa> findAll() {
		return null;
	}

}
