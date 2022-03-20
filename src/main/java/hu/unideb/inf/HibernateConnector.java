package hu.unideb.inf;

import entity.UsersEntity;
import hu.unideb.inf.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class HibernateConnector {
    public static void persistData() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();

            UsersEntity testuser = new UsersEntity();
            testuser.setUsername("hibernate");
            testuser.setPword("hibernate");
            testuser.setFullName("hibernate");
            entityManager.persist(testuser);

            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}
