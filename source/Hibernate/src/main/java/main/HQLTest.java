package main;

import config.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class HQLTest {

    public static void main(String[] args) {

        deleteQuery();
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


            transaction.commit();
        }
    }

    public static void whereQuery() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();


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
                            "UPDATE User SET password = :password where userId = :userId")
                    .setParameter("password", "88888888")
                    .setParameter("userId", 1)
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
