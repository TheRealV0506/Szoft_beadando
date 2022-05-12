package hu.unideb.inf;

import entity.MailboxEntity;
import entity.UsersEntity;
import hu.unideb.inf.model.User;
import jakarta.persistence.*;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class HibernateConnector {
    static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
    static EntityManager entityManager = entityManagerFactory.createEntityManager();
    public static void persistData(UsersEntity user)
    {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(user);
            transaction.commit();
        } finally {
            if (transaction.isActive())
                transaction.rollback();
        }
        transaction.rollback();
    }
    public static void persistMessages(MailboxEntity mbox)
    {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(mbox);
        transaction.commit();
    }
    public static List<UsersEntity> getUsers()
    {
        TypedQuery<UsersEntity> query = entityManager.createQuery(
                "SELECT u FROM UsersEntity u ", UsersEntity.class);
        List<UsersEntity> queryResult = query.getResultList();

        return queryResult;
    }
    public static List<MailboxEntity> getMailboxes()
    {
        TypedQuery<MailboxEntity> query = entityManager.createQuery(
                "SELECT m FROM MailboxEntity m ", MailboxEntity.class);
        List<MailboxEntity> queryResult = query.getResultList();

        return queryResult;
    }

    public static void deleteUser()
    {
        entityManager.getTransaction().begin();
        entityManager.remove(LoginController.currentUser);
        entityManager.getTransaction().commit();
        MainApp.users.remove(LoginController.currentUser);
    }
    public static void updateUser(UsersEntity u)
    {
        MainApp.users.add(u);
        MainApp.users.remove(LoginController.currentUser);
        deleteUser();
        entityManager.getTransaction().begin();
        entityManager.merge(u);
        entityManager.getTransaction().commit();
    }

    public static void close()
    {
        entityManager.close();
        entityManagerFactory.close();
    }
}
