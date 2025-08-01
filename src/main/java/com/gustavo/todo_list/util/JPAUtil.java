package com.gustavo.todo_list.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("todo-list");

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public static void closeEntityManagerFactory() {
        if (emf != null && emf.isOpen())
            emf.close();
    }

    public static void closeEntityManager(EntityManager em) {
        if (em != null && em.isOpen())
            em.close();
    }

    public static void closeBothEntity(EntityManager em) {
        closeEntityManager(em);
        closeEntityManagerFactory();
    }
}
