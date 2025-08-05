package com.gustavo.todo_list.model.dao.impl;

import com.gustavo.todo_list.db.DbException;
import com.gustavo.todo_list.model.dao.TarefaDao;
import com.gustavo.todo_list.model.entities.Tarefa;
import com.gustavo.todo_list.util.JPAUtil;
import jakarta.persistence.EntityManager;

import java.util.List;

public class TarefaDaoJPA implements TarefaDao {
    EntityManager em;

    public TarefaDaoJPA(EntityManager em) {
        this.em = em;
    }

    @Override
    public void insert(Tarefa obj) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(obj);
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new DbException("Erro ao inserir nova tarefa! " + e.getMessage());
        } finally {
            em.close();
        }
    }

    @Override
    public void update(Tarefa obj) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(obj);
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new DbException("Erro ao atualizar tarefa! " + e.getMessage());
        } finally {
            em.close();
        }

    }

    @Override
    public void delete(Tarefa obj) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            Tarefa tarefa = em.find(Tarefa.class, obj.getId());
            if (tarefa != null) {
                em.remove(tarefa);
            }
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new DbException("Erro ao rmeover tarefa! " + e.getMessage());
        } finally {
            em.close();
        }
    }

    @Override
    public List<Tarefa> findAll() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery("SELECT t FROM Tarefa t ORDER BY t.createdAt", Tarefa.class).getResultList();
        } catch (RuntimeException e) {
            throw new DbException("Erro ao buscar tarefas! " + e.getMessage());
        } finally {
            em.close();
        }
    }


}
