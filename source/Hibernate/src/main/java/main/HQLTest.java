package main;

import config.HibernateUtil;
import entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;
import java.util.List;

public class HQLTest {

    public static void main(String[] args) {
        selectQuery();
    }

    public static void fromQuery() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();


            transaction.commit();
        }
    }

    public static void selectQuery() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            List<User> users = session.createQuery("FROM User", User.class).getResultList();
            for (User u : users) {
                System.out.println(u);
            }
            transaction.commit();
        }
    }

    public static void whereQuery() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            List<User> users = session.createQuery("FROM User u WHERE u.id = :id", User.class)
                    .setParameter("id", 1)
                    .getResultList();
            for (User u : users) {
                System.out.println(u);
            }
            transaction.commit();
        }
    }

    public static void orderByQuery() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();


            transaction.commit();
        }
    }

    public static void updateQuery() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            int updatedEntities = session.createMutationQuery(
                            "UPDATE User SET password = ?1 WHERE userId = ?2")
                    .setParameter(1, "88888888")
                    .setParameter(2, 1)
                    .executeUpdate();
            System.out.println(updatedEntities);
            transaction.commit();
        }
    }

    public static void deleteQuery() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            int deletedEntities = session.createMutationQuery("DELETE User WHERE userId = :userId")
                    .setParameter("userId", 4)
                    .executeUpdate();
            System.out.println(deletedEntities);
            transaction.commit();
        }
    }

    public static void insertQuery() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            int insertEntities = session.createMutationQuery(
                    "INSERT User (username, password, createdAt, modifiedAt) " +
                            "VALUES (:username, :password, :createdAt, :modifiedAt)"
                    )
                    .setParameter("username", "HungHD")
                    .setParameter("password", "12345678")
                    .setParameter("createdAt", new Date())
                    .setParameter("modifiedAt", new Date())
                    .executeUpdate();
            System.out.println(insertEntities);
            transaction.commit();
        }
    }

    public static void joinQuery() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();


            transaction.commit();
        }
    }
}
