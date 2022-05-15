package hu.unideb.inf;

import entity.MailboxEntity;
import entity.UsersEntity;
import jakarta.persistence.*;

import java.util.List;

public class HibernateConnector {
    static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
    static EntityManager entityManager = entityManagerFactory.createEntityManager();
    public static void persistData(UsersEntity user)
    {
        EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(user);
            transaction.commit();
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
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(LoginController.currentUser);
            entityManager.getTransaction().commit();
            MainApp.users.remove(LoginController.currentUser);
        } catch (Exception e)
        {

        }
    }
    public static void updateUser(UsersEntity u)
    {
        try {
            MainApp.users.add(u);
            MainApp.users.remove(LoginController.currentUser);
            deleteUser();
            entityManager.getTransaction().begin();
            entityManager.merge(u);
            entityManager.getTransaction().commit();
        } catch (Exception e)
        {

        }
    }

    public static void close()
    {
        entityManager.close();
        entityManagerFactory.close();
    }
}
