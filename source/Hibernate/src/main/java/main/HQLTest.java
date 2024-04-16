package main;

import config.HibernateUtil;
import entity.User;
import entity.UserDetail;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class HQLTest {

    public static void main(String[] args) {


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



            transaction.commit();
        }
    }

    public static void deleteQuery() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();



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
